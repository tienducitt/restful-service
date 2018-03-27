package com.eventgate.backend.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@PropertySource("classpath:Configuration.properties")   // specific the config file location
@ConfigurationProperties("app") // prefix of the config
public class Configuration {

    private boolean jwtAuthenEnable;

    private String error;
    private List<Menu> menus = new ArrayList<>();
    private Compiler compiler = new Compiler();

    @Data
    public static class Menu {
        private String name;
        private String path;
        private String title;
    }

    @Data
    public static class Compiler {
        private String timeout;
        private String outputFolder;
    }
}
