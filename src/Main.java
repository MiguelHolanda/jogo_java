
void main() {

    Pista[] pistas = {
            new Pista("Tamborelo", 72000),
            new Pista("Interlagos", 43000),
            new Pista("Monza", 58000),
            new Pista("alexandroviks", 60000),
    };

    Bot[] bots = {
            new Bot("Gol", "Bot Iniciante", 1, 60),
            new Bot("Civic", "Bot Intermediario", 2, 80),
            new Bot("GTR", "Bot Pro", 3, 100),
            new Bot("M3", "Bot Avançado", 4, 120),
            new Bot("skyline", "Bot ultra hard", 5, 200)
    };

    IO.println("");
    IO.println("________________________________________________________________________________________________________");
    IO.println("_____CADASTRO DO PLAYER_____");
    String nomePlayer = IO.readln("Nome do player: ");
    String nick = IO.readln("Nick: ");

    IO.println("");
    IO.println("_____CADASTRO DO CARRO_____");
    String modelo = IO.readln("Modelo do carro: ");
    String nomeV = IO.readln("Nome do veículo: ");
    Piloto piloto = new Piloto(nomePlayer, nick, modelo, nomeV);

    IO.println("");
    IO.println("Cadastro realizado com sucesso!");
    IO.println("Bem-vindo, " + piloto.getNick() + "!");


    int opcao;
    do {
        IO.println("");
        IO.println("//////////////////////////////////////////////////////////////////////////////////////");
        IO.println("");
        IO.println("                               ----FORZA HORIZON----");
        IO.println("1 - CORRER");
        IO.println("2 - TRABALHAR");
        IO.println("3 - TUNAR");
        IO.println("4 - EXIBIR STATUS");
        IO.println("0 - ENCERRAR SESSÃO");
        IO.println("______________________________");
        IO.println("");
        opcao = Integer.parseInt(IO.readln("Escolha uma ação: "));
        IO.println("");
        IO.println("//////////////////////////////////////////////////////////////////////////////////////");
        IO.println("");
        IO.println("//////////////////////////////////////////////////////////////////////////////////////");
        switch (opcao) {

            case 1:

                piloto.correr(pistas, bots);

                break;

            case 2:
                piloto.trabalhar();
                break;

            case 3:
               piloto.tunar();
                break;

            case 4:

                piloto.exibir();

                break;

            case 0:
                IO.println("");
                IO.println("Encerrando a sessão...");
                break;

            default:
                IO.println("");
                IO.println("Opção inválida!");
                break;
        }
        IO.println("");
        IO.println("//////////////////////////////////////////////////////////////////////////////////////");
        IO.println("");
    } while (opcao != 0);

    IO.println("Até a próxima, " + piloto.getNick() + "!");
    IO.println("________________________________________________________________________________________________________");
}
