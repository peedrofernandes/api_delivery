package udesc;

public class APIHandler {
  private QueryController queryController;

  APIHandler(QueryController queryController) {
    this.queryController = queryController;
  }

  // Inserções
  public void inserirPedido() {
    
  }

  public void inserirEstabelecimento() {
    // -- Inserir estabelecimento
    // insert into estabelecimento (cnpj, nome, cpf, rua, bairro, cidade) values
    // ('12345678901235', 'Empresa X', '12312312312', 'a', 'b', 'c');
  }

  // Consultas
  public void listarPedidos() {
    // -- Listar pedidos
    // select * from pedido;

  }

  public void listarEstabelecimentos() {
    // -- Listar Estabelecimentos
    // select * from estabelecimento;
  }

  public void listarUsuarios() {
    // -- Listar usuários
    // select * from usuario;
  }

  public void listarRefeicoesDoEstabelecimento() {
    // -- Refeições do estabelecimento
    // select * from refeicao where cnpj = '12345678901234';
  }

  // Consultas especiais
  public void pedidoMaisCaro() {
    // -- Pedido mais caro do estabelecimento x
    // select p.id_pedido, p.valor_final from pedido p
    // where p.valor_final in (
    //   select max(p.valor_final) from pedido p
    //   join pedido_refeicao pr on pr.id_pedido = p.id_pedido
    //   join refeicao r on r.id_refeicao = pr.id_refeicao
    //   join estabelecimento e on e.cnpj = r.cnpj 
    //   where e.cnpj = '12345678901234'
    // );
  }

  public void tickedMedioPedidos() {
    // -- Ticket médio dos pedidos do estabelecimento x
    // select distinct avg(p.valor_final) from pedido p
    // join pedido_refeicao pr on pr.id_pedido = p.id_pedido
    // join refeicao r on r.id_refeicao = pr.id_refeicao
    // join estabelecimento e on e.cnpj = r.cnpj
    // where e.nome = 'Restaurante do Chef';
  }
}












  

