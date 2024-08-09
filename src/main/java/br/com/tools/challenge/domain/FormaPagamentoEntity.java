package br.com.tools.challenge.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoEntity {

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String parcelas;

}
