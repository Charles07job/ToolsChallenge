package br.com.tools.challenge.service;

import br.com.tools.challenge.converter.dto.TransacaoInput;
import br.com.tools.challenge.converter.dto.TransacaoOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TransacaoService {

    TransacaoOutput consultaTransacao (Long id);

    TransacaoOutput executaTransacao(TransacaoInput input);

    Page<TransacaoOutput> buscaTodasTransacoes(Pageable paginacao);
}
