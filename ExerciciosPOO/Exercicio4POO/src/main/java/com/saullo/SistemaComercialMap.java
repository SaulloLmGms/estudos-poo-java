package com.saullo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaComercialMap implements SistemaComercial {
  private Map<String, Cliente> clientes;
  private Map<String, Produto> produtos;

  public SistemaComercialMap() {
    this.clientes = new HashMap<String, Cliente>();
    this.produtos = new HashMap<String, Produto>();
  }

  @Override
  public boolean existeProduto(Produto produto) {
    if (this.produtos.containsKey(produto.getCodigo())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Produto pesquisaProduto(String codigoProduto)
      throws ProdutoNaoExisteException {
    if (this.produtos.containsKey(codigoProduto)) {
      return this.produtos.get(codigoProduto);
    }
    throw new ProdutoNaoExisteException("Não foi encontrado produto"
        + " com o código " + codigoProduto);
  }

  @Override
  public boolean cadastraProduto(Produto produto) {
    if (existeProduto(produto)) {
      return false;
    } else {
      this.produtos.put(produto.getCodigo(), produto);
      return true;
    }
  }

  @Override
  public boolean existeCliente(Cliente cliente) {
    if (this.clientes.containsKey(cliente.getId())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
    if (this.clientes.containsKey(id)) {
      return this.clientes.get(id);
    } else {
      throw new ClienteNaoExisteException("Cliente não existe");
    }
  }

  @Override
  public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
    System.out.println("entrei aqui");
    Collection<Produto> produtos = this.produtos.values()
        .stream()
        .filter(item -> item.categoria == categoria)
        .collect(Collectors.toList());

    return produtos;
  }
}