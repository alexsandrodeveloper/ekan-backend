package br.com.ekan.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beneficiarios")
@Data
public class BeneficiarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate dataInclusao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoEntity> documentos;
}

