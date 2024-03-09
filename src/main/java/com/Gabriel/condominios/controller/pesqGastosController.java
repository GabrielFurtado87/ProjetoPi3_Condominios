package com.Gabriel.condominios.controller;

import com.Gabriel.condominios.data.FinanceiroEntity;
import com.Gabriel.condominios.service.PesqGastosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PesqGastos")
public class pesqGastosController {
    
    @Autowired
    PesqGastosService pesqGastosService;
    
    
    @GetMapping("/buscar")
    public ResponseEntity<List> listarInadimplentes(){
     List<FinanceiroEntity> financeiro = pesqGastosService.listarGastos();
     return new ResponseEntity<>(financeiro, HttpStatus.OK);     
    }
      
    
}
