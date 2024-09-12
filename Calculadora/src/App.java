import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculadora = new Calculator();

        double num1 = 0;
        double num2 = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o primeiro numero: ");
                num1 = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada invalida. Insira um numero.");
                scanner.next();
            }
        }

        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o segundo numero: ");
                num2 = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Insira um numero.");
                scanner.next();
            }
        }

        System.out.println("Escolha a operação (+, -, *, /): ");
        char operacao = scanner.next().charAt(0);

        double resultado = 0;
        boolean operacaoValida = true;

        switch (operacao) {
            case '+':
                resultado = calculadora.soma(num1, num2);
                break;
            case '-':
                resultado = calculadora.subtracao(num1, num2);
                break;
            case '*':
                resultado = calculadora.multiplicacao(num1, num2);
                break;
            case '/':
                try {
                    resultado = calculadora.divisao(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    operacaoValida = false;
                }
                break;
            default:
                System.out.println("Operação invalida.");
                operacaoValida = false;
        }

        if (operacaoValida) {
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}
