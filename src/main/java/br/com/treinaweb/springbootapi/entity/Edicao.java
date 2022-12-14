package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Time;
import java.sql.Date;

@Entity
public class Edicao {

  @ApiModelProperty(value = "Código da Edicao")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ApiModelProperty(value = "Numero da Edicao")
  @Column(nullable = false)
  private Integer numero;

  @ApiModelProperty(value = "Ano da Edicao")
  @Column(nullable = false)
  private Integer ano;

  @ApiModelProperty(value = "Data Inicio do dicao")
  @Column(nullable = false)
  private Date dataInicial;

  @ApiModelProperty(value = "Data Final do Edicao")
  @Column(nullable = false)
  private Date dataFinal;

  @ApiModelProperty(value = "Cidade do Edicao")
  @Column(nullable = false)
  private String cidade;

  public long getId() {
    return id;
  }

  public Integer getNumero() {
    return numero;
  }

  public Integer getAno() {
    return ano;
  }

  public Date getDataInicial() {
    return dataInicial;
  }

  public Date getDate() {
    return dataFinal;
  }

  public String getCidade() {
    return cidade;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void seNumero(Integer numero) {
    this.numero = numero;
  }

  public void setType(Integer ano) {
    this.ano = ano;
  }

  public void setDescription(Date dataInicial) {
    this.dataInicial = dataInicial;
  }

  public void setDataFinal(Date dataFinal) {
    this.dataFinal = dataFinal;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
}
