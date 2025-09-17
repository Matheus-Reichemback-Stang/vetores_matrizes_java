import java.util.Scanner;

public class Atividade03 {

    public static void main(String[] args) {
        // Definindo variáveis a serem usadas.
        Scanner scanner = new  Scanner(System.in);
        int[][] matriz = new int[3][3];


        // Recolhendo os números definindos pelo usuário e preenchendo eles na matriz
        System.out.println("#######################################");
        System.out.println("PREENCHIMENTO DE MATRIZ 3X3");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.println("Digite o valor a ser colocado na posição:");
                System.out.println("LINHA: " + (i + 1) + " | COLUNA: " + (j + 1));
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Imprimindo o resultado da matriz conforme os dados inseridos pelo usuário
        System.out.println("#######################################");
        System.out.println("CONFORME OS DADOS INSERIDOS, SE TEM A\nSEGUINTE MATRIZ 3X3:");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
