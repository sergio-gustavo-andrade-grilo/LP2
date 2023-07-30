package documin.documento;

import java.util.ArrayList;

/**
 * Uma visão representa uma forma alternativa de apresentar um documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Visao {
	/**
	 * Os elementos do documento que a visão apresenta.
	 */
	private ArrayList<Elemento> elementos;
	/**
	 * O tipo da visão. Pode ser: completa, resumida, prioritária ou títulos.
	 */
	private String tipoVisao;
	/**
	 * A menor prioridade mostrada em visões prioritárias.
	 */
	private int menorPrioridade;

	/**
	 * Cria uma nova visão, a partir do documento que ela apresenta e do seu tipo.
	 * 
	 * @param doc       O documento que a visão referencia.
	 * @param tipoVisao O tipo da visão. Pode ser: completa, composta pelas
	 *                  representações completas dos elementos do documento;
	 *                  resmida, composta pelas representações resumidas dos
	 *                  elementos do documento; prioritária, composta pelas
	 *                  representações completas dos elementos com prioridade maior
	 *                  ou igual à passada como parâmetro e títulos, composta apenas
	 *                  por títulos.
	 */
	public Visao(Documento doc, String tipoVisao) {
		this.elementos = doc.getElementos();
		this.tipoVisao = tipoVisao;
		this.menorPrioridade = 0;
	}

	/**
	 * Cria uma nova visão, a partir do documento que ela apresenta, do seu tipo e
	 * da menor prioridade dos elementos, necessária para criar uma visão
	 * prioritária.
	 * 
	 * @param doc             O documento que a visão referencia.
	 * @param tipoVisao       O tipo da visão. Pode ser: completa, composta pelas
	 *                        representações completas dos elementos do documento;
	 *                        resmida, composta pelas representações resumidas dos
	 *                        elementos do documento; prioritária, composta pelas
	 *                        representações completas dos elementos com prioridade
	 *                        maior ou igual à passada como parâmetro e títulos,
	 *                        composta apenas por títulos.
	 * @param menorPrioridade A menor prioridade a ser atingida para que um elemento
	 *                        seja adicionado na visão prioritária.
	 */
	public Visao(Documento doc, String tipoVisao, int menorPrioridade) {
		this.elementos = doc.getElementos();
		this.tipoVisao = tipoVisao;
		this.menorPrioridade = menorPrioridade;
	}

	/**
	 * Retorna a representação de uma visão, a depender de seu tipo, num array de
	 * strings.
	 * 
	 * Pode ser:
	 * <ul>
	 * <li>Completa: composta pelas representações completas dos elementos do
	 * documento;</li>
	 * <li>Resumida: composta pelas representações resumidas dos elementos do
	 * documento;</li>
	 * <li>Prioritária: composta pelas representações completas dos elementos com
	 * prioridade maior ou igual à passada como parâmetro;</li>
	 * <li>Títulos, composta apenas por títulos.</li>
	 * </ul>
	 * 
	 * 
	 * @return A representação de uma visão, através de um array de strings.
	 */
	public String[] exibirVisao() {
		String[] out = new String[this.elementos.size()];
		
		
		switch (this.tipoVisao) {
		case "COMPLETA": {
			out = this.visaoCompleta();
			break;
		}
		case "RESUMIDA": {
			out = this.visaoResumida();
			break;
		}
		case "PRIORITÁRIA": {
			out = this.visaoPrioritaria();
			break;
		}
		case "TÍTULOS": {
			out = this.visaoTitulos();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Erro! Tipo de visão inválido!");
		}
		
		return out;
	}

	/**
	 * Retorna a representação completa de cada elemento do documento a ser
	 * apresentado.
	 * 
	 * @return A representação completa de cada elemento do documento a ser
	 *         apresentado.
	 */
	private String[] visaoCompleta() {
		String[] out = new String[this.elementos.size()];

		for (int i = 0; i < this.elementos.size(); i++) {
			out[i] = this.elementos.get(i).representacaoCompleta();
		}

		return out;
	}

	/**
	 * Retorna a representação resumida de cada elemento do documento a ser
	 * apresentado.
	 * 
	 * @return A representação resumida de cada elemento do documento a ser
	 *         apresentado.
	 */
	private String[] visaoResumida() {
		String[] out = new String[this.elementos.size()];

		for (int i = 0; i < this.elementos.size(); i++) {
			out[i] = this.elementos.get(i).representacaoResumida();
		}

		return out;
	}

	/**
	 * Retorna a representação completa de cada elemento do documento a ser
	 * apresentado, caso os elementos possuam prioridade igual ou maior a uma certa
	 * prioridade.
	 * 
	 * @return A representação completa de cada elemento do documento a ser
	 *         apresentado, caso os elementos possuam prioridade igual ou maior a
	 *         uma certa prioridade.
	 */
	private String[] visaoPrioritaria() {
		ArrayList<String> representacoesPrioritarias = new ArrayList<>();

		for (Elemento elemento : this.elementos) {
			if (elemento.getPrioridade() >= menorPrioridade) {
				representacoesPrioritarias.add(elemento.representacaoCompleta());
			}
		}

		String[] out = new String[representacoesPrioritarias.size()];
		out = representacoesPrioritarias.toArray(out);
		return out;
	}

	/**
	 * Retorna a representação resumida de cada elemento do tipo título do documento
	 * a ser apresentado.
	 * 
	 * @return A representação resumida de cada elemento do tipo título do documento
	 *         a ser apresentado.
	 */
	private String[] visaoTitulos() {
		ArrayList<String> representacoesTitulos = new ArrayList<>();

		for (Elemento elemento : this.elementos) {
			if (elemento instanceof Titulo) {
				representacoesTitulos.add(elemento.representacaoResumida());
			}
		}

		String[] out = new String[representacoesTitulos.size()];
		out = representacoesTitulos.toArray(out);
		return out;
	}
}