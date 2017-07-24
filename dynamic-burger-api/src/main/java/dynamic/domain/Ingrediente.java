package dynamic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="INGREDIENTE")
public class Ingrediente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ingrediente_id", unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String nome;

  @Column(unique = true, nullable = false, precision = 10, scale = 2)
  private Double valor;

//  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredientes")
//  private Set<Lanche> lanches;

  public Ingrediente() {
  }

  public Ingrediente(Long id, String nome, Double valor) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }
}
