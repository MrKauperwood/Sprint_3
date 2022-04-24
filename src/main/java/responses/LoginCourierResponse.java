package responses;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class LoginCourierResponse {
    private Integer id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public LoginCourierResponse(Integer id) {
        this.id = id;
    }

    public LoginCourierResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
