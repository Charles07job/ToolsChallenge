package br.com.tools.challenge.converter;

import br.com.tools.challenge.converter.dto.TransacaoInput;
import br.com.tools.challenge.converter.dto.TransacaoOutput;
import br.com.tools.challenge.domain.DescricaoEntity;
import br.com.tools.challenge.domain.FormaPagamentoEntity;
import br.com.tools.challenge.domain.Tipo;
import br.com.tools.challenge.domain.TransacaoEntity;

public class ConverterTransacao {

    public static TransacaoOutput converterTransacaoOutput(TransacaoEntity transacaoEntity) {
        DescricaoEntity descricaoEntityOutput = new DescricaoEntity(
                transacaoEntity.getDescricaoEntity().getValor(),
                transacaoEntity.getDescricaoEntity().getDataHora(),
                transacaoEntity.getDescricaoEntity().getEstabelecimento(),
                transacaoEntity.getDescricaoEntity().getNsu(),
                transacaoEntity.getDescricaoEntity().getCodigoAutorizacao(),
                transacaoEntity.getDescricaoEntity().getStatusTransacao()
        );

        FormaPagamentoEntity formaPagamentoEntityOutput = new FormaPagamentoEntity(
                transacaoEntity.getFormaPagamentoEntity().getTipo(),
                transacaoEntity.getFormaPagamentoEntity().getParcelas()
        );

        return new TransacaoOutput(
                transacaoEntity.getId(),
                transacaoEntity.getCartao(),
                descricaoEntityOutput,
                formaPagamentoEntityOutput
        );
    }

    public static TransacaoEntity converterTransacaoInput(TransacaoInput input) {
        var transacao = new TransacaoEntity();
        transacao.setId(input.id());
        transacao.setCartao(input.cartao());
        transacao.getDescricaoEntity().setValor(input.descricao().valor());
        transacao.getDescricaoEntity().setDataHora(input.descricao().dataHora());
        transacao.getDescricaoEntity().setEstabelecimento(input.descricao().estabelecimento());
        transacao.getFormaPagamentoEntity().setTipo(Tipo.valueOf(input.formaPagamento().tipo()));
        transacao.getFormaPagamentoEntity().setParcelas(input.formaPagamento().parcelas());

        return transacao;
    }
}
