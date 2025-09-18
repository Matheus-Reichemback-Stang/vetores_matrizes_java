import java.util.Random;

public class Atividade07 {
    public static void main(String[] args) {
        // Definindo as variáveis a serem usadas
        Random random = new Random();
        int[][] matriz = new int[3][2];
        int[][] matrizTransposta = new int[2][3];

        // Inserindo dados (números inteiros) na matriz e exibindo ela na tela
        System.out.println("#######################################");
        System.out.println("EXIBINDO DA MATRIZ 3X2");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = random.nextInt(100) + 1;
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println(" ");
        }

        // Preencho os dados da matriz 3x2 na matriz transposta 2x3
        System.out.println("#######################################");
        System.out.println("EXIBINDO VERSÃO TRANSPOSTA DA \nMATRIZ ANTERIOR");
        System.out.println("#######################################");
        for(int i = 0; i < matrizTransposta.length; i++){
            for(int j = 0; j < matrizTransposta[i].length; j++){
                matrizTransposta[i][j] = matriz[j][i];
                System.out.print("| " + matrizTransposta[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
