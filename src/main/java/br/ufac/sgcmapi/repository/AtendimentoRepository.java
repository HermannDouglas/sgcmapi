package br.ufac.sgcmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.sgcmapi.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    
}
