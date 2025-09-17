import java.util.Scanner;

public class Atividade01 {

    public static void main(String[] args) {
        // Definindo variáveis a serem usadas para armazenar valores e ler valores
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];


        // Recolhendo os números definindos pelo usuário
        System.out.println("#######################################");
        System.out.println("INFORME 10 NÚMEROS INTEIROS:");
        System.out.println("#######################################");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Qual vai ser o " + (i + 1) + "° número?");
            numeros[i] = scanner.nextInt();
        }

        // Variáveis que armazenam o maior e o menor valor
        int maior = numeros[0];
        int menor = numeros[0];
        // Verificando e atribuindo o maior e o menor valor digitado pelo usuário
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] > maior){
                maior = numeros[i];
            }
            if(numeros[i] < menor){
                menor = numeros[i];
            }
        }

        // Imprimindo na tela o resultado
        System.out.println("#######################################");
        System.out.println("O maior valor digitado é: " + maior);
        System.out.println("O menor valor digitado é: " + menor);

        scanner.close();
    }
}
