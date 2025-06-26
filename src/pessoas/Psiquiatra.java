package pessoas;

import dados.Profissional;

public class Psiquiatra extends Profissional {
    public Psiquiatra(String nome, String registro) {
        super(nome, "Psiquiatria", Integer.parseInt(registro));
    }
    @Override
    public void atenderPaciente(Paciente paciente) {
        System.out.println("Psiquiatra " + nome + " está atendendo o(a) paciente " + paciente.getNome());
    }
}
