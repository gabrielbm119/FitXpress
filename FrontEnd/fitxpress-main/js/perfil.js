document.addEventListener("DOMContentLoaded", () => {
  const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
  if (!usuario) {
    window.location.href = "login.html";
    return;
  }

  document.getElementById("nome").value = usuario.nome || "";
  document.getElementById("cpf").value = usuario.cpf || "";
  document.getElementById("telefone").value = usuario.telefone || "";
  document.getElementById("email").value = usuario.email || "";
  document.getElementById("esporte").value = usuario.esporte || "";

  const endereco = usuario.endereco || {};
  document.getElementById("cep").value = endereco.cep || "";
  document.getElementById("cidade").value = endereco.cidade || "";
  document.getElementById("bairro").value = endereco.bairro || "";
  document.getElementById("complemento").value = endereco.complemento || "";
  document.getElementById("numero").value = endereco.numero || "";
  document.getElementById("estado").value = endereco.estado || "";
  document.getElementById("rua").value = endereco.rua || "";
});

function fazerLogout() {
  localStorage.removeItem("usuarioLogado");
  alert("Você saiu da sua conta.");
  window.location.href = "login.html";
}
