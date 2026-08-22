import java.util.Scanner;
public class Calculadora {
   public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
     
    System.out.println("=== CALCULADORA ===");
    System.out.println("1 - Somar");
    System.out.println("2 - Subtrair");
    System.out.println("3 - Multiplicar");
    System.out.println("4 - Dividir");
    System.out.println("5 - Sair");

    System.out.print("Escolha uma opção: ");
    int opcao = input.nextInt();


    if (opcao >= 1 && opcao <= 4) {
        System.out.print("Digite o primeiro número: ");
        double numero1 = input.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = input.nextDouble();

    switch (opcao) {
        case 1:
            System.out.println("Resultado: " + (numero1 + numero2));
            break;

        case 2:
            System.out.println("Resultado: " + (numero1 - numero2));
            break;
        
        case 3:
            System.out.println("Resultado: " + (numero1 * numero2));
            break;

        case 4:
            if (numero2 != 0) {
             System.out.println("Resultado: " + (numero1 / numero2)); 
            } else {
                System.out.println("Não é possível dividr por zero!");
            }
            break; 
         } 
      } 
    else if (opcao == 5) {
        System.out.println("Programa encerrado. ");

    } else {
         System.out.println("opcao inválida. " );
    }

     input.close();


    }

   } 

