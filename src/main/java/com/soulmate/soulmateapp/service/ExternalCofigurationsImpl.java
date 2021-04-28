package com.soulmate.soulmateapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ExternalCofigurationsImpl implements ExternalConfigurations{

    @Value("${com.stackroute.message1}")
    private String value;

    @Override
    public String generateMessageUsingValue() {
        return value;
    }

    @Autowired
    private Environment env;

    @Override
    public String generateMessageUsingEnvironment() {
        return env.getProperty("com.stackroute.message2");
    }
}
