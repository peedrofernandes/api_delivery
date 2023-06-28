package udesc;

import java.util.Scanner;

import udesc.data.PedidoData;

public class APIHandler {
  private QueryController queryController;
  private Scanner scanner;

  APIHandler(QueryController queryController, Scanner scanner) {
    this.queryController = queryController;
    this.scanner = scanner;
  }

  // Inserções
  public void inserirPedido() {
    System.out.println("CPF do cliente do pedido: ");
    int cpf = this.scanner.nextInt();
    System.out.println("Taxa de entrega do pedido: ");
    Float taxaDeEntrega = this.scanner.nextFloat();
    System.out.println("Valor final do pedido: ");
    Float valorFinal = this.scanner.nextFloat();
    System.out.println("Status do pedido: ");
    String status = this.scanner.nextLine();
    System.out.println("Observação sobre o pedido: ");
    String observacao = this.scanner.nextLine();
    System.out.println("Código do método de pagamento do pedido: ");
    int codMetodo = this.scanner.nextInt();

    PedidoData dados = new PedidoData(valorFinal, taxaDeEntrega, status, observacao, cpf, codMetodo);
    this.queryController.inserirPedido(dados);
  }

  public void inserirEstabelecimento() {

  }

  // Consultas
  public void listarPedidos() {


  }

  public void listarEstabelecimentos() {

  }

  public void listarUsuarios() {

  }

  public void listarRefeicoesDoEstabelecimento() {

  }

  // Consultas especiais
  public void pedidoMaisCaro() {
  }

  public void tickedMedioPedidos() {
    
  }
}
