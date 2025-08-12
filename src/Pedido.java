import java.time.LocalDate;

public class Pedido {
    private int codPedido;
    private LocalDate data;
    private String status;
    private Cliente cliente;

    public Pedido() {}

    public Pedido(int codPedido, LocalDate data, Cliente cliente) {
        setCliente(cliente);
        setCodPedido(codPedido);
        setData(data);
    }

    public String toString() {
        return "Pedido{" +
                "codPedido=" + codPedido +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", cliente=" + cliente +
                '}';
    }

    public int getCodPedido() {
        return codPedido;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
