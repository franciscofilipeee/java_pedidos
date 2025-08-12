import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    public static boolean criarTabelaCliente() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "CREATE TABLE cliente("
                    + "codCliente INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nome VARCHAR(50) NOT NULL,"
                    + "email VARCHAR(50) NOT NULL,"
                    + "endereco VARCHAR(100),"
                    + "cidade VARCHAR(30),"
                    + "estado CHAR(2),"
                    + "fone VARCHAR(15));";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela cliente não foi criada. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirTabelaCliente() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DROP TABLE cliente;";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela cliente não foi excluída. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM cliente;";
            stat = conexao.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next()) {
                Cliente cli = new Cliente();
                cli.setCodCliente(rs.getInt("codCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setFone(rs.getString("nome"));
                lista.add(cli);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar os valores. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return lista;
    }

    public static Cliente listarCliente(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        ResultSet rs = null;
        Cliente cli = new Cliente();
        try {
            String sql = "SELECT * FROM cliente WHERE codCliente=?;";
            stat = conexao.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while(rs.next()) {
                cli.setCodCliente(rs.getInt("codCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setFone(rs.getString("nome"));
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar o cliente. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return cli;
    }

    public static boolean inserirCliente(Cliente cli) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "INSERT INTO cliente(nome, email, fone, endereco, cidade, estado) VALUES(?,?,?,?,?,?)";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, cli.getNome());
            stat.setString(2, cli.getEmail());
            stat.setString(3, cli.getFone());
            stat.setString(4, cli.getEndereco());
            stat.setString(5, cli.getCidade());
            stat.setString(6, cli.getEstado());
            stat.execute();
            System.out.println("Cadastro feito com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível cadastrar o cliente. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirCliente(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DELETE FROM cliente WHERE codCliente=?;";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, id);
            stat.execute();
            System.out.println("Cadastro feito com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível excluir o cliente. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
