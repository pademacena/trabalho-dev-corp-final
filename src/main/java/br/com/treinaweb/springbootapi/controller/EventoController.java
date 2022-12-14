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

import br.com.treinaweb.springbootapi.entity.Evento;
import br.com.treinaweb.springbootapi.repository.EventoRepository;

@RestController
public class EventoController {

  @Autowired
  private EventoRepository _eventorepository;

  @ApiOperation(value = "Retorna uma lista de eventos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna a lista de eventos"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
  })
  @RequestMapping(value = "/evento", method = RequestMethod.GET, produces = "application/json")
  public List<Evento> Get() {
    return _eventorepository.findAll();
  }

  @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<Evento> GetById(@PathVariable(value = "id") long id) {
    Optional<Evento> evento = _eventorepository.findById(id);
    if (evento.isPresent())
      return new ResponseEntity<Evento>(evento.get(), HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/evento", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  public Evento Post(@Valid @RequestBody Evento evento) {
    return _eventorepository.save(evento);
  }

  @RequestMapping(value = "/evento/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
  public ResponseEntity<Evento> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Evento newEvento) {
    Optional<Evento> oldEvento = _eventorepository.findById(id);
    if (oldEvento.isPresent()) {
      Evento evento = oldEvento.get();
      evento.setNome(newEvento.getNome());
      _eventorepository.save(evento);
      return new ResponseEntity<Evento>(evento, HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/evento/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
    Optional<Evento> evento = _eventorepository.findById(id);
    if (evento.isPresent()) {
      _eventorepository.delete(evento.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
