function produtoSelecionado() {
  const produtoJSON = localStorage.getItem("produtoSelecionado");
  if (!produtoJSON) {
    console.error("Produto não encontrado no localStorage");
    return;
  }
  
  const produto = JSON.parse(produtoJSON);
  
  document.getElementById("titulo").textContent = produto.nome;
  document.getElementById("descricao").textContent = produto.descricao;
  document.getElementById("imagem").src = produto.imagem;
  document.getElementById("valor").textContent = produto.valor;
 
}

window.onload = produtoSelecionado;



