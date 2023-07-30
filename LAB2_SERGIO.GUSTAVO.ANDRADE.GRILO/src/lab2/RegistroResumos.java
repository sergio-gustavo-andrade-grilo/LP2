package lab2;

//TODO Criar uma Classe Resumo em vez de fazer esses Arrays

/**
 * Representa o registro de resumos dos estudos realizados durante o período. Só
 * é possível adicionar um número fixo de resumos.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class RegistroResumos {
	/**
	 * Um Array contendo os temas (títulos) de cada resumo.
	 */
	private String[] temas;

	/**
	 * Um Array contendo os temas (títulos) e os conteúdos dos resumos.
	 */
	private String[] resumos;

	/**
	 * Um contador, para indicar em qual posição adicionar o resumo.
	 */
	private int contador;

	/**
	 * Constrói um registro de resumos, partindo apenas de um número fixo de
	 * resumos.
	 * 
	 * @param numeroDeResumos a quantidade máxima de resumos que se pode adicionar
	 *                        no registro. Caso a quantidade máxima seja atingida,
	 *                        os próximos resumos serão adicionados de forma
	 *                        cíclica, partindo novamente da primeira posição.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.temas = new String[numeroDeResumos];
		this.resumos = new String[numeroDeResumos];
		
		this.contador = 0;
	}

	/**
	 * Adiciona um novo resumo (e seu tema) a os Arrays resumos e temas,
	 * respectivamente. O tema e o conteúdo são necessários para adicionar o resumo.
	 * 
	 * @param tema   o tema do resumo a ser adicionado.
	 * @param resumo o cointeúdo do resumo a ser adicionado. Difere do resumo
	 *               completo, consituindo apenas o conteúdo, sem o tema.
	 */
	public void adiciona(String tema, String resumo) {
		this.temas[this.contador % this.resumos.length] = tema;
		this.resumos[this.contador % this.resumos.length] = resumo;

		this.contador++;
	}

	/**
	 * Retorna o Array de resumos, com seus conteúdos. O texto de cada resumo é
	 * formatado como "Tema: Conteúdo".
	 * 
	 * @return um array de resumos, contendo cada resumo com seu tema e seu
	 *         conteúdo.
	 */
	public String[] pegaResumos() {
		if (contador >= this.resumos.length) {
			String[] auxiliar = new String[this.resumos.length];

			for (int i = 0; i < this.resumos.length; i++) {
				auxiliar[i] = this.temas[i] + ": " + this.resumos[i];
			}

			return auxiliar;

		}

		int cont = this.contador % this.resumos.length;

		String[] auxiliar = new String[cont];

		for (int i = 0; i < cont; i++) {
			if (resumos[i] != null) {
				auxiliar[i] = this.temas[i] + ": " + this.resumos[i];
			}
		}

		return auxiliar;

	}

	/**
	 * Retorna um texto com cada um dos temas (títulos) dos resumos cadastrados,
	 * separados por uma barra vertical (|).
	 * 
	 * @return um texto com cada tema dos resumos cadastrados.
	 */
	public String imprimeResumos() {
		String texto = "- ";

		if (contador >= this.resumos.length) {
			texto += this.resumos.length + " resumo(s) cadastrado(s)\n- ";

			for (int i = 0; i < this.resumos.length - 1; i++) {
				texto = texto + temas[i] + " | ";
			}

			texto += temas[this.resumos.length - 1];

			return texto;

		}

		texto += this.contador % this.resumos.length + " resumo(s) cadastrados\n-";

		for (int i = 0; i < this.contador % this.resumos.length - 1; i++) {
			if (temas[i] != null) {
				texto = texto + temas[i] + " | ";
			}
		}

		texto += temas[this.contador % this.resumos.length - 1];

		return texto;

	}

	/**
	 * Retorna o número de resumos adicionados no registro de resumos, não excedendo
	 * a quantidade máxima de resumos permitidos.
	 * 
	 * @return o número de resumos adicionados no registro de resumos.
	 */
	public int conta() {
		if (this.contador >= this.resumos.length) {
			return this.resumos.length;
		}

		return this.contador % this.resumos.length;
	}

	/**
	 * Retorna um valor booleano que indica se o nome (tema) passado como parâmetro
	 * está contido no Array de temas do registro de resumos.
	 * 
	 * @param nome o nome a ser procurado no Array de resumos.
	 * @return um valor booleano que representa se o nome está ou não no Array de
	 *         resumos.
	 */
	public String temResumo(String nome) {
		boolean inResumo = false;

		for (String tema : temas) {
			if (tema != null && tema.equals(nome)) {
				inResumo = true;
				break;
			}
		}

		return String.valueOf(inResumo);
	}
	
	public String[] busca(String chaveDeBusca) {
		String[] temasAux = new String[this.temas.length];
		String[] resumosAux = new String[this.resumos.length];
		
		for (int i = 0; i < this.resumos.length; i++) {
			temasAux[0] = this.temas[i];
			resumosAux[0] = this.resumos[i];
		}
		
		String temaTemp;
		String resumoTemp;
		
		// Bubble Sort
		for (int i = 0; i < resumosAux.length; i++) {
		    for (int j = i + 1; j < resumosAux.length; j++) {
		        if (resumosAux[i] != null && resumosAux[j] != null && resumosAux[i].compareTo(resumosAux[j]) > 0) {
		            temaTemp = temasAux[i];
		            resumoTemp = resumosAux[i];
		            
		            temasAux[i] = temasAux[j];
		            resumosAux[i] = resumosAux[j];
		            
		            temasAux[j] = temaTemp;
		            resumosAux[j] = resumoTemp;
		        }
		    }
		}
		
		for (String s : resumosAux) {
			System.out.println(s);
		}
		
		String[] busca = new String[resumosAux.length];
		
		for (int i = 0; i < resumosAux.length; i++) {
			if (resumosAux[i] != null && resumosAux[i].contains(chaveDeBusca)) {
				busca[i] = temasAux[i] + ": " + resumosAux[i];
			}
		}
		
		return busca;
		
	}
}
