package br.ufac.sgcmapi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.EStatus;
import br.ufac.sgcmapi.model.Profissional;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@Service
public class AtendimentoService implements ICrudService<Atendimento> {

    private final AtendimentoRepository repo;
    private final ProfissionalService servicoProfissional;

    @Autowired
    public AtendimentoService(
            AtendimentoRepository repo,
            ProfissionalService servicoProfissional) {
        this.repo = repo;
        this.servicoProfissional = servicoProfissional;
    }

    @Override
    public List<Atendimento> getAll() {
        return repo.findAll();
    }

    @Override
    public Atendimento getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Atendimento save(Atendimento objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Atendimento registro = repo.findById(id).orElse(null);
        registro.setStatus(EStatus.CANCELADO);
        repo.save(registro);
    }

    public Atendimento updateStatus(Long id) {
        Atendimento registro = repo.findById(id).orElse(null);
        registro.setStatus(registro.getStatus().proximo());
        repo.save(registro);
        return registro;
    }

    @Override
    public List<Atendimento> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    public List<String> getHorarios(Long profissional_id, Date data) {
        Profissional profissional = servicoProfissional.getById(profissional_id);
        List<Atendimento> atendimentos = repo.findByProfissionalAndData(profissional, data);
        List<String> horarios = new ArrayList<>();     
        for (Atendimento item: atendimentos) {
            horarios.add(item.getHora().toString());
        }
        return horarios;
    }

    public List<Atendimento> getByStatus(List<EStatus> status) {
        List<Atendimento> registros = repo.findByStatusIn(status);
        return registros;
    }
    
}
