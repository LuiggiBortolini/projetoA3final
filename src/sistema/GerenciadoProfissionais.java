package sistema;

import dados.Profissional;

import java.util.ArrayList;

class GerenciadorProfissionais {
    private final ArrayList<Profissional> profissionais;
    public GerenciadorProfissionais() {
        this.profissionais = new ArrayList<>();
    }
    public void adicionarProfissional(Profissional profissional) {
        profissionais.add(profissional);
        System.out.println("Profissional adicionado com sucesso!");
    }
    public ArrayList<Profissional> listarProfissionais() {
        return profissionais;
    }
}
