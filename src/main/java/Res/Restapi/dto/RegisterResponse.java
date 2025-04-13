package Res.Restapi.dto;

public class RegisterResponse {
    private String mess;

    public RegisterResponse(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
