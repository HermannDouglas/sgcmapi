package br.ufac.sgcmapi.controller;

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

import br.ufac.sgcmapi.model.Profissional;
import br.ufac.sgcmapi.service.ProfissionalService;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController implements ICrudController<Profissional> {

    private final ProfissionalService servico;

    @Autowired
    public ProfissionalController(
            ProfissionalService servico) {
        this.servico = servico;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Profissional>> getAll() {
        List<Profissional> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getById(@PathVariable("id") Long id) {
        Profissional registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Profissional> insert(@RequestBody Profissional objeto) {
        Profissional registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Profissional> update(@RequestBody Profissional objeto) {
        Profissional registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Profissional> updateStatus(@PathVariable("id") Long id) {
        Profissional registro = servico.updateStatus(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Profissional>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Profissional> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
    
}
