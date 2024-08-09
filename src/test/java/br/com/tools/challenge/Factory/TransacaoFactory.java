package br.com.tools.challenge.Factory;

import br.com.tools.challenge.converter.dto.DescricaoInput;
import br.com.tools.challenge.converter.dto.FormaPagamentoInput;
import br.com.tools.challenge.converter.dto.TransacaoInput;

import java.time.LocalDateTime;

public class TransacaoFactory {

    public static TransacaoInput transacaoInputMock() {
        return new TransacaoInput(
                "1234 2345 3456 3456 ",
                1L,
                new DescricaoInput(
                        "500.00",
                        LocalDateTime.of(2024, 8, 9, 10, 30),
                        "estabelecimento"),
                new FormaPagamentoInput("AVISTA", "1")
        );
    }
}
