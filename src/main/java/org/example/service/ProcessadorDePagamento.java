package org.example.service;

import org.example.model.Pedido;
import org.example.strategy.EstrategiaDeFrete;

public class ProcessadorDePagamento {

    // Note que passamos a INTERFACE. Isso permite trocar o comportamento
    // em tempo de execução sem quebrar esta classe.
    public void processar(Pedido pedido, EstrategiaDeFrete estrategia) {
        double valorFinal = estrategia.calcularValorFinal(pedido);

        System.out.println("--- Processando Pagamento ---");
        System.out.println("Subtotal: R$ " + pedido.getValorBruto());
        System.out.println("Total com Frete: R$ " + valorFinal);
        System.out.println("Status: Aprovado\n");
    }
}