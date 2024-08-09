package br.com.tools.challenge.service;

import br.com.tools.challenge.Factory.TransacaoFactory;
import br.com.tools.challenge.converter.dto.TransacaoOutput;
import br.com.tools.challenge.domain.TransacaoEntity;
import br.com.tools.challenge.repository.TransacaoRepository;
import br.com.tools.challenge.service.impl.TransacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransacaoEntityServiceImplTest {

    @Mock
    private TransacaoRepository repository;

    @Captor
    ArgumentCaptor<Long> argumentCaptorLong;

    @InjectMocks
    private TransacaoServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultaTransacao() {
        when(repository.getReferenceById(argumentCaptorLong.capture())).thenReturn(new TransacaoEntity());

        service.consultaTransacao(1L);

        verify(repository).getReferenceById(argumentCaptorLong.getValue());
    }

    @Test
    void testExecutaTransacao() {
        var transacaoInput = TransacaoFactory.transacaoInputMock();

        var output = service.executaTransacao(transacaoInput);

        assertThat(output).isNotNull();
        verify(repository, times(1)).save(any());
    }

    @Test
    void testBuscaTodasTransacoes() {
        Pageable paginacao = Pageable.ofSize(10);
        TransacaoEntity transacao = new TransacaoEntity();
        TransacaoOutput transacaoOutput = new TransacaoOutput(transacao);
        Page<TransacaoEntity> paginaTransacoes = new PageImpl<>(List.of(transacao), paginacao, 1);
        when(repository.findAll(paginacao)).thenReturn(paginaTransacoes);

        Page<TransacaoOutput> resultado = service.buscaTodasTransacoes(paginacao);

        assertEquals(1, resultado.getTotalElements());
        assertEquals(transacaoOutput, resultado.getContent().get(0));
        verify(repository).findAll(paginacao);
    }

}