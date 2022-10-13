package br.ufac.sgcmapi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.EStatus;
import br.ufac.sgcmapi.service.AtendimentoService;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController implements ICrudController<Atendimento> {

    private final AtendimentoService servico;

    @Autowired
    public AtendimentoController(
            AtendimentoService servico) {
        this.servico = servico;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Atendimento>> getAll() {
        List<Atendimento> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getById(@PathVariable("id") Long id) {
        Atendimento registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Atendimento> insert(@RequestBody Atendimento objeto) {
        Atendimento registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Atendimento> update(@RequestBody Atendimento objeto) {
        Atendimento registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Atendimento> updateStatus(@PathVariable("id") Long id) {
        Atendimento registro = servico.updateStatus(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Atendimento>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Atendimento> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/horarios/profissional/{profissional_id}/data/{data}")
    public ResponseEntity<List<String>> getHorarios(@PathVariable("profissional_id") Long profissional_id, @PathVariable("data") LocalDate data) {
        List<String> registros = servico.getHorarios(profissional_id, data);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/busca/status/{status}")
    public ResponseEntity<List<Atendimento>> getByStatus(@PathVariable("status") List<EStatus> status) {
        List<Atendimento> registros = servico.getByStatus(status);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/busca/{termoBusca}/status/{status}")
    public ResponseEntity<List<Atendimento>> getByAllAndStatus(@PathVariable("termoBusca") String termoBusca, @PathVariable("status") List<EStatus> status) {
        List<Atendimento> registros = servico.getByAllAndStatus(termoBusca, status);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
    
}
