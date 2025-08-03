document.addEventListener("DOMContentLoaded", carregarPedidos);

function carregarPedidos() {
  const pedidos = JSON.parse(localStorage.getItem("pedidos")) || [];
  const container = document.getElementById("lista-pedidos");

  if (pedidos.length === 0) {
    container.innerHTML = `<p class="text-muted">Nenhum pedido foi realizado.</p>`;
    return;
  }

  pedidos.forEach((pedido, index) => {
    const produtosHTML = pedido.produtos
      .map(
        (p) =>
          `<li>${p.nome} - R$ ${parseFloat(p.valor.replace("R$", ""))
            .toFixed(2)
            .replace(".", ",")}</li>`
      )
      .join("");

    const cliente = pedido.cliente;
    const endereco = cliente.endereco || {};

    const card = `
      <div class="card mb-4">
        <div class="card-header">
          <strong>Pedido #${index + 1}</strong>
        </div>
        <div class="card-body">
          <h5 class="mb-2">Cliente</h5>
          <p><strong>Nome:</strong> ${cliente.nome}</p>
            <p><strong>CPF:</strong> ${cliente.cpf}</p>
          <p><strong>Email:</strong> ${cliente.email}</p>
          <p><strong>Telefone:</strong> ${cliente.telefone}</p>
          <p><strong>Endereço:</strong> ${endereco.rua}, ${endereco.numero}, ${
      endereco.bairro
    }, ${endereco.cidade} - ${endereco.estado}</p>

          <hr/>

          <h5 class="mb-2">Produtos</h5>
          <ul>${produtosHTML}</ul>

          <h5 class="mt-3">Pagamento</h5>
          <p><strong>Forma:</strong> ${pedido.formaPgto}</p>

          <h5 class="mt-3">Entrega</h5>
          <p><strong>Frete:</strong> R$ ${pedido.frete
            .toFixed(2)
            .replace(".", ",")}</p>
          <p><strong>Total:</strong> R$ ${pedido.total
            .toFixed(2)
            .replace(".", ",")}</p>
        </div>
      </div>
    `;

    container.innerHTML += card;
  });
}
