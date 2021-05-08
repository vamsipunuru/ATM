package com.neueda.atm.repository;

import com.neueda.atm.entity.ATM;
import com.neueda.atm.entity.Account;
import com.neueda.atm.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value ="select * from Account where account_number = :accountNumber and pin = :pin", nativeQuery = true)
    public Account findByAccountNumberAndPin(@Param("accountNumber") Long accountNumber,@Param("pin") int pin);
}
