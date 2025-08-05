const produtos = [
  {
    id: 1,
    nome: "Bolinhas Oficiais para Beach Tennis - Pack com 3 Unidades",
    descricao: "Bolinhas de alta durabilidade e pressão ideal para partidas de beach tennis.",
    imagem: "./imagens/beach-tenis/bolinhas.png",
    valor: "R$50,00",
    categoria: "beach-tenis",
    subcategoria: "acessorio"
  },
  {
    id: 2,
    nome: "Regata Feminina Esportiva Salmon Fit",
    descricao: "Regata leve e respirável com tecido tecnológico, ideal para treinos e jogos de beach tennis.",
    imagem: "./imagens/beach-tenis/camiseta-feminina.png",
    valor: "R$120,00",
    categoria: "beach-tenis",
    subcategoria: "vestuario"
  },
  {
    id: 3,
    nome: "Munhequeira Unissex com Absorção de Suor",
    descricao: "Munhequeira confortável que oferece suporte e absorve o suor para melhor performance.",
    imagem: "./imagens/beach-tenis/munhequeira.png",
    valor: "R$30,00",
    categoria: "beach-tenis",
    subcategoria: "vestuario"
  },
  {
    id: 4,
    nome: "Conjunto Feminino Esportivo Roxo - Top e Shorts",
    descricao: "Conjunto com tecido elástico e design moderno para máxima liberdade de movimento na quadra.",
    imagem: "./imagens/beach-tenis/conjunto-feminino.png",
    valor: "R$250,00",
    categoria: "beach-tenis",
    subcategoria: "vestuario"
  },
  {
    id: 5,
    nome: "Raquete Ultra Performance Azul e Verde",
    descricao: "Raquete leve com tecnologia avançada para melhor controle e potência nos golpes.",
    imagem: "./imagens/beach-tenis/raquete-verde-azul.png",
    valor: "R$1.000,00",
    categoria: "beach-tenis",
    subcategoria: "acessorio"
  },
  {
    id: 6,
    nome: "Raquete Sandever Pro Edition - Vermelha, Preta e Amarela",
    descricao: "Raquete profissional com design robusto para máxima resistência e precisão.",
    imagem: "./imagens/beach-tenis/raquete-vermelha.png",
    valor: "R$1.200,00",
    categoria: "beach-tenis",
    subcategoria: "acessorio"
  },
  {
    id: 7,
    nome: "Bandagem Pro de Algodão para Boxe e Muay Thai",
    descricao: "Bandagem resistente e confortável para proteger as mãos durante os treinos e lutas.",
    imagem: "./imagens/boxe-muaythai/bandagem.png",
    valor: "R$29,90",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },
  {
    id: 8,
    nome: "Capacete Infantil de Proteção para Boxe",
    descricao: "Capacete leve com acolchoamento reforçado, ideal para proteção em treinos infantis.",
    imagem: "./imagens/boxe-muaythai/capacete.png",
    valor: "R$129,90",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },
  {
    id: 9,
    nome: "Luvas Brancas NAJA - Conforto e Durabilidade",
    descricao: "Luvas de boxe da marca NAJA, ideais para treinos de boxe e muay thai com ótimo amortecimento.",
    imagem: "./imagens/boxe-muaythai/luva-branca.png",
    valor: "R$199,90",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },
  {
    id: 10,
    nome: "Luvas Rosa NAJA - Estilo e Proteção",
    descricao: "Luvas de boxe NAJA com design feminino e acolchoamento avançado para máxima proteção.",
    imagem: "./imagens/boxe-muaythai/luva-rosa.png",
    valor: "R$250,00",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },
  {
    id: 11,
    nome: "Punching Ball com Base Lastrada - Domyos",
    descricao: "Punching ball profissional com base estável, perfeito para treino de golpes e resistência.",
    imagem: "./imagens/boxe-muaythai/punching-ball.png",
    valor: "R$999,90",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },
  {
    id: 12,
    nome: "Saco de Pancadas Cutshock TB850 - Boxe e Muay Thai",
    descricao: "Saco de pancadas durável e resistente, ideal para treino intenso de boxe e muay thai.",
    imagem: "./imagens/boxe-muaythai/saco-de-pancada.png",
    valor: "R$259,90",
    categoria: "boxe-muaythai",
    subcategoria: "acessorio"
  },

  {
    id: 13,
    nome: "Selim Atrio Comfort - Banco Ergonômico para Bicicleta",
    descricao: "Banco acolchoado e confortável, perfeito para longos passeios e treinos de ciclismo.",
    imagem: "./imagens/ciclismo/banco.jpg",
    valor: "R$69,90",
    categoria: "ciclismo",
    subcategoria: "acessorio"
  },
  {
    id: 14,
    nome: "Bicicleta CECI 24 Branca - Infantil e Versátil",
    descricao: "Bicicleta infantil tamanho 24 com design moderno e estrutura resistente para todas as aventuras.",
    imagem: "./imagens/ciclismo/bicicleta-branca.jpg",
    valor: "R$1.100,00",
    categoria: "ciclismo",
    subcategoria: "bike"
  },
  {
    id: 15,
    nome: "Bicicleta Infantil Rosa - Leve e Segura",
    descricao: "Bicicleta infantil com quadro rosa, ideal para crianças com garantia de segurança e diversão.",
    imagem: "./imagens/ciclismo/bicicleta-infantil-rosa.jpg",
    valor: "R$259,90",
    categoria: "ciclismo",
    subcategoria: "bike"
  },
  {
    id: 16,
    nome: "Bicicleta Preta Urbana - Prática e Estilosa",
    descricao: "Bicicleta preta com design urbano, ideal para trajetos diários e lazer em cidade.",
    imagem: "./imagens/ciclismo/bicicleta-preta.jpg",
    valor: "R$770,00",
    categoria: "ciclismo",
    subcategoria: "bike"
  },
  {
    id: 17,
    nome: "Capacete Infantil Preto - Segurança e Conforto",
    descricao: "Capacete infantil na cor preta, leve e com ajuste fácil para máxima proteção.",
    imagem: "./imagens/ciclismo/capacete-preto.jpg",
    valor: "R$150,00",
    categoria: "ciclismo",
    subcategoria: "acessorio"
  },
  {
    id: 18,
    nome: "Capacete Estampa Fogo - Design Agressivo e Proteção",
    descricao: "Capacete para ciclistas com estampa exclusiva e sistema de ventilação eficiente.",
    imagem: "./imagens/ciclismo/capacete-fogo.jpg",
    valor: "R$150,00",
    categoria: "ciclismo",
    subcategoria: "acessorio"
  },

  {
  id: 19,
  nome: "Camiseta Oficial Internacional - Performance e Estilo",
  descricao: "Camiseta de time do Internacional, tecido leve e respirável para jogos e treinamentos.",
  imagem: "./imagens/futebol/blusa-inter.png",
  valor: "R$200,00",
  categoria: "futebol",
  subcategoria: "vestuario"
},
{
  id: 20,
  nome: "Camiseta Oficial Grêmio - Conforto e Durabilidade",
  descricao: "Camiseta oficial do Grêmio, ideal para torcer com estilo e conforto em dias de jogo.",
  imagem: "./imagens/futebol/gremio.jpg",
  valor: "R$200,00",
  categoria: "futebol",
  subcategoria: "vestuario"
},
{
  id: 21,
  nome: "Chuteira ADIDAS Profissional - Alta Performance",
  descricao: "Chuteira ADIDAS com design moderno e sola antiderrapante para máximo desempenho em campo.",
  imagem: "./imagens/futebol/chuteira.jpg",
  valor: "R$500,00",
  categoria: "futebol",
  subcategoria: "vestuario"
},
{
  id: 22,
  nome: "Bola Europe League - Toque e Precisão",
  descricao: "Bola oficial Europe League, ideal para treinos e partidas de futebol com excelente durabilidade.",
  imagem: "./imagens/futebol/bola.jpg",
  valor: "R$600,00",
  categoria: "futebol",
  subcategoria: "acessorio"
},
{
  id: 23,
  nome: "Luva de Goleiro Profissional - Proteção Máxima",
  descricao: "Luva reforçada para goleiros, oferece conforto e excelente aderência nas defesas.",
  imagem: "./imagens/futebol/luva.jpg",
  valor: "R$600,00",
  categoria: "futebol",
  subcategoria: "acessorio"
},
{
  id: 24,
  nome: "Goleira Pequena - Estrutura Compacta para Treino",
  descricao: "Goleira de futebol em tamanho compacto, perfeita para treinos e jogos recreativos.",
  imagem: "./imagens/futebol/gol.jpg",
  valor: "R$600,00",
  categoria: "futebol",
  subcategoria: "acessorio"
},
{
  id: 25,
  nome: "Camiseta Feminina Azul GROWTH - Conforto e Estilo",
  descricao: "Camiseta feminina azul da GROWTH, tecido tecnológico que garante respirabilidade e liberdade de movimento.",
  imagem: "./imagens/musculacao/camiseta-feminina-azul.png",
  valor: "R$120,00",
  categoria: "musculacao",
  subcategoria: "vestuario"
},
{
  id: 26,
  nome: "Blusa Térmica Masculina GROWTH - Proteção e Performance",
  descricao: "Blusa térmica branca para musculação, mantém a temperatura corporal e oferece conforto em treinos intensos.",
  imagem: "./imagens/musculacao/camiseta-termica.png",
  valor: "R$112,00",
  categoria: "musculacao",
  subcategoria: "vestuario"
},
{
  id: 27,
  nome: "Legging Feminina Azul GROWTH - Flexibilidade e Suporte",
  descricao: "Legging feminina azul da GROWTH, ideal para treinos, com tecido que proporciona elasticidade e conforto.",
  imagem: "./imagens/musculacao/legging.png",
  valor: "R$220,00",
  categoria: "musculacao",
  subcategoria: "vestuario"
},
{
  id: 28,
  nome: "Top Feminino Cinza GROWTH - Suporte e Estilo",
  descricao: "Top feminino cinza da GROWTH, com suporte ideal para atividades de alta performance na academia.",
  imagem: "./imagens/musculacao/top.png",
  valor: "R$99,90",
  categoria: "musculacao",
  subcategoria: "vestuario"
},
{
  id: 29,
  nome: "Strap Rosa GROWTH - Acessório para Treino",
  descricao: "Strap rosa para musculação da GROWTH, auxilia no suporte durante exercícios com pesos.",
  imagem: "./imagens/musculacao/strap-rosa.png",
  valor: "R$39,90",
  categoria: "musculacao",
  subcategoria: "acessorio"
},
{
  id: 30,
  nome: "Faixa de Joelho GROWTH - Proteção e Estabilidade",
  descricao: "Faixa para joelho da GROWTH que oferece suporte e proteção em treinos intensos e prevenções de lesões.",
  imagem: "./imagens/musculacao/faixa-de-joelho.png",
  valor: "R$39,90",
  categoria: "musculacao",
  subcategoria: "acessorio"
},
{
  id: 31,
  nome: "Maiô Infantil Feminino Natação - Conforto e Mobilidade",
  descricao: "Maiô infantil feminino, tecido resistente ao cloro e design que garante liberdade nos movimentos dentro d'água.",
  imagem: "./imagens/natacao/maio.jpg",
  valor: "R$189,90",
  categoria: "natacao",
  subcategoria: "vestuario"
},
{
  id: 32,
  nome: "Maiô Feminino Performance - Alta Durabilidade",
  descricao: "Maiô feminino para natação com tecido de alta durabilidade e ajuste perfeito para treinos e competições.",
  imagem: "./imagens/natacao/maio2.jpg",
  valor: "R$239,90",
  categoria: "natacao",
  subcategoria: "vestuario"
},
{
  id: 33,
  nome: "Sunga Masculina para Natação - Conforto e Praticidade",
  descricao: "Sunga masculina desenvolvida para máxima performance na água, tecido leve e resistente ao cloro.",
  imagem: "./imagens/natacao/sunga.jpg",
  valor: "R$79,90",
  categoria: "natacao",
  subcategoria: "vestuario"
},
{
  id: 34,
  nome: "Touca de Natação Silicone - Ajuste Perfeito",
  descricao: "Touca para natação feita em silicone, oferece excelente ajuste e reduz resistência na água para melhor desempenho.",
  imagem: "./imagens/natacao/touca.png",
  valor: "R$79,90",
  categoria: "natacao",
  subcategoria: "vestuario"
},
{
  id: 35,
  nome: "Pé de Pato Profissional - Equipamento de Mergulho",
  descricao: "Pé de pato para natação e mergulho, design ergonômico para impulsão eficiente na água.",
  imagem: "./imagens/natacao/peDePato.jpg",
  valor: "R$339,90",
  categoria: "natacao",
  subcategoria: "acessorio"
},
{
  id: 36,
  nome: "Óculos de Mergulho Antivazamento - Visão Clara",
  descricao: "Óculos de mergulho com vedação segura, lentes antiembaçantes para melhor visibilidade subaquática.",
  imagem: "./imagens/natacao/oculos.png",
  valor: "R$59,90",
  categoria: "natacao",
  subcategoria: "acessorio"
},
{
  id: 37,
  nome: "Bermuda Feminina para Praia - Leve e Confortável",
  descricao: "Bermuda feminina ideal para praia, tecido leve e design moderno para máxima liberdade de movimento.",
  imagem: "./imagens/surf/bermuda-feminina.png",
  valor: "R$129,90",
  categoria: "surf",
  subcategoria: "vestuario"
},
{
  id: 38,
  nome: "Long John para Surf - Proteção e Flexibilidade",
  descricao: "Roupa de neoprene Long John que oferece conforto térmico e flexibilidade para surfistas.",
  imagem: "./imagens/surf/long-john.png",
  valor: "R$429,90",
  categoria: "surf",
  subcategoria: "vestuario"
},
{
  id: 39,
  nome: "Prancha Soft Stand Up Paddle 10' - Edição Especial Rosa",
  descricao: "Prancha de Stand Up Paddle 10 pés soft, com kit remada, ideal para iniciantes e com design exclusivo rosa.",
  imagem: "./imagens/surf/prancha-rosa.png",
  valor: "R$2.809,90",
  categoria: "surf",
  subcategoria: "prancha"
},
{
  id: 40,
  nome: "Prancha Longboard Verde - Desempenho e Estilo",
  descricao: "Prancha de Longboard com acabamento verde, perfeita para ondas suaves e surf de estilo clássico.",
  imagem: "./imagens/surf/prancha-verde.png",
  valor: "R$2.800,00",
  categoria: "surf",
  subcategoria: "prancha"
},
{
  id: 41,
  nome: "Kit Completo Stand Up Paddle - Diversão Garantida",
  descricao: "Kit Stand Up Paddle completo, inclui prancha, remo e acessórios para diversão e esporte na água.",
  imagem: "./imagens/surf/kit-standup.png",
  valor: "R$3.700,00",
  categoria: "surf",
  subcategoria: "prancha"
},
{
  id: 42,
  nome: "Leash para Surf Sea Club - Segurança em Primeiro Lugar",
  descricao: "Leash de alta resistência para surf, marca Sea Club, garante segurança e evita perda da prancha.",
  imagem: "./imagens/surf/leash-surf.png",
  valor: "R$2.800,00",
  categoria: "surf",
  subcategoria: "acessorio"
},
{
  id: 43,
  nome: "Creatina em Cápsulas GROWTH - Energia e Performance",
  descricao: "Creatina em cápsulas para aumento de força e resistência muscular, fórmula concentrada GROWTH.",
  imagem: "./imagens/suplementos/creatina-potinho.png",
  valor: "R$150,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
},
{
  id: 44,
  nome: "Creatina em Pó GROWTH - Potência Máxima",
  descricao: "Creatina em pó com alta pureza para melhor absorção e rendimento em treinos intensos.",
  imagem: "./imagens/suplementos/creatina.png",
  valor: "R$159,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
},
{
  id: 45,
  nome: "Multivitamínico em Cápsulas GROWTH - Saúde Completa",
  descricao: "Suplemento multivitamínico para suporte geral ao organismo e aumento de imunidade.",
  imagem: "./imagens/suplementos/multivitaminico.png",
  valor: "R$59,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
},
{
  id: 46,
  nome: "Whey Protein GROWTH - Recuperação e Crescimento",
  descricao: "Proteína whey de alta qualidade para recuperação muscular e ganho de massa magra.",
  imagem: "./imagens/suplementos/whey.png",
  valor: "R$150,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
},
{
  id: 47,
  nome: "Whey Protein Pronto GROWTH - Praticidade e Sabor",
  descricao: "Shake pronto de whey protein para consumo rápido, sabor delicioso e alta concentração proteica.",
  imagem: "./imagens/suplementos/wheypronto.png",
  valor: "R$20,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
},
{
  id: 48,
  nome: "Pasta de Amendoim GROWTH - Energia Natural",
  descricao: "Pasta de amendoim cremosa, rica em proteínas e gorduras saudáveis para o dia a dia.",
  imagem: "./imagens/suplementos/pasta-de-amendoim.png",
  valor: "R$150,00",
  categoria: "suplemento",
  subcategoria: "suplemento"
}

];

function gerarCardsAleatorios(qtd) {
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
              <button onclick="verProduto(${produto.id})" class="btn btn-warning w-100">Comprar</button>
            </div>
          </div>
        </div>
      `;
    });
  }

  document.addEventListener("DOMContentLoaded", () => {
    gerarCardsAleatorios(8);
  });

function exibirTodosProdutos(produtos){
  const container= document.getElementById("produtos-container");
  container.innerHTML = "";

  produtos.forEach(produto => {
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
              <button onclick="verProduto(${produto.id})" class="btn btn-warning w-100">Comprar</button>
            </div>
          </div>
        </div>
    `;
  });

  const botaoVerTodos = document.getElementById("botao-ver-todos");
  botaoVerTodos.innerHTML = "";

  document.addEventListener("DOMContentLoaded", () => {
  exibirTodosProdutos();
  
});
}



function verProduto(id){
  const produto = produtos.find(p => p.id === id);

  if(!produto){
    alert("produto nao encontrado")
  }else{
    localStorage.setItem("produtoSelecionado", JSON.stringify(produto));
    window.location.href ="./produto.html";
  }
   
}




