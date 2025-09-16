import java.util.Scanner;

public class Atividade01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];


        System.out.println("Informe 10 números inteiros");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Qual vai ser o " + (i + 1) + "° número?");
            numeros[i] = scanner.nextInt();
        }

        int maior = 0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] > maior){
                maior = numeros[i];
            }
        }

        int menor = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] < menor){
                menor = numeros[i];
            }
        }
        System.out.println("O maior valor digitado é: " + maior);
        System.out.println("O menor valor digitado é: " + menor);


    }
}
