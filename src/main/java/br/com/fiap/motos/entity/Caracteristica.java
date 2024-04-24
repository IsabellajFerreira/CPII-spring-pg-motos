package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_CARACTERISTICA_2TDSPG", uniqueConstraints = {
        @UniqueConstraint( name = "UK_TB_CARACTERISTICA", columnNames = {"NOME_CARACTERISTICA", "ID_VEICULO" })
})
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARACTERISTICA")
    @SequenceGenerator(name = "SQ_CARACTERISTICA", sequenceName = "SQ_CARACTERISTICA", allocationSize = 1)
    @Column(name = "ID_CARACTERISTICA")
    private Long id;

    //30 digitos
    @Column(name = "NOME_CARACTERISTICA", length = 30)
    private String nome;

    //20 digitos
    @Column(name = "DESCRICAO_CARACTERISTICA", length = 20)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_VEICULO",
            referencedColumnName = "ID_VEICULO",
            foreignKey = @ForeignKey(name = "FK_CARACTERISTICA_VEICULO"),
            nullable = false
    )
    private Veiculo veiculo;


}
