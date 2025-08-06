package App;

import Controller.CarrinhoController;
import Controller.ClienteController;
import Controller.ProdutoController;
import Controller.PedidoController;
import DataBase.DadosSimulados;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private ClienteController clienteController = new ClienteController();
    private ProdutoController produtoController = new ProdutoController();
    private CarrinhoController carrinhoController = new CarrinhoController(
            DadosSimulados.listaProdutos
    );
    private PedidoController pedidoController = new PedidoController(carrinhoController);

    public void iniciarSistema() {
        while (true) {
            String[] opcoes = {"Cliente", "Administrador", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Bem-vindo ao FitXpress!\nEscolha uma opção para continuar:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0: menuCliente(); break;
                case 1: menuAdministrador(); break;
                default:
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o FitXpress!");
                    System.exit(0);
            }
        }
    }

    private void menuCliente() {
        while (true) {
            String[] opcoes = {"Login", "Cadastrar", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Área do Cliente - Escolha uma opção:",
                    "Menu Cliente",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0: loginCliente(); break;
                case 1: cadastrarCliente(); break;
                default: return;
            }
        }
    }

    private void menuAdministrador() {
        String nome = JOptionPane.showInputDialog("Nome de administrador:");
        String senha = JOptionPane.showInputDialog("Senha:");

        if (DadosSimulados.administrador.autenticarAdmin(nome, senha)) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            menuAdministradorLogado();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais inválidas.");
        }
    }

    private void cadastrarCliente() {
        try {
            String nome = JOptionPane.showInputDialog("Nome:");
            String cpf = JOptionPane.showInputDialog("CPF:");
            String email = JOptionPane.showInputDialog("Email:");
            String senha = JOptionPane.showInputDialog("Senha:");
            String telefone = JOptionPane.showInputDialog("Telefone:");
            String esportePreferencia = JOptionPane.showInputDialog("Esporte de preferência (opcional):");

            // Endereço
            String rua = JOptionPane.showInputDialog("Endereço - Rua:");
            String numero = JOptionPane.showInputDialog("Número:");
            String complemento = JOptionPane.showInputDialog("Complemento:");
            String bairro = JOptionPane.showInputDialog("Bairro:");
            String cidade = JOptionPane.showInputDialog("Cidade:");
            String estado = JOptionPane.showInputDialog("Estado (sigla):");
            String cep = JOptionPane.showInputDialog("CEP:");

            Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade, estado, cep);
            Cliente novoCliente = new Cliente(nome, cpf, email, senha, telefone, endereco, esportePreferencia);

            clienteController.cadastrarCliente(novoCliente);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private void loginCliente() {
        String email = JOptionPane.showInputDialog("Digite seu email:");
        String senha = JOptionPane.showInputDialog("Digite sua senha:");

        Cliente clienteAutenticado = clienteController.autenticarCliente(email, senha);

        if (clienteAutenticado != null) {
            carrinhoController.criarCarrinho(clienteAutenticado); // ← AQUI!
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso! Bem-vindo, " + clienteAutenticado.getNomeCliente());
            menuClienteLogado(clienteAutenticado);
        } else {
            JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
        }
    }

    private void menuClienteLogado(Cliente cliente) {
        while (true) {
            String[] opcoes = {
                    "Meu carrinho",
                    "Meus pedidos",
                    "Editar meu cadastro",
                    "Voltar"
            };

            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Olá, " + cliente.getNomeCliente() + "! O que deseja fazer?",
                    "Menu do Cliente",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0 -> abrirMenuCarrinho(cliente);
                case 1 -> visualizarPedidos(cliente);
                case 2 -> editarCadastro(cliente);
                default -> { return; }
            }
        }
    }

    private void abrirMenuCarrinho(Cliente cliente) {
        while (true) {
            String[] opcoes = {
                    "Visualizar produtos no carrinho",
                    "Adicionar produto",
                    "Remover produto",
                    "Finalizar pedido",
                    "Voltar"
            };

            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Gerenciamento do Carrinho",
                    "Carrinho de " + cliente.getNomeCliente(),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0 -> visualizarCarrinho(cliente);
                case 1 -> adicionarProdutoCarrinho(cliente);
                case 2 -> removerProdutoCarrinho(cliente);
                case 3 -> finalizarPedido(cliente);
                default -> { return; }
            }
        }
    }

    private void visualizarCarrinho(Cliente cliente) {
        Carrinho carrinho = carrinhoController.buscarCarrinhoPorCliente(cliente);

        if (carrinho == null || carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seu carrinho está vazio.");
            return;
        }

        StringBuilder sb = new StringBuilder("Produtos no seu carrinho:\n");

        List<Produto> produtos = carrinho.getProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            sb.append(String.format(
                    "%d - %s (ID: %d) | R$ %.2f\n",
                    i + 1,
                    p.getNomeProduto(),
                    p.getIdProduto(),
                    p.getValorProduto()
            ));
        }

        sb.append("\nTotal parcial: R$ ").append(String.format("%.2f", carrinho.getTotalParcial()));

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void adicionarProdutoCarrinho(Cliente cliente) {
        StringBuilder sb = new StringBuilder("Produtos disponíveis:\n");

        List<Produto> produtosDisponiveis = produtoController.listarTodosProdutos();

        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            Produto p = produtosDisponiveis.get(i);
            sb.append(String.format(
                    "%d - %s (ID: %d) | R$ %.2f\n",
                    i + 1,
                    p.getNomeProduto(),
                    p.getIdProduto(),
                    p.getValorProduto()
            ));
        }

        String input = JOptionPane.showInputDialog(null, sb + "\nDigite o número do produto que deseja adicionar ao carrinho:");

        if (input == null || input.isBlank()) return;

        try {
            int indice = Integer.parseInt(input) - 1;
            System.out.println("Indice digitado: " + input + " | Interpretado: " + indice);

            if (indice < 0 || indice >= produtosDisponiveis.size()) {
                JOptionPane.showMessageDialog(null, "Número inválido.");
                return;
            }

            carrinhoController.adicionarProdutoAoCarrinho(cliente, produtosDisponiveis.get(indice).getIdProduto());
            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    private void removerProdutoCarrinho(Cliente cliente) {
        Carrinho carrinho = carrinhoController.buscarCarrinhoPorCliente(cliente);

        if (carrinho == null || carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seu carrinho está vazio.");
            return;
        }

        StringBuilder sb = new StringBuilder("Produtos no carrinho:\n");

        List<Produto> produtos = carrinho.getProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            sb.append(String.format(
                    "%d - %s (ID: %d) | R$ %.2f\n",
                    i + 1,
                    p.getNomeProduto(),
                    p.getIdProduto(),
                    p.getValorProduto()
            ));
        }

        String input = JOptionPane.showInputDialog(null, sb + "\nDigite o número do produto que deseja remover:");

        if (input == null || input.isBlank()) return;

        try {
            int indice = Integer.parseInt(input) - 1;
            System.out.println("Indice digitado: " + input + " | Interpretado: " + indice);

            if (indice < 0 || indice >= produtos.size()) {
                JOptionPane.showMessageDialog(null, "Número inválido.");
                return;
            }

            carrinhoController.removerProdutoDoCarrinhoPorIndice(cliente, indice);
            JOptionPane.showMessageDialog(null, "Produto removido do carrinho com sucesso.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    private void finalizarPedido(Cliente cliente) {
        Carrinho carrinho = carrinhoController.buscarCarrinhoPorCliente(cliente);

        if (carrinho == null || carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seu carrinho está vazio.");
            return;
        }

        String[] formasPgto = {"Pix", "Boleto", "Cartão de Crédito", "Cartão de Débito"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha a forma de pagamento:",
                "Pagamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                formasPgto,
                formasPgto[0]
        );

        if (escolha == -1) return;

        FormaPgto formaSelecionada = switch (escolha) {
            case 0 -> FormaPgto.PIX   ;
            case 1 -> FormaPgto.BOLETO;
            case 2 -> FormaPgto.CREDITO;
            case 3 -> FormaPgto.DEBITO;
            default -> null;
        };

        if (formaSelecionada == null) {
            JOptionPane.showMessageDialog(null, "Forma de pagamento inválida.");
            return;
        }

        pedidoController.criarPedido(cliente, carrinho, formaSelecionada);
        carrinhoController.limparCarrinho(cliente);
        JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
    }

    private void visualizarPedidos(Cliente cliente) {
        List<Pedido> pedidosCliente = pedidoController.listarPedidosDoCliente(cliente);

        if (pedidosCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você ainda não possui pedidos.");
            return;
        }

        StringBuilder msg = new StringBuilder("Seus pedidos:\n\n");
        for (Pedido pedido : pedidosCliente) {
            msg.append(pedido).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, msg.toString());
    }

    private void editarCadastro(Cliente cliente) {
        try {
            String novoNome = JOptionPane.showInputDialog("Nome atual: " + cliente.getNomeCliente() + "\nNovo nome:", cliente.getNomeCliente());
            String novoEmail = JOptionPane.showInputDialog("Email atual: " + cliente.getEmailCliente() + "\nNovo email:", cliente.getEmailCliente());
            String novoTelefone = JOptionPane.showInputDialog("Telefone atual: " + cliente.getTelefoneCliente() + "\nNovo telefone:", cliente.getTelefoneCliente());
            String novoEsporte = JOptionPane.showInputDialog("Esporte de preferência atual: " + cliente.getEsportePreferenciaCliente() + "\nNovo esporte:", cliente.getEsportePreferenciaCliente());

            Endereco enderecoAtual = cliente.getEnderecoCliente();

            String novaRua = JOptionPane.showInputDialog("Rua atual: " + enderecoAtual.getRuaEndereco() + "\nNova rua:", enderecoAtual.getRuaEndereco());
            String novoNumero = JOptionPane.showInputDialog("Número atual: " + enderecoAtual.getNumeroEndereco() + "\nNovo número:", enderecoAtual.getNumeroEndereco());
            String novoComplemento = JOptionPane.showInputDialog("Complemento atual: " + enderecoAtual.getComplementoEndereco() + "\nNovo complemento:", enderecoAtual.getComplementoEndereco());
            String novoBairro = JOptionPane.showInputDialog("Bairro atual: " + enderecoAtual.getBairroEndereco() + "\nNovo bairro:", enderecoAtual.getBairroEndereco());
            String novaCidade = JOptionPane.showInputDialog("Cidade atual: " + enderecoAtual.getCidadeEndereco() + "\nNova cidade:", enderecoAtual.getCidadeEndereco());
            String novoEstado = JOptionPane.showInputDialog("Estado atual: " + enderecoAtual.getEstadoEndereco() + "\nNovo estado:", enderecoAtual.getEstadoEndereco());
            String novoCep = JOptionPane.showInputDialog("CEP atual: " + enderecoAtual.getCepEndereco() + "\nNovo CEP:", enderecoAtual.getCepEndereco());

            // Criar novo endereço e atualizar dados
            Endereco novoEndereco = new Endereco(novaRua, novoNumero, novoComplemento, novoBairro, novaCidade, novoEstado, novoCep);

            // Criar um objeto Cliente com os novos dados (mesmo CPF e senha mantidos)
            Cliente clienteAtualizado = new Cliente();
            clienteAtualizado.setNomeCliente(novoNome);
            clienteAtualizado.setEmailCliente(novoEmail);
            clienteAtualizado.setTelefoneCliente(novoTelefone);
            clienteAtualizado.setEsportePreferenciaCliente(novoEsporte);
            clienteAtualizado.setEnderecoCliente(novoEndereco);

            boolean sucesso = clienteController.editarCliente(cliente.getCpfCliente(), clienteAtualizado);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o cadastro.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar cadastro: " + e.getMessage());
        }
    }

    private void menuAdministradorLogado() {
        while (true) {
            String[] opcoes = {
                    "Cadastrar produto",
                    "Editar produto",
                    "Excluir produto",
                    "Listar produtos",
                    "Visualizar pedidos",
                    "Sair"
            };

            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Área do Administrador - Escolha uma opção:",
                    "Menu Admin",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0: cadastrarProduto(); break;
                case 1: editarProduto(); break;
                case 2: excluirProduto(); break;
                case 3: listarProdutos(); break;
                case 4: visualizarTodosPedidos(); break;
                default: return;
            }
        }
    }

    private void cadastrarProduto() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do produto:");
            String categoria = JOptionPane.showInputDialog("Categoria:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor (R$):"));
            String descricao = JOptionPane.showInputDialog("Descrição:");
            String tamanhoOuPeso = JOptionPane.showInputDialog("Tamanho ou Peso:");

            Produto novoProduto = new Produto(nome, categoria, valor, descricao, tamanhoOuPeso);
            produtoController.cadastrarProduto(novoProduto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void editarProduto() {
        List<Produto> lista = produtoController.listarTodosProdutos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder produtosMsg = new StringBuilder("Produtos disponíveis:\n");
        for (Produto produto : lista) {
            produtosMsg.append(produto.getIdProduto()).append(" - ").append(produto.getNomeProduto()).append("\n");
        }

        String idStr = JOptionPane.showInputDialog(produtosMsg + "\nDigite o ID do produto que deseja editar:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            Produto produtoExistente = produtoController.buscarProdutoPorId(id);

            if (produtoExistente == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }

            // Novos dados
            String nome = JOptionPane.showInputDialog("Nome:", produtoExistente.getNomeProduto());
            String categoria = JOptionPane.showInputDialog("Categoria:", produtoExistente.getCategoriaProduto());
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor (R$):", produtoExistente.getValorProduto()));
            String descricao = JOptionPane.showInputDialog("Descrição:", produtoExistente.getDescricaoProduto());
            String tamanhoOuPeso = JOptionPane.showInputDialog("Tamanho/Peso:", produtoExistente.getTamanhoOuPesoProduto());

            Produto novosDados = new Produto(nome, categoria, valor, descricao, tamanhoOuPeso);
            boolean sucesso = produtoController.editarProduto(id, novosDados);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao editar produto.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private void excluirProduto() {
        List<Produto> lista = produtoController.listarTodosProdutos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder produtosMsg = new StringBuilder("Produtos disponíveis:\n");
        for (Produto produto : lista) {
            produtosMsg.append(produto.getIdProduto()).append(" - ").append(produto.getNomeProduto()).append("\n");
        }

        String idStr = JOptionPane.showInputDialog(produtosMsg + "\nDigite o ID do produto que deseja excluir:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);
            Produto produto = produtoController.buscarProdutoPorId(id);

            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja excluir o produto: " + produto.getNomeProduto() + "?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = produtoController.excluirProduto(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir produto.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
        }
    }

    private void listarProdutos() {
        List<Produto> lista = produtoController.listarTodosProdutos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder msg = new StringBuilder("Produtos cadastrados:\n\n");
        for (Produto produto : lista) {
            msg.append("| ")
                    .append(produto.getIdProduto()).append(" - ")
                    .append(produto.getNomeProduto())
                    .append(" (").append(produto.getCategoriaProduto()).append(") | R$ ")
                    .append(String.format("%.2f", produto.getValorProduto()))
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, msg.toString());
    }

    private void visualizarTodosPedidos() {
        List<Pedido> lista = pedidoController.listarTodosPedidos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido realizado até o momento.");
            return;
        }

        StringBuilder msg = new StringBuilder("Pedidos realizados:\n\n");
        for (Pedido pedido : lista) {
            msg.append(pedido).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, msg.toString());
    }

}
