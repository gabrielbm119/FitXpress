package com.fitxpress.Controller;

import org.springframework.ui.Model;
import com.fitxpress.Model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    ProdutoController produtoController = new ProdutoController();

    @GetMapping("/")
    public String paginaInicial(Model model) {
        List<Produto> produtos = produtoController.listarTodosProdutos();
        model.addAttribute("produtos", produtos);
        return "pagina-inicial";
    }
}