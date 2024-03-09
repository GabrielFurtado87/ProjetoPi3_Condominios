package com.Gabriel.condominios.service;

import com.Gabriel.condominios.data.ApartamentosEntity;
import com.Gabriel.condominios.data.ApartamentosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApartamentosService {
    
    @Autowired
    ApartamentosRepository apartamentosRepository;
    
    //Listar agendamentos
    public List<ApartamentosEntity> listarInadimplentes(){
        return apartamentosRepository.findAll();
    }
}
