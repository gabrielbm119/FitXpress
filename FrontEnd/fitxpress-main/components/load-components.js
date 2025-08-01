document.addEventListener("DOMContentLoaded", function () {
    fetch("components/header.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("header-placeholder").innerHTML = data;
            inicializarBusca()
        });

    fetch("components/footer.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("footer-placeholder").innerHTML = data;
        });

    fetch("components/nav.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("nav-placeholder").innerHTML = data;
        })  

});

function inicializarBusca() {
    const form = document.getElementById("form-pesquisa");
    if (!form) return;

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const busca = document.getElementById("input-pesquisa").value.trim().toLowerCase();

        if (busca === "") {
            alert("produto não encontrado");
            exibirTodosProdutos(produtos);
            return;
        }

        const resultadoPesquisa = produtos.filter(p =>
            p.nome.toLowerCase().includes(busca)
        );

        exibirTodosProdutos(resultadoPesquisa);
    });
}