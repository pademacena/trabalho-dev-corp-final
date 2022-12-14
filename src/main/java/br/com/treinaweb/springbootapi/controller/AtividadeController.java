package br.com.treinaweb.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import br.com.treinaweb.springbootapi.entity.Atividade;
import br.com.treinaweb.springbootapi.repository.AtividadeRepository;

@RestController
public class AtividadeController {

  @Autowired
  private AtividadeRepository _atividadeRepository;

  @ApiOperation(value = "Retorna uma lista de atividades")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna a lista de atividades"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
  })
  @RequestMapping(value = "/atividade", method = RequestMethod.GET, produces = "application/json")
  public List<Atividade> Get() {
    return _atividadeRepository.findAll();
  }

  @RequestMapping(value = "/atividade/{id}", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<Atividade> GetById(@PathVariable(value = "id") long id) {
    Optional<Atividade> atividade = _atividadeRepository.findById(id);
    if (atividade.isPresent())
      return new ResponseEntity<Atividade>(atividade.get(), HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/atividade", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  public Atividade Post(@Valid @RequestBody Atividade atividade) {
    return _atividadeRepository.save(atividade);
  }

  @RequestMapping(value = "/atividade/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
  public ResponseEntity<Atividade> Put(@PathVariable(value = "id") long id,
      @Valid @RequestBody Atividade newAtividade) {
    Optional<Atividade> oldAtividade = _atividadeRepository.findById(id);
    if (oldAtividade.isPresent()) {
      Atividade atividade = oldAtividade.get();
      atividade.setNome(newAtividade.getNome());
      _atividadeRepository.save(atividade);
      return new ResponseEntity<Atividade>(atividade, HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/atividade/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
    Optional<Atividade> atividade = _atividadeRepository.findById(id);
    if (atividade.isPresent()) {
      _atividadeRepository.delete(atividade.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
