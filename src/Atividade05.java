import java.util.Scanner;

public class Atividade05 {
    public static void main(String[] args) {
        // Definindo variáveis a serem usadas.
        Scanner scanner = new  Scanner(System.in);
        int[][] matriz = new int[3][3];
        int valorTotal = 0;

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

        // Imprimindo a matriz 3x3 na tela para o usuário visualizar
        System.out.println("#######################################");
        System.out.println("EXIBINDO NÚMEROS DA MATRIZ 3X3");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }

        // Imprimindo o valor da soma de cada linha e definindo o valor total da matriz
        System.out.println("#######################################");
        System.out.println("A SOMA DE CADA LINHA É:");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            int valorSomado = 0;
            for(int j = 0; j < matriz[i].length; j++) {
                valorSomado += matriz[i][j];
            }
            System.out.println("LINHA "+ (i + 1) +": " + valorSomado);
            valorTotal += valorSomado;
        }

        // Imprimindo o valor da soma de cada coluna
        System.out.println("#######################################");
        System.out.println("A SOMA DE CADA COLUNA É:");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            int valorSomado = 0;
            for(int j = 0; j < matriz[i].length; j++) {
                valorSomado += matriz[j][i];
            }
            System.out.println("COLUNA "+ (i + 1) +": " + valorSomado);
        }

        // Exibindo o valor total da matriz
        System.out.println("#######################################");
        System.out.println("SOMANDO TODOS OS VALORES DA MATRIZ \nSE TEM O SEGUINTE RESULTADO:");
        System.out.println("#######################################");
        System.out.println("TOTAL: " + valorTotal);


        scanner.close();
    }
}
