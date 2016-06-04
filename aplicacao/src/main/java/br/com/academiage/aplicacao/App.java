package br.com.academiage.aplicacao;

import br.com.academiage.entidade.Cliente;
import br.com.academiage.util.JpaUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
        try{
            Dao dao = new Dao(Cliente.class);
            ClienteDao cdao = new ClienteDao(Cliente.class);

            Cliente c = new Cliente("Teste");
            
            dao.salvar(c);
            
            System.out.printf("Cliente: " + c.getId().toString());
            
            c = (Cliente) dao.buscaPorID(Long.parseLong("4"));
            
            System.out.printf("Cliente: " + c.getId().toString()+ " - " + c.getNome());
            
            List<Cliente> clist = dao.buscaTodos();
                for (Cliente cliente: clist){
                     System.out.printf("Cliente: " + cliente.getId().toString()+ " - " + cliente.getNome()+"\n");
                }
            
            System.out.printf("\n\nTeste DAO Especifico - Busca Por Nome.\n\n");
            
            List<Cliente> listaCliente = cdao.buscaPorNome("Teste");
                for (Cliente cliente: listaCliente){
                    System.out.printf("Cliente: " + cliente.getId().toString()+ " - " + cliente.getNome() + "\n");
            }
            
            System.out.printf("\n\nTeste DAO Especifico - Busca Por Data.\n\n");
            
            //Passar parametro para a data para expecificar a data
           Date dataCadastro = new Date(); 
            listaCliente = cdao.buscaPorDataCadastro(dataCadastro);
                for (Cliente cliente: listaCliente){
                    System.out.printf("Cliente: " + cliente.getId().toString()+ " - " + cliente.getNome() + " - " + cliente.getDataCadastro()+"\n");
            }
            
            //dao.remover(c)
        } finally {
            JpaUtil.FecharConexao();
        }
    
    }
}
