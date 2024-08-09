package br.com.tools.challenge.converter.dto;

import br.com.tools.challenge.domain.DescricaoEntity;
import br.com.tools.challenge.domain.FormaPagamentoEntity;
import br.com.tools.challenge.domain.TransacaoEntity;

public record TransacaoOutput(

        Long id,

        String cartao,

        DescricaoEntity descricao,

        FormaPagamentoEntity formaPagamento) {


    public TransacaoOutput(TransacaoEntity transacaoEntity) {
        this(transacaoEntity.getId(), transacaoEntity.getCartao(), transacaoEntity.getDescricaoEntity(), transacaoEntity.getFormaPagamentoEntity());
    }
}
