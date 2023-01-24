package br.com.poch2jpa.repository.manytomany.inheritance;

import br.com.poch2jpa.model.inheritance.ObjetoSegurado;
import br.com.poch2jpa.model.inheritance.ObjetoSeguradoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InheritanceRepository extends JpaRepository<ObjetoSegurado, Long> {

    ObjetoSegurado findById(ObjetoSeguradoKey objetoSeguradoKey);


}
