import java.text.DecimalFormat;
import java.util.Random;

public class Atividade09 {
    public static void main(String[] args) {
        // Definindo variáveis que vão ser usadas
        DecimalFormat df = new DecimalFormat("0.0");
        double[][] notas = new double[5][2];

        System.out.println("#######################################");
        System.out.println("EXIBINDO NOTAS DE CADA ALUNO");
        System.out.println("#######################################");
        // Método que define e imprime das notas dos alunos
        imprimirNotas(notas, df);
        System.out.println("#######################################");
        System.out.println("EXIBINDO MÉDIA DE CADA ALUNO");
        System.out.println("#######################################");
        // Método que calcula a média dos alunos e imprime na tela
        calcularMedias(notas, df);

    }

    public static void calcularMedias(double[][] notas, DecimalFormat df) {
        double soma = 0;
        for(int i = 0; i < notas.length; i++){
            for(int j = 0; j < notas[i].length; j++){
                soma += notas[i][j];
            }
            double media = soma / notas[i].length;
            System.out.println((i + 1) + "° Aluno: " + df.format(media));
            soma = 0;
        }
    }

    public static void imprimirNotas(double[][] notas, DecimalFormat df) {
        Random random = new Random();
        for(int i = 0; i < notas.length; i++){
            System.out.print((i + 1) + "° Aluno: ");
            for(int j = 0; j < notas[i].length; j++){
                notas[i][j] = random.nextDouble(10);
                System.out.print(" |  "+ df.format(notas[i][j]) + " | ");
            }
            System.out.println(" ");
        }
    }
}
