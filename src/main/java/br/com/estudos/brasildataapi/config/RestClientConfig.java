package br.com.estudos.brasildataapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
/**
 * Configuração do cliente HTTP utilizado para integrações externas.
 *
 * Disponibiliza o RestClient para injeção nas classes que realizam chamadas externas.
 */
@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }
}