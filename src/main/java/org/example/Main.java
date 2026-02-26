package org.example;
import org.example.model.Pedido;
import org.example.service.ProcessadorDePagamento;
import org.example.strategy.impl.FreteGratis;
import org.example.strategy.impl.FretePadrao;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoComum = new Pedido(100.0);
        ProcessadorDePagamento processador = new ProcessadorDePagamento();

        // O Processador aceita FretePadrao...
        processador.processar(pedidoComum, new FretePadrao());

        // ...e aceita FreteGratis de forma IDENTICA.
        // Isso é o LSP: a substituição não causou efeitos colaterais.
        processador.processar(pedidoComum, new FreteGratis());
    }
}