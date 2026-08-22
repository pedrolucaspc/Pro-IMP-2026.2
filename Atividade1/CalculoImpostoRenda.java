import java.util.Scanner;

public class CalculoImpostoRenda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu salário bruto: R$ ");
        double salario = scanner.nextDouble();

        double imposto;

        if (salario <= 2428.80) {
            imposto = 0;
        } else if (salario <= 2826.65) {
            imposto = salario * 0.075 - 182.16;
        } else if (salario <= 3751.05) {
            imposto = salario * 0.15 - 394.16;
        } else if (salario <= 4664.68) {
            imposto = salario * 0.225 - 675.49;
        } else {
            imposto = salario * 0.275 - 908.73;
        }

        if (imposto < 0) {
            imposto = 0;
        }

        double salarioLiquido = salario - imposto;

        System.out.printf("Salário bruto: R$ %.2f%n", salario);
        System.out.printf("Imposto de Renda: R$ %.2f%n", imposto);
        System.out.printf("Salário após IR: R$ %.2f%n", salarioLiquido);

        scanner.close();
    }
}