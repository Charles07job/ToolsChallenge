package br.com.tools.challenge.converter.dto;


public record TransacaoInput(

        String cartao,

        Long id,

        DescricaoInput descricao,

        FormaPagamentoInput formaPagamento) {



}
