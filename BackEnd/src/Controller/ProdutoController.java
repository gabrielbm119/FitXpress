package Controller;

import Model.Produto;

import static DataBase.DadosSimulados.listaProdutos;
import java.util.List;

public class ProdutoController {

    public void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public Produto buscarProdutoPorId(int idProduto) {
        for (Produto produto : listaProdutos) {
            if (produto.getIdProduto() == idProduto) {
                return produto;
            }
        }
        return null;
    }

    public boolean editarProduto(int idProduto, Produto novosDados) {
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto != null) {
            produto.setNomeProduto(novosDados.getNomeProduto());
            produto.setCategoriaProduto(novosDados.getCategoriaProduto());
            produto.setValorProduto(novosDados.getValorProduto());
            produto.setDescricaoProduto(novosDados.getDescricaoProduto());
            produto.setTamanhoOuPesoProduto(novosDados.getTamanhoOuPesoProduto());
            return true;
        }
        return false;
    }

    public boolean excluirProduto(int idProduto) {
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto != null) {
            listaProdutos.remove(produto);
            return true;
        }
        return false;
    }

    public List<Produto> listarTodosProdutos() {
        return listaProdutos;
    }
}