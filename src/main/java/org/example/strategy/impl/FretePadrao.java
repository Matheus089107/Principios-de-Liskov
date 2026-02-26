package org.example.strategy.impl;

import org.example.model.Pedido;
import org.example.strategy.EstrategiaDeFrete;

public class FretePadrao implements EstrategiaDeFrete {
    @Override
    public double calcularValorFinal(Pedido pedido) {
        return pedido.getValorBruto() + 15.0; // Regra: Adiciona R$ 15,00
    }
}