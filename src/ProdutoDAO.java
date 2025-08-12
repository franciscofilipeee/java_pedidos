import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    public static boolean criarTabelaProduto() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "CREATE TABLE produto("
                    + "codProduto INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nome VARCHAR(50) NOT NULL,"
                    + "preco VARCHAR(50) NOT NULL,"
                    + "estoque INT NOT NULL);";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela produto não foi criada. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirTabelaProduto() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DROP TABLE produto;";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela produto não foi excluída. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static ArrayList listarProdutos() {
        ArrayList lista = new ArrayList<Cliente>();
        Connection conexao = Conexao.criarConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM produto;";
            stat = conexao.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next()) {
                Produto pro = new Produto();
                pro.setCodProduto(rs.getInt("codProduto"));
                pro.setNome(rs.getString("nome"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setPreco(rs.getInt("estoque"));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar os valores. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return lista;
    }

    public static Produto listarProduto(int id) {
        Connection conexao = Conexao.criarConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        Produto pro = new Produto();
        try {
            String sql = "SELECT * FROM produto WHERE codProduto=?;";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while(rs.next()) {
                pro.setCodProduto(rs.getInt("codProduto"));
                pro.setNome(rs.getString("nome"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setPreco(rs.getInt("estoque"));
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar os valores. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return pro;
    }

    public static boolean inserirProduto(Produto pro) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "INSERT INTO produto(nome, preco, estoque) VALUES(?,?,?)";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, pro.getNome());
            stat.setDouble(2, pro.getPreco());
            stat.setInt(3, pro.getEstoque());
            stat.execute();
            System.out.println("Cadastro feito com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível cadastrar o produto. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirProduto(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DELETE FROM pedidos WHERE codProduto=?";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, id);
            stat.execute();
            System.out.println("Exclusão feita com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível excluir o produto. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
