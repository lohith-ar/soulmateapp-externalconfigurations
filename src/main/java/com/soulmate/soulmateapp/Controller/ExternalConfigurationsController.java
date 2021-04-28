package com.soulmate.soulmateapp.Controller;

import com.soulmate.soulmateapp.service.ExternalConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("soulmate")
public class ExternalConfigurationsController {

    private ExternalConfigurations extConfig;

    @Autowired
    public ExternalConfigurationsController(ExternalConfigurations extConfig) {
        this.extConfig = extConfig;
    }


    @GetMapping("/value")
    public String getMessageUsingValue(){
        return extConfig.generateMessageUsingValue();
    }

    @GetMapping("/env")
    public String getMessageUsingEnvironment(){
        return extConfig.generateMessageUsingEnvironment();
    }


}
