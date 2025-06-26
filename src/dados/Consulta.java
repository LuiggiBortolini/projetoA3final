package dados;

import pessoas.*;

public class Consulta {
    private Paciente paciente;
    private Profissional profissional;
    private double preco;
    private String data; // atributo para data da consulta
    public Consulta(Paciente paciente, Profissional profissional, double preco, String data) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.preco = preco;
        this.data = data; // inicializa a data da consulta
    }
    public void realizarConsulta() {
        Paciente Paciente = this.paciente;
        profissional.atenderPaciente(Paciente);
    }
    public double getPreco() {
        return preco;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Profissional getProfissional() {
        return profissional;
    }
    @Override
    public String toString() {
        return "Paciente: " + paciente.getNome() + ", Profissional: " + profissional.getNome() + ", Preço: R$" + String.format("%.2f", preco) + ", Data: " + data;
    }
}
