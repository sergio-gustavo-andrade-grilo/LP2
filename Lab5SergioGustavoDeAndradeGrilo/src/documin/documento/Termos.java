package documin.documento;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Uma classe que representa termos, um tipo de elemento de um documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Termos extends Elemento {
	/**
	 * As palavras contidas nos termos.
	 */
	private String[] palavras;

	/**
	 * Cria novos termos, a partir de seu valor, de sua prioridade e de suas
	 * propriedades, que são seu caractere separador e sua ordem (nenhuma,
	 * alfabética ou por tamanho).
	 * 
	 * @param valor        O valor dos termos.
	 * @param prioridade   A prioridade dos termos.
	 * @param propriedades As propriedades dos termos: caractere separador e ordem
	 *                     (nenhuma, alfabética ou por tamanho).
	 */
	public Termos(String valor, int prioridade, HashMap<String, String> propriedades) {
		super(valor, prioridade, propriedades);
		this.palavras = valor.split(" " + this.propriedades.get("Separador") + " ");
	}

	/**
	 * Retorna a prioridade dos termos.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Retorna a representação completa dos termos, incluindo o total de palavra e
	 * cada palavra separada por vírgulas. A ordem do retorno pode ser a original,
	 * alfabética ou por tamanho.
	 */
	@Override
	public String representacaoCompleta() {
		String out = "Total termos: " + this.palavras.length + System.lineSeparator() + "- ";

		if (this.propriedades.get("Ordem").equals("ALFABÉTICA")) {
			Arrays.sort(this.palavras, String.CASE_INSENSITIVE_ORDER);

		}
		if (this.propriedades.get("Ordem").equals("TAMANHO")) {
			Arrays.sort(this.palavras, new ComparadorTamanho());
		}

		for (int i = 0; i < this.palavras.length - 1; i++) {
			out += this.palavras[i] + ", ";
		}
		out += this.palavras[this.palavras.length - 1];

		return out;
	}

	/**
	 * Retorna a representação resumida dos termos, que consiste em cada palavra
	 * separada pelo caractere separador. A ordem do retorno pode ser a original,
	 * alfabética ou por tamanho.
	 */
	@Override
	public String representacaoResumida() {
		String out = "";

		if (this.propriedades.get("Ordem").equals("ALFABÉTICA")) {
			Arrays.sort(this.palavras, String.CASE_INSENSITIVE_ORDER);

		}
		
		if (this.propriedades.get("Ordem").equals("TAMANHO")) {
			Arrays.sort(this.palavras, new ComparadorTamanho());
		}

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

		if (!(o instanceof Termos)) {
			return false;
		}

		Termos oTermos = (Termos) o;

		return this.representacaoCompleta().equals(oTermos.representacaoCompleta());
	}
}