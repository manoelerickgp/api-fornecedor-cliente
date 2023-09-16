package com.ecommerce.API.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.API.Ecommerce.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
