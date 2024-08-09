package br.com.tools.challenge.controller;

import br.com.tools.challenge.converter.dto.TransacaoInput;
import br.com.tools.challenge.converter.dto.TransacaoOutput;
import br.com.tools.challenge.domain.StatusTransacao;
import br.com.tools.challenge.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Controller
@RequestMapping("transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    @GetMapping("/{id}")
    ResponseEntity<TransacaoOutput> buscaTransacaoPorId(@PathVariable Long id) {
        var transacaoOutput = transacaoService.consultaTransacao(id);
        transacaoOutput.descricao().setStatusTransacao(StatusTransacao.NEGADO);

        return ResponseEntity.ok(transacaoOutput);
    }

    @PostMapping
    public ResponseEntity<TransacaoOutput> executaTransacao (@RequestBody TransacaoInput input, UriComponentsBuilder uriBuilder) {
        var transacaoOutput = transacaoService.executaTransacao(input);

        var uri = uriBuilder.path("/transacao/{id}").buildAndExpand(transacaoOutput.id()).toUri();

        return ResponseEntity.created(uri).body(transacaoOutput);
    }

    @GetMapping
    public ResponseEntity<Page<TransacaoOutput>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = transacaoService.buscaTodasTransacoes(paginacao);

        return ResponseEntity.ok(page);
    }

}
