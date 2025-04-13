package Res.Restapi.dto;

public class LoginResponse {
    private String email;
    private String mess;
    private String token;

    public LoginResponse generateRespone(String email, String mess, String token) {
        return new LoginResponse(email, mess, token);
    }

    public LoginResponse(String email, String mess, String token) {
        this.email = email;
        this.mess = mess;
        this.token = token;
    }

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public String getMess() {
        return mess;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
