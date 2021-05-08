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
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    @Query(value ="select c.id,c.amount,c.count from Currency c", nativeQuery = true)
    public List<Currency> getCurrency();
}
