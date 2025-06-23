import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.println("Digite os dados do trabalhador");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nível: ");
        String nivel = sc.nextLine();
        System.out.print("Salário: ");
        Double salario = sc.nextDouble();
        System.out.print("Quantos contratos o trabalhador tem? ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++) {
            System.out.println("Digite os dados do contrato " + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            sc.nextLine();
            LocalDate data = LocalDate.parse(sc.nextLine(), f1);
            System.out.println(data);
        }


        sc.close();
    }
}