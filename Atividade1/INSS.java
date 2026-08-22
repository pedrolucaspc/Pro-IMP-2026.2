import java.util.Scanner;
public class INSS {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        System.out.print("Digite seu salário bruto: R$ ");
        double salario = input.nextDouble();

        double inss;

        if (salario <= 1621.00) {
            inss = salario * 0.075;

        } else if (salario <= 2902.84) {
            inss = (1621.00 * 0.075)
                    + ((salario - 1621.00) * 0.09);

        } else if (salario <= 4354.27) {
            inss = (1621.00 * 0.075)
                    + ((2902.84 - 1621.00) * 0.09)
                    + ((salario - 2902.84) * 0.12);

        } else if (salario <= 8475.55) {
            inss = (1621.00 * 0.075)
                    + ((2902.84 - 1621.00) * 0.09)
                    + ((4354.27 - 2902.84) * 0.12)
                    + ((salario - 4354.27) * 0.14);

        } else {
            inss = (1621.00 * 0.075)
                    + ((2902.84 - 1621.00) * 0.09)
                    + ((4354.27 - 2902.84) * 0.12)
                    + ((8475.55 - 4354.27) * 0.14);
        }

        double salarioLiquido = salario - inss;

        System.out.printf("Contribuição ao INSS: R$ %.2f%n", inss);
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);

        input.close();
    }
}
    
