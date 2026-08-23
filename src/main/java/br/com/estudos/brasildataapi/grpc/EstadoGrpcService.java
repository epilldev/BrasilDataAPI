package br.com.estudos.brasildataapi.grpc;

import br.com.estudos.brasildataapi.dto.EstadoResponse;
import br.com.estudos.brasildataapi.service.EstadoService;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

import java.util.List;

/**
 * Adaptador de entrada gRPC para operações relacionadas a estados.
 *
 * Reutiliza a camada de serviço da aplicação, mantendo a lógica de negócio
 * compartilhada entre as interfaces REST e gRPC.
 */
@GrpcService
public class EstadoGrpcService extends EstadoServiceGrpc.EstadoServiceImplBase {

    private final EstadoService estadoService;

    public EstadoGrpcService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @Override
    public void getEstados(
            GetEstadosRequest request,
            StreamObserver<GetEstadosResponse> responseObserver) {

        List<EstadoResponse> estados = estadoService.listarEstados();

        GetEstadosResponse.Builder response = GetEstadosResponse.newBuilder();

        for (EstadoResponse estado : estados) {
            response.addEstados(
                    Estado.newBuilder()
                            .setSigla(estado.sigla())
                            .setNome(estado.nome())
                            .build()
            );
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}