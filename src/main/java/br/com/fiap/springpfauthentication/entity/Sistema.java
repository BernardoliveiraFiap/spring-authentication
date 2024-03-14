package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "TB_2TDSPF_SISTEMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(
            name = "SQ_SISTEMA",
            sequenceName = "SQ_SISTEMA",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_SISTEMA")
    private long id;

    @Column(name = "NM_SISTEMA")
    private String nome;

    @Column(name = "SG_SISTEMA")
    private String sigla;

    @OneToMany(mappedBy = "sistema")
    private Set<Permissao> permissoes;

    @ManyToMany(mappedBy = "responsaveis")
    private Set<Usuario> responsaveis;
}

