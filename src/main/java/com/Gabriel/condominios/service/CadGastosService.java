package com.Gabriel.condominios.service;

import com.Gabriel.condominios.data.FinanceiroEntity;
import com.Gabriel.condominios.data.FinanceiroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadGastosService {
    @Autowired
    FinanceiroRepository financeiroRepository;
    
    public FinanceiroEntity criarGasto(FinanceiroEntity cadastroGasto){
        cadastroGasto.setId(null);
        financeiroRepository.save(cadastroGasto);
        return cadastroGasto;        
    }
    
    public List<FinanceiroEntity> listarGastos(){
        return financeiroRepository.findAll();
    } 
    
}
