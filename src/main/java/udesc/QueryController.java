package udesc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import udesc.data.EstabelecimentoData;
import udesc.data.PedidoData;

public class QueryController 
{
  private Connection connection;

  private String executeQuery(String query) 
  {
    String result = "";

    try 
    {
      Statement statement = connection.createStatement();
      ResultSet r = statement.executeQuery(query);

      for (int i = 1; i <= r.getMetaData().getColumnCount(); i++)
        result += r.getMetaData().getColumnName(i) + "\t";
      result += "\n";

      while (r.next()) {
        for (int i = 1; i <= r.getMetaData().getColumnCount(); i++)
          result += r.getString(i) + "\t";
        result += "\n";
      }

    } 
    catch (SQLException exc) 
    {
      exc.printStackTrace();
      System.exit(1);
    }

    return result;
  }

  public QueryController(Connection connection) 
  {
    this.connection = connection;
  }

  public void inserirPedido(PedidoData dados) 
  {
    String comandoInsercao = "insert into pedido (id_pedido, valor_final, taxa_de_entrega, status, observacao, cpf, cod_metodo) values ((select max(id_pedido) from pedido) + 1, ?, ?, ?, ?, ?, ?)";

    try {
      PreparedStatement stmt = this.connection.prepareStatement(comandoInsercao);
      stmt.setFloat(1, dados.getValorFinal());
      stmt.setFloat(2, dados.getTaxaDeEntrega());
      stmt.setString(3, dados.getStatus());
      stmt.setString(4, dados.getObservacao());
      stmt.setInt(5, dados.getCpf());
      stmt.setInt(6, dados.getCodMetodo());

      stmt.executeUpdate();
      System.out.println("Inserção de pedidos realizada com sucesso.");
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
  
  public void inserirEstabelecimento(EstabelecimentoData dados)
  {
    String comandoInsercao = "INSERT INTO estabelecimento (cnpj, nome, cpf, rua, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?)";

    try {
      PreparedStatement stmt = this.connection.prepareStatement(comandoInsercao);
      stmt.setString(1, dados.getCnpj());
      stmt.setString(2, dados.getNome());
      stmt.setString(3, dados.getCpf());
      stmt.setString(4, dados.getRua());
      stmt.setString(5, dados.getBairro());
      stmt.setString(6, dados.getCidade());

      stmt.executeUpdate();
      System.out.println("Inserção de estabelecimento realizada com sucesso.");
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public void listarEstabelecimentos() {
    String result = this.executeQuery("select * from estabelecimento");
    System.out.println("------ Lista de estabelecimentos ------");
    System.out.println(result);
  }

  public void listarUsuarios() {
    String result = this.executeQuery("select * from usuario");
    System.out.println("------ Lista de usuários ------");
    System.out.println(result);
  }

  public void listarRefeicoesDoEstabelecimento(String cnpj) {
    String result = this.executeQuery("select * from refeicao where cnpj = '" + cnpj + "'");
    System.out.println("------ Lista de refeicoes do estabelecimento com cnpj " + cnpj + " ------");
    System.out.println(result);
  }

  public void pedidoMaisCaro(String cnpj) {
    String query = 
    "select p.id_pedido, p.valor_final from pedido p" +
    "where p.valor_final in (" +
      "select max(p.valor_final) from pedido p" +
      "join pedido_refeicao pr on pr.id_pedido = p.id_pedido" +
      "join refeicao r on r.id_refeicao = pr.id_refeicao" +
      "join estabelecimento e on e.cnpj = r.cnpj" +
      "where e.cnpj = '" + cnpj + "'" +
    ")";
    String result = this.executeQuery(query);
    System.out.println("------ Pedido mais caro do estabelecimento '" + cnpj + "' ------");
    System.out.println(result);
  }
  
  public void ticketMedioPedidos(String cnpj) {
    String query = 
    "select distinct avg(p.valor_final) from pedido p" +
    "join pedido_refeicao pr on pr.id_pedido = p.id_pedido" +
    "join refeicao r on r.id_refeicao = pr.id_refeicao" +
    "join estabelecimento e on e.cnpj = r.cnpj" +
            "where e.cnpj = '" + cnpj + "'";
    String result = this.executeQuery(query);
    System.out.println("------ Ticked médio dos pedidos do estabelecimento '" + cnpj + "' ------");
    System.out.println(result);
  }

}
