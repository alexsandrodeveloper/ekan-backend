package br.com.ekan.dto;

import br.com.ekan.annotations.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO para representar um beneficiário")
public class BeneficiarioDTO {

    private Long id;

    @ApiModelProperty(value = "Nome do beneficiário", example = "João Silva")
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @ApiModelProperty(value = "Número de telefone do beneficiário", example = "+5511999999999")
    @Phone
    private String telefone;

    @ApiModelProperty(value = "Data de nascimento do beneficiário", example = "1990-01-01")
    @NotNull(message = "A data da transferência não pode estar em branco")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Lista de documentos do beneficiário")
    @NotEmpty(message = "A lista de documentos não pode estar vazia")
    @Valid
    private List<DocumentoDTO> documentos;

    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;
}
