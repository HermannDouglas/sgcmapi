package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Unidade;
import br.ufac.sgcmapi.repository.UnidadeRepository;

@Service
public class UnidadeService implements ICrudService<Unidade> {

    private final UnidadeRepository repo;

    @Autowired
    public UnidadeService(UnidadeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Unidade> getAll() {
        return repo.findAll();
    }

    @Override
    public Unidade getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Unidade> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Unidade save(Unidade objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);        
    }
    
}
