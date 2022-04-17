package reststeps;

import io.restassured.response.Response;
import requests.ListOfOrders;
import requests.LoginCourier;
import requests.NewCourier;
import requests.NewOrder;
import responses.ListOfOrdersResponse;
import responses.LoginCourierResponse;
import responses.NewCourierResponse;
import responses.NewOrderResponse;

import static io.restassured.RestAssured.given;
import static reststeps.Constants.*;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class SendRequest {

    public static final String URL = "https://qa-scooter.praktikum-services.ru";

    public static NewCourierResponse createNewCourier(NewCourier user) {
        return createNewCourierSC(user).as(NewCourierResponse.class);
    }

    public static Response createNewCourierSC(NewCourier user) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(user)
                        .when()
                        .post(URL + HANDLER_POST_CREATE_NEW_COURIER);
    }

    public static Response loginCourierSC(LoginCourier loginCourier) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(loginCourier)
                        .when()
                        .post(URL + HANDLER_POST_LOGIN_COURIER);
    }

    public static LoginCourierResponse loginCourier(LoginCourier loginCourier) {
        return loginCourierSC(loginCourier).as(LoginCourierResponse.class);
    }

    public static Response orderCreationSC(NewOrder newOrder) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(newOrder)
                        .when()
                        .post(URL + HANDLER_POST_CREATE_ORDER);
    }

    public static NewOrderResponse orderCreation(NewOrder newOrder) {
        return orderCreationSC(newOrder).as(NewOrderResponse.class);
    }

    public static Response getOrdersSC(ListOfOrders listOfOrders) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .queryParam("courierId", listOfOrders.getCourierId())
                        .queryParam("nearestStation", listOfOrders.getNearestStation())
                        .queryParam("limit", listOfOrders.getLimit())
                        .queryParam("page", listOfOrders.getPage())
                        .when()
                        .get(URL + HANDLER_GET_LIST_OF_ORDERS);
    }

    public static ListOfOrdersResponse getOrders(ListOfOrders listOfOrders) {
        return getOrdersSC(listOfOrders).as(ListOfOrdersResponse.class);
    }
}
