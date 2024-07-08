package br.com.ekan.controller;

import br.com.ekan.dto.BeneficiarioDTO;
import br.com.ekan.dto.DocumentoDTO;
import br.com.ekan.service.BeneficiarioService;
import br.com.ekan.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> registrar(@Valid @RequestBody BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioDTO novoBeneficiario = beneficiarioService.registrar(beneficiarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBeneficiario);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> buscarBeneficiarios() {
        List<BeneficiarioDTO> beneficiarios = beneficiarioService.listar();
        return ResponseEntity.ok(beneficiarios);
    }

    @GetMapping("/{id}/documentos")
    public ResponseEntity<List<DocumentoDTO>> listarDocumentosPorBeneficiario(@PathVariable Long id) {
        List<DocumentoDTO> documentos = documentoService.listarDocumentosPorBeneficiario(id);
        return ResponseEntity.ok(documentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> atualizarBeneficiario(@PathVariable Long id, @Valid @RequestBody BeneficiarioDTO beneficiarioDTO) {
        beneficiarioDTO.setId(id); // Assegura que o DTO tenha o ID correto
        BeneficiarioDTO beneficiarioAtualizado = beneficiarioService.atualizarBeneficiario(beneficiarioDTO);
        return ResponseEntity.ok(beneficiarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return ResponseEntity.noContent().build();
    }
}

