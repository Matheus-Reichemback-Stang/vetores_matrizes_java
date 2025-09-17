import java.util.Random;

public class Atividade04 {
    public static void main(String[] args) {
        // Definindo as variáveis a serem usadas.
        Random random = new Random();
        int[][] matriz = new int[4][4];

        // Inserindo números aleatórios na matriz 4x4
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100) + 1;
            }
        }

        // Imprimindo a matriz 4x4 na tela para o usuário visualizar
        System.out.println("#######################################");
        System.out.println("EXIBINDO NÚMEROS DA MATRIZ 4X4");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
        // Imprimindo apenas a diagonal principal da matriz 4x4
        System.out.println("#######################################");
        System.out.println("EXIBINDO APENAS NÚMEROS DA DIAGONAL \nPRINCIPAL");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                if(i == j){
                    System.out.print("- " + matriz[i][j] + " -");
                }
            }
        }
    }
}
