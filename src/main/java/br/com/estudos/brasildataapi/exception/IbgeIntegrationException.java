package br.com.estudos.brasildataapi.exception;
/**
 * Exceção lançada quando ocorre uma falha na integração com o IBGE.
 *
 * Permite que a camada de tratamento de erros converta a falha externa em uma resposta HTTP adequada.
 */
public class IbgeIntegrationException extends RuntimeException {

    public IbgeIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}