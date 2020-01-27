package br.com.livros.controller;


import br.com.livros.model.livrariaModel;
import br.com.livros.service.livrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class livrariaController {

    @Autowired
    private livrariaService service;

    @GetMapping
    public String home (){
        return "index";
    }

    @GetMapping ("/cadastrar")
    public String cadastrar() {
        return "cadastrar";
    }
    @PostMapping("/sucess")
    public  String  cadastrarLivro(livrariaModel livro){
        service.cadastrarLivro(livro);
        return "sucess";
    }
}
