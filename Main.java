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
    // Listas estáticas para armazenar diferentes tipos de veículos, clientes e vendas
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Van> vans = new ArrayList<>();

    public static void main(String[] args) {
        // Cria um Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        // Loop principal do programa - continua até que o usuário escolha sair
        do {
            try {
                // Exibe o menu principal de opções
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

                // Lê a escolha do usuário no menu
                escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                System.out.println();

                // Switch para lidar com diferentes opções do menu
                switch (escolha) {
                    case 1:
                        // Mostra todos os veículos cadastrados
                        mostrarVeiculos();
                        break;
                    case 2:
                        // Permite comprar/cadastrar um novo veículo
                        comprarVeiculo(scanner);
                        break;
                    case 3:
                        // Permite vender um veículo
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        // Cadastra um novo cliente
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        // Gera um relatório de vendas
                        gerarRelatorio();
                        break;
                    case 6:
                        // Exibe a lista de clientes cadastrados
                        exibirClientesCadastrados();
                        break;
                    case 7:
                        // Fornece sugestão de moto baseada no biotipo do cliente
                        sugestaoVeiculo(scanner);
                        break;
                    case 0:
                        // Fecha o programa
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        // Trata opção inválida
                        System.out.println("Opção invalida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Trata erros de entrada inválida
                System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
                scanner.nextLine(); // Limpa a entrada inválida
            } catch (Exception e) {
                // Captura quaisquer outros erros inesperados
                System.out.println("Erro desconhecido: " + e.getMessage());
            }
        } while (escolha != 0); // Continua até que o usuário escolha sair

        // Fecha o scanner
        scanner.close();
    }

    // Método para sugerir uma motocicleta com base no peso do cliente
    private static void sugestaoVeiculo(Scanner scanner) {
        System.out.println("--- Sugestão de Moto por Biotipo do Cliente ---\n");
        System.out.println("Qual o peso do cliente?");
        // Lê o peso do cliente
        double peso = scanner.nextDouble();
        scanner.nextLine();

        // Recomenda motocicletas com base em diferentes faixas de peso
        if (peso <= 90) {
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto da Marca Honda de 50cc.\n");
        } else if (peso > 90 && peso < 152) {
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto Yamaha de 115cc.\n");
        } else if (peso >= 152 && peso <= 166) {
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto Honda de 125cc.\n");
        } else if (peso > 166 && peso <= 192) {
            System.out.println("Para esse cliente como peso " + peso + "KG recomendamos a Moto da Marca Yamaha de 125cc.\n");
        } else {
            System.out.println("Infelizmente, não temos recomendações específicas para esse peso.\n");
        }
    }

    // Método para exibir clientes cadastrados
    private static void exibirClientesCadastrados() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes Cadastrados ###");
            int x = 1;
            // Itera e imprime detalhes de cada cliente cadastrado
            for (Pessoa pessoa : clientes) {
                System.out.println(x + "-" + pessoa.getNome() + " - " + pessoa.getEmail() + " - " + pessoa.getTelefone() + "\n");
                x++;
            }
        } else {
            System.out.println("Nenhum cliente foi encontrado!");
        }
    }

    // Método genérico para mostrar veículos de diferentes tipos
    private static <T extends Veiculo> void mostrarVeiculos(List<T> veiculos, String titulo) {
        if (!veiculos.isEmpty()) {
            System.out.println("### " + titulo + " ###");
            int x = 1;
            // Itera e imprime detalhes de cada veículo
            for (T veiculo : veiculos) {
                System.out.println(x + " - " + veiculo.getModelo() + " - Ano: " + veiculo.getAno() + " - Preço de Custo: R$ " + veiculo.getPreco() + "\n");
                x++;
            }
        } else {
            System.out.println("Nenhum " + titulo.toLowerCase().substring(0, titulo.length() - 1) + " foi encontrado!");
        }
    }

    // Método para mostrar todos os tipos de veículos
    private static void mostrarVeiculos() {
        mostrarVeiculos(carros, "Lista de Carros");
        System.out.println("----------------------------------");
        mostrarVeiculos(motos, "Lista de Motos");
        System.out.println("----------------------------------");
        mostrarVeiculos(vans, "Lista de Vans");
        System.out.println("");
    }

    // Método para comprar/registrar um novo veículo
    private static void comprarVeiculo(Scanner scanner) {
        try {
            System.out.println("### Compra de Veiculo ###");
            int escolha;

            // Menu de seleção do tipo de veículo
            System.out.println("Qual novo veiculo deseja cadastrar?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Van");
            System.out.println("0 - Voltar ao menu");
            escolha = scanner.nextInt();
            scanner.nextLine();

            // Valida a escolha do usuário
            if (escolha > 3) {
                throw new InputMismatchException();
            }

            // Continua até que o usuário escolha voltar ao menu
            while (escolha != 0) {
                // Coleta detalhes comuns do veículo
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
                double preco = scanner.nextDouble(); // preço de custo

                // Campos de entrada diferentes baseados no tipo de veículo
                switch (escolha) {
                    case 1: // Carro
                        System.out.print("Digite o numero de portas veículo: ");
                        int nPortar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite o tipo de combustivel: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.print("Digite a capacidade do porta malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();
                        scanner.nextLine();

                        // Cria e adiciona o carro à lista
                        Carro carro = new Carro(marca, modelo, ano, cor, preco, nPortar, tipoCombustivel, capacidadePortaMalas);
                        carros.add(carro);
                        System.out.println("Carro modelo: " + modelo + ", cadastrado com sucesso!\n");
                        escolha = 0;
                        break;

                    case 2: // Moto
                        System.out.print("Digite as cilindradas do veiculo: ");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("O veiculo possui partida eletrica? S - sim, N - não");
                        String partida = scanner.nextLine();
                        boolean partidaEletrica;
                        if (partida.equalsIgnoreCase("S")) {
                            partidaEletrica = true;
                        } else {
                            partidaEletrica = false;
                        }

                        System.out.print("Digite a categoria do veiculo: ");
                        String categoria = scanner.nextLine();

                        // Cria e adiciona a moto à lista
                        Moto moto = new Moto(marca, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                        motos.add(moto);
                        System.out.println("moto modelo: " + modelo + ", cadastrada com sucesso!\n");
                        escolha = 0;
                        break;

                    case 3: // Van
                        System.out.print("Digite a quantidade total de assentos para passageiros: ");
                        int qtdAssentos = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("A van possui porta automática ? S - Sim, N - Não");
                        String porta = scanner.nextLine();
                        boolean portaAutomatica;
                        if (porta.equalsIgnoreCase("S")) {
                            portaAutomatica = true;
                        } else {
                            portaAutomatica = false;
                        }

                        System.out.print("Digite a capacidade total de carga da van : ");
                        double capacidadeCarga = scanner.nextDouble();

                        // Cria e adiciona a van à lista
                        Van van = new Van(marca, modelo, ano, cor, preco, qtdAssentos, capacidadeCarga, portaAutomatica);
                        vans.add(van);
                        System.out.println("Van modelo: " + modelo + ", cadastrada com sucesso!\n");
                        escolha = 0;
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void venderVeiculo(Scanner scanner) {
        try {
            // Verifica se há clientes cadastrados, caso contrário, lança uma exceção personalizada.
            if (clientes.isEmpty()) {
                throw new ClienteNaoEncontradoException("Não há clientes cadastrados na base de dados!");
            }
            // Verifica se há veículos disponíveis para venda, caso contrário, lança uma exceção personalizada.
            if (carros.isEmpty() && motos.isEmpty() && vans.isEmpty()) {
                throw new VeiculoIndisponivelException("Nenhum veículo disponível para venda!");
            }

            // Mostra a lista de clientes cadastrados.
            mostrarClientes();
            // Solicita ao usuário a seleção de um cliente pelo índice.
            System.out.print("Selecione o cliente (número): ");
            int clienteIndex = scanner.nextInt() - 1; // O índice é ajustado para começar em 0.
            scanner.nextLine();// Limpa o buffer de entrada.

            // Valida se o índice do cliente selecionado é válido.
            if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                throw new ClienteNaoEncontradoException("Índice de cliente inválido!");
            }
            Pessoa comprador = clientes.get(clienteIndex); // Obtém o cliente selecionado.

            // Solicita ao usuário a escolha do tipo de veículo para vender.
            System.out.println("Qual veículo deseja vender?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Van");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            // Solicita o valor da venda.
            System.out.print("Informe o valor da venda: R$ ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("");

            // Processa a venda com base no tipo de veículo escolhido.
            switch (escolha) {
                case 1: // Venda de carro
                    if (carros.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhum carro disponível para venda:");
                    }
                    mostrarVeiculos(carros, "Lista de Carros"); // Mostra a lista de carros disponíveis.
                    System.out.print("Escolha o número do carro para efetuar a venda: ");
                    Carro carroParaVenda = carros.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(carroParaVenda, comprador, valor, LocalDateTime.now())); // Registra a venda.
                    carros.remove(carroParaVenda); // Remove o carro vendido da lista.
                    break;

                case 2: // Venda de moto
                    if (motos.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhuma moto disponível para venda!");
                    }
                    mostrarVeiculos(motos, "Lista de Motos"); // Mostra a lista de motos disponíveis.
                    System.out.print("Escolha o número da moto para efetuar a venda:");
                    Moto motoParaVenda = motos.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(motoParaVenda, comprador, valor, LocalDateTime.now())); // Registra a venda.
                    motos.remove(motoParaVenda); // Remove a moto vendida da lista.
                    break;

                case 3: // Venda de van
                    if (vans.isEmpty()) {
                        throw new VeiculoIndisponivelException("Nenhuma van disponível para venda!");
                    }
                    mostrarVeiculos(vans, "Lista de Vans"); // Mostra a lista de vans disponíveis.
                    System.out.print("Escolha o número da van para efetuar a venda:");
                    Van vanParaVenda = vans.get(scanner.nextInt() - 1);
                    vendas.add(new Venda(vanParaVenda, comprador, valor, LocalDateTime.now())); // Registra a venda.
                    vans.remove(vanParaVenda); // Remove a van vendida da lista.
                    break;

                default:
                    // Opção inválida escolhida pelo usuário.
                    System.out.println("Opção inválida.");
            }
            // Confirmação de venda realizada com sucesso.
            System.out.println("Venda executada com sucesso!\n");
        } catch (ClienteNaoEncontradoException | VeiculoIndisponivelException e) {
            // Trata exceções específicas relacionadas a cliente ou veículos.
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            // Trata erro de entrada inválida.
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); // Limpa o buffer de entrada.
        } catch (Exception e) {
            // Trata erros gerais não especificados.
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void mostrarClientes() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes ###");
            int x = 1;
            for (Pessoa cliente : clientes) {
                System.out.println(x + " - " + cliente.getNome() + " - " + cliente.getTelefone());
                x++;
            }
        } else {
            System.out.println("Nenhuma cliente foi encontrado!");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try {
            // Exibe o título do processo de cadastro de cliente.
            System.out.println("### Cadastro de Cliente ###");

            // Solicita o nome do cliente e armazena na variável 'nome'.
            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            // Solicita a idade do cliente e armazena na variável 'idade'.
            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada.

            // Solicita o endereço do cliente e armazena na variável 'endereco'.
            System.out.println("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            // Solicita o telefone do cliente e armazena na variável 'telefone'.
            System.out.println("Digite um telefone para contato do cliente: ");
            String telefone = scanner.nextLine();

            // Solicita o email do cliente e armazena na variável 'email'.
            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            // Solicita a altura do cliente e armazena na variável 'altura'.
            System.out.println("Digite a altura do cliente: ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer de entrada.

            // Solicita o peso do cliente e armazena na variável 'peso'.
            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer de entrada.

            // Cria um novo objeto do tipo Pessoa com os dados coletados.
            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);

            // Adiciona o novo cliente à lista de clientes.
            clientes.add(novoCliente);

            // Exibe uma mensagem de sucesso ao usuário.
            System.out.println("O cliente: " + nome + ", foi cadastrado com sucesso!\n");
        } catch (InputMismatchException e) {
            // Trata exceções causadas por entrada incompatível (ex.: texto onde era esperado número).
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); // Limpa o buffer para evitar loops de erro.
        } catch (Exception e) {
            // Trata exceções genéricas não especificadas.
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        // Verifica se existem vendas registradas.
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
        } else {
            // Exibe o título do relatório de vendas.
            System.out.println("### Relatorio de vendas ###");
            System.out.println();

            // Inicializa a variável para calcular o lucro total.
            double totalLucro = 0.0;

            // Percorre a lista de vendas para exibir informações detalhadas de cada uma.
            for (Venda venda : vendas) {
                // Calcula os valores de custo, venda e lucro/prejuízo.
                double custoVeiculo = venda.getVeiculo().getPreco();
                double valorVenda = venda.getValor();
                double lucro = valorVenda - custoVeiculo;

                // Exibe informações detalhadas da venda.
                System.out.println("Data: " + venda.getDataVenda());
                System.out.println("Veiculo: " + venda.getVeiculo().getModelo() + " - " + venda.getVeiculo().getAno());
                System.out.println("Comprador: " + venda.getComprador().getNome() + " - " + venda.getComprador().getTelefone());
                System.out.println("Valor de Custo: R$ " + custoVeiculo);
                System.out.println("Valor da venda: R$" + venda.getValor());

                // Exibe o lucro ou prejuízo para a venda específica.
                if (lucro >= 0) {
                    System.out.println("Lucro: R$" + String.format("%.2f", lucro));
                } else {
                    System.out.println("Prejuízo: R$" + String.format("%.2f", Math.abs(lucro)));
                }

                // Atualiza o lucro total com o resultado da venda atual.
                totalLucro += lucro;

                // Separa as informações de cada venda.
                System.out.println("----------------------------------------------------------------");
                System.out.println();
            }

            // Exibe o resumo financeiro total do relatório.
            System.out.println("Resumo Financeiro:");
            if (totalLucro > 0) {
                System.out.println("Você teve um lucro total de: R$" + String.format("%.2f", totalLucro));
            } else {
                System.out.println("Você teve um prejuízo total de : R$" + String.format("%.2f", totalLucro));
            }
        }
    }
}