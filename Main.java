import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
// Exceção para cliente não encontrado
class ClienteNaoEncontradoException extends Exception {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}

// Exceção para veículo indisponível
class VeiculoIndisponivelException extends Exception {
    public VeiculoIndisponivelException(String message) {
        super(message);
    }
}

public class Main {
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Van> vans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do{
            try{
                System.out.println("### Menu Concessionaria ###");
                System.out.println("1 - Mostrar Veículos");
                System.out.println("2 - Comprar Veículo");
                System.out.println("3 - Vender Veículo");
                System.out.println("4 - Cadastrar um cliente");
                System.out.println("5 - Gerar relatorio");
                System.out.println("6 - Exibir Clientes Cadastrados");
                System.out.println("7 - Sugestão de Moto de acordo com Biotipo");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (escolha) {
                    case 1:
                        mostrarVeiculos();
                        break;
                    case 2:
                        comprarVeiculo(scanner);
                        break;
                    case 3:
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        gerarRelatorio();
                        break;
                    case 6:
                        exibirClientesCadastrados();
                        break;
                    case 7:
                        sugestaoVeiculo(scanner);
                        break;
                    case 0:
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                }
            }catch (InputMismatchException e){
                System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Erro desconhecido: "+e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void sugestaoVeiculo(Scanner scanner) {
        System.out.println("--- Sugestão de Moto por Biotipo do Cliente ---\n");
        System.out.println("Qual o peso do cliente?");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        if(peso <= 90){
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto da Marca Honda de 50cc.\n");
        }else if (peso > 90 && peso < 152){
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto Yamaha de 115cc.\n");
        }else if (peso >= 152 && peso <= 166){
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto Honda de 125cc.\n");
        }else if (peso > 166 && peso <= 192){
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto da Marca Yamaha de 125cc.\n");
        } else{
            System.out.println("Infelizmente, não temos recomendações específicas para esse peso.\n");
        }
    }

    private static void exibirClientesCadastrados() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes Cadastrados ###");
            int x = 1;
            for (Pessoa pessoa : clientes) {
                System.out.println(x+"-"+pessoa.getNome()+" - "+pessoa.getEmail() + " - " + pessoa.getTelefone() + "\n");
                x++;
            }
        }else{
            System.out.println("Nenhum cliente foi encontrado!");
        }
    }

    private static <T extends Veiculo> void mostrarVeiculos(List<T> veiculos, String titulo) {
        if (!veiculos.isEmpty()) {
            System.out.println("### " + titulo + " ###");
            int x = 1;
            for (T veiculo : veiculos) {
                System.out.println(x + " - " + veiculo.getModelo() + " - Ano: " + veiculo.getAno() + " - Preço de Custo: R$ " + veiculo.getPreco());
                x++;
            }
        } else {
            System.out.println("Nenhum " + titulo.toLowerCase().substring(0, titulo.length() - 1) + " foi encontrado!");
        }
    }

    private static void mostrarVeiculos() {
        mostrarVeiculos(carros, "Lista de Carros");
        System.out.println("----------------------------------");
        mostrarVeiculos(motos, "Lista de Motos");
        System.out.println("----------------------------------");
        mostrarVeiculos(vans, "Lista de Vans");
        System.out.println("");
    }

    private static void comprarVeiculo(Scanner scanner) {
        try{
            System.out.println("### Compra de Veiculo ###");
            int escolha;

            System.out.println("Qual novo veiculo deseja cadastrar?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Van");
            System.out.println("0 - Voltar ao menu");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 3) {
                throw new InputMismatchException();
            }
            while (escolha != 0) {
                System.out.print("Digite a marca do veículo: ");
                String marca = scanner.nextLine();

                System.out.print("Digite o modelo do veículo: ");
                String modelo = scanner.nextLine();

                System.out.print("Digite o ano do veículo: ");
                int ano = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite a cor do veículo: ");
                String cor = scanner.nextLine();

                System.out.print("Digite o preço do veículo: ");
                double preco = scanner.nextDouble(); //preço de custo
            
                switch (escolha) {
                    case 1:
                        System.out.print("Digite o numero de portas veículo: ");
                        int nPortar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite o tipo de combustivel: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.print("Digite a capacidade do porta malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();
                        scanner.nextLine();

                        Carro carro = new Carro(marca, modelo, ano, cor, preco, nPortar, tipoCombustivel, capacidadePortaMalas);
                        carros.add(carro);
                        System.out.println("Carro modelo: "+modelo+", cadastrado com sucesso!\n");
                        escolha = 0;
                        break;
                    
                    case 2:
                        System.out.print("Digite as cilindradas do veiculo: ");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("O veiculo possui partida eletrica? S - sim, N - não");
                        String partida = scanner.nextLine();
                        boolean partidaEletrica;
                        if(partida == "S" || partida == "s"){
                            partidaEletrica = true;
                        }else{
                            partidaEletrica = false;
                        }

                        System.out.print("Digite a categoria do veiculo: ");
                        String categoria = scanner.nextLine();

                        Moto moto = new Moto(marca, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                        motos.add(moto);
                        System.out.println("moto modelo: "+modelo+", cadastrada com sucesso!\n");
                        escolha = 0;
                        break;

                    case 3:
                        System.out.print("Digite a quantidade total de assentos para passageiros: ");
                        int qtdAssentos = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("A van possui porta automática ? S - Sim, N - Não");
                        String porta = scanner.nextLine();
                        boolean portaAutomatica;
                        if(porta == "S" || porta == "s"){
                            portaAutomatica = true;
                        }else{
                            portaAutomatica = false;
                        }

                        System.out.print("Digite a capacidade total de carga da van : ");
                        double capacidadeCarga = scanner.nextDouble();

                        Van van = new Van(marca, modelo, ano, cor, preco, qtdAssentos, capacidadeCarga, portaAutomatica);
                        vans.add(van);
                        System.out.println("Van modelo: "+modelo+", cadastrada com sucesso!\n");
                        escolha = 0;

                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                        break;
                }
            }
            
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void venderVeiculo(Scanner scanner) {
        try {
            if (clientes.isEmpty()) {
                throw new ClienteNaoEncontradoException("Não há clientes cadastrados na base de dados!");
            }
            if (carros.isEmpty() && motos.isEmpty() && vans.isEmpty()) {
                throw new VeiculoIndisponivelException("Nenhum veículo disponível para venda!");
            }

            mostrarClientes();
            System.out.print("Selecione o cliente (número): ");
            int clienteIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                throw new ClienteNaoEncontradoException("Índice de cliente inválido!");
            }
            Pessoa comprador = clientes.get(clienteIndex);

            System.out.print("Informe o valor da venda: R$ ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Qual veículo deseja vender?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Van");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    if (carros.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhum carro disponível para venda!");
                    }
                    mostrarVeiculos(carros, "Lista de Carros");
                    System.out.print("Escolha o número do carro para efetuar a venda:");
                    Carro carroParaVenda = carros.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(carroParaVenda, comprador, valor, LocalDateTime.now()));
                    carros.remove(carroParaVenda);
                    break;

                case 2:
                    if (motos.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhuma moto disponível para venda!");
                    }
                    mostrarVeiculos(motos, "Lista de Motos");
                    System.out.print("Escolha o número da moto para efetuar a venda:");
                    Moto motoParaVenda = motos.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(motoParaVenda, comprador, valor, LocalDateTime.now()));
                    motos.remove(motoParaVenda);
                    break;

                case 3:
                    if (vans.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhuma van disponível para venda!");
                    }
                    mostrarVeiculos(vans, "Lista de Vans");
                    System.out.print("Escolha o número da van para efetuar a venda:");
                    Van vanParaVenda = vans.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(vanParaVenda, comprador, valor, LocalDateTime.now()));
                    vans.remove(vanParaVenda);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Venda concluída com sucesso!\n");
        } catch (ClienteNaoEncontradoException | VeiculoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }


    private static void mostrarClientes() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes ###");
            int x = 1;
            for (Pessoa cliente : clientes) {
                System.out.println(x+" - "+cliente.getNome()+" - "+cliente.getTelefone());
                x++;
            }
        }else{
            System.out.println("Nenhuma cliente foi encontrado!");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try{
            System.out.println("### Cadastro de Cliente ###");

            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.println("Digite um telefone para contato do cliente: ");
            String telefone = scanner.nextLine();

            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            System.out.println("Digite a altura do cliente: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println("O cliente: "+nome+", foi cadastrado com sucesso!\n");
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
        }else{
            System.out.println("### Relatorio de vendas ###");
            System.out.println();

            double totalLucro = 0.0;

            for (Venda venda : vendas) {
               double custoVeiculo = venda.getVeiculo().getPreco();
               double valorVenda = venda.getValor();
               double lucro = valorVenda - custoVeiculo;

               System.out.println("Data: "+ venda.getDataVenda());
               System.out.println("Veiculo: "+venda.getVeiculo().getModelo()+" - "+venda.getVeiculo().getAno());
               System.out.println("Comprador: "+venda.getComprador().getNome()+" - "+venda.getComprador().getTelefone());
               System.out.println("Valor de Custo: R$ " + custoVeiculo);
               System.out.println("Valor da venda: R$"+venda.getValor());

                if (lucro >= 0) {
                    System.out.println("Lucro: R$" + String.format("%.2f", lucro));
                } else {
                    System.out.println("Prejuízo: R$" + String.format("%.2f", Math.abs(lucro)));
                }

                totalLucro += lucro;

                System.out.println("----------------------------------------------------------------");
                System.out.println();
            }
            // Resumo total do relatório
            System.out.println("Resumo Financeiro:");
            if(totalLucro > 0){
                System.out.println("Você teve um lucro total de: R$" + String.format("%.2f", totalLucro));
            }else{
                System.out.println("Você teve um prejuízo total de : R$" + String.format("%.2f", totalLucro));
            }
        }
    }
}
