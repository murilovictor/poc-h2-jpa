package br.com.poch2jpa.model.inheritance;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ObjetoSeguradoKey implements Serializable {

    private Long idObjetoSegurado;
    private Long idApolice;
    private Long idConsentimento;
    private Long skRespostaAceitacaoSeguro;
    private Long nrCNPJCompanhia;
    private String dsProdutoSeguradoOriginal;

}