package reststeps;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public final class Constants {

    public static final String HANDLER_POST_CREATE_NEW_COURIER = "/api/v1/courier";
    public static final String HANDLER_POST_LOGIN_COURIER = "/api/v1/courier/login";
    public static final String HANDLER_POST_CREATE_ORDER = "/api/v1/orders";
    public static final String HANDLER_GET_LIST_OF_ORDERS = "/api/v1/orders";

    public static final String ERROR_MESSAGE_FOR_IDENTICAL_COURIERS = "Этот логин уже используется";
    public static final String ERROR_MESSAGE_FOR_CREATION_USER_WITH_EMPTY_LOGIN_OR_PASSWORD = "Недостаточно данных для создания учетной записи";
    public static final String ERROR_MESSAGE_FOR_LOGIN_WITH_EMPTY_LOGIN_OR_PASSWORD = "Недостаточно данных для входа";
    public static final String ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA = "Учетная запись не найдена";
}
