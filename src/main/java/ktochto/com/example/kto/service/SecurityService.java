package ktochto.com.example.kto.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
