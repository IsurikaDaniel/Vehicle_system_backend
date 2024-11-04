package edu.icet.crm.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Confi {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
