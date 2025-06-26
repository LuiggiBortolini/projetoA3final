package sistema;

import dados.Consulta;
import java.util.ArrayList;

public class GerenciadorConsultas {
    private final ArrayList<Consulta> consultas;
    public GerenciadorConsultas() {
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
            System.out.println((i + 1) + ". " + consultas.get(i).toString());}
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
    public void editarConsulta(int index, Consulta novaConsulta) {
        if (index >= 0 && index < consultas.size()) {
            consultas.set(index, novaConsulta);
            System.out.println("Consulta editada com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
    public void removerConsulta(int index) {
        if (index >= 0 && index < consultas.size()) {
            consultas.remove(index);
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }
}
