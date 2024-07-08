package br.com.ekan.controller;

import br.com.ekan.enums.TipoDocumento;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import br.com.ekan.dto.BeneficiarioDTO;
import br.com.ekan.dto.DocumentoDTO;
import br.com.ekan.service.BeneficiarioService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@AutoConfigureMockMvc
public class BeneficiarioControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BeneficiarioService beneficiarioService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private BeneficiarioDTO beneficiarioDTO;
    private List<BeneficiarioDTO> beneficiariosDto;

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());

        beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setId(1L);
        beneficiarioDTO.setNome("João Silva");
        beneficiarioDTO.setTelefone("11999999999");
        beneficiarioDTO.setDataNascimento(LocalDate.of(1990, 1, 1));

        DocumentoDTO documentoDTO1 = new DocumentoDTO();
        documentoDTO1.setId(1L);
        documentoDTO1.setTipoDocumento(TipoDocumento.CPF);
        documentoDTO1.setDescricao("99999999999");

        DocumentoDTO documentoDTO2 = new DocumentoDTO();
        documentoDTO2.setId(2L);
        documentoDTO2.setTipoDocumento(TipoDocumento.RG);
        documentoDTO2.setDescricao("999999999");

        List<DocumentoDTO> documentos = new ArrayList<>();
        documentos.add(documentoDTO1);
        documentos.add(documentoDTO2);

        beneficiarioDTO.setDocumentos(documentos);

        beneficiariosDto = new ArrayList<>();
        beneficiariosDto.add(beneficiarioDTO);
    }

    //@Test
    //@WithMockUser(username = "ekan", roles = "USER")
    public void testRegistrarBeneficiario() throws Exception {
        mockMvc.perform(post("/api/beneficiario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beneficiarioDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }

    //@Test
    //@WithMockUser(username = "ekan", roles = "USER")
    public void testListarBeneficiarios() throws Exception {
        Mockito.when(beneficiarioService.listar()).thenReturn(beneficiariosDto);

        mockMvc.perform(get("/api/beneficiario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }
}




