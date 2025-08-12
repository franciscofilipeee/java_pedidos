import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

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

    public static boolean inserirItemPedido(ItemPedido it) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "INSERT INTO item_pedido(Produto, Pedido, quantidade, precoUnit) VALUES(?,?,?,?)";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, it.getProduto().getCodProduto());
            stat.setInt(2, it.getPedido().getCodPedido());
            stat.setInt(3, it.getQuantidade());
            stat.setDouble(4, it.getPrecoUnit());
            stat.execute();
            System.out.println("Cadastro feito com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível cadastrar o item do pedido. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
