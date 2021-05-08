package com.neueda.atm.repository;

import com.neueda.atm.entity.ATM;
import com.neueda.atm.entity.Account;
import com.neueda.atm.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<ATM, Integer> {
}
