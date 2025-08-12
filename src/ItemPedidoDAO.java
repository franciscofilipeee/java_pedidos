import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemPedidoDAO {

    public static boolean criarTabelaItemPedido() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "CREATE TABLE item_pedido("
                    + "codItem INT PRIMARY KEY AUTO_INCREMENT,"
                    + "Produto VARCHAR(200) NOT NULL,"
                    + "Pedido VARCHAR(200) NOT NULL,"
                    + "quantidade INT NOT NULL,"
                    + "precoUnit DECIMAL NOT NULL);";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela item_pedido não foi criada. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirTabelaItemPedido() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DROP TABLE item_pedido;";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela item_pedido não foi excluída. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
