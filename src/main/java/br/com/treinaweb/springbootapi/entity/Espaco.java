package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Espaco {

  @ApiModelProperty(value = "Código do evento")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ApiModelProperty(value = "Nome do Espaco")
  @Column(nullable = false)
  private String nome;

  @ApiModelProperty(value = "Localizacao do espaco")
  @Column(nullable = false)
  private String localizacao;

  @ApiModelProperty(value = "Capacidade do Espaco")
  @Column(nullable = false)
  private Integer capacidade;

  @ApiModelProperty(value = "Recursos do Espaco")
  @Column(nullable = false)
  private String recursos;

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public Integer getCapacidade() {
    return capacidade;
  }

  public String getRecursos() {
    return recursos;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void seLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public void setCapacidade(Integer capacidade) {
    this.capacidade = capacidade;
  }

  public void setRecursos(String recursos) {
    this.recursos = recursos;
  }
}
