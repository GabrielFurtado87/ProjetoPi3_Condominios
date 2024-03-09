package com.Gabriel.condominios.controller;


import com.Gabriel.condominios.data.ApartamentosEntity;
import com.Gabriel.condominios.service.ApartamentosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pesqInadimplentes")
public class ApartamentosController {
    
    @Autowired
    ApartamentosService apartamentosService;
    
    @GetMapping("/buscar")
    public ResponseEntity<List> listarInadimplentes(){
     List<ApartamentosEntity> inadimplentes = apartamentosService.listarInadimplentes();
     return new ResponseEntity<>(inadimplentes, HttpStatus.OK);     
    }    

    
}
