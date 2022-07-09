package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Balance;

import java.math.BigDecimal;

public interface AccountDao {
    public Balance getAccountBalance(Long userId);

    public void increaseAccountBalance(Long userId,  BigDecimal amount);

    public void decreaseAccountBalance(Long userId,  BigDecimal amount);
}
