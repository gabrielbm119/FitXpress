function produtoSelecionado() {
  const produtoJSON = localStorage.getItem("produtoSelecionado");
  if (!produtoJSON) {
    console.error("Produto não encontrado no localStorage");
    return;
  }

  const produto = JSON.parse(produtoJSON);

  window.produtoAtual = produto;

  document.getElementById("titulo").textContent = produto.nome;
  document.getElementById("descricao").textContent = produto.descricao;
  document.getElementById("imagem").src = produto.imagem;
  document.getElementById("valor").textContent = produto.valor;
}

window.onload = produtoSelecionado;

function adicionarNoCarrinho() {
  if (!window.produtoAtual) {
    alert("Produto não carregado.");
    return;
  }

  let carrinho = JSON.parse(localStorage.getItem("carrinho")) || [];
  carrinho.push(window.produtoAtual);
  localStorage.setItem("carrinho", JSON.stringify(carrinho));

  alert("Produto adicionado ao carrinho!");
}
