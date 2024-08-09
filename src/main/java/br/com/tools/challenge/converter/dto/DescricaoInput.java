package br.com.tools.challenge.converter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DescricaoInput(
        String valor,

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dataHora,

        String estabelecimento
) {
}
