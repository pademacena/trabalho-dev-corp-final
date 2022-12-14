package br.com.treinaweb.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treinaweb.springbootapi.entity.Edicao;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
}