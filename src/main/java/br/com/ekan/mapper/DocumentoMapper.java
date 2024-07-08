package br.com.ekan.mapper;

import br.com.ekan.dto.DocumentoDTO;
import br.com.ekan.model.DocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    @Mapping(source = "beneficiario.id", target = "beneficiarioId")
    DocumentoDTO entityToDto(DocumentoEntity documentoEntity);

    @Mapping(source = "beneficiarioId", target = "beneficiario.id")
    DocumentoEntity dtoToEntity(DocumentoDTO documentoDTO);

    List<DocumentoDTO> entitiesToDtos(List<DocumentoEntity> documentosEntity);

    List<DocumentoEntity> dtosToEntities(List<DocumentoDTO> documentosDTO);
}
