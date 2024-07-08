package br.com.ekan.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.com.ekan.dto.BeneficiarioDTO;
import br.com.ekan.mapper.BeneficiarioMapper;
import br.com.ekan.model.BeneficiarioEntity;
import br.com.ekan.repository.BeneficiarioRepository;

@SpringBootTest
@Transactional
class BeneficiarioServiceUnitTest {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private BeneficiarioMapper beneficiarioMapper;

    //@Test
    public void testRegistrarBeneficiario() {
        // Criação de um BeneficiarioDTO para teste
        BeneficiarioDTO dto = new BeneficiarioDTO();
        dto.setNome("João Silva");
        dto.setTelefone("+5511999999999");
        dto.setDataNascimento(LocalDate.of(1990, 1, 1));
        dto.setDocumentos(new ArrayList<>());

        // Chama o método do serviço
        BeneficiarioDTO resultDTO = beneficiarioService.registrar(dto);

        // Verificações
        assertNotNull(resultDTO.getId());
        assertEquals(dto.getNome(), resultDTO.getNome());
        assertEquals(dto.getTelefone(), resultDTO.getTelefone());
        assertEquals(dto.getDataNascimento(), resultDTO.getDataNascimento());

        // Verifica se o beneficiário foi salvo no banco de dados
        BeneficiarioEntity savedEntity = beneficiarioRepository.findById(resultDTO.getId())
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado no banco de dados"));

        assertEquals(dto.getNome(), savedEntity.getNome());
        assertEquals(dto.getTelefone(), savedEntity.getTelefone());
        assertEquals(dto.getDataNascimento(), savedEntity.getDataNascimento());
    }
}
