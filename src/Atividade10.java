import java.util.Random;
import java.util.Scanner;

public class Atividade10 {
    public static void main(String[] args) {
        // Definição de variáveis que vão ser usadas
        int linhas = 7;
        int colunas = 7;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[][] oceanoDoUsuario = new String[linhas][colunas];
        String[][] oceanoDoSistema = new String[linhas][colunas]; // Não aparece no sistema
        String simboloDoOceano = " ꕀ ";
        String simboloAoErrar = " ⌀ ";
        String simboloDoNavioAtingido = " ⅹ ";
        String emojiTubarao = " 🦈 ";
        String emojiLula = " 🦑 ";
        String emojiCamarao = " 🦐 ";
        String emojiBaleia = " 🐋 ";

        // Aprensentação incial do jogo
        System.out.println("###############################################");
        System.out.println("BATALHA NAVAL SIMPLIFICADO!");
        System.out.println("###############################################");
        System.out.println("Neste jogo, o usuário deve informar a linha e \ncoluna na qual deseja atacar para descobrir se \na posição atingida acertou ou não um navio. \nExistem apenas três navios no mapa e o jogo só \ntermina ao acertar todos eles ou se suas \njogadas acabarem.");
        System.out.println("###############################################");
        System.out.println("SÍMBOLOS DO JOGO:");
        System.out.println("Mar não explorado: " + simboloDoOceano);
        System.out.println("Mar atingido mas sem navio: " + simboloAoErrar);
        System.out.println("Mar atingido e acertado em navio: " + simboloDoNavioAtingido);
        System.out.println("###############################################");
        // Método que cria o mapa do usuário e o mapa do sistema
        criandoMapas(oceanoDoUsuario, oceanoDoSistema, simboloDoOceano);


        // Adicionando barcos e animais no mapa do sistema
        adicionarItensNoMapa(linhas, colunas, random, oceanoDoSistema, simboloDoOceano, simboloDoNavioAtingido,
                emojiTubarao, emojiLula, emojiCamarao, emojiBaleia);


        // Loop para se manter no jogo até terminar
        int quantidadeDeJogadas = linhas * colunas;
        int barcosAtingidos = 0;
        while (quantidadeDeJogadas >= 1 && barcosAtingidos < 3) {
            imprimirMapa(oceanoDoUsuario);
            System.out.println("###############################################");
            System.out.println("QUANTIDADE DE JOGADAS RESTANTES: " + quantidadeDeJogadas);
            System.out.println("###############################################");

            // Recolhendo a posição da LINHA e COlUNA que o usuário deseja.
            System.out.println("###############################################");
            System.out.println("Digite a posição da LINHA:");
            System.out.println("###############################################");
            int linhaEscolhida = scanner.nextInt() - 1;
            System.out.println("###############################################");
            System.out.println("Digite a posição da COLUNA:");
            System.out.println("###############################################");
            int colunaEscolhida = scanner.nextInt() - 1;

            // Validação de posição escolhida pelo usuário
            if(oceanoDoUsuario[linhaEscolhida][colunaEscolhida].equals(simboloDoOceano)) {
                if(oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(simboloDoOceano)) {
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = simboloAoErrar;
                    quantidadeDeJogadas--;
                    System.out.println("###############################################");
                    System.out.println("NÃO HÁ NENHUM NAVIO NESTA POSIÇÃO!");
                    System.out.println("###############################################");
                } else if (oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(simboloDoNavioAtingido)) {
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = simboloDoNavioAtingido;
                    quantidadeDeJogadas--;
                    barcosAtingidos++;
                    System.out.println("###############################################");
                    System.out.println("UM NAVIO FOI ATINGIDO!");
                    System.out.println("###############################################");
                } else if(oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(emojiTubarao)) {
                    System.out.println("###############################################");
                    System.out.println("VOCÊ MATOU UM TUBARÃO! (-5 JOGADAS)");
                    System.out.println("###############################################");
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = emojiTubarao;
                    quantidadeDeJogadas -= 5;
                } else if(oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(emojiBaleia)) {
                    System.out.println("###############################################");
                    System.out.println("VOCÊ MATOU UMA BALEIA! (-10 JOGADAS)");
                    System.out.println("###############################################");
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = emojiBaleia;
                    quantidadeDeJogadas -= 10;
                } else if(oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(emojiCamarao)) {
                    System.out.println("###############################################");
                    System.out.println("VOCÊ MATOU 3 MIL CAMARÕES! (-3 JOGADAS)");
                    System.out.println("###############################################");
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = emojiCamarao;
                    quantidadeDeJogadas -= 3;
                } else if(oceanoDoSistema[linhaEscolhida][colunaEscolhida].equals(emojiLula)) {
                    System.out.println("###############################################");
                    System.out.println("VOCÊ MATOU UMA LULA! (-13 JOGADAS + AZAR)");
                    System.out.println("###############################################");
                    oceanoDoUsuario[linhaEscolhida][colunaEscolhida] = emojiLula;
                    quantidadeDeJogadas -= 13;
                }
            } else {
                System.out.println("###############################################");
                System.out.println("ESTE LOCAL JÁ FOI ATINGIDO! POR FAVOR, JOGUE \nEM OUTRA POSIÇÃO.");
                System.out.println("###############################################");
            }

            // Para o código por 3 segundos para o usuário ler as informações
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if(barcosAtingidos == 3) {
            System.out.println("###############################################");
            System.out.println("PARABÉNS, VOCÊ GANHOU O JOGO!");
            System.out.println("###############################################");
        } else {
            System.out.println("###############################################");
            System.out.println("SUAS JOGADAS ACABARAM! VOCÊ PERDEU O JOGO!");
            System.out.println("###############################################");
        }
    }

    public static void criandoMapas(String[][] oceanoDoUsuario, String[][] oceanoDoSistema, String simboloDoOceano) {
        for(int i = 0; i < oceanoDoUsuario.length; i++) {
            for(int j = 0; j < oceanoDoUsuario[i].length; j++) {
                oceanoDoUsuario[i][j] = simboloDoOceano;
                oceanoDoSistema[i][j] = simboloDoOceano;
            }
        }
    }

    public static void adicionarItensNoMapa(int linhas, int colunas, Random random, String[][] oceanoDoSistema,
    String simboloDoOceano, String simboloDoNavioAtingido, String emojiTubarao, String emojiLula, String emojiCamarao, String emojiBaleia) {
        int barcosNoMapa = 0;
        while (barcosNoMapa < 3) {
            int linhaSortidaDoBarco = random.nextInt(linhas);
            int colunaSortidaDoBarco = random.nextInt(colunas);

            if(oceanoDoSistema[linhaSortidaDoBarco][colunaSortidaDoBarco].equals(simboloDoOceano)) {
                oceanoDoSistema[linhaSortidaDoBarco][colunaSortidaDoBarco] = simboloDoNavioAtingido;
                barcosNoMapa++;

                if(barcosNoMapa == 3) {

                    int animaisNoMapa = 0;
                    while (animaisNoMapa < 4) {
                        int linhaSortidaDoAnimal = random.nextInt(linhas);
                        int colunaSortidaDoAnimal = random.nextInt(colunas);

                        if(oceanoDoSistema[linhaSortidaDoAnimal][colunaSortidaDoAnimal].equals(simboloDoOceano)) {
                            switch (animaisNoMapa) {
                                case 0:
                                    oceanoDoSistema[linhaSortidaDoAnimal][colunaSortidaDoAnimal] = emojiTubarao;
                                    break;
                                case 1:
                                    oceanoDoSistema[linhaSortidaDoAnimal][colunaSortidaDoAnimal] = emojiLula;
                                    break;
                                case 2:
                                    oceanoDoSistema[linhaSortidaDoAnimal][colunaSortidaDoAnimal] = emojiCamarao;
                                    break;
                                case 3:
                                    oceanoDoSistema[linhaSortidaDoAnimal][colunaSortidaDoAnimal] = emojiBaleia;
                                    break;
                            }
                            animaisNoMapa++;
                        }
                    }
                }
            }
        }
    }

    public static void imprimirMapa(String[][] oceanoDoUsuario) {
        for(int i = 0; i < oceanoDoUsuario.length; i++) {
            for(int j = 0; j < oceanoDoUsuario[i].length; j++) {
                System.out.print(oceanoDoUsuario[i][j]);
            }
            System.out.println(" ");
        }
    }

}
