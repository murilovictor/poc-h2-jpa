package br.com.poch2jpa.controller.inheritance;

import br.com.poch2jpa.model.inheritance.InfoObjetoSeguradoAuto;
import br.com.poch2jpa.model.inheritance.InfoObjetoSeguradoRural;
import br.com.poch2jpa.model.inheritance.ObjetoSeguradoKey;
import br.com.poch2jpa.model.manytomany.Segment;
import br.com.poch2jpa.repository.manytomany.inheritance.InheritanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class InheritanceController {

    private final InheritanceRepository repository;

    @GetMapping("inheritance")
    public ResponseEntity<Set<Segment>> findSegments(@RequestParam String produto) {


        switch (produto) {
            case "RURAL":
                InfoObjetoSeguradoRural apoliceRuralDetail = new InfoObjetoSeguradoRural();
                ObjetoSeguradoKey objetoSeguradoKey = new ObjetoSeguradoKey();
                objetoSeguradoKey.setIdObjetoSegurado(1L);
                objetoSeguradoKey.setIdApolice(2L);
                objetoSeguradoKey.setIdConsentimento(3L);
                objetoSeguradoKey.setNrCNPJCompanhia(4L);
                objetoSeguradoKey.setSkRespostaAceitacaoSeguro(5L);
                objetoSeguradoKey.setDsProdutoSeguradoOriginal("RURAL");

                apoliceRuralDetail.setId(objetoSeguradoKey);
                apoliceRuralDetail.setProduct(produto);
                apoliceRuralDetail.setRebanho(1000);
                repository.save(apoliceRuralDetail);
                System.out.println(repository.findById(objetoSeguradoKey));
                break;
            case "AUTO":
                ObjetoSeguradoKey objetoSeguradoKeyr = new ObjetoSeguradoKey();
                objetoSeguradoKeyr.setIdObjetoSegurado(1L);
                objetoSeguradoKeyr.setIdApolice(2L);
                objetoSeguradoKeyr.setIdConsentimento(3L);
                objetoSeguradoKeyr.setNrCNPJCompanhia(4L);
                objetoSeguradoKeyr.setSkRespostaAceitacaoSeguro(5L);
                objetoSeguradoKeyr.setDsProdutoSeguradoOriginal("AUTO");

                InfoObjetoSeguradoAuto apoliceAutoDetail = new InfoObjetoSeguradoAuto();
                apoliceAutoDetail.setId(objetoSeguradoKeyr);
                apoliceAutoDetail.setProduct(produto);
                apoliceAutoDetail.setModelo("Azera");
                repository.save(apoliceAutoDetail);
                System.out.println(repository.findById(objetoSeguradoKeyr));

                break;
            default:
                System.out.println("Default");
                break;
        }


        return ResponseEntity.ok(null);
    }


}

