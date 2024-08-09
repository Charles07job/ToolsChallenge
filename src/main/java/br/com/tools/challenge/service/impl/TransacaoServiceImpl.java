package br.com.tools.challenge.service.impl;

import br.com.tools.challenge.converter.ConverterTransacao;
import br.com.tools.challenge.converter.dto.TransacaoInput;
import br.com.tools.challenge.converter.dto.TransacaoOutput;
import br.com.tools.challenge.domain.StatusTransacao;
import br.com.tools.challenge.repository.TransacaoRepository;
import br.com.tools.challenge.service.TransacaoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

    private TransacaoRepository repository;

    @Override
    public TransacaoOutput consultaTransacao(Long id) {
        var transacaoEntity = repository.getReferenceById(id);

        return ConverterTransacao.converterTransacaoOutput(transacaoEntity);
    }

    @Transactional
    @Override
    public TransacaoOutput executaTransacao(TransacaoInput input) {
        var transacaoEntity = ConverterTransacao.converterTransacaoInput(input);
        transacaoEntity.getDescricaoEntity().setNsu("123456789");
        transacaoEntity.getDescricaoEntity().setCodigoAutorizacao("123456123");
        transacaoEntity.getDescricaoEntity().setStatusTransacao(StatusTransacao.AUTORIZADO);
        repository.save(transacaoEntity);

        return ConverterTransacao.converterTransacaoOutput(transacaoEntity);
    }

    @Override
    public Page<TransacaoOutput> buscaTodasTransacoes(Pageable paginacao) {
        return repository.findAll(paginacao).map(TransacaoOutput::new);
    }

}
