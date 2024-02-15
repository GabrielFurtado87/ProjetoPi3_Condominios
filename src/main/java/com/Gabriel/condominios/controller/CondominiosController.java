/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Gabriel.condominios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Gabriel_PC
 *  
 */


@Controller
public class CondominiosController {
    
    @GetMapping("/index") // Define a URL do navegador
    public String index(){                
        return "index";
    }
    
    @GetMapping("/Sistema")
    public String Sistema(){
        return"Sistema";
    }
    
    @GetMapping("/Financeiro")
    public String Financeiro(){
        return"Financeiro";
    }
    
    
    @GetMapping("/CadGastos")
    public String CadGastos(){
        return"CadGastos";
    }
    
    @GetMapping("/CadAtendimentos")
    public String cadAtendimentos(){
        return"CadAtendimentos";
    }
    
    @GetMapping("/pesqGastos")
    public String pesqGastos(){
        return"pesqGastos";
    }
    
    @GetMapping("/pesqInadimplentes")
    public String pesqInadimplentes(){
        return"pesqInadimplentes";
    }
}
