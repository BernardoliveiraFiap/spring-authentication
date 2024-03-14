package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "TB_2TDSPF_USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(
            name = "SQ_USUARIO",
            sequenceName = "SQ_USUARIO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_USUARIO")
    private long id;

    @Column(name = "DS_EMAIL", unique = true)
    private String email;

    @Column(name = "DS_SENHA")
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TB_2TDSPF_USUARIO",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_ID_PESSOA")
    )
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_2TDSPF_USUARIO_SISTEMA",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_SISTEMA")
    )
    private Set<Sistema> responsaveis;
}


