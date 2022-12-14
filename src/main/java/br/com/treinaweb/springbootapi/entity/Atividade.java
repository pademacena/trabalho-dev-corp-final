package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@Entity
public class Atividade {

  @ApiModelProperty(value = "Código da atividade")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ApiModelProperty(value = "Nome da atividade")
  @Column(nullable = false)
  private String nome;

  @ApiModelProperty(value = "Tipo da atividade")
  @Column(nullable = false)
  private String type;

  @ApiModelProperty(value = "Descrição do evento")
  @Column(nullable = false)
  private String description;

  @ApiModelProperty(value = "Data do evento")
  @Column(nullable = false)
  private Date date;

  @ApiModelProperty(value = "Hora de inicio do evento")
  private String startHour;

  @ApiModelProperty(value = "Hora de fim do evento")
  private String endHour;

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public Date getDate() {
    return date;
  }

  public String getStartTime() {
    return startHour;
  }

  public String getEndTime() {
    return endHour;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setStartTime(String startHour) {
    this.startHour = startHour;
  }

  public void setEndTime(String endHour) {
    this.endHour = endHour;
  }
}
