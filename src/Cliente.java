import java.sql.Connection;
import java.sql.PreparedStatement;

public class Cliente {
    private int codCliente;
    private String nome;
    private String email;
    private String fone;
    private String endereco;
    private String cidade;
    private String estado;

    public Cliente(int codCliente, String nome, String email) {
        setNome(nome);
        setEmail(email);
        setCodCliente(codCliente);
    }

    public Cliente() {
    }

    public String ToString() {
        return getCodCliente() + getNome() + getEmail() + getFone();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getNome() {
        return nome;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getFone() {
        return fone;
    }

    public String getEndereco() {return endereco;}

    public String getCidade() {return cidade;}

    public String getEstado() {return estado;}

    public String toString() {
        return "Cliente{" +
                "codCliente=" + codCliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }
}
