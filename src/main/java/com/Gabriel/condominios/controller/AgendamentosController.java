package com.Gabriel.condominios.controller;

import com.Gabriel.condominios.data.AgendaEntity;
import com.Gabriel.condominios.service.AgendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CadAtendimentos")
public class AgendamentosController {
    
    @Autowired
    AgendaService agendaService;
    
    
    //Buscar todos os agendamentos
    @GetMapping("/buscar")
    public ResponseEntity<List> listarAgendamentos(){
     List<AgendaEntity> atendimentos = agendaService.listarAgendamentos();
     return new ResponseEntity<>(atendimentos, HttpStatus.OK);     
    }    
    
    @PostMapping("/cadastrar")
    public ResponseEntity<AgendaEntity> cadastroAgendamento(@RequestBody AgendaEntity agenda){
        var novoAgendamento = agendaService.criarAgendamento(agenda);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.OK);
    }    
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarAgendamento(@PathVariable int id){
        agendaService.deletarAgendamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}
