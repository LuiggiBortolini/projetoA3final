package sistema;

import pessoas.Paciente;

import java.util.ArrayList;

public class GerenciadorPacientes {
    private final ArrayList<Paciente> pacientes;
    public GerenciadorPacientes() {
        this.pacientes = new ArrayList<>();
    }
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente adicionado com sucesso!");
    }
    public ArrayList<Paciente> listarPacientes() {
        return pacientes;
    }
}
