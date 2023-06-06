/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package apresentacao;

import com.datastax.driver.core.LocalDate;
import java.util.List;
import negocio.Pessoa;
import persistencia.PessoaDAO;

/**
 *
 * @author iapereira
 */
public class Main {

    public static void main(String[] args) {
//        new PessoaDAO().inserir(new Pessoa("111.111.111-11", "Fulano", LocalDate.fromYearMonthDay(1987, 01, 20), List.of("cassandra", "neo4j")));
//          new PessoaDAO().listar().forEach(x -> System.out.println(x));

//        new PessoaDAO().deletar("111.111.111-11");

        new PessoaDAO().atualizarNome("Igor", "111.111.111-11");
    }
}