package documin.documento;

import java.util.HashMap;

/**
 * Uma classe que representa um título, que é um tipo de elemento de um
 * documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Titulo extends Elemento {

	/**
	 * Cria um novo título, a partir de seu valor, de sua prioridade e de suas
	 * propriedades, que são seu nível e se é linkável ou não.
	 * 
	 * @param valor        O valor do título.
	 * @param prioridade   A prioridade do título.
	 * @param propriedades As propriedades do título: nível e linkável.
	 */
	public Titulo(String valor, int prioridade, HashMap<String, String> propriedades) {
		super(valor, prioridade, propriedades);
	}

	/**
	 * Retorna a prioridade do título.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Retorna a representação completa do título, composta por seu nível, seu valor
	 * e, se linkável, seu link.
	 */
	@Override
	public String representacaoCompleta() {
		String nivel = this.propriedades.get("Nível");
		String linkavel = this.propriedades.get("Linkável");

		String out = nivel + ". " + this.valor;

		if (linkavel.equals("true")) {
			out += " -- " + nivel + "-" + this.valor.toUpperCase().replaceAll("\\s+", "");
		}

		return out;
	}

	/**
	 * Retorna a representação resumida do título, composta por seu nível e seu
	 * valor.
	 */
	@Override
	public String representacaoResumida() {
		String nivel = this.propriedades.get("Nível");

		return nivel + ". " + this.valor;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof Titulo)) {
			return false;
		}
		
		Titulo oTitulo = (Titulo) o;
		
		return this.representacaoCompleta().equals(oTitulo.representacaoCompleta());
	}
}