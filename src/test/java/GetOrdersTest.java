import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import requests.ListOfOrders;
import responses.ListOfOrdersResponse;

import static reststeps.CreateNewOrder.createNewOrderAndGetId;
import static reststeps.SendRequest.*;

/**
 * Author: Alexey Bondarenko
 * Date: 17.04.2022
 */
public class GetOrdersTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
        createNewOrderAndGetId();
    }

    @Test
    @DisplayName("Check SC for successful getOrders request")
    public void checkSCForSuccessfulGetOrderRequest() {
        ListOfOrders listOfOrders = new ListOfOrders();
        Response response = getOrdersSC(listOfOrders);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("Check successful getOrders request returns orders")
    public void checkSuccessfulGetOrderRequestReturnsOrders() {
        ListOfOrders listOfOrders = new ListOfOrders();
        ListOfOrdersResponse response = getOrders(listOfOrders);
        Assert.assertTrue(response.getOrders().size() >= 1);
        Assert.assertNotNull(response.getOrders());
    }
}
