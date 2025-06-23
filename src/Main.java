import entities.Contrato;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

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
        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salario, new Departamento(departamento));

        System.out.print("Quantos contratos o trabalhador tem? ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++) {
            System.out.println("Digite os dados do contrato " + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            sc.nextLine();
            LocalDate data = LocalDate.parse(sc.nextLine(), f1);
            System.out.print("Valor da hora: ");
            Double valorHora = sc.nextDouble();
            System.out.print("Duração: ");
            Integer horas = sc.nextInt();
            Contrato contrato = new Contrato(data, valorHora, horas);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println();
        System.out.print("Digite o mês e o ano para calcular o valor (MM/YYYY): ");
        sc.nextLine();
        String mesAno = sc.nextLine();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3, 7));
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Valor para " + mesAno + ": " + String.format("%.2f", trabalhador.valorPorMesAno(ano, mes)));

        sc.close();
    }
}