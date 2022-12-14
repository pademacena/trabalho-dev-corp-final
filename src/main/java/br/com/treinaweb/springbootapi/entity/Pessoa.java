package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pessoa {
  @ApiModelProperty(value = "Código da pessoa")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ApiModelProperty(value = "Nome da pessoa")
  @Column(nullable = false)
  private String nome;

  @ApiModelProperty(value = "Username da pessoa")
  @Column(nullable = false)
  private String username;

  @ApiModelProperty(value = "Email da pessoa")
  @Column(nullable = false)
  private String email;

  @ApiModelProperty(value = "Senha da pessoa")
  @Column(nullable = false)
  private String password;

  @ApiModelProperty(value = "Afiliacao ")
  @Column(nullable = false)
  private String afiliacao;

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getAfiliacao() {
    return afiliacao;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAfiliacao(String afiliacao) {
    this.afiliacao = afiliacao;
  }

}