public class Van extends Veiculo {
    private int qtdAssentos;
    private double capacidadeDeCarga;
    private boolean portaAutomatica;

    public Van(String marca, String modelo, int ano, String cor, double preco, int qtdAssentos, double capacidadeDeCarga, boolean portaAutomatica) {
        super(marca, modelo, ano, cor, preco);
        this.qtdAssentos = qtdAssentos;
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.portaAutomatica = portaAutomatica;
    }

    public int getQtdAssentos(){
        return qtdAssentos;
    }

    public double getCapacidadeDeCarga(){
        return capacidadeDeCarga;
    }

    public boolean setPortaAutomatica() {
        return portaAutomatica;
    }

    public void setQtdAssentos(int qtdAssentos){
        this.qtdAssentos = qtdAssentos;
    }

    public void setCapacidadeDeCarga(double capacidadeDeCarga){
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public void setPortaAutomatica(boolean portaAutomatica){
        this.portaAutomatica = portaAutomatica;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Quantidade de Assentos: "+qtdAssentos);
        System.out.println("Qual o peso total suportado: "+capacidadeDeCarga);
        System.out.println("Esta van possui porta automática?" + (portaAutomatica ? "Sim" : "Não"));
    }
}



