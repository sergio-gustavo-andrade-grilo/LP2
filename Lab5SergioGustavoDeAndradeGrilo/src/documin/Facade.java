package documin;

import documin.documento.DocumentoController;

/**
 * Uma fachada para chamar os métodos do sistema DocuMin. Representa apenas um
 * ponto de entrada para as demais classes do sistema.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 * 
 */
public class Facade {
	/**
	 * O controlador de documentos do sistema.
	 */
	private DocumentoController documentoController;

	/**
	 * Cria uma nova fachada para o sistema.
	 */
	public Facade() {
		this.documentoController = new DocumentoController();
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
		return this.documentoController.criarDocumento(titulo);
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
		return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
	}

	/**
	 * Remove um documento selecionado a partir do seu título do mapa de documentos.
	 * 
	 * @param titulo O título do documento a ser removido.
	 */
	public void removerDocumento(String titulo) {
		this.documentoController.removerDocumento(titulo);
	}

	/**
	 * Retorna a quantidade de elementos cadastrados em um documento, selecionado a
	 * partir de seu título.
	 * 
	 * @param titulo O título do documento.
	 * @return A quantidade de elementos cadastrados no documento selecionado.
	 */
	public int contarElementos(String titulo) {
		return this.documentoController.contarElementos(titulo);
	}

	/**
	 * Retorna a representação de um documento, selecionado a partir de seu título,
	 * por meio de um array de strings contendo a representação resumida dos seus
	 * elementos.
	 * 
	 * @param titulo O titulo do documento.
	 * @return A representação do documento em um array de strings.
	 */
	public String[] exibirDocumento(String titulo) {
		return this.documentoController.exibirDocumento(titulo);
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
		return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
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
		return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
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
		return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
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
		return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
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
		return this.documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
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
		return this.documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
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
		return this.documentoController.apagarElemento(tituloDoc, elementoPosicao);
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
		this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
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
		this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
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
		return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
	}

	/**
	 * Cria uma nova visão do tipo completa, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		return this.documentoController.criarVisaoCompleta(tituloDoc);
	}

	/**
	 * Cria uma nova visão do tipo resumida, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoResumida(String tituloDoc) {
		return this.documentoController.criarVisaoResumida(tituloDoc);
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
		return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
	}

	/**
	 * Cria uma nova visão do tipo títulos, a partir do título do documento que irá
	 * ser apresentado por ela.
	 * 
	 * @param tituloDoc O documento que irá ser apresentado na visão.
	 * @return A posição da visão na lista de visões.
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		return this.criarVisaoTitulo(tituloDoc);
	}

	/**
	 * Retorna a representação de uma visão, selecionada a partir da sua posição na
	 * lista de visões.
	 * 
	 * @param visaoId A posição da visão na lista de visões.
	 * @return A representação da visão selsecionada.
	 */
	public String[] exibirVisao(int visaoId) {
		return this.exibirVisao(visaoId);
	}

}
