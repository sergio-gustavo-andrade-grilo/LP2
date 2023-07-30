package documin.documento;


/**
 * Uma classe que representa um texto, que é um tipo de elemento de um
 * documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Texto extends Elemento {

	/**
	 * Cria um novo texto, a partir de seu valor e de sua prioridade.
	 * 
	 * @param valor        O valor do texto a ser criado.
	 * @param prioridade   A prioridade do texto a ser criado.
	 */
	public Texto(String valor, int prioridade) {
		super(valor, prioridade, null);
	}

	/**
	 * Retorna a prioridade do texto.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Retorna a representação completa do texto, composta apenas pelo seu valor. É
	 * igual á representação resumida do texto.
	 */
	@Override
	public String representacaoCompleta() {
		return this.valor;
	}

	/**
	 * Retorna a representação resumida do texto, composta apenas pelo seu valor. É
	 * igual á representação completa do texto.
	 */
	@Override
	public String representacaoResumida() {
		return this.valor;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof Texto)) {
			return false;
		}

		Texto oTexto = (Texto) o;

		return this.representacaoCompleta().equals(oTexto.representacaoCompleta());
	}
}