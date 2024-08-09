package br.com.tools.challenge.converter.dto;

import br.com.tools.challenge.domain.StatusTransacao;

import java.time.LocalDateTime;

public record DescricaoOutput(
        String valor,

        LocalDateTime hora,

        String estabelecimento,

        String nsu,

        String codigoAutorizacao,

        StatusTransacao statusTransacao) {

    public DescricaoOutput(String valor, LocalDateTime hora, String estabelecimento, String nsu, String codigoAutorizacao, StatusTransacao statusTransacao) {
        this.valor = valor;
        this.hora = hora;
        this.estabelecimento = estabelecimento;
        this.nsu = nsu;
        this.codigoAutorizacao = codigoAutorizacao;
        this.statusTransacao = statusTransacao;
    }
}
