package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Paciente;
import br.ufac.sgcmapi.repository.PacienteRepository;

@Service
public class PacienteService implements ICrudService<Paciente> {

    private final PacienteRepository repo;

    @Autowired
    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Paciente> getAll() {
        return repo.findAll();
    }

    @Override
    public Paciente getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Paciente save(Paciente objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
