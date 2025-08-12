import java.sql.Connection;
import java.sql.PreparedStatement;

public class Produto {
    private int codProduto;
    private String nome;
    private double preco;
    private int estoque;

    public Produto() {}

    public Produto(int codProduto, double preco, int estoque) {
        setCodProduto(codProduto);
        setPreco(preco);
        setEstoque(estoque);
    }

    public String toString() {
        return "Produto{" +
                "codProduto=" + codProduto +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
