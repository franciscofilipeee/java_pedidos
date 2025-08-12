import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoDAO {
    public static boolean criarTabelaPedido() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "CREATE TABLE pedido("
                    + "codPedido INT PRIMARY KEY AUTO_INCREMENT,"
                    + "data DATE NOT NULL,"
                    + "status VARCHAR(10) NOT NULL,"
                    + "cliente VARCHAR(200) NOT NULL);";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela pedido não foi criada. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirTabelaPedido() {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DROP TABLE pedido;";
            stat = conexao.prepareStatement(sql);
            stat.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: A tabela pedido não foi excluída. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM pedido;";
            stat = conexao.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next()) {
                Cliente cli = ClienteDAO.listarCliente(rs.getInt("cliente"));
                Pedido ped = new Pedido();
                ped.setCodPedido(rs.getInt("codCliente"));
                ped.setData(LocalDate.now());
                ped.setCliente(cli);
                lista.add(ped);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar os valores. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return lista;
    }

    public static Pedido listarPedido(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        ResultSet rs = null;
        Pedido ped = new Pedido();
        try {
            String sql = "SELECT * FROM pedido WHERE codPedido=?;";
            stat = conexao.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next()) {
                Cliente cli = ClienteDAO.listarCliente(rs.getInt("cliente"));
                ped.setCodPedido(rs.getInt("codCliente"));
                ped.setData(LocalDate.now());
                ped.setCliente(cli);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível resgatar os valores. - " + e.getMessage());
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return ped;
    }

    public static boolean inserirPedido(Pedido ped) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "INSERT INTO pedido(data, status, cliente) VALUES(?,?,?)";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setDate(1, Date.valueOf(LocalDate.now()));
            stat.setString(2, ped.getStatus());
            stat.setInt(3, ped.getCliente().getCodCliente());
            stat.execute();
            System.out.println("Cadastro feito com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível cadastrar o pedido. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean excluirPedido(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "DELETE FROM pedidos WHERE codPedido=?; DELETE FROM item_pedido WHERE Pedido=?";
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, id);
            stat.setInt(2, id);
            stat.execute();
            System.out.println("Exclusão feita com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível excluir o pedido. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public static boolean alterarPedido(int id) {
        PreparedStatement stat = null;
        Connection conexao = Conexao.criarConexao();
        try {
            String sql = "UPDATE pedido SET nome=?,email=?,endereco=?,cidade=?,estado=?,";
            Pedido ped = new Pedido();
            stat=conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, ped.getStatus());
            stat.setString(2, ped.getCliente().toString());
            stat.setDate(3, Date.valueOf(LocalDate.now()));
            stat.execute();
            System.out.println("Atualização feita com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível atualizar o pedido. - " + e.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
