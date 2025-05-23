package br.com.fiap.checkpoint3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.checkpoint3.model.Consulta;
import br.com.fiap.checkpoint3.model.ConsultaStatus;

public interface ConsultaRepository 
        extends JpaRepository <Consulta, Long>{

        public List <Consulta> findByStatus (ConsultaStatus status);
} 
