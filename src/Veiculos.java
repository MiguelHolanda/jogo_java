import java.util.Random;

public abstract class Veiculos implements Corrivel {

    private static final Random RANDOM = new Random();

    private String modelo;
    private String nome;
    private int velocidade = 60;

    public Veiculos(String modelo, String nome) {
        this.modelo = modelo;
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    protected void setVelocidade(int velocidade) {
        if (velocidade > 0) {
            this.velocidade = velocidade;
        }
    }

    public void tunar() {
        velocidade += 8;
    }

    // Retorna o tempo em minutos (tamanho em metros, velocidade em km/h)
    @Override
    public double correr(Pista pista) {
        double tempo = (pista.getTamanho() / (velocidade / 3.6)) / 60.0;
        return tempo * (0.95 + RANDOM.nextDouble() * 0.10);
    }

    public void exibir() {
        IO.println("MODELO: " + modelo);
        IO.println("NOME: " + nome);
        IO.println("VELOCIDADE: " + velocidade + " km/h");
    }
}