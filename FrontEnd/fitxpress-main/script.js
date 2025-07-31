const produtos = [
    {
        nome: "Bolinhas de Beach Tenis",
        descricao: "Bolinhas para jogo de beach tenis",
        imagem: "./imagens/beach-tenis/bolinhas.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "acessorio"
        
    },
    {
        nome: "Camiseta feminina",
        descricao: "Regata feminina salmão",
        imagem: "./imagens/beach-tenis/camiseta-feminina.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "vestuario"
    },
    {
        nome: "Munhequeira",
        descricao: "Munhequeira unissex",
        imagem: "./imagens/beach-tenis/munhequeira.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "vestuario"
    },
    {
        nome: "Conjunto feminino",
        descricao: "Conjunto feminino roxo",
        imagem: "./imagens/beach-tenis/conjunto-feminino.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "vestuario"
    },
    {
        nome: "Raquete Ultra",
        descricao: "Raquete da marca ultra na cor azul e verde",
        imagem: "./imagens/beach-tenis/raquete-verde-azul.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "acessorio"
    },
    {
        nome: "Raquete Sandever",
        descricao: "Raquete da marca Sandever vermelho, preta e amarela",
        imagem: "./imagens/beach-tenis/raquete-vermelha.png",
        valor: "R$200,00",
        categoria: "beach-tenis",
        tipo: "acessorio"
    },

]

function gerarCardsAleatorios(qtd = 3) {
    const container = document.getElementById("produtos-container");
    container.innerHTML = ""; // Limpa antes de renderizar

    const produtosAleatorios = produtos.sort(() => 0.5 - Math.random()).slice(0, qtd);

    produtosAleatorios.forEach(produto => {
      container.innerHTML += `
        <div class="col">
          <div class="card h-100">
            <img src="${produto.imagem}" class="card-img-top img-fluid" alt="${produto.nome}">
            <div class="card-body">
              <h5 class="card-title">${produto.nome}</h5>
              <p class="card-text">${produto.descricao}</p>
              <p class = "card-text">${produto.valor}</p>
            </div>
            <div class="card-footer text-center">
              <button class="btn btn-warning w-100">Comprar</button>
            </div>
          </div>
        </div>
      `;
    });
  }

  // Ao carregar a página, mostra produtos aleatórios
  document.addEventListener("DOMContentLoaded", () => {
    gerarCardsAleatorios(6);
  });
