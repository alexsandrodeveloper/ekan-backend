package br.com.ekan.repository;

import br.com.ekan.model.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {

    List<DocumentoEntity> findAllByBeneficiarioId(Long beneficiarioId);}
