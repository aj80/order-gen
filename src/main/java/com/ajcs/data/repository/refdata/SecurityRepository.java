package com.ajcs.data.repository.refdata;

import com.ajcs.data.model.refdata.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {

    Optional<Security> findByTicker(String ticker);

}
