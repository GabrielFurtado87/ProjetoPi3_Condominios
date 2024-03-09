package com.Gabriel.condominios.service;

import com.Gabriel.condominios.data.AgendaEntity;
import com.Gabriel.condominios.data.AgendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
    
    @Autowired
    AgendaRepository agendaRepository;
    //Criar agendamentos
    public AgendaEntity criarAgendamento(AgendaEntity agendamento){
        agendamento.setId(null);
        agendaRepository.save(agendamento);
        return agendamento;        
    }
    //Listar agendamentos
    public List<AgendaEntity> listarAgendamentos(){
        return agendaRepository.findAll();
    }
    
    //Encontrar Agendamento pelo ID
    public AgendaEntity getAgendaById(Integer agendaID){
        return agendaRepository.findById(agendaID).orElse(null);
    }
    
    //Deletar agendamentos
    public void deletarAgendamento(Integer idAgendamento){
        AgendaEntity agenda = getAgendaById(idAgendamento);
        agendaRepository.deleteById(agenda.getId());
    }
    
     
}
