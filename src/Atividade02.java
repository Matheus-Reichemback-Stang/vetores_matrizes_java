import java.util.Random;

public class Atividade02 {

    public static void main(String[] args) {
        // Definindo variáveis que vão ser usadas
        Random random = new Random();
        int[] numeros = new int[15];

        // Atribuindo números aleatórios no array "numeros"
        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }

        // Definindo o tipo (par/ímpar) de cada número do array "numeros" e imprimindo na tela
        for(int i = 0; i < numeros.length; i++) {
            int valor = numeros[i] % 2;
            if(valor == 0) {
                System.out.println("O " + (i + 1) + "° número: " + numeros[i] + " é PAR");
            } else {
                System.out.println("O " + (i + 1) + "° número: " + numeros[i] + " é ÍMPAR");
            }
        }
    }

}
