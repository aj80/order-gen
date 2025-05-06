package com.ajcs.data.service;

import com.ajcs.data.model.refdata.Security;
import com.ajcs.data.repository.refdata.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityServiceImpl implements SecurityService {

    private SecurityRepository securityRepository;

    @Autowired
    SecurityServiceImpl(SecurityRepository secRepository) {
        this.securityRepository = secRepository;
    }
    @Override
    public Security createSecurity(Security security) {
        return this.securityRepository.save(security);
    }

    @Override
    public Security getSecurity(String ticker) {
        Security sec = securityRepository.findByTicker(ticker)
                .orElse(null);
        return sec;
    }
}
