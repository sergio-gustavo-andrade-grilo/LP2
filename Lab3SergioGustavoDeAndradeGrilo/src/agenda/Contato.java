package agenda;

/**
 * Uma representação de um contato a ser registrado na agenda.
 * 
 * @author user
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Contato {
	/**
	 * O primeiro nome do contato.
	 */
	private String nome;
	/**
	 * O segundo nome do contato.
	 */
	private String sobrenome;
	/**
	 * O telefone pertencente ao contato.
	 */
	private String telefone;

	/**
	 * Cria um novo contato a partir do nome, sobrenome e telefone passados como
	 * parâmetro.
	 * 
	 * @param nome      o primeiro nome do contato.
	 * @param sobrenome o segundo nome do contato.
	 * @param telefone  o telefone pertencente ao contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Acessa e retorna o nome do contato.
	 * 
	 * @return o primeiro nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Acessa e retorna o sobrenome do contato.
	 * 
	 * @return o segundo nome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}

	/**
	 * Acessa e retorna o telefone do contato.
	 * 
	 * @return o telefone pertencente ao contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}

	@Override
	public boolean equals(Object o) {
		// Verifica se o objeto não é nulo
		if (o == null) {
			return false;
		}

		// Verifica se são da mesma classe
		if (!(o instanceof Contato)) {
			return false;
		}

		// Cria uma referência de classe para o objeto
		Contato oContato = (Contato) o;

		// Verifica se os atributos relevantes são iguais
		return this.toString().toLowerCase().equals(oContato.toString().toLowerCase());
	}
}
