package Models;
import Services.Input;
import Services.logicaJogo;
import Views.Output;

public class Jogo {
	private ListaDuplamenteEncadeada jogadorHumano = new ListaDuplamenteEncadeada();
	private ListaDuplamenteEncadeada jogadorcomputador = new ListaDuplamenteEncadeada();
	private ListaDuplamenteEncadeada mesaCompra = new ListaDuplamenteEncadeada();
	private ListaDuplamenteEncadeada mesaAtual = new ListaDuplamenteEncadeada();
	private ListaDuplamenteEncadeada pecas = new ListaDuplamenteEncadeada();
	private logicaJogo jogo = new logicaJogo();
	private Output saida = new Output();
	private Input entrada = new Input();
	
	public void inicio() {
	    while(true) {
	        exibirMensagemInicial();

	        String option = receberInputUsuario();

	        if (option.equalsIgnoreCase("s")) {
	            iniciarNovoJogo();
	        } else {
	            exibirMensagemFinal();
	            break; // Encerra o loop e termina o método
	        }
	    }
	}

	private void exibirMensagemInicial() {
	    saida.exibirMensagem("Deseja iniciar um novo jogo? S / N");
	}

	private String receberInputUsuario() {
	    return entrada.receberInputString();
	}

	private void iniciarNovoJogo() {
	    jogo.iniciarJogo(pecas, jogadorHumano, jogadorcomputador, mesaCompra, mesaAtual);
	}

	private void exibirMensagemFinal() {
	    saida.exibirMensagem("Fim de jogo");
	}
}
