import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import requests.NewCourier;
import responses.NewCourierResponse;

import java.util.ArrayList;

import static reststeps.Constants.ERROR_MESSAGE_FOR_CREATION_USER_WITH_EMPTY_LOGIN_OR_PASSWORD;
import static reststeps.Constants.ERROR_MESSAGE_FOR_IDENTICAL_COURIERS;
import static reststeps.CreateAndRegisterNewCourier.generateDataForNewCourier;
import static reststeps.SendRequest.createNewCourier;
import static reststeps.SendRequest.createNewCourierSC;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class CourierCreationTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Check SC is equal 201 for successful creation courier")
    public void checkStatusCode201ForSuccessfulCreationCourier() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(userData.get(0), userData.get(1), userData.get(2));
        Response response = createNewCourierSC(newCourier);
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test
    @DisplayName("Check body in response for successful creation courier")
    public void checkBodyInResponseForSuccessfulCreationCourier() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(userData.get(0), userData.get(1), userData.get(2));
        NewCourierResponse response = createNewCourier(newCourier);
        Assert.assertEquals(true, response.getOk());
    }

    @Test
    @DisplayName("Check request with attempt to create two identical couriers")
    public void checkRequestWithAttemptToCreateTwoIdenticalCouriers() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(userData.get(0), userData.get(1), userData.get(2));
        createNewCourierSC(newCourier);
        Response response = createNewCourierSC(newCourier);
        NewCourierResponse parsedResponse = response.as(NewCourierResponse.class);
        Assert.assertEquals(409, response.getStatusCode());
        Assert.assertEquals(ERROR_MESSAGE_FOR_IDENTICAL_COURIERS, parsedResponse.getMessage());
    }

    @Test
    @DisplayName("Check request with attempt to create courier without login field")
    public void checkRequestWithAttemptToCreateCourierWithoutLoginField() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(null, userData.get(1), userData.get(2));
        Response response = createNewCourierSC(newCourier);
        NewCourierResponse parsedResponse = response.as(NewCourierResponse.class);
        Assert.assertEquals(400, response.getStatusCode());
        Assert.assertEquals(ERROR_MESSAGE_FOR_CREATION_USER_WITH_EMPTY_LOGIN_OR_PASSWORD, parsedResponse.getMessage());
    }

    @Test
    @DisplayName("Check request with attempt to create courier without password field")
    public void checkRequestWithAttemptToCreateCourierWithoutPasswordField() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(userData.get(0), null, userData.get(2));
        Response response = createNewCourierSC(newCourier);
        NewCourierResponse parsedResponse = response.as(NewCourierResponse.class);
        Assert.assertEquals(400, response.getStatusCode());
        Assert.assertEquals(ERROR_MESSAGE_FOR_CREATION_USER_WITH_EMPTY_LOGIN_OR_PASSWORD, parsedResponse.getMessage());
    }

    @Test
    @DisplayName("Check SC is equal 400 for attempt to create courier without firstName field")
    @Description("I did not find in the specification what the expected result should be")
    public void checkStatusCode400ForAttemptToCreateCourierWithoutFirstNameField() {
        ArrayList<String> userData = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(userData.get(0), userData.get(1), null);
        Response response = createNewCourierSC(newCourier);
        Assert.assertEquals(400, response.getStatusCode());
    }
}
