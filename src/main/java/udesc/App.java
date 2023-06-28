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
public class App 
{
    private static Connection establishConnection()
    {
        Connection connection = null;

        try 
        {
            Dotenv dotenv = Dotenv.load();

            Class.forName("org.postgresql.Driver");

            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");
            connection = DriverManager.getConnection(url, username, password);
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }

        return connection;
    }
    
    private static void closeConnection(Connection c)
    {
        try 
        {
            c.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("Trying to connect to postgres");

        Connection c = establishConnection();
        QueryController queryController = new QueryController(c);
        System.out.println(queryController.selectFromTest());
        closeConnection(c);

        Scanner s = new Scanner(System.in);
        int op;
        do {
            System.out.println("Sistema de delivery - API de dados");
            System.out.println("Digite a sua opção: ");
            System.out.println("[1] Inserir um novo pedido;");
            System.out.println("[2] Inserir um novo estabelecimento;");
            System.out.println("[3] Listar todos os pedidos existentes;");
            System.out.println("[4] Listar todos os pedidos existentes;");
            System.out.println("[5] Listar todos os pedidos existentes;");
            System.out.println("[6] Listar todos os pedidos existentes;");
            op = s.nextInt();
        } while (op != 0);
    }
}
