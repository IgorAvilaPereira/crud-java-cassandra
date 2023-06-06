/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author iapereira
 */
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.util.List;

@Table(keyspace = "exemplo", name = "pessoa")
public class Pessoa {

    @PartitionKey
    private String cpf;
    
    
    private String nome;
    private LocalDate nascimento;
    private List<String> gostos;

    public Pessoa() {
    }

    @PartitionKey
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String cpf, String nome, LocalDate nascimento, List<String> gostos) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.gostos = gostos;
    }
    
    
    
    

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<String> getGostos() {
        return gostos;
    }

    public void setGostos(List<String> gostos) {
        this.gostos = gostos;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", nome=" + nome + ", nascimento=" + nascimento + ", gostos=" + gostos + '}';
    }
    
    
}
