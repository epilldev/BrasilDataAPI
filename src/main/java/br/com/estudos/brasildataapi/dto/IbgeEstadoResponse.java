package br.com.estudos.brasildataapi.dto;
/**
 * DTO que representa a estrutura de estado retornada pela API do IBGE.
 *
 * Isola o contrato externo do IBGE dos modelos internos da aplicação.
 */
public record IbgeEstadoResponse(
        Long id,
        String sigla,
        String nome
) {
}