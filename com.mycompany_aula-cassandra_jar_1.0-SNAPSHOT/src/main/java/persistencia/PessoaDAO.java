/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.*;
import negocio.Pessoa;

/**
 *
 * @author iapereira
 */
public class PessoaDAO {

    public void inserir(Pessoa p) {
        try (Cluster cluster = Cluster.builder().addContactPoint("localhost").build()) {
            Session session = cluster.connect("exemplo");
            Mapper<Pessoa> pessoaMapper = new MappingManager(session).mapper(Pessoa.class);
            pessoaMapper.save(p);
        }
    }
    
    public Result<Pessoa> listar(){    
        try (Cluster cluster = Cluster.builder().addContactPoint("localhost").build()) {
            Session session = cluster.connect("exemplo");
            ResultSet results = session.execute ("select * from pessoa");            
            Mapper<Pessoa> pessoaMapper = new MappingManager(session).mapper(Pessoa.class);
            Result<Pessoa> pessoas = pessoaMapper.map(results);
            return pessoas;        
        }
    }
    
    
    public void deletar(String cpf){    
        try (Cluster cluster = Cluster.builder().addContactPoint("localhost").build()) {
            Session session = cluster.connect("exemplo");
            Mapper<Pessoa> pessoaMapper = new MappingManager(session).mapper(Pessoa.class);            
            pessoaMapper.delete(cpf);
        }
    }
    
    public void atualizarNome(String novoNome, String cpf){    
        try (Cluster cluster = Cluster.builder().addContactPoint("localhost").build()) {
            Session session = cluster.connect("exemplo");            
            PreparedStatement prepared = session.prepare("UPDATE pessoa SET nome = ? WHERE cpf = ?");
            BoundStatement b = prepared.bind(novoNome, cpf);
            session.execute(b);
        }
    }
}
