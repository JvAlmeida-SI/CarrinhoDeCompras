package main;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;

        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                System.out.println("Item: " + i.getNome() + ", preço: " + i.getPreco() + ", quantidade: " + i.getQuantidade());
            }
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    @Override
    public String toString() {
        return "Carrinho de compras{" + "itens=" + itemList + "}";
    }


    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Caneta", 2d, 3);
        carrinhoDeCompras.adicionarItem("Borracha", 1d, 2);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 2);
        carrinhoDeCompras.adicionarItem("Caderno", 15d, 1);

        carrinhoDeCompras.exibirItens();
        System.out.println("O valor da compra é = " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Lápis");

        System.out.println("APÓS REMOVER UM ITEM...");
        carrinhoDeCompras.exibirItens();

        System.out.println("O valor da compra após remover um item é = " + carrinhoDeCompras.calcularValorTotal());
    }
}