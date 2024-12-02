// Definição da classe Van, que é uma especialização (subclasse) de Veiculo.
public class Van extends Veiculo {
    // Declaração de atributos específicos da classe Van.
    private int qtdAssentos;         // Quantidade de assentos disponíveis na van.
    private double capacidadeDeCarga; // Capacidade máxima de carga suportada pela van.
    private boolean portaAutomatica;  // Indica se a van possui porta automática.

    // Construtor da classe Van que inicializa atributos herdados e específicos.
    public Van(String marca, String modelo, int ano, String cor, double preco,
               int qtdAssentos, double capacidadeDeCarga, boolean portaAutomatica) {
        // Chamada ao construtor da classe pai (Veiculo) para inicializar atributos herdados.
        super(marca, modelo, ano, cor, preco);
        // Inicializa os atributos específicos da Van.
        this.qtdAssentos = qtdAssentos;
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.portaAutomatica = portaAutomatica;
    }

    // Métodos getter para acessar os atributos privados da classe.
    public int getQtdAssentos() {
        return qtdAssentos;
    }
    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }
    public boolean setPortaAutomatica() {
        return portaAutomatica;
    }

    // Métodos setter para modificar os atributos privados da classe.
    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }
    public void setCapacidadeDeCarga(double capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }
    public void setPortaAutomatica(boolean portaAutomatica) {
        this.portaAutomatica = portaAutomatica;
    }

    // Sobrescrita (override) do método exibirInformacoes da classe pai (Veiculo).
    @Override
    public void exibirInformacoes() {
        // Chama o método exibirInformacoes da classe pai para exibir os atributos herdados.
        super.exibirInformacoes();
        // Adiciona informações específicas da classe Van.
        System.out.println("Quantidade de Assentos: " + qtdAssentos);
        System.out.println("Qual o peso total suportado: " + capacidadeDeCarga);
        System.out.println("Esta van possui porta automática? " + (portaAutomatica ? "Sim" : "Não"));
    }
}
