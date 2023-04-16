import java.util.Scanner;

public class Quinta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite sua palavra:");
        String palavra = input.nextLine();  //recebo a palavra

        char[] caracteres = palavra.toCharArray(); //divido eka em um array
        int tamanho = caracteres.length;  //pego o tamanho do array
        for (int i = 0; i < tamanho / 2; i++) {
            int alocado = tamanho - 1 - i;  // pego a posicão do que vai ser alocado na posição atual 

            char temp = caracteres[i];  // armazena o valor do caractere atual
            caracteres[i] = caracteres[alocado]; // substitui o caractere atual pelo da posicao do que sera alocado
            caracteres[alocado] = temp;  // coloca o armazenado na posicao do que foi alocado
        }
        System.out.println(caracteres); //imprime os 
        input.close();

    }
}
