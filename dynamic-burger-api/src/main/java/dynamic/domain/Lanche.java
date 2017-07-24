package dynamic.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="LANCHE")
public class Lanche {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "lanche_id", unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String nome;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  @JoinTable(name = "LANCHE_INGREDIENTE",
          joinColumns = { @JoinColumn(name = "lanche_id") },
          inverseJoinColumns = { @JoinColumn(name = "ingrediente_id") })
  private List<Ingrediente> ingredientes;

  @Transient
  private Double valor;

  public Lanche() {
  }

  public Lanche(Long id, String nome) {
    this.id = id;
    this.nome = nome;
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

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }
}
