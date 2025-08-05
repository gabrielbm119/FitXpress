document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("#formCadastro");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const novoUsuario = {
      nome: form.nomeCliente.value,
      cpf: form.cpfCliente.value,
      email: form.emailCliente.value,
      senha: form.senhaCliente.value,
      telefone: form.telefoneCliente.value,
      esporte: form.esportePreferenciaCliente.value,
      endereco: {
        rua: form.ruaEndereco.value,
        numero: form.numeroEndereco.value,
        complemento: form.complementoEndereco.value,
        bairro: form.bairroEndereco.value,
        cidade: form.cidadeEndereco.value,
        estado: form.estadoEndereco.value,
        cep: form.cepEndereco.value,
      },
    };

    let usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

    const emailExistente = usuarios.some(
      (user) => user.email === novoUsuario.email
    );

    if (emailExistente) {
      alert("E-mail já cadastrado!");
      return;
    }

    usuarios.push(novoUsuario);
    localStorage.setItem("usuarios", JSON.stringify(usuarios));

    alert("Cadastro realizado com sucesso!");
    window.location.href = "login.html";
  });
});
