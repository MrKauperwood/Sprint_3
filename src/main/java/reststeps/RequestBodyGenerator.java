package reststeps;

import requests.NewCourier;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class RequestBodyGenerator {

    public static String getRegisterRequestBody(NewCourier user) {
        return "{\"login\":\"" + user.getLogin() + "\","
                + "\"password\":\"" + user.getPassword() + "\","
                + "\"firstName\":\"" + user.getPassword() + "\"}";
    }
}
