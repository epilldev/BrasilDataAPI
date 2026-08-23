package br.com.estudos.brasildataapi.client;

import br.com.estudos.brasildataapi.dto.IbgeEstadoResponse;
import br.com.estudos.brasildataapi.exception.IbgeIntegrationException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;
/**
 * Client responsável pela comunicação com a API pública do IBGE.
 *
 * Isola os detalhes da integração externa da camada de negócio.
 */
@Component
public class IbgeClient {

    private final RestClient restClient;

    public IbgeClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<IbgeEstadoResponse> buscarEstados() {
        try {
            return restClient
                    .get()
                    .uri("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<IbgeEstadoResponse>>() {
                    });
        } catch (RestClientException exception) {
            throw new IbgeIntegrationException(
                    "Erro ao consultar a API do IBGE",
                    exception
            );
        }
    }
}