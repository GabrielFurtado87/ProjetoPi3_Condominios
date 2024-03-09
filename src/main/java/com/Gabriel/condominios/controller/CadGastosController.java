package com.Gabriel.condominios.controller;

import com.Gabriel.condominios.data.FinanceiroEntity;
import com.Gabriel.condominios.service.CadGastosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CadGastos")
public class CadGastosController {
    
    @Autowired
    CadGastosService cadGastosService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<FinanceiroEntity> cadastroAgendamento(@RequestBody FinanceiroEntity financeiro){
        var novoGasto = cadGastosService.criarGasto(financeiro);
        return new ResponseEntity<>(novoGasto, HttpStatus.OK);
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List> ListarGastos(){
     List<FinanceiroEntity> financeiro = cadGastosService.listarGastos();
     return new ResponseEntity<>(financeiro, HttpStatus.OK);     
    }
    
    
}
