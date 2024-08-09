package br.com.tools.challenge.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "transacao")
@Entity(name = "transacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cartao;

    @Embedded
    private DescricaoEntity descricaoEntity = new DescricaoEntity();

    @Embedded
    private FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();

}
