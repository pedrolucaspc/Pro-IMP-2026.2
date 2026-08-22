import java.util.Scanner;
public class Exemplo3 {

public static void main(String[] args) {
Scanner input = new Scanner(System.in);

   System.out.println("Digite seu nome");
   String nome = input.nextLine();

   System.out.println("Digite sua idade");
   int idade = input.nextInt();

   System.out.println("Qual a sua altura");
   double altura = input.nextDouble();

   System.out.println("Você é estudante?");
   boolean estudante = input.nextBoolean();
   
System.out.println("Nome: "+ nome);
System.out.println("Idade: " + idade);
System.out.println("Altura: " + altura);
System.out.println("Estudante: " + estudante);

   input.close();



}
}
