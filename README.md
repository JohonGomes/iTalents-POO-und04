# Projeto: Sistema de Gestão de Concessionária

## Descrição

Este é um sistema de gestão de uma concessionária desenvolvido em Java. O objetivo é permitir a administração de clientes, veículos, e vendas, com funcionalidades como cadastro, venda e geração de relatórios financeiros detalhados. O projeto também implementa tratamento de erros através de exceções personalizadas, promovendo um sistema mais robusto e confiável.

## Funcionalidades Atuais

- Cadastro de clientes com informações completas (nome, idade, endereço, telefone, e-mail, altura e peso).
- Cadastro e venda de veículos (carros, motos, vans).
- Geração de relatórios detalhados de vendas, incluindo cálculo de lucro ou prejuízo por venda e resumo financeiro total.
- Tratamento de exceções comuns, como entradas inválidas e inconsistências de dados.

## Melhorias Planejadas

1. **Implementar mais um veículo na concessionária:**
   - Adicionar uma nova categoria de veículos (ex.: caminhões).

2. **Ajustar menu para exibir clientes cadastrados:**
   - Modificar a interface do menu para apresentar uma lista de clientes registrados.

3. **Refatorar o método de mostrar veículos:**
   - Unificar a lógica de exibição de veículos para todas as categorias (carros, motos, vans) em um único método genérico.

4. **Criar método de sugestão de veículo por biotipo do cliente:**
   - Desenvolver uma lógica que recomenda veículos com base nos dados do cliente, como altura, peso, e idade.

5. **Refatorar relatório para apresentar perda ou lucro por venda:**
   - Ajustar o relatório financeiro para destacar claramente o lucro ou prejuízo em cada venda.

6. **Gerar pelo menos duas exceções personalizadas:**
   - Criar exceções específicas para situações como "Cliente não encontrado" e "Veículo indisponível".

7. **Vasculhar o código em busca de possíveis bugs:**
   - Realizar revisão completa do código para identificar e corrigir problemas de execução ou lógica.

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/nome-do-repositorio.git
   ```
2. Compile o código-fonte utilizando um IDE ou terminal com o comando:
   ```bash
   javac NomeDoArquivo.java
   ```
3. Execute o programa:
   ```bash
   java NomeDoArquivo
   ```

## Requisitos

- **Java 8** ou superior.
- IDE Java (recomendado: IntelliJ IDEA, Eclipse, ou VS Code com extensão Java).
- Biblioteca padrão do Java (nenhuma dependência externa).

## Estrutura do Código

- `cadastrarCliente`: Método responsável por registrar um novo cliente no sistema.
- `venderVeiculo`: Gerencia a venda de veículos, incluindo validação de dados.
- `gerarRelatorio`: Gera um relatório financeiro detalhado das vendas realizadas.
- Métodos auxiliares: Funções para exibir dados de clientes e veículos, além de tratamento de exceções personalizadas.



