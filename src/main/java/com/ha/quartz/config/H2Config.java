package com.ha.quartz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class H2Config {

    @Value(value = "${spring.h2.port}")
    private String port;

    @Value(value = "${spring.h2.wport}")
    private String wport;

    private org.h2.tools.Server webServer;
    private org.h2.tools.Server server;

    @EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
        this.webServer = org.h2.tools.Server.createWebServer("-webPort", wport).start();
        this.server = org.h2.tools.Server.createTcpServer("-tcpPort", port).start();
    }

    @EventListener(org.springframework.context.event.ContextClosedEvent.class)
    public void stop() {
        this.webServer.stop();
        this.server.stop();
    }
}
