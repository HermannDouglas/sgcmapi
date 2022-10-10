package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Especialidade;
import br.ufac.sgcmapi.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService implements ICrudService<Especialidade> {

    private final EspecialidadeRepository repo;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Especialidade> getAll() {
        return repo.findAll();
    }

    @Override
    public Especialidade getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Especialidade> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Especialidade save(Especialidade objeto) {
       return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
