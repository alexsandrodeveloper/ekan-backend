package br.com.ekan.mapper;

import br.com.ekan.dto.BeneficiarioDTO;
import br.com.ekan.dto.DocumentoDTO;
import br.com.ekan.model.BeneficiarioEntity;
import br.com.ekan.model.DocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = DocumentoMapper.class)
public interface BeneficiarioMapper {

    BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);

    @Mappings({
            @Mapping(target = "documentos", qualifiedByName = "mapDocumentosDTOToEntity"),
            @Mapping(target = "dataInclusao", ignore = true), // Ignorar dataInclusao na conversão DTO para Entity
            @Mapping(target = "dataAtualizacao", ignore = true) // Ignorar dataAtualizacao na conversão DTO para Entity
    })
    BeneficiarioEntity dtoToEntity(BeneficiarioDTO dto);

    @Mappings({
            @Mapping(target = "documentos", qualifiedByName = "mapDocumentosEntityToDTO")
    })
    BeneficiarioDTO entityToDto(BeneficiarioEntity entity);

    @Named("mapDocumentosDTOToEntity")
    default List<DocumentoEntity> mapDocumentosDTOToEntity(List<DocumentoDTO> documentosDTO) {
        return DocumentoMapper.INSTANCE.dtosToEntities(documentosDTO);
    }

    @Named("mapDocumentosEntityToDTO")
    default List<DocumentoDTO> mapDocumentosEntityToDTO(List<DocumentoEntity> documentosEntity) {
        return DocumentoMapper.INSTANCE.entitiesToDtos(documentosEntity);
    }
}
