package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Evento {

  @ApiModelProperty(value = "Código do evento")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ApiModelProperty(value = "Nome do evento")
  @Column(nullable = false)
  private String nome;

  @ApiModelProperty(value = "Sigla do evento")
  @Column(nullable = false)
  private String sigla;

  @ApiModelProperty(value = "Descrição do evento")
  @Column(nullable = false)
  private String description;

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSigla() {
    return sigla;
  }

  public String getPassword() {
    return description;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
