package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_LOJA")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOJA")
    @SequenceGenerator(name = "SQ_LOJA", sequenceName = "SQ_LOJA", allocationSize = 1)
    @Column(name = "ID_LOJA")
    private Long id;

    @Column(name = "NOME_LOJA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_LOJA_VEICULOS_COMERCIALIZADOS",
            joinColumns = {
                    @JoinColumn(
                            name = "LOJA",
                            referencedColumnName = "ID_LOJA",
                            foreignKey = @ForeignKey(
                                    name = "FK_LOJA_VEICULOS_COMERCIALIZADOS"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "VEICULOS_COMERCIALIZADOS",
                            referencedColumnName = "ID_VEICULOS_COMERCIALIZADOS",
                            foreignKey = @ForeignKey(
                                    name = "FK_VEICULOS_COMERCIALIZADOS_LOJA"
                            )
                    )
            }
    )
    private Set<Veiculo> veiculosComercializados = new LinkedHashSet<>();

}
