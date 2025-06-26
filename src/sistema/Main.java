package sistema;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import dados.*;
import pessoas.*;

public class Main {
    private static final GerenciadorPacientes gerenciadorPacientes = new GerenciadorPacientes();
    private static final GerenciadorConsultas gerenciadorConsultas = new GerenciadorConsultas();
    private static final GerenciadorProfissionais gerenciadorProfissionais = new GerenciadorProfissionais();
    private static final Carrinho carrinho = new Carrinho(); // Instância do carrinho
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Profissional");
            System.out.println("3. Iniciar Consulta");
            System.out.println("4. Listar Consultas");
            System.out.println("5. Editar Consulta");
            System.out.println("6. Deletar Consulta");
            System.out.println("7. Finalizar Consulta e Escolher Pagamento");
            System.out.println("8. Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    adicionarProfissional();
                    break;
                case 3:
                    iniciarConsulta();
                    break;
                case 4:
                    gerenciadorConsultas.listarConsultas();
                    break;
                case 5:
                    editarConsulta();
                    break;
                case 6:
                    deletarConsulta();
                    break;
                case 7:
                    finalizarConsulta();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);
    }
    private static void adicionarPaciente() {
        System.out.print("Nome do Paciente: ");
        String nome = scanner.next();
        int idade = 0;
        boolean idadeValida = false;
        // Validação da entrada da idade
        while (!idadeValida) {
            System.out.print("Idade do Paciente: ");
            try {
                idade = scanner.nextInt();
                if (idade < 0) {
                    System.out.println("A idade não pode ser negativa. Tente novamente.");
                } else {
                    idadeValida = true; // Idade válida
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido para a idade.");
                scanner.next(); // Limpa o buffer
            }
        }
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.next(); // Solicita o CPF
        gerenciadorPacientes.adicionarPaciente(new Paciente(nome, idade, cpf)); // Adiciona o CPF ao paciente
    }
    private static void adicionarProfissional() {
        System.out.print("Nome do Profissional: ");
        String nome = scanner.next();
        System.out.print("Número de Registro: ");
        String registro = scanner.next(); // Novo atributo para registro
        System.out.println("Selecione a especialidade:");
        System.out.println("1. Psicólogo");
        System.out.println("2. Psiquiatra");
        int tipoSelecionado = scanner.nextInt();
        Profissional profissional;
        if (tipoSelecionado == 1) {
            profissional = new Psicologo(nome, registro);
        } else {
            profissional = new Psiquiatra(nome, registro);
        }
        gerenciadorProfissionais.adicionarProfissional(profissional);
    }
    private static void iniciarConsulta() {
        // Selecionar paciente
        ArrayList<Paciente> pacientes = gerenciadorPacientes.listarPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        System.out.println("Selecione um Paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }
        int pacienteIndex = scanner.nextInt() - 1;
        Paciente pacienteSelecionado = pacientes.get(pacienteIndex);
        // Selecionar tipo de profissional
        ArrayList<Profissional> profissionais = gerenciadorProfissionais.listarProfissionais();
        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }
        System.out.println("Selecione o tipo de profissional:");
        for (int i = 0; i < profissionais.size(); i++) {
            System.out.println((i + 1) + ". " + profissionais.get(i).getNome());
        }
        int profissionalIndex = scanner.nextInt() - 1;
        Profissional profissionalSelecionado = profissionais.get(profissionalIndex);
        double preco = profissionalSelecionado instanceof Psicologo ? 120.0 : 150.0; // Define o preço com base na escolha
        // Solicitar a data da consulta
        System.out.print("Data da Consulta: ");
        String data = scanner.next(); // Novo atributo para data da consulta
        // Criar a consulta
        Consulta consulta = new Consulta(pacienteSelecionado, profissionalSelecionado, preco, data);
        consulta.realizarConsulta(); // Realiza a consulta
        gerenciadorConsultas.adicionarConsulta(consulta); // Adiciona ao carrinho
        carrinho.adicionarConsulta(consulta); // Adiciona a consulta ao carrinho
    }
    private static void editarConsulta() {
        gerenciadorConsultas.listarConsultas();
        System.out.print("Selecione o número da consulta que deseja editar: ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index >= gerenciadorConsultas.getConsultas().size()) {
            System.out.println("Índice inválido!");
            return;
        }
        // Obter novos dados para a consulta
        System.out.println("Selecione o tipo de profissional:");
        ArrayList<Profissional> profissionais = gerenciadorProfissionais.listarProfissionais();
        for (int i = 0; i < profissionais.size(); i++) {
            System.out.println((i + 1) + ". " + profissionais.get(i).getNome());
        }
        int profissionalIndex = scanner.nextInt() - 1;
        // Criar nova consulta com os dados atualizados
        Profissional profissional = profissionais.get(profissionalIndex);
        System.out.print("Data da Consulta: ");
        String data = scanner.next(); // Novo atributo para data da consulta
        Consulta novaConsulta = new Consulta(gerenciadorConsultas.getConsultas().get(index).getPaciente(), profissional, profissional instanceof Psicologo ? 120.0 : 150.0, data);
        gerenciadorConsultas.editarConsulta(index, novaConsulta);
    }
    private static void deletarConsulta() {
        gerenciadorConsultas.listarConsultas();
        System.out.print("Selecione o número da consulta que deseja deletar: ");
        int index = scanner.nextInt() - 1;

        gerenciadorConsultas.removerConsulta(index);
    }
    private static void finalizarConsulta() {
        carrinho.listarConsultas();
        if (!carrinho.getConsultas().isEmpty()) {
            Consulta consulta = carrinho.getConsultas().getFirst(); // Pega a primeira consulta do carrinho
            carrinho.escolherPagamento(gerenciadorConsultas, consulta);
        } else {
            System.out.println("O carrinho está vazio. Não há consultas para finalizar.");
        }
    }
}