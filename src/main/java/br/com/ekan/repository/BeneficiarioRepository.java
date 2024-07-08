package br.com.ekan.repository;

import br.com.ekan.model.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Long> {
}
