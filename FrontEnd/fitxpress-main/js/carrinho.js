function carregarCarrinho() {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) {
    window.location.href = "login.html";
    return;
  }

  const carrinho =
    JSON.parse(localStorage.getItem(`carrinho_${usuario.email}`)) || [];
  const lista = document.getElementById("lista-carrinho");
  const container = document.getElementById("carrinho-container");
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
    const preco = parseFloat(produto.valor.replace("R$", "").replace(",", "."));
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

  const frete = calcularFrete(subtotal);
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

function calcularFrete(subtotal) {
  return subtotal >= 300 ? 0 : 30;
}

function removerItem(index) {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) return;

  let carrinho =
    JSON.parse(localStorage.getItem(`carrinho_${usuario.email}`)) || [];
  carrinho.splice(index, 1);
  localStorage.setItem(`carrinho_${usuario.email}`, JSON.stringify(carrinho));
  carregarCarrinho();
}

function finalizarCompra() {
  const formaSelecionada = document.querySelector(
    'input[name="formaPgtoPedido"]:checked'
  );

  if (!formaSelecionada) {
    alert("Por favor, selecione uma forma de pagamento.");
    return;
  }

  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (usuario) {
    localStorage.removeItem(`carrinho_${usuario.email}`);
  }

  alert(`Compra realizada com sucesso via ${formaSelecionada.value}!`);
  window.location.href = "pagina-inicial.html";
}

document.addEventListener("DOMContentLoaded", carregarCarrinho);
