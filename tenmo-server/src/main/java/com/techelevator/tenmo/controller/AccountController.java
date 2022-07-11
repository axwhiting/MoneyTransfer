package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
public class AccountController {
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;
    private final static String BASE_API_URL = "http://localhost:8080/";

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "user/{id}/balance", method = RequestMethod.GET)
    public Balance getBalance(@PathVariable long id){

        return accountDao.getAccountBalance(id);
    }

    @RequestMapping(path = "usernames", method = RequestMethod.GET)
    public List<User> users(){
        return userDao.userNames();
    }

    @RequestMapping(path = "user/{id}/balance", method = RequestMethod.PUT)
    public void increaseBalance(@PathVariable long id, BigDecimal amount){
        accountDao.increaseAccountBalance(id, amount);
        accountDao.decreaseAccountBalance(id, amount);
    }

//    @RequestMapping(path = "user/{id}/balance", method = RequestMethod.PUT)
//    public void decreaseBalance(@PathVariable long id, BigDecimal amount){
//
//    }
//

}
