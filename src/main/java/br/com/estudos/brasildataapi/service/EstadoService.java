package br.com.estudos.brasildataapi.service;

import br.com.estudos.brasildataapi.client.IbgeClient;
import br.com.estudos.brasildataapi.dto.EstadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Serviço responsável pelas regras de negócio relacionadas a estados.
 *
 * Centraliza a lógica compartilhada pelas interfaces REST e gRPC.
 */
@Service
public class EstadoService {

    private final IbgeClient ibgeClient;

    public EstadoService(IbgeClient ibgeClient) {
        this.ibgeClient = ibgeClient;
    }

    public List<EstadoResponse> listarEstados() {
        return ibgeClient.buscarEstados()
                .stream()
                .map(estado -> new EstadoResponse(
                        estado.sigla(),
                        estado.nome()
                ))
                .toList();
    }
}