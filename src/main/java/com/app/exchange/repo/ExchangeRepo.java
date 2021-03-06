package com.app.exchange.repo;


import com.app.exchange.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExchangeRepo extends JpaRepository<Exchange, Integer> {
    List<Exchange> findByName(String name);

}
