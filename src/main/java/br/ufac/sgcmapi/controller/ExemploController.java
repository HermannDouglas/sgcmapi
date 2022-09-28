package br.ufac.sgcmapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@Controller
public class ExemploController {
    
    private final AtendimentoRepository repo;

    @Autowired
    public ExemploController(AtendimentoRepository repo){
        this.repo = repo;
    }

    @RequestMapping("/exemplo")
    @ResponseBody
    public String exemplo(){
        List<Atendimento> atendimentos = repo.findAll();
        StringBuilder resultado = new StringBuilder();
        for (Atendimento item : atendimentos) {
            resultado.append(item.getId() + "\n");
            resultado.append(item.getData() + "\n");
            resultado.append(item.getHora() + "\n");
            resultado.append(item.getStatus() + "\n");
            resultado.append(item.getPaciente().getNome() + "\n");
            resultado.append(item.getProfissional().getNome() + "\n");
            resultado.append(item.getConvenio().getNome() + "\n");
            resultado.append("\n");
        }
        return "<pre>" + resultado.toString() + "</pre>";
    }

}
