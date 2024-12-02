// Declaração de uma interface chamada InterfaceVeiculo
public interface InterfaceVeiculo {
    // Método para ligar o veículo
    // Por padrão, métodos em interfaces são públicos e abstratos
    void ligar();

    // Método para desligar o veículo
    void desligar();

    // Método para acelerar o veículo
    // Recebe como parâmetro a velocidade de aceleração
    void acelerar(int velocidade);

    // Método para frear o veículo
    // Recebe como parâmetro a velocidade de redução
    void frear(int velocidade);

    // Método para exibir informações do veículo
    void exibirInformacoes();
}