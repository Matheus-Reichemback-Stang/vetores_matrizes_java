public class Atividade06 {
    public static void main(String[] args) {
        // Definição de matriz 5x5 que vai ser usada
        int[][] matriz = new int[5][5];

        // Construção da Matriz Identidade
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(i == j){
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        //Exibindo Matriz Identidade na tela do usuário
        System.out.println("#######################################");
        System.out.println("EXIBINDO DA MATRIZ IDENTIDADE 5X5");
        System.out.println("#######################################");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
