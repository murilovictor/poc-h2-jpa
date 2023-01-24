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
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;

    @OrderBy
    @ManyToMany
    @JoinTable(name = "segment_components",
            joinColumns = {@JoinColumn(name = "segment_id")},
            inverseJoinColumns = {@JoinColumn(name = "components_id")})
    private Set<Component> components = new HashSet<>();

}
