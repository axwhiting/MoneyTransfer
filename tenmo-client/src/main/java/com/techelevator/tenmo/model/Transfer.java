package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private int transferTypeId;
    private int transferStatusId;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;

//    public Transfer(int transfer_id, int transfer_type_id, int transfer_status_id, int account_from, int account_to, BigDecimal amount) {
//        this.transfer_id = transfer_id;
//        this.transfer_type_id = transfer_type_id;
//        this.transfer_status_id = transfer_status_id;
//        this.account_from = account_from;
//        this.account_to = account_to;
//        this.amount = amount;
//    }
    public Transfer (){}

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransfer_type_id() {
        return transferTypeId;
    }

    public void setTransfer_type_id(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransfer_status_id() {
        return transferStatusId;
    }

    public void setTransfer_status_id(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
