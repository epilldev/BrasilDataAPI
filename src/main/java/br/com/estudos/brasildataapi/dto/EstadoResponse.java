package br.com.estudos.brasildataapi.dto;
/**
 * DTO que representa o estado exposto pela API REST.
 *
 * Define o contrato de resposta da aplicação para os consumidores REST.
 */
public record EstadoResponse(
        String sigla,
        String nome
) {
}