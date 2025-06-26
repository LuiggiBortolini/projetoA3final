package pessoas;

import dados.Profissional;

public class Psicologo extends Profissional {
    public Psicologo(String nome, String registro) {
        super(nome, "Psicologia", Integer.parseInt(registro));
    }
    @Override
    public void atenderPaciente(Paciente paciente) {
        System.out.println("Psicólogo " + nome + " está atendendo o(a) paciente " + paciente.getNome());
    }
}

