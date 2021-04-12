package ktochto.com.example.kto.service;

import ktochto.com.example.kto.model.Account;

public interface AccountService {

    void save(Account account);

    Account findByUsername(String username);

}
