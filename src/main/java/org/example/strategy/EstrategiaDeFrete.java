package org.example.strategy;

import org.example.model.Pedido;

public interface EstrategiaDeFrete {
    // O contrato: qualquer um que implemente isso DEVE retornar o valor final
    double calcularValorFinal(Pedido pedido);
}