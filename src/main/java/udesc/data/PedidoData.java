package udesc.data;

public class PedidoData {
  // String comandoInsercao = "insert into pedido (id_pedido, valor_final,
  // taxa_de_entrega, status, observacao, cpf, cod_metodo) values ((select
  // max(id_pedido) from pedido) + 1, ?, ?, ?, ?, ?, ?)";
  private Float valorFinal;
  private Float taxaDeEntrega;
  private String status;
  private String observacao;
  private long cpf;
  private int codMetodo;

  public PedidoData(
      Float valorFinal,
      Float taxaDeEntrega,
      String status,
      String observacao,
      long cpf,
      int codMetodo) {
    this.valorFinal = valorFinal;
    this.taxaDeEntrega = taxaDeEntrega;
    this.status = status;
    this.observacao = observacao;
    this.cpf = cpf;
    this.codMetodo = codMetodo;
  }

  public Float getValorFinal() {
    return valorFinal;
  }

  public Float getTaxaDeEntrega() {
    return taxaDeEntrega;
  }

  public String getStatus() {
    return status;
  }

  public String getObservacao() {
    return observacao;
  }

  public long getCpf() {
    return cpf;
  }

  public int getCodMetodo() {
    return codMetodo;
  }
}
