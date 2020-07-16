package com.pagamento.senes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamento.senes.entity.CartaoCredito;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoCredito, Long> {

}
