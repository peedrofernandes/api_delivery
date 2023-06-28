package udesc;

import java.util.Scanner;

import udesc.data.EstabelecimentoData;
import udesc.data.PedidoData;

public class APIHandler {
  private QueryController queryController;
  private Scanner scanner;



  public APIHandler(QueryController queryController, Scanner scanner) {
    this.queryController = queryController;
    this.scanner = scanner;
  }

  // Inserções
  public void inserirPedido() {

    System.out.print("CPF do cliente do pedido: ");
    long cpf = this.scanner.nextLong();
    System.out.print("Taxa de entrega do pedido: ");
    Float taxaDeEntrega = this.scanner.nextFloat();
    System.out.print("Valor final do pedido: ");
    Float valorFinal = this.scanner.nextFloat();
    
    this.scanner.nextLine();

    System.out.print("Status do pedido: ");
    String status = this.scanner.nextLine();
    System.out.print("Observação sobre o pedido: ");
    String observacao = this.scanner.nextLine();
    System.out.print("Código do método de pagamento do pedido: ");
    int codMetodo = this.scanner.nextInt();

    this.scanner.nextLine();

    PedidoData dados = new PedidoData(valorFinal, taxaDeEntrega, status, observacao, cpf, codMetodo);
    this.queryController.inserirPedido(dados);
  }

  public void inserirEstabelecimento() {
    System.out.print("CNPJ do estabelecimento: ");
    String cnpj = this.scanner.nextLine();
    System.out.print("Nome do cliente: ");
    String nome = this.scanner.nextLine();
    System.out.print("CPF do cliente: ");
    String cpf = this.scanner.nextLine();
    System.out.print("Rua do estabelecimento: ");
    String rua = this.scanner.nextLine();
    System.out.print("Bairro do estabelecimento: ");
    String bairro = this.scanner.nextLine();
    System.out.print("Cidade do estabelecimento: ");
    String cidade = this.scanner.nextLine();

    EstabelecimentoData dados = new EstabelecimentoData(cnpj, nome, cpf, cidade, bairro, rua);
    this.queryController.inserirEstabelecimento(dados);
  }

  // Consultas
  public void listarPedidos() {
    this.queryController.listarPedidos();
  }

  public void listarEstabelecimentos() {
    this.queryController.listarEstabelecimentos();
  }

  public void listarUsuarios() {
    this.queryController.listarUsuarios();
  }

  public void listarRefeicoesDoEstabelecimento() {
    System.out.println("CNPJ do estabelecimento: ");
    String cnpj = this.scanner.nextLine();

    this.queryController.listarRefeicoesDoEstabelecimento(cnpj);
  }

  // Consultas especiais
  public void pedidoMaisCaroDoEstabelecimento() {
    System.out.println("CNPJ do estabelecimento: ");
    String cnpj = this.scanner.nextLine();

    this.queryController.pedidoMaisCaro(cnpj);
  }

  public void tickedMedioPedidosDoEstabelecimento() {
    System.out.println("CNPJ do estabelecimento: ");
    String cnpj = this.scanner.nextLine();

    this.queryController.ticketMedioPedidos(cnpj);
  }
}
