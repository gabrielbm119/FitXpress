package Controller;

import Model.Carrinho;
import Model.Cliente;

import static DataBase.DadosSimulados.listaClientes;
import java.util.List;

public class ClienteController {

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente autenticarCliente(String email, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.autenticarCliente(email, senha)) {
                if (cliente.getCarrinho() == null) {
                    cliente.setCarrinho(new Carrinho(cliente));
                }
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpfCliente().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean editarCliente(String cpf, Cliente novosDados) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            cliente.setNomeCliente(novosDados.getNomeCliente());
            cliente.setEmailCliente(novosDados.getEmailCliente());
            cliente.setTelefoneCliente(novosDados.getTelefoneCliente());
            cliente.setEnderecoCliente(novosDados.getEnderecoCliente());
            cliente.setEsportePreferenciaCliente(novosDados.getEsportePreferenciaCliente());
            return true;
        }
        return false;
    }

    public boolean excluirCliente(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    public List<Cliente> listarTodosClientes() {
        return listaClientes;
    }
}