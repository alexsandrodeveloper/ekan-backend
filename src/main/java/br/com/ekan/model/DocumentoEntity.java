package br.com.ekan.model;

import br.com.ekan.enums.TipoDocumento;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documentos")
@Data
public class DocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false)
    private String descricao;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate dataInclusao;

    @UpdateTimestamp
    @Column
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private BeneficiarioEntity beneficiario;

}
