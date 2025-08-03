function carregarCarrinho() {
  const carrinho = JSON.parse(localStorage.getItem("carrinho")) || [];
  const lista = document.getElementById("lista-carrinho");
  lista.innerHTML = "";

  let subtotal = 0;

  carrinho.forEach((produto, index) => {
    const preco = parseFloat(produto.valor.replace("R$", ""));
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
              <p class="card-text">R$ ${preco.toFixed(2).replace(".", ",")}
</p>
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
  return subtotal >= 300 ? 0 : 30; // Frete grátis a partir de R$300
}

function removerItem(index) {
  let carrinho = JSON.parse(localStorage.getItem("carrinho")) || [];
  carrinho.splice(index, 1);
  localStorage.setItem("carrinho", JSON.stringify(carrinho));
  carregarCarrinho();
}

document.addEventListener("DOMContentLoaded", carregarCarrinho);

function finalizarCompra() {
  const formaSelecionada = document.querySelector(
    'input[name="formaPgtoPedido"]:checked'
  );

  if (!formaSelecionada) {
    alert("Por favor, selecione uma forma de pagamento.");
    return;
  }

  alert(`Compra realizada com sucesso via ${formaSelecionada.value}!`);
  localStorage.removeItem("carrinho");
  window.location.href = "pagina-inicial.html"; // ou uma página de confirmação
}
