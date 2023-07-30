package documin.documento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Representação de um documento do sistema DocuMin. Cada documento é composto
 * por uma sequência de elementos.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Documento {
	/**
	 * O titulo do documento, que o identifica unicamente. Não pode ser uma String
	 * vazia nem composta apenas por espaços.
	 */
	private String titulo;

	/**
	 * Delimita o número de elementos que um Documento pode ter.
	 */
	private int tamanhoMaximo;

	/**
	 * Uma lista de elementos do documento, em que eles serão armazenados.
	 */
	private ArrayList<Elemento> elementos;

	/**
	 * Um valor inteiro que indica quantas vezes o documento foi referenciado como atalho.
	 */
	private int vezesAtalho;

	/**
	 * Um valor booleano que indica se o documento tem ou não atalhos.
	 */
	private boolean hasAtalho;

	/**
	 * Cria um novo documento, a partir de seu título. Nesse caso, não há limite
	 * para a quantidade máxima de elementos.
	 * 
	 * @param titulo O título do documento a ser criado.
	 */
	public Documento(String titulo) {
		this.titulo = titulo;
		this.tamanhoMaximo = Integer.MAX_VALUE;
		this.elementos = new ArrayList<>();
	}

	/**
	 * Cria um novo documento, a partir de seu título e da quantidade máxima de
	 * elementos que ele pode ter.
	 * 
	 * @param titulo        O título do documento a ser criado.
	 * @param tamanhoMaximo O tamanho máximo da lista de elementos do documento.
	 */
	public Documento(String titulo, int tamanhoMaximo) {
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.elementos = new ArrayList<>();
	}

	/**
	 * Retorna a quantidade de elementos do documento. Se não houver elementos, a
	 * quantidade retornada é 0.
	 * 
	 * @return A quantidade de elementos do documento.
	 */
	public int contarElementos() {
		return this.elementos.size();
	}

	/**
	 * Retorna a representação resumida de cada elemento cadastrado no documento por
	 * meio de um array de strings.
	 * 
	 * @return Um array de strings que contém a representação resumida de cada
	 *         elemento do sistema.
	 */
	public String[] exibirDocumento() {
		String[] out = new String[this.contarElementos()];

		for (int i = 0; i < this.contarElementos(); i++) {
			out[i] = this.elementos.get(i).representacaoResumida();
		}

		return out;
	}

	/**
	 * Cria um novo elemento do tipo texto. Para criar o texto, são passados como
	 * parâmetro o seu valor e a sua prioridade.
	 * 
	 * @param valor      O valor do texto a ser criado.
	 * @param prioridade A prioridade do texto a ser criado.
	 * @return A posição do texto na lista de elementos do documento.
	 */
	public int criarTexto(String valor, int prioridade) {
		if (this.elementos.size() >= this.tamanhoMaximo) {
			return -1;
		}

		if (prioridade < 1 || prioridade > 5) {
			return -1;
		}

		Texto texto = new Texto(valor, prioridade);

		this.elementos.add(texto);
		return this.contarElementos() - 1;
	}

	/**
	 * Cria um novo elemento do tipo título no documento. Para criar o título, são
	 * passados como parâmetro o seu valor, sua prioridade, seu nível e se ele é
	 * linkável ou não.
	 * 
	 * @param valor      O valor do título a ser criado.
	 * @param prioridade A prioridade do título a ser criado.
	 * @param nivel      O nível do título a ser criado.
	 * @param linkavel   Se o título pode ou não ter um link.
	 * @return A posição do título na lista de elementos do documento.
	 */
	public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		if (this.elementos.size() >= this.tamanhoMaximo) {
			return -1;
		}

		if (prioridade < 1 || prioridade > 5) {
			return -1;
		}

		if (nivel < 1 || nivel > 5) {
			return -1;
		}

		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("Nível", String.valueOf(nivel));
		propriedades.put("Linkável", String.valueOf(linkavel));

		Titulo titulo = new Titulo(valor, prioridade, propriedades);

		this.elementos.add(titulo);
		return this.contarElementos() - 1;
	}

	/**
	 * Cria um novo elemento do tipo lista no documento. Para criar a lista, são
	 * passados como parâmetro o seu valor, sua prioridade, seu caractere separador
	 * e seu caractere de lsita.
	 * 
	 * @param valorLista O valor da lista a ser criada.
	 * @param prioridade A prioridade da lista a ser criada.
	 * @param separador  O caractere separador da lista a ser criada.
	 * @param charLista  O caractere de lista da lista a ser criada.
	 * @return A posição da lista na lista de elementos do documento.
	 */
	public int criarLista(String valorLista, int prioridade, String separador, String charLista) {
		if (this.elementos.size() >= this.tamanhoMaximo) {
			return -1;
		}

		if (prioridade < 1 || prioridade > 5) {
			return -1;
		}

		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("Separador", separador);
		propriedades.put("Caractere", charLista);

		Lista lista = new Lista(valorLista, prioridade, propriedades);

		this.elementos.add(lista);
		return this.contarElementos() - 1;
	}

	/**
	 * Cria um novo elemento do tipo termos no documento. Para criar o elemento do
	 * tipo termos, são passados como parâmetro o seu valor, sua prioridade, seu
	 * caractere separador e sua ordem.
	 * 
	 * @param valorTermos O valor dos termos a serem criados.
	 * @param prioridade  A prioridade dos termos a serem criados.
	 * @param separador   O separador dos termos a serem criados.
	 * @param ordem       A ordem dos termos criados. Pode ser nenhuma, alfabética
	 *                    ou por tamanho.
	 * @return A posição dos termos na lista de elementos do documento.
	 */
	public int criarTermos(String valorTermos, int prioridade, String separador, String ordem) {
		if (this.elementos.size() >= this.tamanhoMaximo) {
			return -1;
		}

		if (prioridade < 1 || prioridade > 5) {
			return -1;
		}

		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("Separador", separador);
		propriedades.put("Ordem", ordem);

		Termos termos = new Termos(valorTermos, prioridade, propriedades);

		this.elementos.add(termos);
		return this.contarElementos() - 1;
	}

	/**
	 * Retorna a representação completa de um elemento, selecionado a partir de sua
	 * posição no documento.
	 * 
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação completa do elemento na posição correspondente.
	 */
	public String pegarRepresentacaoCompleta(int elementoPosicao) {
		return this.elementos.get(elementoPosicao).representacaoCompleta();
	}

	/**
	 * Retorna a representação resumida de um elemento, selecionado a partir de sua
	 * posição no documento.
	 * 
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação resumida do elemento na posição correspondente.
	 */
	public String pegarRepresentacaoResumida(int elementoPosicao) {
		return this.elementos.get(elementoPosicao).representacaoResumida();
	}

	/**
	 * Apaga um elemento - selecionado a partir de sua posição - do documento.
	 * 
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return Um valor booleano que indica se o elemento foi removido ou não.
	 */
	public boolean apagarElemento(int elementoPosicao) {
		if (elementoPosicao >= 0 && elementoPosicao < this.contarElementos()) {
			this.elementos.remove(elementoPosicao);
			return true;
		}
		return false;
	}

	/**
	 * Move, se possível, um elemento uma posição acima na lista. O elemento é
	 * selecionado a partir de sua posição.
	 * 
	 * @param elementoPosicao A posição do elemento a ser movido.
	 */
	public void moverParaCima(int elementoPosicao) {
		if (elementoPosicao >= 0 && elementoPosicao < this.contarElementos() - 1) {
			Collections.swap(this.elementos, elementoPosicao, elementoPosicao + 1);
		}
	}

	/**
	 * Move, se possível, um elemento uma posição abaixo na lista. O elemento é
	 * selecionado a partir de sua posição.
	 * 
	 * @param elementoPosicao A posição do elemento a ser movido.
	 */
	public void moverParaBaixo(int elementoPosicao) {
		if (elementoPosicao >= 1 && elementoPosicao < this.contarElementos()) {
			Collections.swap(this.elementos, elementoPosicao, elementoPosicao - 1);
		}
	}

	/**
	 * Retorna a lista de elementos do documento.
	 * 
	 * @return A lista de elementos do documento.
	 */
	public ArrayList<Elemento> getElementos() {
		return this.elementos;
	}

	/**
	 * Retorna se o documento tem algum atalho.
	 * 
	 * @return Se o documento tem algum atalho.
	 */
	public boolean getHasAtalho() {
		return this.hasAtalho;
	}

	/**
	 * Atribui o valor passado para indicar se o documento tem ou não atalhos.
	 * 
	 * @param bool Um valor booleano que indica se o documento tem ou não atalhos.
	 */
	public void setHasAtalho(boolean bool) {
		this.hasAtalho = bool;
	}

	/**
	 * Retorna a quantidade de vezes que um documento foi referenciado como atalho.
	 * 
	 * @return A quantidade de vezes que um documento foi referenciado como atalho.
	 */
	public int getVezesAtalho() {
		return this.vezesAtalho;
	}

	/**
	 * Aumenta a quantidade de vezes que um documento foi referenciado como atalho.
	 */
	public void incrementaVezesAtalho() {
		this.vezesAtalho++;
	}
	
	/**
	 * Diminui a quantidade de vezes que um documento foi referenciado como atalho.
	 */
	public void decrementaVezesAtalho() {
		this.vezesAtalho--;
	}

	/**
	 * Cria um novo atalho, a partir do documento que ele referencia.
	 * 
	 * @param docReferenciado       O documento que irá tornar-se um atalho.
	 * @return A posição do atalho no documento.
	 */

	public int criarAtalho(Documento docReferenciado) {
		if (this.elementos.size() >= this.tamanhoMaximo) {
			return -1;
		}
		
		Atalho atalho = new Atalho(docReferenciado);

		this.elementos.add(atalho);
		return this.contarElementos() - 1;
	}
	
	/**
	 * Retorna o título do documento.
	 * @return O título do documento.
	 */
	public String getTitulo() {
		return this.titulo;
	}

}