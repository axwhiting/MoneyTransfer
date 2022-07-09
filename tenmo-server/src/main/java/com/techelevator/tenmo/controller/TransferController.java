package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransferController {
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;
    private final static String BASE_API_URL = "http://localhost:8080/";

    public TransferController(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "transfers", method = RequestMethod.POST)
        public Transfer newTransfer(@RequestBody Transfer transfer ){
        return transferDao.createTransfer(transfer);
    }

    @RequestMapping(path = "transfers/{transferId}", method = RequestMethod.GET)
    public Transfer getTransferByTransferId(@PathVariable int transferId) {
        return transferDao.getTransferByTransferId(transferId);
    }

    @RequestMapping(path = "user/{userId}/transfers", method = RequestMethod.GET)
    public Transfer getTransferByUserId(@PathVariable int userId) {
        return transferDao.getTransferByTransferId(userId);
    }

    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> getTransfer(){
        return transferDao.getTransferList();
    }


}