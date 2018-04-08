package demo.springboot2.websocket.domain;

public class DemoResponse {

    private String responseMessage;

    public DemoResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
