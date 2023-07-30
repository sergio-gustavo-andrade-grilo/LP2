package lab4;

/**
 * Representação de um time de futebol do sistema Mr. Bet.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Time {

	/**
	 * O código identificador do time. Cada time tem um id único.
	 */
	private String codigo;

	/**
	 * O nome do time.
	 */
	private String nome;

	/**
	 * A mascote do time.
	 */
	private String mascote;

	/**
	 * (Bônus) A quantidade de campeonatos aos quais o time pertence.
	 */
	private int frequenciaCampeonatos;

	/**
	 * (Bônus) A quantidade de vezes em que foi apostado no time para que ele
	 * atingisse o primeiro lugar no campeonato.
	 */
	private int popularidadeApostas;

	/**
	 * Cria um novo time, a partir de um código identificador, de um nome e de uma
	 * mascote.
	 * 
	 * @param codigo  O código identificador do time.
	 * @param nome    O nome do time.
	 * @param mascote A mascote do time.
	 */
	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.frequenciaCampeonatos = 0;
		this.popularidadeApostas = 0;
	}

	/**
	 * Retorna o código identificador do time.
	 * 
	 * @return O código identificador do time.
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Retorna o nome do time.
	 * 
	 * @return O nome do time.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * (Bônus) Retorna a freqência com que o time aparece em campeonatos.
	 * 
	 * @return A freqência com que o time aparece em campeonatos.
	 */
	public int getFrequenciaCampeonatos() {
		return this.frequenciaCampeonatos;
	}

	/**
	 * (Bônus) Retorna a popularidade do time em apostas.
	 * 
	 * @return A popularidade do time em apostas.
	 */
	public int getPopularidadeApostas() {
		return this.popularidadeApostas;
	}

	/**
	 * (Bônus) Incrementa a frequência com que o time aparece em campeonatos em 1
	 * unidade.
	 */
	public void incrementarFrequencia() {
		this.frequenciaCampeonatos++;
	}

	/**
	 * (Bônus) Incrementa a popularidade do time em apostas em 1 unidade.
	 */
	public void incrementarPopularidade() {
		this.popularidadeApostas++;
	}

	@Override
	public String toString() {
		return "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
	}

	@Override
	public int hashCode() {
		return this.codigo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Time)) {
			return false;
		}

		Time outroTime = (Time) obj;

		return this.getCodigo().equals(outroTime.getCodigo());
	}
}