// Definição da classe Pessoa que representa uma pessoa com várias informações pessoais.
public class Pessoa {
    // Declaração de variáveis de instância (atributos) privadas para encapsular os dados da classe.
    private String nome;         // Nome da pessoa
    private int idade;           // Idade da pessoa
    private String endereco;     // Endereço da pessoa
    private String telefone;     // Telefone da pessoa
    private String email;        // Email da pessoa
    private double altura;       // Altura da pessoa em centímetros
    private double peso;         // Peso da pessoa em quilogramas

    // Construtor da classe que inicializa os atributos da pessoa ao criar um novo objeto.
    public Pessoa(String nome, int idade, String endereco, String telefone,
                  String email, double altura, double peso){
        this.nome = nome;         // Inicializa o atributo 'nome' com o valor recebido.
        this.idade = idade;       // Inicializa o atributo 'idade' com o valor recebido.
        this.endereco = endereco; // Inicializa o atributo 'endereco' com o valor recebido.
        this.telefone = telefone; // Inicializa o atributo 'telefone' com o valor recebido.
        this.email = email;       // Inicializa o atributo 'email' com o valor recebido.
        this.altura = altura;     // Inicializa o atributo 'altura' com o valor recebido.
        this.peso = peso;         // Inicializa o atributo 'peso' com o valor recebido.
    }

    // Métodos getters para permitir acesso aos atributos privados da classe.
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }

    // Métodos setters para permitir a modificação dos atributos privados da classe.
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setPeso(double peso) { this.peso = peso; }

    // Método que incrementa a idade da pessoa em 1 ano, simulando um aniversário.
    public void fazerAniversario() {
        idade++; // Incrementa a idade em 1.
        System.out.println("Feliz aniversario, " + nome + ". Agora voce tem " + idade + " anos!");
    }

    // Método que exibe todas as informações da pessoa no console.
    public void exibirInformacoes() {
        System.out.println("Nome:     " + nome);      // Exibe o nome.
        System.out.println("Idade:    " + idade);     // Exibe a idade.
        System.out.println("Endereço: " + endereco);  // Exibe o endereço.
        System.out.println("Telefone: " + telefone);  // Exibe o telefone.
        System.out.println("Email:    " + email);     // Exibe o email.
        System.out.println("Altura:   " + altura + " CM"); // Exibe a altura.
        System.out.println("Peso:     " + peso + " KG");   // Exibe o peso.
    }
}
