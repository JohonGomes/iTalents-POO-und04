// Declaração da classe Carro que herda da classe Veiculo
public class Carro extends Veiculo {
    // Atributos específicos da classe Carro
    private int nPortar;  // Número de portas do carro
    private String tipoCombustivel;  // Tipo de combustível utilizado
    private int capacidadePortaMalas;  // Capacidade do porta-malas em litros

    // Construtor da classe Carro que recebe todos os atributos do carro
    public Carro(String marca, String modelo, int ano, String cor, double preco,
                 int nPortar, String tipoCombustivel, int capacidadePortaMalas) {

        // Chama o construtor da classe pai (Veiculo) com os atributos herdados
        super(marca, modelo, ano, cor, preco);

        // Inicializa os atributos específicos do Carro
        this.nPortar = nPortar;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    // Método para simular a abertura do porta-malas
    public void abrirPortaMalas(){
        System.out.println("Abrindo porta malas...");
    }

    // Método para simular o fechamento do porta-malas
    public void fecharPortaMalas(){
        System.out.println("Fechando porta malas...");
    }

    // Métodos getters para recuperar os valores dos atributos
    public int getnPortar() {
        return nPortar;
    }
    public String getTipoCombustivel() {
        return tipoCombustivel;
    }
    public int getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    // Métodos setters para modificar os valores dos atributos
    public void setnPortar(int nPortar) {
        this.nPortar = nPortar;
    }
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    public void setCapacidadePortaMalas(int capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    // Sobrescrita do método exibirInformacoes da classe pai
    @Override
    public void exibirInformacoes() {
        // Chama o método exibirInformacoes da classe pai (Veiculo)
        super.exibirInformacoes();

        // Adiciona informações específicas do Carro
        System.out.println("Numero de portas: "+nPortar);
        System.out.println("Tipo de combustivel: "+tipoCombustivel);
        System.out.println("Capacidade do porta malas: "+capacidadePortaMalas+" litros");
    }
}