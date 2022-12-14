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

import br.com.treinaweb.springbootapi.entity.Espaco;
import br.com.treinaweb.springbootapi.repository.EspacoRepository;

@RestController
public class EspacoController {

  @Autowired
  private EspacoRepository _espacoRepository;

  @ApiOperation(value = "Retorna uma lista de espacos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna a lista de espaco"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
  })
  @RequestMapping(value = "/espaco", method = RequestMethod.GET, produces = "application/json")
  public List<Espaco> Get() {
    return _espacoRepository.findAll();
  }

  @RequestMapping(value = "/espaco/{id}", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<Espaco> GetById(@PathVariable(value = "id") long id) {
    Optional<Espaco> espaco = _espacoRepository.findById(id);
    if (espaco.isPresent())
      return new ResponseEntity<Espaco>(espaco.get(), HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/espaco", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  public Espaco Post(@Valid @RequestBody Espaco espaco) {
    return _espacoRepository.save(espaco);
  }

  @RequestMapping(value = "/espaco/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
  public ResponseEntity<Espaco> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Espaco newEspaco) {
    Optional<Espaco> oldespaco = _espacoRepository.findById(id);
    if (oldespaco.isPresent()) {
      Espaco espaco = oldespaco.get();
      espaco.setNome(newEspaco.getNome());
      _espacoRepository.save(espaco);
      return new ResponseEntity<Espaco>(espaco, HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/espaco/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
    Optional<Espaco> espaco = _espacoRepository.findById(id);
    if (espaco.isPresent()) {
      _espacoRepository.delete(espaco.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}