package br.com.poch2jpa.model.manytomany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = @Index(columnList = "description"))
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private String url;

    @OrderBy
    @ManyToMany
    @JoinTable(name = "component_compositions",
            joinColumns = {@JoinColumn(name = "component_id")},
            inverseJoinColumns = {@JoinColumn(name = "compositions_id")})
    private Set<Composition> compositions = new HashSet<>();

}
