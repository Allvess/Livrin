package br.com.livros.repository;

import br.com.livros.model.livrariaModel;
import org.springframework.data.repository.CrudRepository;

public interface livrariaRepository extends CrudRepository<livrariaModel, Integer> {
}
