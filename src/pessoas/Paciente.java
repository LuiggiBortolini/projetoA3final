package pessoas;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf; // Atributo CPF
    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf; // Inicializa o CPF
    }
    public String getNome() {
        return nome; // Método getter para o nome
    }
    public int getIdade() {
        return idade;
    }
    public String getCpf() {
        return cpf; // Método para obter o CPF
    }
}
