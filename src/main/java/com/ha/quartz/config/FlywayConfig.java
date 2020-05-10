package com.ha.quartz.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    private final DataSource dataSource;

    private Flyway flyway;

    public FlywayConfig(DataSource dataSource) {
        this.dataSource = dataSource;
        migrate();
    }

    private void migrate() {
        flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
