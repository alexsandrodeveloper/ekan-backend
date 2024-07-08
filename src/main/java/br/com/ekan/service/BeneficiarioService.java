package br.com.ekan.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ekan.dto.BeneficiarioDTO;
import br.com.ekan.exception.BeneficiarioInvalidDataException;
import br.com.ekan.exception.BeneficiarioNotFoundException;
import br.com.ekan.mapper.BeneficiarioMapper;
import br.com.ekan.model.BeneficiarioEntity;
import br.com.ekan.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioMapper beneficiarioMapper;

    @Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository, BeneficiarioMapper beneficiarioMapper) {
        this.beneficiarioRepository = beneficiarioRepository;
        this.beneficiarioMapper = beneficiarioMapper;
    }

    @Transactional
    public BeneficiarioDTO registrar(BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioEntity beneficiarioEntity = beneficiarioMapper.dtoToEntity(beneficiarioDTO);

        // Associando o beneficiário aos documentos
        BeneficiarioEntity finalBeneficiarioEntity = beneficiarioEntity;
        beneficiarioEntity.getDocumentos().forEach(documento -> documento.setBeneficiario(finalBeneficiarioEntity));

        beneficiarioEntity = beneficiarioRepository.save(beneficiarioEntity);
        return beneficiarioMapper.entityToDto(beneficiarioEntity);
    }


    public List<BeneficiarioDTO> listar() {
        List<BeneficiarioEntity> beneficiarioEntities = beneficiarioRepository.findAll();
        return beneficiarioEntities.stream()
                .map(beneficiarioMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public BeneficiarioDTO buscarBeneficiarioPorId(Long id) {
        BeneficiarioEntity beneficiarioEntity = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new BeneficiarioNotFoundException(id));
        return beneficiarioMapper.entityToDto(beneficiarioEntity);
    }

    @Transactional
    public BeneficiarioDTO atualizarBeneficiario(BeneficiarioDTO beneficiarioDTO) {
        try {
            BeneficiarioEntity beneficiarioEntity = beneficiarioMapper.dtoToEntity(beneficiarioDTO);
            beneficiarioEntity = beneficiarioRepository.save(beneficiarioEntity);
            return beneficiarioMapper.entityToDto(beneficiarioEntity);
        } catch (Exception e) {
            throw new BeneficiarioInvalidDataException("Erro ao atualizar beneficiário: " + e.getMessage());
        }
    }

    @Transactional
    public void deletarBeneficiario(Long id) {
        try {
            beneficiarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new BeneficiarioNotFoundException(id);
        }
    }
}
