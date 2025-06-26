package sistema;

import dados.Consulta;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrinho {
    private final ArrayList<Consulta> consultas;
    public Carrinho() {
        this.consultas = new ArrayList<>();
    }
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        System.out.println("Consulta adicionada ao carrinho.");
    }
    public void listarConsultas() {if (consultas.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }
        System.out.println("Consultas no Carrinho:");
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println((i + 1) + ". " + consultas.get(i).toString());
        }
        System.out.printf("Total: R$%.2f%n", calcularTotal());
    }
    public ArrayList<Consulta> getConsultas() {
        return consultas; // Método para retornar a lista de consultas
    }
    public double calcularTotal() {
        double total = 0;
        for (Consulta consulta : consultas) {
            total += consulta.getPreco();
        }
        return total;
    }
    public void escolherPagamento(GerenciadorConsultas gerenciadorConsultas, Consulta consulta) {
        System.out.println("Escolha o tipo de pagamento:");
        System.out.println("1. Cartão de Débito");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Pix");
        Scanner scanner = new Scanner(System.in);
        int tipoPagamento = scanner.nextInt();
        switch (tipoPagamento) {
            case 1:
                System.out.println("Pagamento realizado com sucesso via Cartão de Débito!");
                gerenciadorConsultas.removerConsulta(consulta); // Remove a consulta do sistema
                break;
            case 2:
                System.out.println("Pagamento realizado com sucesso via Cartão de Crédito!");
                gerenciadorConsultas.removerConsulta(consulta); // Remove a consulta do sistema
                break;
            case 3:
                System.out.println("Pagamento realizado com sucesso via Pix!");
                gerenciadorConsultas.removerConsulta(consulta); // Remove a consulta do sistema
                break;
            default:
                System.out.println("Opção de pagamento inválida!");
        }
    }
}
