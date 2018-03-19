package com.eventgate.backend.service.controller;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Controller
@ApiIgnore
@RequestMapping({"/resources/swagger-resources"})
public class SwaggerResouceHandler {
    @Autowired(
            required = false
    )
    private SecurityConfiguration securityConfiguration;
    private SecurityConfiguration DEFAULT_SECURITY_CONF = new SecurityConfiguration((String)null, (String)null, (String)null, (String)null, (String)null, ApiKeyVehicle.HEADER, "api_key", ",");
    private UiConfiguration DEFAULT_UI_CONF = new UiConfiguration(null, "none", "alpha", "schema", UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, (Long)null);
    @Autowired(
            required = false
    )
    private UiConfiguration uiConfiguration;
    private final SwaggerResourcesProvider swaggerResources;

    @Autowired
    public SwaggerResouceHandler(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    @RequestMapping({"/configuration/security"})
    @ResponseBody
    ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return new ResponseEntity(Optional.fromNullable(this.securityConfiguration).or(DEFAULT_SECURITY_CONF), HttpStatus.OK);
    }

    @RequestMapping({"/configuration/ui"})
    @ResponseBody
    ResponseEntity<UiConfiguration> uiConfiguration() {
        return new ResponseEntity(Optional.fromNullable(this.uiConfiguration).or(DEFAULT_UI_CONF), HttpStatus.OK);
    }

    @RequestMapping
    @ResponseBody
    ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity(this.swaggerResources.get(), HttpStatus.OK);
    }
}

