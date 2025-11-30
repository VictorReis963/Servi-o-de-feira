public boolean validarCesta(Cesta cesta, Plano plano, List<ItemCesta> itens, List<Produto> produtos) {

    int frutas = 0;
    int legumes = 0;

    for (ItemCesta ic : itens) {
        Produto p = produtos.stream()
                .filter(pr -> pr.getId() == ic.getIdProduto())
                .findFirst().orElse(null);

        if (p == null) return false;

        if (p.getTipo().equals("FRUTA")) frutas += ic.getQuantidade();
        else legumes += ic.getQuantidade();
    }

    return frutas == plano.getQtdFrutas()
            && legumes == plano.getQtdLegumes();
}
