// Classe Venda representa uma transação de venda de um veículo para uma pessoa.
import java.time.LocalDateTime; // Importação da classe para manipulação de data e hora.

public class Venda {
    // Declaração dos atributos privados da classe.
    private Veiculo veiculo;           // O veículo vendido.
    private Pessoa comprador;          // O comprador do veículo.
    private double valor;              // Valor da venda.
    private LocalDateTime dataVenda;   // Data e hora em que a venda foi realizada.

    // Construtor da classe que inicializa todos os atributos da venda.
    public Venda(Veiculo veiculo, Pessoa comprador, double valor, LocalDateTime dataVenda){
        this.veiculo = veiculo;        // Inicializa o veículo associado à venda.
        this.comprador = comprador;    // Inicializa o comprador do veículo.
        this.valor = valor;            // Inicializa o valor da venda.
        this.dataVenda = dataVenda;    // Inicializa a data e hora da venda.
    }

    // Métodos getters para acesso aos atributos privados da classe.
    public Veiculo getVeiculo() {
        return veiculo;                // Retorna o veículo da venda.
    }
    public Pessoa getComprador() {
        return comprador;              // Retorna o comprador da venda.
    }
    public double getValor() {
        return valor;                  // Retorna o valor da venda.
    }
    public LocalDateTime getDataVenda() {
        return dataVenda;              // Retorna a data e hora da venda.
    }

    // Métodos setters para modificar os atributos privados da classe.
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;        // Modifica o veículo da venda.
    }
    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;    // Modifica o comprador da venda.
    }
    public void setValor(double valor) {
        this.valor = valor;            // Modifica o valor da venda.
    }
    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;    // Modifica a data e hora da venda.
    }

    // Método que exibe os detalhes da venda formatados no console.
    public void exibirDetalhesVenda(){
        System.out.println("Detalhes da venda");
        System.out.println("Veiculo: " + veiculo.getModelo() + " - Ano: " + veiculo.getAno());
        System.out.println("Comprador: " + comprador.getNome() + " contato: " + comprador.getTelefone());
        System.out.println("Valor da venda: R$" + valor);
        System.out.println("Data da venda: " + dataVenda);
    }
}
