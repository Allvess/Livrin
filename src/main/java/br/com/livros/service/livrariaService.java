package br.com.livros.service;

import br.com.livros.model.livrariaModel;
import br.com.livros.repository.livrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class livrariaService {
    @Autowired
    private livrariaRepository repository;

    public livrariaModel cadastrarLivro(livrariaModel livro){
        return repository.save(livro);
    }
}
