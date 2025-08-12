public class ItemPedido {
    private int codItem;
    private Produto produto;
    private Pedido pedido;
    private int quantidade;
    private double precoUnit;

    public String toString() {
        return "ItemPedido{" +
                "codItem=" + codItem +
                ", produto=" + produto +
                ", pedido=" + pedido +
                ", quantidade=" + quantidade +
                ", precoUnit=" + precoUnit +
                '}';
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getCodItem() {
        return codItem;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
