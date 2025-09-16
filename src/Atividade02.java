import java.util.Random;

public class Atividade02 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numeros = new int[15];

        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt((100 - 1) + 1) + 1;
        }

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
