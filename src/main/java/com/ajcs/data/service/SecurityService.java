package com.ajcs.data.service;

import com.ajcs.data.model.refdata.Security;

public interface SecurityService {

    Security createSecurity(Security security);

    Security getSecurity(String ticker);
}
