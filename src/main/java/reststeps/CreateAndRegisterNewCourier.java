package reststeps;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import requests.LoginCourier;
import requests.NewCourier;
import java.util.ArrayList;
import static reststeps.SendRequest.*;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class CreateAndRegisterNewCourier {

    public static ArrayList<String> generateDataForNewCourier() {

        String courierLogin = RandomStringUtils.randomAlphabetic(10);
        String courierPassword = RandomStringUtils.randomAlphabetic(10);
        String courierFirstName = RandomStringUtils.randomAlphabetic(10);

        ArrayList<String> loginPass = new ArrayList<>();

        loginPass.add(courierLogin);
        loginPass.add(courierPassword);
        loginPass.add(courierFirstName);

        return loginPass;
    }

    public static ArrayList<String> registerNewCourierAndReturnLoginPassword(){

        ArrayList<String> loginPass = generateDataForNewCourier();
        NewCourier newCourier = new NewCourier(loginPass.get(0), loginPass.get(1), loginPass.get(2));
        Response response = createNewCourierSC(newCourier);
        if (response.statusCode() == 201) {
            return loginPass;
        } else {
            return  new ArrayList<>();
        }
    }

    public static ArrayList<String> registerNewCourierAndLogin(){
        ArrayList<String> userData = registerNewCourierAndReturnLoginPassword();
        LoginCourier dataForLogin = new LoginCourier(userData.get(0), userData.get(1));
        Response response = loginCourierSC(dataForLogin);
        if (response.statusCode() == 200) {
            return userData;
        } else {
            return  new ArrayList<>();
        }
    }
}
