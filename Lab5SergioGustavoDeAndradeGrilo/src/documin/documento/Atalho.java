package documin.documento;

import java.util.ArrayList;

/**
 * Uma classe que representa um atalho para um documento. Um atalho é um tipo d
 * eelemento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Atalho extends Elemento {
	/**
	 * O título do documento que o atalho referencia.
	 */
	private String tituloDocReferenciado;
	
	/**
	 * Os elementos do documento que o atalho referencia.
	 */
	private ArrayList<Elemento> elementos;

	/**
	 * Cria um novo atalho, a partir do documento que ele referencia.
	 * 
	 * @param docReferenciado O documento que irá tornar-se um atalho.
	 */
	public Atalho(Documento docReferenciado) {
		super(docReferenciado.getTitulo(), 0, null);
		this.tituloDocReferenciado = docReferenciado.getTitulo();
		this.elementos = docReferenciado.getElementos();
		this.prioridade = this.getPrioridade();
	}

	/**
	 * Retorna a prioridade do atalho, que é a média de todas as prioridades dos
	 * elementos do documento que o atalho referencia.
	 */
	@Override
	public int getPrioridade() {
		int out = 0;
		int cont = 0;

		for (Elemento elemento : this.elementos) {
			out += elemento.getPrioridade();
			cont++;
		}
		return out / cont;
	}

	/**
	 * Retorna a concatenação de todas as representações completas dos elementos
	 * contidos no documento referenciado pelo atalho.
	 */
	@Override
	public String representacaoCompleta() {
		String out = "";

		for (Elemento elemento : this.elementos) {
			if (elemento.getPrioridade() >= 4) {
				out += elemento.representacaoCompleta() + System.lineSeparator();
			}
		}
		return out.trim();
	}

	/**
	 * Retorna a concatenação de todas as representações resumidas dos elementos
	 * contidos no documento referenciado pelo atalho.
	 */
	@Override
	public String representacaoResumida() {
		String out = "";

		for (Elemento elemento : this.elementos) {
			if (elemento.getPrioridade() >= 4) {
				out += elemento.representacaoResumida() + System.lineSeparator();
			}
		}
		return out.trim();
	}
	
	/**
	 * Retorna o título do documento referenciado pelo atalho.
	 * @return O título do documento referenciado pelo atalho.
	 */
	public String getTituloDocReferenciado() {
		return this.tituloDocReferenciado;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof Atalho)) {
			return false;
		}

		Atalho oAtalho = (Atalho) o;

		return this.elementos.equals(oAtalho.elementos);

	}

}