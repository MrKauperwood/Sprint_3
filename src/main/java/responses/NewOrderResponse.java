package responses;

/**
 * Author: Alexey Bondarenko
 * Date: 15.04.2022
 */
public class NewOrderResponse {

    private Integer track;
    private String message;

    public NewOrderResponse() {
    }

    public NewOrderResponse(Integer track) {
        this.track = track;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
