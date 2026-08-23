package br.com.estudos.brasildataapi.controller;

import br.com.estudos.brasildataapi.dto.EstadoResponse;
import br.com.estudos.brasildataapi.service.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/api/estados")
    public List<EstadoResponse> estados() {
        return estadoService.listarEstados();
    }
}