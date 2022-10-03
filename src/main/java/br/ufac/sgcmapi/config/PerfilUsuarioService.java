package br.ufac.sgcmapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufac.sgcmapi.model.Usuario;
import br.ufac.sgcmapi.service.UsuarioService;

public class PerfilUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioService servico;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = servico.getByNomeUsuario(username);
        return new PerfilUsuario(usuario);
    }
    
}
