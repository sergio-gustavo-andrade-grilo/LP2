package documin.documento;

import java.util.HashMap;

/**
 * Uma classe que representa uma lista, que é um tipo de elemento de um
 * documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Lista extends Elemento {
	/**
	 * Um array de palavras contidas na lista.
	 */
	private String[] palavras;

	/**
	 * Cria uma nova lista, a partir de seu valor, de sua prioridade e de suas
	 * propriedades, que são seu caractere separador e seu caractere de lista.
	 * 
	 * @param valor        O valor da lista.
	 * @param prioridade   A prioridade da lista.
	 * @param propriedades As propriedades da lista: caractere separator e caractere
	 *                     de lista
	 */
	public Lista(String valor, int prioridade, HashMap<String, String> propriedades) {
		super(valor, prioridade, propriedades);
		this.palavras = valor.split(" " + this.propriedades.get("Separador") + " ");
	}

	/**
	 * Retorna a prioridade da lista.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Retorna a representação completa da lista, composta por itens, que contém o
	 * caractere de lista e uma das palavras, separados por linha.
	 */
	@Override
	public String representacaoCompleta() {
		String out = "";
		
		for (String palavra : palavras) {
			out += this.propriedades.get("Caractere") + " " + palavra + System.lineSeparator();
		}
		
		return out.trim();
	}

	/**
	 * Retorna a representação resumida da lista, composta por cada palavra separada
	 * pelo caractere separador.
	 */
	@Override
	public String representacaoResumida() {
		String out = "";

		for (int i = 0; i < this.palavras.length - 1; i++) {
			out += this.palavras[i] + " " + this.propriedades.get("Separador") + " ";
		}
		
		out += this.palavras[this.palavras.length - 1];

		return out;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof Lista)) {
			return false;
		}

		Lista oLista = (Lista) o;

		return this.representacaoCompleta().equals(oLista.representacaoCompleta());
	}
}