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

import br.com.treinaweb.springbootapi.entity.Edicao;
import br.com.treinaweb.springbootapi.repository.EdicaoRepository;

@RestController
public class EdicaoController {

  @Autowired
  private EdicaoRepository _edicaoRepository;

  @ApiOperation(value = "Retorna uma lista de edicaos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna a lista de edicao"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
  })
  @RequestMapping(value = "/edicao", method = RequestMethod.GET, produces = "application/json")
  public List<Edicao> Get() {
    return _edicaoRepository.findAll();
  }

  @RequestMapping(value = "/edicao/{id}", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<Edicao> GetById(@PathVariable(value = "id") long id) {
    Optional<Edicao> edicao = _edicaoRepository.findById(id);
    if (edicao.isPresent())
      return new ResponseEntity<Edicao>(edicao.get(), HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/edicao", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  public Edicao Post(@Valid @RequestBody Edicao edicao) {
    return _edicaoRepository.save(edicao);
  }

  @RequestMapping(value = "/edicao/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
  public ResponseEntity<Edicao> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Edicao newEdicao) {
    Optional<Edicao> oldEdicao = _edicaoRepository.findById(id);
    if (oldEdicao.isPresent()) {
      Edicao edicao = oldEdicao.get();
      edicao.setCidade(newEdicao.getCidade());
      _edicaoRepository.save(edicao);
      return new ResponseEntity<Edicao>(edicao, HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/edicao/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
    Optional<Edicao> edicao = _edicaoRepository.findById(id);
    if (edicao.isPresent()) {
      _edicaoRepository.delete(edicao.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}