package br.com.hibejix.loja.util;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author macrusal on 29/12/20
 * @project quarkus-loja
 */
public class DatabaseLifeCycle implements QuarkusTestResourceLifecycleManager {

    public static PostgreSQLContainer<?> POSTGRESQL = new PostgreSQLContainer<>("postgres");

    @Override
    public Map<String, String> start() {
        POSTGRESQL.start();
        Map<String, String> propriedades = new HashMap<>();
        propriedades.put("quarkus.datasource.jdbc.url", POSTGRESQL.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", POSTGRESQL.getUsername());
        propriedades.put("quarkus.datasource.password", POSTGRESQL.getPassword());
        return propriedades;
    }

    @Override
    public void stop() {
        if(POSTGRESQL != null) {
            POSTGRESQL.stop();
        }
    }
}
