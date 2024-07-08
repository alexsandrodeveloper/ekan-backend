package br.com.ekan.service;

import br.com.ekan.dto.DocumentoDTO;
import br.com.ekan.exception.BeneficiarioNotFoundException;
import br.com.ekan.mapper.DocumentoMapper;
import br.com.ekan.model.DocumentoEntity;
import br.com.ekan.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository, DocumentoMapper documentoMapper) {
        this.documentoRepository = documentoRepository;
        this.documentoMapper = documentoMapper;
    }

    @Transactional
    public List<DocumentoDTO> listarDocumentosPorBeneficiario(Long idBeneficiario) {
        List<DocumentoEntity> documentos = documentoRepository.findAllByBeneficiarioId(idBeneficiario);
        if (documentos.isEmpty()) {
            throw new BeneficiarioNotFoundException(idBeneficiario);
        }
        return documentos.stream()
                .map(documentoMapper::entityToDto)
                .collect(Collectors.toList());
    }
}

