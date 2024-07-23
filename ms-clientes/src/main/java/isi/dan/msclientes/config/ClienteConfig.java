package isi.dan.msclientes.config;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ClienteConfig {

    @Value("${cliente.maximoDescubierto.default}")
    private BigDecimal maximoDescubiertoDefault;

    @Bean
    public BigDecimal maximoDescubiertoDefault() {
        return maximoDescubiertoDefault;
    }
}