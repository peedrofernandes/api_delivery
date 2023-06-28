package udesc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App {
  private static Connection establishConnection() {
    Connection connection = null;

    try {
      Dotenv dotenv = Dotenv.load();

      Class.forName("org.postgresql.Driver");

      String url = dotenv.get("DB_URL");
      String username = dotenv.get("DB_USERNAME");
      String password = dotenv.get("DB_PASSWORD");
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }

    return connection;
  }

  private static void closeConnection(Connection c) {
    try {
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    // Objeto que lê valores que o usuário digita na tela
    Scanner scanner = new Scanner(System.in);

    // Estabelece conexão com o banco de dados - O objeto 'connection' contém dados sobre a conexão
    // e vai ser usado para fazer consultas e manipulações no banco
    Connection connection = establishConnection();

    // Objeto que contém métodos que efetivamente farão as consultas SQL
    QueryController queryController = new QueryController(connection);

    // Objeto que contém métodos que lidarão com a entrada de dados do usuário, passando esses dados
    // para os métodos de QueryController
    APIHandler apiHandler = new APIHandler(queryController, scanner);

    // Variável da opção que o usuário irá escolher
    int op;

    do {
      System.out.println("Sistema de delivery - API de dados");
      System.out.println("Digite a sua opção: ");
      System.out.println("[1] Inserir um novo pedido;");
      System.out.println("[2] Inserir um novo estabelecimento;");
      System.out.println("[3] Listar todos os pedidos;");
      System.out.println("[4] Listar todos os estabelecimentos;");
      System.out.println("[5] Listar todos os usuários;");
      System.out.println("[6] Ver o pedido mais caro de um estabelecimento;");
      System.out.println("[7] Obter o ticket médio dos pedidos de um estabelecimento;");
      System.out.println("[0] Encerrar o programa;");
      System.out.println("Sua opção: ");
      op = scanner.nextInt();

      // Cada caso desse switch deverá cobrir um caso de uso do sistema, que corresponderá a um método
      // disponível no objeto APIHandler.
      switch (op) {
        case 1: // Inserir um novo pedido
          apiHandler.inserirPedido();
          break;
        case 2: // Inserir um novo estabelecimento
          break;
        case 3: // Listar todos os pedidos
          break;
        case 4: // Listar todos os estabelecimentos
          break;
        case 5: // Listar todos os usuários
          break;
        case 6: // Ver o pedido mais caro de um estabelecimento
          break;
        case 7: // Obter o ticket médio dos pedidos de um estabelecimento
          break;
        case 0: // Encerrar o programa
          System.out.println("Encerrando o programa, até a próxima.");
        default:
          System.out.println("Opção inválida, tente novamente!");
          break;
      }
    } while (op != 0);

    // Fecha a conexão com o banco de dados no fim do programa
    closeConnection(connection);

  }
}
