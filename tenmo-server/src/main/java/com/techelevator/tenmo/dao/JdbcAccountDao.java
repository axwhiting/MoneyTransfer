package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{
    private JdbcTemplate jdbcTemplate;
     public JdbcAccountDao(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}

   // @Override
    public Balance getAccountBalance(){
        Balance balance = new Balance();

         String sql = "SELECT balance " +
                 "FROM account " +
                 "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
          balance = mapRowToBalance(results); ;
        }
         return balance;
    }
    private Balance mapRowToBalance(SqlRowSet rs) {
        Balance balance = new Balance();
        balance.setBalance(rs.getBigDecimal("balance"));
        return balance;
    }

}
