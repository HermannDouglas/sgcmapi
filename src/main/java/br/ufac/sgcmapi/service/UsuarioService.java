package br.ufac.sgcmapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.EPapel;
import br.ufac.sgcmapi.model.Usuario;
import br.ufac.sgcmapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICrudService<Usuario> {

    private final UsuarioRepository repo;

    @Autowired
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<String> getPapeis() {
        return Stream.of(EPapel.values())
            .map(item -> item.name())
            .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> registros = repo.findAll();
        return registros;
    }

    @Override
    public Usuario getById(Long id) {
        Usuario registro = repo.findById(id).orElse(null);
        return registro;
    }

    @Override
    public List<Usuario> getByAll(String termoBusca) {
        List<Usuario> registros = repo.findByAll(termoBusca);
        return registros;
    }

    @Override
    public Usuario save(Usuario objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Usuario getByNomeUsuario(String nomeUsuario) {
        Usuario usuario = repo.findByNomeUsuario(nomeUsuario);
        return usuario;
    }
    
}
