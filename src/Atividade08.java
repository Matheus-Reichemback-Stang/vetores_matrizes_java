import java.util.Random;
import java.util.Scanner;

public class Atividade08 {
    public static void main(String[] args) {
        // Definindo variáveis a serem usadas
        Scanner scanner = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];
        Random random = new Random();
        String simboloX = "| X |";
        String simboloCirulo = "| ○ |";
        String simboloVazio = "| - |";

        // Inserindo os dados iniciais no tabuleiro
        System.out.println("#######################################");
        System.out.println("BEM-VINDO AO JOGO DA VELHA");
        System.out.println("#######################################");
        for(int i = 0; i < tabuleiro.length; i++) {
            for(int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = simboloVazio;
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println(" ");
        }


        // Variáveis úteis para controlar o jogo
        int quantidadeDePartidas = 0;
        int linha = 0;
        int coluna = 0;
        while(quantidadeDePartidas < 9) {
            // Recolhendo a posição da LINHA e COlUNA que o usuário deseja.
            System.out.println("#######################################");
            System.out.println("Digite a posição da LINHA:");
            System.out.println("#######################################");
            linha = scanner.nextInt() - 1;
            System.out.println("#######################################");
            System.out.println("Digite a posição da COLUNA:");
            System.out.println("#######################################");
            coluna = scanner.nextInt() - 1;

            // Fazendo validação do tabuleiro
            if(tabuleiro[linha][coluna].equals(simboloVazio)) {
                tabuleiro[linha][coluna] = simboloX;
                // Método que imprime o tabuleiro atualizado
                imprimeTabuleiro(tabuleiro);
                quantidadeDePartidas++;
                // Verifica se há uma vitória com esta última jogada
                if (validaTabuleiro(tabuleiro, simboloX)) {
                    quantidadeDePartidas = 1000;
                    System.out.println("#######################################");
                    System.out.println("O JOGADOR 'X' VENCEU O JOGO");
                    System.out.println("#######################################");
                }
                // Evita que tenha que aguardar a jogada do bot, pois o jogador x é sempre quem termina o jogo
                if(quantidadeDePartidas < 9) {
                    System.out.println("#######################################");
                    System.out.println("AGUARDANDO A JOGADA DO OUTRO JOGADOR...");
                    System.out.println("#######################################");
                    // Para o código por 3 segundos para dar a impressão de ser outro jogador
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // Executa após 3 segundos
                    boolean posicaoValida = false;
                    while(!posicaoValida) {
                        int linhaSortida = random.nextInt(3);
                        int colunaSortida = random.nextInt(3);
                        // Valida se a posição é válida
                        if(tabuleiro[linhaSortida][colunaSortida].equals(simboloVazio)) {
                            tabuleiro[linhaSortida][colunaSortida] = simboloCirulo;
                            // Método que imprime o tabuleiro atualizado
                            imprimeTabuleiro(tabuleiro);
                            quantidadeDePartidas++;
                            // Verifica se há uma vitória com esta última jogada
                            if (validaTabuleiro(tabuleiro, simboloCirulo)) {
                                quantidadeDePartidas = 1000;
                                System.out.println("#######################################");
                                System.out.println("O JOGADOR '○' VENCEU O JOGO");
                                System.out.println("#######################################");
                            }
                            posicaoValida = true;
                        }
                    }
                }
            } else {
                System.out.println("#######################################");
                System.out.println("ESTA POSIÇÃO JÁ FOI PREENCHIDA! POR FAVOR \nDIGITE AS POSIÇÕES NOVAMENTE.");
                System.out.println("#######################################");
                // Método que imprime o tabuleiro atualizado
                imprimeTabuleiro(tabuleiro);
            }

        }

        // Resultado em caso de EMPATE
        if(quantidadeDePartidas == 9) {
            System.out.println("#######################################");
            System.out.println("HOUVE UM EMPATE!");
            System.out.println("#######################################");
        }

        scanner.close();
    }

    public static boolean validaTabuleiro(String[][] tabuleiro, String simbolo) {
        for(int i = 0; i < 3; i++) {
            // Valida Linhas | Valida Colunas | Valida Diagonal Principal | Valida Diagonal Secundária
            if(tabuleiro[i][0].equals(simbolo) && tabuleiro[i][1].equals(simbolo) && tabuleiro[i][2].equals(simbolo)) {
                return true;
            } else if (tabuleiro[0][i].equals(simbolo) && tabuleiro[1][i].equals(simbolo) && tabuleiro[2][i].equals(simbolo)){
                return true;
            } else if(tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)){
                return true;
            } else if(tabuleiro[0][2].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)){
                return true;
            }
        }
        return false;
    }

    public static void imprimeTabuleiro(String[][] tabuleiro) {
        for(int i = 0; i < tabuleiro.length; i++) {
            for(int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println(" ");
        }
    }
}
