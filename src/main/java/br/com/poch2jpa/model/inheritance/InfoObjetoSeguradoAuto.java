package br.com.poch2jpa.model.inheritance;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tbInfoComplementarObjetoSeguradoAuto")
public class InfoObjetoSeguradoAuto extends ObjetoSegurado {

    @Column(name = "cdModeloAuto")
    private String modelo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InfoObjetoSeguradoAuto that = (InfoObjetoSeguradoAuto) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}