package com.Gabriel.condominios.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="financeiro")
public class FinanceiroEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  
    private Double SALDO;
    private String DESCRICAO;    
    private Double VALOR_TOTAL;
    private Date DATA_GASTO;
    
}
