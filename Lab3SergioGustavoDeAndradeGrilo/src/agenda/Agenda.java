package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 * @author Sérgio Gustavo de Andrade Grilo
 *
 */
public class Agenda {

	/**
	 * Uma constante que representa o tamanho padrão de uma agenda de contatos.
	 */
	private static final int TAMANHO_AGENDA = 100;
	
	/**
	 * Uma constante que representa o tamanho padrão de uma agenda de contatos favoritados.
	 */
	private static final int TAMANHO_FAVORITOS = 10;

	/**
	 * Um array que representa uma agenda de contatos.
	 */
	private Contato[] contatos;
	
	/**
	 * Um array que representa uma agenda de contatos favoritados.
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma nova agenda, com um Array de contatos e outro de favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * Acessa a lista de contatos mantida na agenda.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa a lista de favoritos mantida na agenda.
	 * 
	 * @return O array de favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico da agenda.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * 
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return this.contatos[posicao - 1];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
	 * sobrescreve o anterior. Não é possível cadastrar um contato com qualquer
	 * parâmetro vazio, nem um contato que já exista no array de contatos.
	 * 
	 * @param posicao Posição do contato.
	 * @param contato O contato a ser cadastrado.
	 */
	public void cadastraContato(int posicao, Contato contato) {
		if (!nomeVazio(contato) && !telefoneVazio(contato) && posicaoValida(posicao, this.getContatos())) {
			for (Contato c : this.getContatos()) {
				if (c != null && c.equals(contato)) {
					return;
				}

				this.contatos[posicao - 1] = contato;
			}
		}
	}

	/**
	 * Cadastra um contato numa posição no array de favoritos.
	 * 
	 * @param posicaoFavorito a posição do favorito no array de favoritos
	 * @param posicaoContato a posiçãod do cadastro a ser registrado em favoritos.
	 */
	public void cadastraFavorito(int posicaoFavorito, int posicaoContato) {
		this.favoritos[posicaoFavorito - 1] = this.getContato(posicaoContato);
	}

	/**
	 * Remove um favorito do array de favoritos.
	 * 
	 * @param posicao a posição do favorito a ser removido.
	 */
	public void removeFavorito(int posicao) {
		this.favoritos[posicao - 1] = null;
	}

	/**
	 * Retorna se a posição passada está dentro dos limites de umdeterminado Array
	 * de contatos.
	 * 
	 * @param posicao  Posição do contato.
	 * @param contatos O array de contatos cuja posição será analisada.
	 * 
	 * @return Um valor booleano que indica se a posição passada como parãmetro está
	 *         dentro dos limites do Array de contatos.
	 */
	public boolean posicaoValida(int posicao, Contato[] contatos) {
		return 0 <= posicao - 1 && posicao - 1 < contatos.length;
	}

	/**
	 * Retorna se o nome do contato a ser cadastrado é vazio.
	 * 
	 * @param contato O contato a ser cadastrado.
	 * 
	 * @return Um valor booleano que representa se o nome do contato é vazio o não.
	 */
	private boolean nomeVazio(Contato contato) {
		return contato.getNome().isEmpty();
	}

	/**
	 * Retorna se o telefone do contato a ser cadastrado é vazio.
	 * 
	 * @param contato O contato a ser cadastrado.
	 * 
	 * @return Um valor booleano que representa se o telefone do contato é vazio o
	 *         não.
	 */
	private boolean telefoneVazio(Contato contato) {
		return contato.getTelefone().isEmpty();
	}

}
