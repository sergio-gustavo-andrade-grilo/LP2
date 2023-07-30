package documin.documento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Um controlador para os documentos do sistema DocuMin. Faz com que seja
 * possível criar e armazenar documentos, assim como adicionar, editar e remover
 * elementos de um documento.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class DocumentoController {

	/**
	 * Um mapa de documentos, em que eles serão aramzenados.
	 */
	private HashMap<String, Documento> documentos;

	/**
	 * Uma lista de visões do documento, em que elas serão armazenadas.
	 */
	private ArrayList<Visao> visoes;

	/**
	 * Cria um novo controlador de documentos, que permite ao sistema realizar
	 * operações referentes a documentos e a elementos.
	 */
	public DocumentoController() {
		this.documentos = new HashMap<String, Documento>();
		this.visoes = new ArrayList<Visao>();
	}

	/**
	 * Cria um novo documento a partir de seu título, que não pode ser nem vazio nem
	 * composto por espaços. Nesse caso, não há limites para o tamanho da lista de
	 * elementos.
	 * 
	 * @param titulo O título do documento a ser criado.
	 * @return Um valor booleano que representa o resultado da operação.
	 */
	public boolean criarDocumento(String titulo) {
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("Erro! Título inválido!");
		}

		if (documentos.containsKey(titulo)) {
			return false;
		}

		Documento documento = new Documento(titulo);
		this.documentos.put(titulo, documento);

		return true;
	}

	/**
	 * Cria um novo documento a partir de seu título e de um tamanho máximo para a
	 * sua lista de elementos. O título não pode ser nem vazio nem composto por
	 * espaços.
	 * 
	 * @param titulo        O título do documento.
	 * @param tamanhoMaximo A quantidade máxima de elementos que o documento pode
	 *                      ter.
	 * @return Um valor booleano que representa o resultado da operação.
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("Erro! Título inválido!");
		}

		if (this.documentos.containsKey(titulo)) {
			return false;
		}

		if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("Erro! O tamanho não pode ser menor ou igual a 0!");
		}

		Documento documento = new Documento(titulo, tamanhoMaximo);
		this.documentos.put(titulo, documento);

		return true;

	}

	/**
	 * Remove um documento selecionado a partir do seu título do mapa de documentos.
	 * 
	 * @param titulo O título do documento a ser removido.
	 */
	public void removerDocumento(String titulo) {
		tratarTituloDoc(titulo);

		this.documentos.remove(titulo);
	}

	/**
	 * Retorna a quantidade de elementos cadastrados em um documento, selecionado a
	 * partir de seu título.
	 * 
	 * @param titulo O título do documento.
	 * @return A quantidade de elementos cadastrados no documento selecionado.
	 */
	public int contarElementos(String titulo) {
		tratarTituloDoc(titulo);

		Documento documento = this.documentos.get(titulo);

		return documento.contarElementos();
	}

	/**
	 * Retrona a representação de um documento, selecionado a partir de seu título,
	 * por meio de um array de strings contendo a representação resumida dos seus
	 * elementos.
	 * 
	 * @param titulo O titulo do documento.
	 * @return A representação do documento em um array de strings.
	 */
	public String[] exibirDocumento(String titulo) {
		tratarTituloDoc(titulo);

		return this.documentos.get(titulo).exibirDocumento();
	}

	// ------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo elemento do tipo texto em um documento selecionado a partir do
	 * seu título. Para criar o texto, são passados como parâmetro o seu valor e a
	 * sua prioridade.
	 * 
	 * @param tituloDoc  O título do documento.
	 * @param valor      O valor do texto a ser criado.
	 * @param prioridade A prioridade do texto a ser criado.
	 * @return A posição do texto na lista de elementos do documento.
	 */
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).criarTexto(valor, prioridade);
	}

	/**
	 * Cria um novo elemento do tipo título em um documento selecionado a partir do
	 * seu título. Para criar o título, são passados como parâmetro o seu valor, sua
	 * prioridade, seu nível e se ele é linkável ou não.
	 * 
	 * @param tituloDoc  O título do documento.
	 * @param valor      O valor do título a ser criado.
	 * @param prioridade A prioridade do título a ser criado.
	 * @param nivel      O nível do título a ser criado.
	 * @param linkavel   Se o título pode ou não ter um link.
	 * @return A posição do título na lista de elementos do documento.
	 */
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).criarTitulo(valor, prioridade, nivel, linkavel);
	}

	/**
	 * Cria um novo elemento do tipo lista em um documento selecionado a partir do
	 * seu título. Para criar a lista, são passados como parâmetro o seu valor, sua
	 * prioridade, seu caractere separador e seu caractere de lsita.
	 * 
	 * @param tituloDoc  O título do documento.
	 * @param valorLista O valor da lista a ser criada.
	 * @param prioridade A prioridade da lista a ser criada.
	 * @param separador  O caractere separador da lista a ser criada.
	 * @param charLista  O caractere de lista da lista a ser criada.
	 * @return A posição da lista na lista de elementos do documento.
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).criarLista(valorLista, prioridade, separador, charLista);
	}

	/**
	 * Cria um novo elemento do tipo termos em um documento selecionado a partir do
	 * seu título. Para criar o elemento do tipo termos, são passados como parâmetro
	 * o seu valor, sua prioridade, seu caractere separador e sua ordem.
	 * 
	 * @param tituloDoc   O título do documento.
	 * @param valorTermos O valor dos termos a serem criados.
	 * @param prioridade  A prioridade dos termons a serem criados.
	 * @param separador   O separador dos termos a serem criados.
	 * @param ordem       A ordem dos termos criados. Pode ser nenhuma, alfabética
	 *                    ou por tamanho.
	 * @return A posição dos termos na lista de elementos do documento.
	 */
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).criarTermos(valorTermos, prioridade, separador, ordem);
	}

	/**
	 * Retorna a representação completa de um elemento, selecionado a partir de sua
	 * posição no documento, que é selecionado a partir de seu título.
	 * 
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação completa do elemento na posição correspondente.
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
	}

	/**
	 * Retorna a representação resumida de um elemento, selecionado a partir de sua
	 * posição no documento, que é selecionado a partir de seu título.
	 * 
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return A representação resumida do elemento na posição correspondente.
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		tratarTituloDoc(tituloDoc);

		return this.documentos.get(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
	}

	/**
	 * Apaga um elemento de um documento, sendo este selecionado a partir de seu
	 * título e aquele selecionado a partir de sua posição.
	 * 
	 * @param tituloDoc       O título do documento.
	 * @param elementoPosicao A posição do elemento no documento.
	 * @return Um valor booleano que indica se o elemento foi removido ou não.
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		tratarTituloDoc(tituloDoc);
		tratarApagarAtalho(tituloDoc, elementoPosicao);
		
		return this.documentos.get(tituloDoc).apagarElemento(elementoPosicao);
	}

	/**
	 * Move, se possível, um elemento uma posição acima na lista do documento que o
	 * contém. O elemento é selecionado a partir de sua posição e o documento é
	 * selecionado a partir de seu título.
	 * 
	 * @param tituloDoc       O título do documento ao qual o elemento pertence.
	 * @param elementoPosicao A posição do elemento a ser movido.
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		tratarTituloDoc(tituloDoc);

		this.documentos.get(tituloDoc).moverParaCima(elementoPosicao);
	}

	/**
	 * Move, se possível, um elemento uma posição abaixo na lista do documento que o
	 * contém. O elemento é selecionado a partir de sua posição e o documento é
	 * selecionado a partir de seu título.
	 * 
	 * @param tituloDoc       O título do documento ao qual o elemento pertence.
	 * @param elementoPosicao A posição do elemento a ser movido.
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		tratarTituloDoc(tituloDoc);

		this.documentos.get(tituloDoc).moverParaBaixo(elementoPosicao);
	}

	// ------------------------------------------------------------------------------------------------------

	/**
	 * Cria, se possível, um atalho a partir do título do documento que ele
	 * referencia. Em seguida, coloca o atalho num documento, selecionado a partir
	 * do seu título. O documento que irá se tornar atalho não pode ter atalhos; e o
	 * documento que irá conter esse atalho não pode ser um atalho.
	 * 
	 * @param tituloDoc             O título do documento que irá conter o atalho.
	 * @param tituloDocReferenciado O título do documento que irá tornar-se um
	 *                              atalho.
	 * @return A posição do atalho no documento que o contém.
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		tratarTituloDoc(tituloDoc);
		tratarTituloDoc(tituloDocReferenciado);

		Documento doc = this.documentos.get(tituloDoc);
		Documento docReferenciado = this.documentos.get(tituloDocReferenciado);

		if (doc.getVezesAtalho() > 0) {
			throw new IllegalStateException("O documento não pode ser um atalho!");
		}

		if (docReferenciado.getHasAtalho()) {
			throw new IllegalStateException("O atalho não pode ter atalhos!");
		}

		doc.setHasAtalho(true);
		docReferenciado.incrementaVezesAtalho();
		return doc.criarAtalho(docReferenciado);
	}

	/**
	 * Cria uma nova visão do tipo completa, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		tratarTituloDoc(tituloDoc);

		Documento doc = this.documentos.get(tituloDoc);
		Visao visao = new Visao(doc, "COMPLETA");

		this.visoes.add(visao);
		return this.visoes.size() - 1;
	}

	/**
	 * Cria uma nova visão do tipo resumida, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoResumida(String tituloDoc) {
		tratarTituloDoc(tituloDoc);

		Documento doc = this.documentos.get(tituloDoc);
		Visao visao = new Visao(doc, "RESUMIDA");

		this.visoes.add(visao);
		return this.visoes.size() - 1;
	}

	/**
	 * Cria uma nova visão do tipo prioritária, a partir do título do documento que
	 * irá ser apresentado por ela e da menor prioridade possível.
	 * 
	 * @param tituloDoc  O documento que irá ser apresentado na visão.
	 * @param prioridade A menor prioridade possível para a visão prioritária.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		tratarTituloDoc(tituloDoc);

		Documento doc = this.documentos.get(tituloDoc);
		Visao visao = new Visao(doc, "PRIORITÁRIA", prioridade);

		this.visoes.add(visao);
		return this.visoes.size() - 1;
	}

	/**
	 * Cria uma nova visão do tipo títulos, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		tratarTituloDoc(tituloDoc);

		Documento doc = this.documentos.get(tituloDoc);
		Visao visao = new Visao(doc, "TÍTULOS");

		this.visoes.add(visao);
		return this.visoes.size() - 1;
	}

	/**
	 * Retorna a representação de uma visão, selecionada a partir da sua posição na
	 * lista de visões.
	 * 
	 * @param visaoId A posição da visão na lista de visões.
	 * @return A representação da visão selsecionada.
	 */
	public String[] exibirVisao(int visaoId) {
		if (visaoId < 0 || visaoId > this.visoes.size() - 1) {
			throw new IllegalArgumentException("Erro! ID inválido!");
		}

		return this.visoes.get(visaoId).exibirVisao();
	}

	/**
	 * Trata o título do documento. Caso ele seja vazio ou composto por espaços,
	 * lança uma exceção do tipo IllegalArgumentException. Caso o mapa de documentos
	 * não contenha o título, lança uma exceção do tipo NoSuchElementException.
	 * 
	 * @param tituloDoc O título do documento a ser tratado.
	 */
	private void tratarTituloDoc(String tituloDoc) {
		if (tituloDoc.isBlank()) {
			throw new IllegalArgumentException("Erro! Título inválido!");
		}

		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("Erro! Não há documento com esse título!");
		}
	}
	
	/**
	 * Reduz a quantidade de vezes que um documento é referenciado como atalho.
	 * 
	 * @param tituloDoc O título do documento que contém o atalho a ser tratado.
	 * @param elementoPosicao A posição do elemento no documento.
	 */
	private void tratarApagarAtalho(String tituloDoc, int elementoPosicao) {
		Elemento e = this.documentos.get(tituloDoc).getElementos().get(elementoPosicao);
		if (e instanceof Atalho) {
			this.documentos.get(((Atalho) e).getTituloDocReferenciado()).decrementaVezesAtalho();
		}
	}

}
