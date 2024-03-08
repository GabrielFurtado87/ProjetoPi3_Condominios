package com.Gabriel.condominios.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Integer>{
    
}
