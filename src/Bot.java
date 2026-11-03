
public class Bot extends Veiculos implements Corrivel {

    private int nivel;

    public Bot(String modelo, String nome, int nivel, int velocidade) {
        super(modelo, nome);
        this.nivel = nivel;
        setVelocidade(velocidade);
    }

    public int getNivel() {
        return nivel;
    }


    @Override
    public void exibir() {
        super.exibir();
        IO.println("NIVEL: " + nivel);
    }
}
