Desafio: Refatoração com Liskov (LSP)
Este projeto aplica o Princípio de Substituição de Liskov para resolver problemas de herança mal planejada em um sistema de fretes.

1. O Problema (Por que quebrava o LSP?)
No design antigo, o PedidoComFreteGratis herdava de Pedido. Isso era ruim porque:

O sistema esperava que todo Pedido tivesse um cálculo de frete padrão.

Se o PedidoComFreteGratis mudasse essa regra ou desse erro, o código que usa o Pedido (o Cliente) quebrava.

O programador era obrigado a usar if (pedido instanceof ...) para saber se cobrava frete ou não.

2. A Solução (Strategy Pattern)
Em vez de herança, usamos composição. Separamos a regra de frete em uma Interface.

Arquitetura de Pastas:
model/Pedido.java: Apenas o valor do produto.

strategy/EstrategiaDeFrete.java: A Interface (O contrato).

strategy/impl/: As regras reais (FretePadrao e FreteGratis).

service/ProcessadorDePagamento.java: O Cliente que faz a cobrança.

3. Código Refatorado

   
O Contrato (Interface)


Java


public interface EstrategiaDeFrete {


    double calcularValorFinal(Pedido pedido);

    
}


As Regras (Implementações)


Java


// Frete Padrão: Soma R$ 15,00


public class FretePadrao implements EstrategiaDeFrete {


    public double calcularValorFinal(Pedido pedido) {

    
        return pedido.getValorBruto() + 15.0;

        
    }

    
}

public class FreteGratis implements EstrategiaDeFrete {


    public double calcularValorFinal(Pedido pedido) {

    
        return pedido.getValorBruto();

        
    }

    
}


O Cliente (Respeitando o LSP)


O ProcessadorDePagamento agora aceita qualquer frete sem precisar de if/else. Ele confia na interface!


Java


public class ProcessadorDePagamento {


    public void processar(Pedido pedido, EstrategiaDeFrete frete) {

    
    double total = frete.calcularValorFinal(pedido);

    
        System.out.println("Total a pagar: R$ " + total);

        
    }
}

Agora você pode trocar FretePadrao por FreteGratis a qualquer momento. O programa não quebra, o comportamento é previsível e o código ficou muito mais limpo!
