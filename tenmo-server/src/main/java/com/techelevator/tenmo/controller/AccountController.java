package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Balance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private AccountDao accountDao;
    private UserDao userDao;
    private final static String BASE_API_URL = "http://localhost:8080/";

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "user/{id}/balance", method = RequestMethod.GET)
    public Balance getBalance(@PathVariable long id){

        return accountDao.getAccountBalance(id);
    }

}
