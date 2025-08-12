import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
    public static Connection criarConexao() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String servidor = "jdbc:mysql://localhost:3306/pedidos";
        String usuario = "";
        String senha = "";
        try {
            Class.forName(driver);
            return DriverManager.getConnection(servidor,usuario,senha);
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conn, PreparedStatement stat) {
        fecharConexao(conn);
        if(stat != null) {
            try {
                stat.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public static void fecharConexao(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public String toString() {
        return super.toString();
    }
}
