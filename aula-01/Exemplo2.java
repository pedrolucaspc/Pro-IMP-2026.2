import java.util.Scanner;
public class Exemplo2 {
     public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("dgite sua primeira nota");
        double nota1 = input.nextDouble();

        System.out.println("digite sua segunda nota");
        double nota2 = input.nextDouble();

        System.out.println("digite sua terceira nota");
        double nota3 = input.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        System.out.printf("Média: %.2f%n", media);

        if (media >= 7) {
         System.out.println("Aprovado!");
        }

        if (media <= 7) {
         System.out.println("Reprovado!");
        }

       input.close();

     }
}