import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import requests.NewOrder;
import responses.NewOrderResponse;

import java.util.ArrayList;
import java.util.List;

import static reststeps.CreateAndRegisterNewCourier.registerNewCourierAndLogin;
import static reststeps.SendRequest.orderCreation;
import static reststeps.SendRequest.orderCreationSC;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
@RunWith(Parameterized.class)
public class OrderCreationParametrizedTest {

    private List<String> color ;

    private String metroStation = "Комсомольская";
    private String phone = "7921740833";
    private Integer rentTime = 5;
    private String deliveryDate = "08.04.2022";
    private String comment = "Достоевская";
    private String address = "Москва";

    public OrderCreationParametrizedTest(List<String> color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static List<List<String>> getColors() {
        return List.of(
                List.of("BLACK"),
                List.of("GREY"),
                List.of("GREY", "BLACK"),
                List.of("")
        );
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Check SC is equal 201 for successful order creation with parametrize color")
    public void checkStatusCode201ForSuccessfulOrderCreation() {
        ArrayList<String> userData = registerNewCourierAndLogin();
        NewOrder newOrder = new NewOrder(
                userData.get(0), userData.get(1), address, metroStation,
                phone, rentTime, deliveryDate, comment, color
        );
        Response response = orderCreationSC(newOrder);
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test
    @DisplayName("Check body for successful order creation with parametrize color")
    public void checkBodyForSuccessfulOrderCreation() {
        ArrayList<String> userData = registerNewCourierAndLogin();
        NewOrder newOrder = new NewOrder(
                userData.get(0), userData.get(1), address, metroStation,
                phone, rentTime, deliveryDate, comment, color
        );
        NewOrderResponse response = orderCreation(newOrder);
        Assert.assertNotNull(response.getTrack());
    }
}
