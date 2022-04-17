import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import requests.NewOrder;
import responses.NewOrderResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static reststeps.CreateAndRegisterNewCourier.registerNewCourierAndLogin;
import static reststeps.SendRequest.*;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class OrderCreationTest {

    private String metroStation = "Комсомольская";
    private String phone = "7921740833";
    private Integer rentTime = 5;
    private String deliveryDate = new Date().toString();
    private String comment = "Достоевская";
    private String address = "Москва";
    private List<String> color = List.of("BLACK");

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
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
