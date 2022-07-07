package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    public void createTransfer(Transfer transfer);

    public List<Transfer> transferList();

    public Transfer getTransferByUserId(int userId);

    public Transfer getTransferByTransferId(int transferId);


}
