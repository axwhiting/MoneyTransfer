package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcTransferDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    private BigDecimal amountToTransfer;
    private TransferDao transferDao;

    public Transfer createTransfer(Transfer transfer){
        String sql = "INSERT INTO transfer( transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (?,?,?,?,?);";

        jdbcTemplate.update(sql, transfer.getTransferTypeId(),transfer.getTransferStatusId(),
                getUserId(transfer.getAccountFrom()), getUserId(transfer.getAccountTo()), transfer.getAmount());
        return transfer;
    }

//    public Transfer createTransfer(Transfer transfer){
//        String sql = "INSERT INTO transfer  " +
//                "SELECT transfer.transfer_id, transfer.transfer_type_id, transfer.transfer_status_id, transfer.account_from, transfer.account_to, transfer.amount " +
//                "FROM transfer " +
//                "LEFT JOIN account ON transfer.account_from = account.user_id;";
//
//        jdbcTemplate.update(sql, transfer.getTransferId(), transfer.getTransferTypeId(),transfer.getTransferStatusId(),
//                transfer.getAccountTo(), transfer.getAccountFrom(), transfer.getAmount());
//        return transfer;
//    }

    public int getUserId(int userId){
        String sql ="SELECT user_id " +
                "FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        return userId;
    }

    public List<Transfer> transferList(){
        List<Transfer> transferList = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            transferList.add(mapRowToTransfer(results));
        }

        return transferList;
    }

    public Transfer getTransferByUserId(int userId){
        Transfer transfer = null;
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer " +
                "JOIN account ON account.account_id = transfer.account_from " +
                "OR account.account_id = transfer.account_to " +
                "WHERE user_id =?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()){
            transfer=mapRowToTransfer(results);
        }
        return transfer;
    }

    public Transfer getTransferByTransferId(int transferId){
        Transfer transfer = null;
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer WHERE transfer_id =?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if(results.next()){
            transfer=mapRowToTransfer(results);
        }
        return transfer;
    }

    private Transfer mapRowToTransfer(SqlRowSet result) {
        int transferId = result.getInt("transfer_id");
        int transferTypeId = result.getInt("transfer_type_id");
        int transferStatusId = result.getInt("transfer_status_id");
        int accountFrom = result.getInt("account_from");
        int accountTo = result.getInt("account_to");
        String amountTransfer = result.getString("amount");

        Transfer transfer = new Transfer(transferId, accountFrom, accountTo, new BigDecimal(amountTransfer));
        return transfer;
    }
}
