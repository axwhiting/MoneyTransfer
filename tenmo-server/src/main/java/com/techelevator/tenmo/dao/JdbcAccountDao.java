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
     public JdbcAccountDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

<<<<<<< HEAD
//    private User user = new User();
=======
    private User user = new User();
>>>>>>> bb6f68e1c4517dd92f4f419a5a22c54d345b4bf3
   // @Override
    public Balance getAccountBalance(Long userId){
        Balance balance = new Balance();

         String sql = "SELECT balance " +
                 "FROM account " +
                 "WHERE user_id = ?;";

<<<<<<< HEAD
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId );
=======
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId() );
>>>>>>> bb6f68e1c4517dd92f4f419a5a22c54d345b4bf3
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
