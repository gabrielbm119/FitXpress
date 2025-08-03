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

  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) {
    alert("Você precisa estar logado para adicionar ao carrinho.");
    window.location.href = "login.html";
    return;
  }

  const chaveCarrinho = `carrinho_${usuario.email}`;
  let carrinho = JSON.parse(localStorage.getItem(chaveCarrinho)) || [];
  carrinho.push(window.produtoAtual);
  localStorage.setItem(chaveCarrinho, JSON.stringify(carrinho));

  alert("Produto adicionado ao carrinho!");
}
