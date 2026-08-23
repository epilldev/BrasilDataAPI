package br.com.estudos.brasildataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IbgeIntegrationException.class)
    public ProblemDetail handleIbgeIntegrationException(
            IbgeIntegrationException exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(
                HttpStatus.BAD_GATEWAY
        );

        problemDetail.setTitle("Erro na integração com o IBGE");
        problemDetail.setDetail(exception.getMessage());

        return problemDetail;
    }
}