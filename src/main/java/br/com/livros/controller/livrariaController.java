package br.com.livros.controller;


import br.com.livros.model.livrariaModel;
import br.com.livros.service.livrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class livrariaController {

    @Autowired
    private livrariaService service;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(livrariaModel livro) {
        service.cadastrarLivro(livro);
        return "/listaLivros";
    }

    @GetMapping("livros")
    public ModelAndView pg() {
        ModelAndView pag = new ModelAndView("listaLivros");
        Iterable<livrariaModel> livros = service.listaLivros();
        pag.addObject("livros", livros);
        return pag;
    }

    //feito pelo o professor, pesquisar depois em casa
    @GetMapping("/buscar")
    public String retorLivro() {
        return "idLivros";
    }

    @GetMapping("livro")
    public String listaLivros(@RequestParam("id") int id, Model model){
        livrariaModel livro = service.listarLivro(id);
            if (livro != null) {
                model.addAttribute("livro", livro);
        }
     return "listarLivro";
    }

     @GetMapping("livro/{id}")
    public String listaLivrosPorPagina(@PathVariable("id") int id, Model model) {
        livrariaModel livro = service.listarLivro(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "listarLivro";
     }
}