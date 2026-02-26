package org.example.strategy.impl;

import org.example.model.Pedido;
import org.example.strategy.EstrategiaDeFrete;

public class FreteGratis implements EstrategiaDeFrete {
    @Override
    public double calcularValorFinal(Pedido pedido) {
        return pedido.getValorBruto(); // Regra: Valor limpo, sem acréscimo
    }
}