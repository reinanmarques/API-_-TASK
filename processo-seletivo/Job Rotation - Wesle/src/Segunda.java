import java.util.Scanner;

public class Segunda {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite seu numero: ");
        int num = input.nextInt();

        int num1 = 0;
        int num2 = 1;
        int proximo = 0;
        boolean pertence = false;

        while (proximo < num) {
            proximo = num1 + num2;
            num1 = num2;
            num2 = proximo;

            if (proximo == num) {
                pertence = true;
                break;
            }
        }

        if (pertence) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }

        input.close();
    }
}

