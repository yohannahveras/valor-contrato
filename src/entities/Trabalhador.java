package entities;

import entities.enums.NivelTrabalhador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private Double salario;
    private Departamento departamento;
    private List<Contrato> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void adicionarContrato(Contrato contrato){
        contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato){
        contratos.remove(contrato);
    }

    /*public double valorPorMesAno(int ano, int mes) {
        double soma = salario;
        for (Contrato c : contratos) {
            int c_ano = c.getData().getYear();
            int c_mes = c.getData().getMonthValue();
            if (c_ano == ano && c_mes == mes) {
                soma += c.valorTotal();
            }
        }
        return soma;
    }
    */
    public double valorPorMesAno(int ano, int mes) {
        double soma = salario;
        for (Contrato c : contratos) {
            LocalDate data = c.getData();
            int c_ano = data.getYear();
            int c_mes = data.getMonthValue();
            if (c_ano == ano && c_mes == mes) {
                soma += c.valorTotal();
            }
        }
        return soma;
    }

}
