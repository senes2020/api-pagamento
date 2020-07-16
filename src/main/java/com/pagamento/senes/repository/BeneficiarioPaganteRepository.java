package com.pagamento.senes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamento.senes.entity.BeneficiarioPagante;

@Repository
public interface BeneficiarioPaganteRepository extends JpaRepository<BeneficiarioPagante, Long>{

	public BeneficiarioPagante findByCpf(String cpf);
	
}
