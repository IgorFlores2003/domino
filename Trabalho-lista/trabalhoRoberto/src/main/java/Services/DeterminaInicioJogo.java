package Services;

import Models.ListaDuplamenteEncadeada;
import Models.Peca;
import Views.Output;

import java.util.List;

public class DeterminaInicioJogo {

    private Output saida = new Output();

    public void determinarJogadorInicial(ListaDuplamenteEncadeada jogadorPrincipal,
            ListaDuplamenteEncadeada jogadorComputador, ListaDuplamenteEncadeada mesaJogo) {
Peca maiorPecaJogador = encontrarMaiorPeca(jogadorPrincipal);
Peca maiorPecaComputador = encontrarMaiorPeca(jogadorComputador);

boolean jogadorPossuiCarretao = possuiCarretao(maiorPecaJogador);
boolean computadorPossuiCarretao = possuiCarretao(maiorPecaComputador);

if (jogadorPossuiCarretao && computadorPossuiCarretao) {
int totalJogador = calcularTotalPeca(maiorPecaJogador);
int totalComputador = calcularTotalPeca(maiorPecaComputador);
if (totalJogador > totalComputador) {
saida.exibirMensagem("Você possui um carretão maior. Você inicia o jogo!");
} else if (totalComputador > totalJogador) {
saida.exibirMensagem("O computador possui um carretão maior. O computador inicia o jogo!");
jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
mesaJogo.imprimirTodasPecas();
} else {
saida.exibirMensagem("Ambos têm carretões de igual valor. Sorteio para determinar quem inicia...");
// Lógica de sorteio para determinar o início do jogo
}
} else if (jogadorPossuiCarretao) {
saida.exibirMensagem("Você possui um carretão. Você inicia o jogo!");
} else if (computadorPossuiCarretao) {
saida.exibirMensagem("O computador possui um carretão. O computador inicia o jogo!");
jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
mesaJogo.imprimirTodasPecas();
} else if (maiorPecaJogador != null && maiorPecaComputador != null) {
int totalJogador = calcularTotalPeca(maiorPecaJogador);
int totalComputador = calcularTotalPeca(maiorPecaComputador);
if (totalJogador > totalComputador) {
saida.exibirMensagem("Você possui a maior peça. Você inicia o jogo!");
} else if (totalComputador > totalJogador) {
saida.exibirMensagem("O computador possui a maior peça. O computador inicia o jogo!");
jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
mesaJogo.imprimirTodasPecas();
} else {
saida.exibirMensagem("Ambos os jogadores têm peças de igual valor. Sorteio para determinar quem inicia...");
// Lógica de sorteio para determinar o início do jogo
}
} else {
saida.exibirMensagem("Ambos os jogadores não têm peças. O jogo termina em empate.");
}
}

private Peca encontrarMaiorPeca(ListaDuplamenteEncadeada jogador) {
if (jogador.estaVazia()) {
return null; // Retorna null se a lista estiver vazia
}

Peca maiorPeca = jogador.getPecaPorIndice(0);

for (int i = 1; i <= jogador.getUltimoIndice(); i++) {
Peca pecaAtual = jogador.getPecaPorIndice(i);
if (pecaAtual != null && calcularTotalPeca(pecaAtual) > calcularTotalPeca(maiorPeca)) {
maiorPeca = pecaAtual;
}
}

return maiorPeca;
}

private boolean possuiCarretao(Peca peca) {
return peca.getNumero1() == peca.getNumero2();
}

private int calcularTotalPeca(Peca peca) {
return peca.getNumero1() + peca.getNumero2();
}
}