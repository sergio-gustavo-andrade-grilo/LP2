package documin.documento;

import java.util.HashMap;

/**
 * Uma classe abstrata que representa um elemento. Um elemento pode representar
 * um texto, um tópico, uma lista, um conjunto de termos ou até um documento.
 * 
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public abstract class Elemento {
	/**
	 * Uma string que representa os dados do elemento.
	 */
	protected String valor;
	
	/**
	 * A prioridade do elemento. Varia crescentemente de 1 a 5.
	 */
	protected int prioridade;

	/**
	 * Um mapa de strings para strings que representam propriedades particulares dos
	 * elementos.
	 */
	protected HashMap<String, String> propriedades;

	/**
	 * Cria um novo elemento, a partir de sua prioridade, de seu valor e de suas
	 * propriedades.
	 * 
	 * @param prioridade   Um valor inteiro de 1 a 5 que representa a prioridade do
	 *                     elemento.
	 * @param valor        O valor atrelado ao elemento, que representa seus dados.
	 * @param propriedades Um mapa que associa strings a strings que contém
	 *                     propriedades particulares de cada elemento.
	 */
	public Elemento(String valor, int prioridade, HashMap<String, String> propriedades) {
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = propriedades;
	}

	/**
	 * Retorna um valor inteiro que representa a prioridade do elemento.
	 * 
	 * @return Um valor inteiro que representa a prioridade do elemento
	 */
	public abstract int getPrioridade();

	/**
	 * Retorna uma string que contém a representação completa do elemento.
	 * 
	 * @return Uma string que contém a representação completa do elemento.
	 */
	public abstract String representacaoCompleta();

	/**
	 * Retorna uma string que contém a representação resumida do elemento.
	 * 
	 * @return Uma string que contém a representação resumida do elemento.
	 */
	public abstract String representacaoResumida();
}
