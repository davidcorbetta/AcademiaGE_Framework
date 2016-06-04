package br.com.academiage.aplicacao;

import br.com.academiage.entidade.Cliente;
import br.com.academiage.util.JpaUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
        try{
            Dao dao = new Dao();

            Cliente c = new Cliente("Teste");

            dao.salvar(c);

            dao.remover(c);
        } finally {
            JpaUtil.FecharConexao();
        }
    
    }
}
