document.addEventListener("DOMContentLoaded", function () {
  fetch("components/header.html")
    .then((res) => res.text())
    .then((data) => {
      document.getElementById("header-placeholder").innerHTML = data;
      atualizarHeaderUsuario();
      inicializarBusca();

    });

  fetch("components/footer.html")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("footer-placeholder").innerHTML = data;
    });

  fetch("components/nav.html")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("nav-placeholder").innerHTML = data;
    });
});

function inicializarBusca() {
  const form = document.getElementById("form-pesquisa");
  if (!form) return;

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const busca = document
      .getElementById("input-pesquisa")
      .value.trim()
      .toLowerCase();

    if (busca === "") {
      alert("produto não encontrado");
      exibirTodosProdutos(produtos);
      return;
    }

    const resultadoPesquisa = produtos.filter((p) =>
      p.nome.toLowerCase().includes(busca)
    );

    const produtosSeparados = document.getElementById("produtos-separados").scrollIntoView({behavior : 'smooth'});

    exibirTodosProdutos(resultadoPesquisa);
  });
}

function atualizarHeaderUsuario() {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  const container = document.getElementById("usuario-header");

  if (!container) return;

  if (usuario) {
    container.innerHTML = `
      <div class="icones-header d-flex gap-3 align-items-center">
        <a href="carrinhoCompras.html">
          <img src="../fitxpress-main/assets/carrinhoIcon.svg" alt="Carrinho" width="34">
        </a>
        <a href="perfil.html">
          <img src="../fitxpress-main/assets/perfilIcon.svg" alt="Perfil" width="34">
        </a>
      </div>
    `;
  } else {
    container.innerHTML = `
      <a href="./login.html" class="text-decoration-none fw-bold text-dark">ENTRE OU CADASTRE-SE</a>
    `;
  }
}

document.addEventListener("DOMContentLoaded", atualizarHeaderUsuario);
