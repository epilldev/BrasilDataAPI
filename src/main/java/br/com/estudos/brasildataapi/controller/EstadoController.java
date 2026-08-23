package br.com.estudos.brasildataapi.controller;

import br.com.estudos.brasildataapi.dto.EstadoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoController {

    @GetMapping("/api/estados")
    public List<EstadoResponse> estados() {
        return List.of(
                new EstadoResponse("MG", "Minas Gerais"),
                new EstadoResponse("SP", "São Paulo"),
                new EstadoResponse("RJ", "Rio de Janeiro")
        );
    }
}