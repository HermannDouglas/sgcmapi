package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Convenio;
import br.ufac.sgcmapi.repository.ConvenioRepository;

@Service
public class ConvenioService implements ICrudService<Convenio> {

    private final ConvenioRepository repo;

    @Autowired
    public ConvenioService(ConvenioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Convenio> getAll() {
        return repo.findAll();
    }

    @Override
    public Convenio getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Convenio> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Convenio save(Convenio objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
