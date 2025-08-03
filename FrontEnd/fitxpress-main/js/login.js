document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const email = form.emailCliente.value;
    const senha = form.senhaCliente.value;

    const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

    const usuario = usuarios.find(
      (user) => user.email === email && user.senha === senha
    );

    if (usuario) {
      localStorage.setItem("usuarioLogado", JSON.stringify(usuario));
      alert("Login realizado com sucesso!");
      window.location.href = "pagina-inicial.html";
    } else {
      alert("E-mail ou senha incorretos!");
    }
  });
});
