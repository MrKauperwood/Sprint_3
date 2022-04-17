package reststeps;

import requests.NewOrder;
import responses.NewOrderResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static reststeps.CreateAndRegisterNewCourier.registerNewCourierAndLogin;
import static reststeps.SendRequest.orderCreation;

/**
 * Author: Alexey Bondarenko
 * Date: 17.04.2022
 */
public class CreateNewOrder {

    public static String metroStation = "Комсомольская";
    public static String phone = "79217777777";
    public static Integer rentTime = 5;
    public static String deliveryDate = new Date().toString();
    public static String comment = "Хочу сегодня кататься!";
    public static String address = "Мой адрес Советский Союз";
    public static List<String> color = List.of("BLACK");

    public static Integer createNewOrderAndGetId() {
        ArrayList<String> userData = registerNewCourierAndLogin();
        NewOrder newOrder = new NewOrder(
                userData.get(0), userData.get(1), address, metroStation,
                phone, rentTime, deliveryDate, comment, color
        );
        NewOrderResponse response = orderCreation(newOrder);
        return response.getTrack();
    }
}
