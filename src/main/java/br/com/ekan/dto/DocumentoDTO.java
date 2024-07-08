package br.com.ekan.dto;

import br.com.ekan.annotations.Document;
import br.com.ekan.annotations.EnumNamePattern;
import br.com.ekan.enums.TipoDocumento;
import br.com.ekan.model.BeneficiarioEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO para representar um documento")
public class DocumentoDTO {

    private Long id;

    @ApiModelProperty(value = "Tipo de Documento do Beneficiario", required = true, example = "CPF")
    @EnumNamePattern(regexp = "RG|CPF|CNPJ", message = "Tipop de documento inválido")
    private TipoDocumento tipoDocumento;

    @ApiModelProperty(value = "Descrição do documento", example = "99999999999")
    @NotBlank(message = "O número do documento não pode estar em branco")
    @Document(message = "Documento inválido")
    private String descricao;

    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;

    private Long beneficiarioId;
}
