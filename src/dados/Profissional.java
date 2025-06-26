package dados;

import pessoas.Paciente;

abstract public class Profissional implements IAtendimento {
    protected String nome;
    protected String especialidade;
    protected int registro; // atributo para número de registro
    public Profissional(String nome, String especialidade, int registro) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro; // inicia o número de registro
    }
    public String getNome() {
        return nome; // metodo getter pra buscar o nome
    }

    public abstract void atenderPaciente(Paciente paciente);
}
