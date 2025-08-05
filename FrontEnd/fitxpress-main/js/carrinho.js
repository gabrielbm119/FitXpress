function carregarCarrinho() {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  const container = document.getElementById("carrinho-container");
  const lista = document.getElementById("lista-carrinho");

  if (!usuario) {
    container.innerHTML = `
      <div class="text-center py-5">
        <h4 class="text-muted">Você precisa estar logado para ver o carrinho.</h4>
        <a href="login.html" class="btn btn-warning mt-3">Fazer Login</a>
      </div>
    `;
    return;
  }

  const chaveCarrinho = `carrinho_${usuario.email}`;
  const carrinho = JSON.parse(localStorage.getItem(chaveCarrinho)) || [];
  lista.innerHTML = "";

  if (carrinho.length === 0) {
    container.innerHTML = `
      <div class="text-center py-5">
        <h4 class="text-muted">Seu carrinho está vazio</h4>
        <a href="pagina-inicial.html" class="btn btn-warning mt-3">Explorar Produtos</a>
      </div>
    `;
    return;
  }

  let subtotal = 0;

  carrinho.forEach((produto, index) => {
    const preco = parseFloat(
      produto.valor.replace("R$", "").replace(".", "").replace(",", ".")
    );
    subtotal += preco;

    const card = `
      <div class="card mb-3">
        <div class="row g-0">
          <div class="col-md-3">
            <img src="${produto.imagem}" class="img-fluid rounded-start" alt="${
      produto.nome
    }">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              <h5 class="card-title">${produto.nome}</h5>
              <p class="card-text">${produto.descricao}</p>
              <p class="card-text">R$ ${preco.toFixed(2).replace(".", ",")}</p>
            </div>
          </div>
          <div class="col-md-2 d-flex justify-content-center align-items-center text-center my-2">
            <button class="btn btn-sm btn-dark" onclick="removerItem(${index})">Remover</button>
          </div>
        </div>
      </div>
    `;
    lista.innerHTML += card;
  });

  const frete = calcularFrete(usuario);
  const total = subtotal + frete;

  document.getElementById("subtotal").textContent = subtotal
    .toFixed(2)
    .replace(".", ",");
  document.getElementById("frete").textContent = frete
    .toFixed(2)
    .replace(".", ",");
  document.getElementById("total").textContent = total
    .toFixed(2)
    .replace(".", ",");
}

function calcularFrete(usuario) {
  const estado = usuario.endereco.estado.toUpperCase();
  switch (estado) {
    case "SP":
      return 10.0;
    case "RJ":
      return 12.0;
    case "MG":
      return 14.0;
    default:
      return 20.0;
  }
}

function removerItem(index) {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) return;

  const chaveCarrinho = `carrinho_${usuario.email}`;
  let carrinho = JSON.parse(localStorage.getItem(chaveCarrinho)) || [];
  carrinho.splice(index, 1);
  localStorage.setItem(chaveCarrinho, JSON.stringify(carrinho));
  carregarCarrinho();
}

function finalizarCompra() {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) {
    alert("Você precisa estar logado para finalizar a compra.");
    window.location.href = "login.html";
    return;
  }

  const formaSelecionada = document.querySelector(
    'input[name="formaPgtoPedido"]:checked'
  );

  if (!formaSelecionada) {
    alert("Por favor, selecione uma forma de pagamento.");
    return;
  }

  const formaPgto = formaSelecionada.value;
  const chaveCarrinho = `carrinho_${usuario.email}`;
  const carrinho = JSON.parse(localStorage.getItem(chaveCarrinho)) || [];

  if (carrinho.length === 0) {
    alert("Seu carrinho está vazio.");
    return;
  }

  const subtotal = carrinho.reduce((acc, item) => {
    return (
      acc +
      parseFloat(
        item.valor.replace("R$", "").replace(".", "").replace(",", ".")
      )
    );
  }, 0);

  const frete = calcularFrete(usuario);
  const total = subtotal + frete;

  const novoPedido = {
    cliente: usuario,
    produtos: carrinho,
    formaPgto,
    frete,
    total,
  };

  const pedidos = JSON.parse(localStorage.getItem("pedidos")) || [];
  pedidos.push(novoPedido);
  localStorage.setItem("pedidos", JSON.stringify(pedidos));

  localStorage.removeItem(chaveCarrinho);

  alert("Compra realizada com sucesso!");
  window.location.href = "pagina-inicial.html";
}

document.addEventListener("DOMContentLoaded", carregarCarrinho);
