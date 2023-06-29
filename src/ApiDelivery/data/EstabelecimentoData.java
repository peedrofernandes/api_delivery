package ApiDelivery.data;

public class EstabelecimentoData {
  private String cnpj;
  private String nome;
  private String cpf;
  private String rua;
  private String bairro;
  private String cidade;

  public EstabelecimentoData(String cnpj, String nome, String cpf, String rua, String bairro, String cidade) {
    this.cnpj = cnpj;
    this.nome = nome;
    this.cpf = cpf;
    this.rua = rua;
    this.bairro = bairro;
    this.cidade = cidade;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getRua() {
    return rua;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }
}
