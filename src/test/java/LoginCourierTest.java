import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import requests.LoginCourier;
import responses.LoginCourierResponse;

import java.util.ArrayList;

import static reststeps.Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_EMPTY_LOGIN_OR_PASSWORD;
import static reststeps.Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA;
import static reststeps.CreateAndRegisterNewCourier.registerNewCourierAndReturnLoginPassword;
import static reststeps.SendRequest.*;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class LoginCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Check SC is equal 200 for successful login courier")
    public void checkStatusCode201ForSuccessfulCreationCourier() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), userData.get(1));
        Response response = loginCourierSC(dataForLogin);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("Check response for successful login courier")
    public void checkResponseForSuccessfulLoginCourier() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), userData.get(1));
        LoginCourierResponse response = loginCourier(dataForLogin);
        Assert.assertNotNull(response.getId());
    }

    @Test
    @DisplayName("Check SC is equal 400 for request without login")
    public void checkStatusCode400ForRequestWithoutLogin() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(null, userData.get(1));
        Response response = loginCourierSC(dataForLogin);
        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    @DisplayName("Check error message for request without login")
    public void checkErrorMessageForRequestWithoutLogin() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(null, userData.get(1));
        LoginCourierResponse response = loginCourier(dataForLogin);
        Assert.assertEquals(ERROR_MESSAGE_FOR_LOGIN_WITH_EMPTY_LOGIN_OR_PASSWORD, response.getMessage());
    }

    @Test
    @DisplayName("Check SC is equal 400 for request without password")
    public void checkStatusCode400ForWithoutPassword() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(1), null);
        Response response = loginCourierSC(dataForLogin);
        Assert.assertEquals(400, response.getStatusCode());
    }

    @Test
    @DisplayName("Check error message for request without password")
    public void checkErrorMessageForRequestWithoutPassword() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), null);
        LoginCourierResponse response = loginCourier(dataForLogin);
        Assert.assertEquals(ERROR_MESSAGE_FOR_LOGIN_WITH_EMPTY_LOGIN_OR_PASSWORD, response.getMessage());
    }

    @Test
    @DisplayName("Check SC is equal 404 for request with incorrect password")
    public void checkStatusCode404ForRequestWithIncorrectPassword() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), "123");
        Response response = loginCourierSC(dataForLogin);
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Test
    @DisplayName("Check error message for request with incorrect password")
    public void checkErrorMessageForRequestWithIncorrectPassword() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), "123");
        LoginCourierResponse response = loginCourier(dataForLogin);
        Assert.assertEquals(ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA, response.getMessage());
    }

    @Test
    @DisplayName("Check SC is equal 404 for request with incorrect login")
    public void checkStatusCode404ForRequestWithIncorrectLogin() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier("123", userData.get(1));
        Response response = loginCourierSC(dataForLogin);
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Test
    @DisplayName("Check error message for request with incorrect login")
    public void checkErrorMessageForRequestWithIncorrectLogin() {
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier("123", userData.get(1));
        LoginCourierResponse response = loginCourier(dataForLogin);
        Assert.assertEquals(ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA, response.getMessage());
    }

}
