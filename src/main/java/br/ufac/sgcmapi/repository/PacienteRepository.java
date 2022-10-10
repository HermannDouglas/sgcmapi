package br.ufac.sgcmapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query(
        "SELECT p FROM Paciente p WHERE p.nome LIKE %?1%" +
        " OR p.email LIKE %?1%" +
        " OR p.telefone LIKE %?1%" +
        " OR p.dataNascimento LIKE %?1%" +
        " OR p.grupoSanguineo LIKE %?1%" +
        " OR p.sexo LIKE %?1%" +
        " OR p.cep LIKE %?1%" +
        " OR p.endereco LIKE %?1%"
    )
    List<Paciente> findByAll(String termoBusca);
    
}
