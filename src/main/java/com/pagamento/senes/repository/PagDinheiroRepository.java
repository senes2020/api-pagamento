package com.pagamento.senes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamento.senes.entity.Dinheiro;

@Repository
public interface PagDinheiroRepository extends JpaRepository<Dinheiro, Long>{

}
