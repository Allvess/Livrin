package br.com.livros.service;

import br.com.livros.model.livrariaModel;
import br.com.livros.repository.livrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class livrariaService {
    @Autowired
    private livrariaRepository repository;

    public livrariaModel cadastrarLivro(livrariaModel livro){
        return repository.save(livro);
    }
    public Iterable<livrariaModel> listaLivros(){
    Iterable<livrariaModel> livros = repository.findAll();
    return livros;

    }
//feito pelo o professor, pesquisar depois
    public livrariaModel listarLivro(int id) {
        Optional<livrariaModel> livro = repository.findById(id);
        return livro.get();
    }
}
