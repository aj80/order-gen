package com.ajcs.data.controller;

import com.ajcs.data.model.refdata.Security;
import com.ajcs.data.service.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trading")
public class SecurityController {

    SecurityService securityServiceImpl;

    public SecurityController(SecurityService secServiceImpl) {
        this.securityServiceImpl = secServiceImpl;
    }

    @PostMapping("/security")
    public ResponseEntity<Security> createSecurity(@RequestBody Security security) {
        Security sec = this.securityServiceImpl.createSecurity(security);
            return new ResponseEntity<Security>(security, HttpStatus.OK);
    }

    @GetMapping("/security/{ticker}")
    public Security getSecurity(@PathVariable  String ticker) {
        return this.securityServiceImpl.getSecurity(ticker);
    }


}
