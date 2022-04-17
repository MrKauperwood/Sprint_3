package responses;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class NewCourierResponse {

    private Boolean ok;
    private String message;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
