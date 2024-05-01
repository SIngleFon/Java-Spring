package ru.gb.my_first_crud.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@ConfigurationProperties(prefix = "sql")
@EnableConfigurationProperties
@Setter
@Getter
@Component
public class SqlQueries {
    private String findAll;
    private String save;
    private String deleteById;
    private String update;
    private String findById;

}
