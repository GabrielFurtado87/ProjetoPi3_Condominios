package com.Gabriel.condominios.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="apartamentos")
public class ApartamentosEntity {
    @Id
    private Integer idApartamentos;  
    private Integer id_VagaGaragem;        
    private String Situacao;
    
}
