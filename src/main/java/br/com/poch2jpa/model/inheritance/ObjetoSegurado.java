package br.com.poch2jpa.model.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tbObjetoSegurado")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ObjetoSegurado {

    @EmbeddedId
    private ObjetoSeguradoKey id;

    private String numero;

    private String product;

}
