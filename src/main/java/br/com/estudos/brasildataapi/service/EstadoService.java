package br.com.estudos.brasildataapi.service;

import br.com.estudos.brasildataapi.client.IbgeClient;
import br.com.estudos.brasildataapi.dto.EstadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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