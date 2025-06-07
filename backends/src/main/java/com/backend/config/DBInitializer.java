package com.backend.config;


import com.umg.proy.milibreria.db.DBConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {
    @PostConstruct
    public void init() {
        DBConfig.configureMySQL(
            "jdbc:mysql://localhost:3306/turnos",  
            "root",                            
            "admin"                          
        );
        DBConfig.configureMongo(
            "mongodb://admin:admin@localhost:27017",            
            "logsdb",                               
            "logsCollection"                         
        );
    }
}