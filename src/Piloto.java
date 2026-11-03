
public class Piloto {

    private String nomePlayer;
    private String nick;
    private double saldo = 50;
    private final Carro veiculo;

    public Piloto(String nomePlayer, String nick, String modelo, String nomeV) {
        this.nomePlayer = nomePlayer;
        this.nick = nick;
        this.veiculo = new Carro(modelo, nomeV);
    }

    public String getNomePlayer() {
        return nomePlayer;
    }

    public String getNick() {
        return nick;
    }

    public double getSaldo() {
        return saldo;
    }

    public Carro getVeiculo() {
        return veiculo;
    }


    private void pausa(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void animarAcao(String mensagem) {
        IO.println("\n" + mensagem);

        pausa(1000);
    }

    int limite = 0;

    public void trabalhar() {
        if(limite>4){

            IO.println("---__JÁ ESTA NA HORA DE VOLTAR A CORRER!!__---");

        }else {

            animarAcao("Trabalhando...");
            limite +=1;
            saldo += 25;

            IO.println("");
            IO.println("Você trabalhou e ganhou 25 de saldo!");
            IO.println("Saldo atual: " + saldo);
            pausa(2000);

        }
    }

    int limitet = 0;
    public void tunar() {

        if(limitet>=4){
            IO.println("---__JÁ ESTA NA HORA DE VOLTAR A CORRER!!__---");
        }else {

                animarAcao("Tunando...");
            IO.println("");
            if (saldo >= 25) {
                saldo -= 25;
                veiculo.tunar();

                IO.println("Carro tunado!");
                IO.println("Velocidade atual: " + veiculo.getVelocidade() + " km/h");
                IO.println("Saldo atual: " + saldo);
                pausa(2000);

            } else {
                IO.println("Saldo insuficiente para tunar.");
            }
        }
    }

    public void exibir() {
        animarAcao("Carregando dados do piloto e do veículo...");
        IO.println("");
        IO.println("_____DADOS DO PILOTO_____");
        IO.println("NOME: " + nomePlayer);
        IO.println("NICK: " + nick);
        IO.println("SALDO: " + saldo);

        IO.println("");
        IO.println("_____DADOS DO CARRO_____");
        veiculo.exibir();
        pausa(2000);

    }

    public void correr(Pista[] pistas, Bot[] bots) {

        if(limite>0){
        limite-=2;}

        if(limitet>0) {
            limitet -= 2;
        }

        IO.println("");
        IO.println("--- ESCOLHA A PISTA ---");

        for (int i = 0; i < pistas.length; i++) {
            IO.println((i + 1) + " - " + pistas[i].getNomePista() + " (" + pistas[i].getTamanho() + "m)");
        }

        int escolhaPista = Integer.parseInt(IO.readln("Digite a pista desejada: ")
        );

        if (escolhaPista < 1 || escolhaPista > pistas.length) {
            IO.println("Pista inválida!");
            return;
        }

        Pista pista = pistas[escolhaPista - 1];

        IO.println("");
        IO.println("--- ESCOLHA O NIVEL DO BOT ---");

        for (Bot bot : bots) {
            IO.println(bot.getNivel() + " - " + bot.getNome() + " (" + bot.getVelocidade() + " km/h)");
        }

        int nivelEscolhido = Integer.parseInt(IO.readln("Digite o nível do bot: ")
        );

        Bot adversario = null;

        for (Bot bot : bots) {
            if (bot.getNivel() == nivelEscolhido) {
                adversario = bot;
                break;
            }
        }

        if (adversario == null) {
            IO.println("Nível de bot inválido!");
            return;
        }
        IO.println("_____________________________________________________________________________");
        IO.println("");
        IO.println("--- CORRIDA INICIADA ---");
        IO.println("Pista: " + pista.getNomePista());
        IO.println("Player: " + nick);
        IO.println("Adversário: " + adversario.getNome());
        IO.println("__________");
        animarAcao("Correndo...");

        double tempoPlayer = veiculo.correr(pista);
        double tempoBot = adversario.correr(pista);

        IO.println("Tempo do player: " + String.format("%.2f", tempoPlayer) + " minutos");

        IO.println("Tempo do bot: " + String.format("%.2f", tempoBot) + " minutos");
        IO.println("___________");

        if (tempoPlayer < tempoBot) {
            IO.println("PARABÉNS! O PLAYER " + nick + " VENCEU!");
            saldo += 20;
            IO.println("Você ganhou 20 de saldo!");
        } else if (tempoBot < tempoPlayer) {
            IO.println("O BOT VENCEU!");
            saldo-=10;
            IO.println("Você perdeu 10 de saldo!");
        } else {
            IO.println("A corrida terminou empatada!");
            saldo+=5;
        }
        pausa(2000);

        IO.println("Saldo atual: " + saldo);
    }
}
