import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu Principal" +
                "\n1-Pedidos" +
                "\n2-Clientes" +
                "\n3-Produtos" +
                "\n4-Sair");
        int input = sc.nextInt();
        switch(input) {
            case 1:
                pedidos();
                break;
            case 2:
                clientes();
                break;
            case 3:
                produtos();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }
    }

    public static void pedidos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pedidos" +
                "\n1-Incluir Pedido" +
                "\n2-Alterar Pedido" +
                "\n3-Excluir Pedido" +
                "\n4-Listar Pedido" +
                "\n5-Voltar");
        int input = sc.nextInt();
        switch(input) {
            case 1:
                cadastrarPedidos();
                break;
            case 2:
                alterarPedidos();
                break;
            case 3:
                excluirPedidos();
                break;
            case 4:
                listarPedidos();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }
    }

    public static void clientes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Clientes" +
                "\n1-Incluir Cliente" +
                "\n2-Alterar Cliente" +
                "\n3-Excluir Cliente" +
                "\n4-Listar Cliente" +
                "\n5-Voltar");
        int input = sc.nextInt();
        
        switch(input) {
            case 1:
                cadastrarClientes();
                break;
            case 2:
                alterarClientes();
                break;
            case 3:
                excluirClientes();
                break;
            case 4:
                listarClientes();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }
    }

    public static void produtos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Produtos" +
                "\n1-Incluir Produto" +
                "\n2-Alterar Produto" +
                "\n3-Excluir Produto" +
                "\n4-Listar Produto" +
                "\n5-Voltar");
        int input = sc.nextInt();
        
        switch(input) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                alterarProdutos();
                break;
            case 3:
                excluirProdutos();
                break;
            case 4:
                listarProdutos();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }
    }

    public static void listarPedidos() {
        System.out.println(PedidoDAO.listarPedidos());
        pedidos();
    }

    public static void listarClientes() {
        System.out.println(ClienteDAO.listarClientes());
        clientes();
    }

    public static void listarProdutos() {
        System.out.println(ProdutoDAO.listarProdutos());
        produtos();
    }

    public static void cadastrarClientes() {
        Cliente cli = new Cliente();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o nome do cliente: ");
        String nome = sc.next();
        System.out.println("Escreva o email do cliente: ");
        String email = sc.next();
        System.out.println("Escreva o fone do cliente: ");
        String fone = sc.next();
        System.out.println("Escreva o endereco do cliente: ");
        String endereco = sc.next();
        System.out.println("Escreva o cidade do cliente: ");
        String cidade = sc.next();
        System.out.println("Escreva o estado do cliente: ");
        String estados = sc.next();
        
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setFone(fone);
        cli.setEndereco(endereco);
        cli.setCidade(cidade);
        cli.setEstado(estados);
        ClienteDAO.inserirCliente(cli);
        clientes();
    }

    public static void cadastrarPedidos() {
        Pedido ped = new Pedido();
        ItemPedido it = new ItemPedido();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o status do pedido: ");
        String status = sc.next();
        System.out.println("Escreva o código do cliente: ");
        int codCli = sc.nextInt();
        while(true) {
            System.out.println("Digite o código do produto (0 p/ finalizar): ");
            int codProduto = sc.nextInt();
            if(codProduto == 0)
                break;
            System.out.println("Digite a quantidade do produto: ");
            int qtd = sc.nextInt();
            Produto pro = ProdutoDAO.listarProduto(codProduto);
            it.setPedido(ped);
            it.setProduto(pro);
            it.setQuantidade(qtd);
            it.setPrecoUnit(pro.getPreco());
            ItemPedidoDAO.inserirItemPedido(it);
        }
        Cliente cli = ClienteDAO.listarCliente(codCli);
        ped.setStatus(status);
        ped.setData(LocalDate.now());
        ped.setCliente(cli);
        PedidoDAO.inserirPedido(ped);
        pedidos();
    }

    public static void cadastrarProdutos() {
        Produto pro = new Produto();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o nome do produto: ");
        String nome = sc.next();
        System.out.println("Escreva o preço do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Escreva o estoque do produto: ");
        int estoque = sc.nextInt();
        
        pro.setNome(nome);
        pro.setPreco(preco);
        pro.setEstoque(estoque);
        ProdutoDAO.inserirProduto(pro);
        produtos();
    }

    public static void excluirProdutos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o código do produto: ");
        int id = sc.nextInt();
        
        ProdutoDAO.excluirProduto(id);
        produtos();
    }

    public static void excluirPedidos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o código do pedido: ");
        int id = sc.nextInt();
        
        PedidoDAO.excluirPedido(id);
        pedidos();
    }

    public static void excluirClientes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o código do cliente: ");
        int id = sc.nextInt();
        
        ClienteDAO.excluirCliente(id);
        clientes();
    }

    public static void alterarProdutos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto que deseja alterar: ");
        int id = sc.nextInt();
        Produto pro = ProdutoDAO.listarProduto(id);
        System.out.println("Escreva o novo nome do produto: (antigo: " + pro.getNome() + ".");
        String nome = sc.next();
        System.out.println("Escreva o novo preço do produto: (antigo: " + pro.getPreco() + ".");
        double preco = sc.nextDouble();
        System.out.println("Escreva o novo estoque do produto: (antigo: " + pro.getEstoque() + ".");
        int estoque = sc.nextInt();
        
        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        p.setEstoque(estoque);
        ProdutoDAO.inserirProduto(p);
        produtos();
    }

    public static void alterarPedidos() {
        Scanner sc = new Scanner(System.in);
        java.sql.Date langDate = null;
        System.out.println("Digite o código do pedido que deseja alterar: ");
        int id = sc.nextInt();
        Pedido ped = PedidoDAO.listarPedido(id);
        System.out.println("Escreva o novo status do pedido: (antigo: " + ped.getStatus() + ".");
        String status = sc.next();
        System.out.println("Escreva o código do novo cliente do pedido: (antigo: " + ped.getCliente() + ".");
        int idCli = sc.nextInt();
        Cliente cli = ClienteDAO.listarCliente(idCli);
        Pedido p = new Pedido();
        p.setStatus(status);
        p.setData(LocalDate.now());
        p.setCliente(cli);
        PedidoDAO.inserirPedido(p);
        pedidos();
    }

    public static void alterarClientes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do cliente que deseja alterar: ");
        int id = sc.nextInt();
        Cliente cli = ClienteDAO.listarCliente(id);
        System.out.println("Escreva o novo nome do cliente: (antigo: " + cli.getNome() + ".");
        String nome = sc.next();
        System.out.println("Escreva o novo email do cliente: (antigo: " + cli.getEmail() + ".");
        String email = sc.next();
        System.out.println("Escreva o novo fone do cliente: (antigo: " + cli.getFone() + ".");
        String fone = sc.next();
        System.out.println("Escreva o novo endereço do cliente: (antigo: " + cli.getEndereco() + ".");
        String endereco = sc.next();
        System.out.println("Escreva a nova cidade do cliente: (antigo: " + cli.getCidade() + ".");
        String cidade = sc.next();
        System.out.println("Escreva o novo estado do cliente: (antigo: " + cli.getEstado() + ".");
        String estado = sc.next();
        
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEmail(email);
        c.setFone(fone);
        c.setEndereco(endereco);
        c.setCidade(cidade);
        c.setEstado(estado);
        ClienteDAO.inserirCliente(c);
        clientes();
    }
}
