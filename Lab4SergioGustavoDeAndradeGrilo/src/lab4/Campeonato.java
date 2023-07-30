package lab4;

/**
 * Representação de um campeonato de times.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Campeonato {

	/**
	 * O nome do campeonato.
	 */
	private String nome;

	/**
	 * A quantidade atual de participantes do campeonato. Inicialmente, é 0.
	 */
	private int quantidadeAtualParticipantes;

	/**
	 * A quantidade máxima de participantes do campeonato
	 */
	private int quantidadeMaximaParticipantes;

	/**
	 * Um array que contém os times que participam do campeonato.
	 */
	private Time[] participantes;

	/**
	 * Cria um novo campeonato, a partir do nome e da quantidade de participantes.
	 * 
	 * @param nome                          O nome do campeonato.
	 * @param quantidadeMaximaParticipantes A quantidade máxima de participantes.
	 */
	public Campeonato(String nome, int quantidadeMaximaParticipantes) {
		this.nome = nome;
		this.quantidadeAtualParticipantes = 0;
		this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
		this.participantes = new Time[quantidadeMaximaParticipantes];
	}

	/**
	 * Adiciona um time no campeonato. Caso o número de times adicionados exceda a
	 * quantidade máxima de participantes, o time não será adicionado.
	 * 
	 * @param time O time a ser adicionado no campeonato.
	 * @return Um valor booleano que indica o resultado da operação.
	 */
	public boolean adicionaTime(Time time) {
		if (this.quantidadeAtualParticipantes < this.quantidadeMaximaParticipantes) {
			participantes[this.quantidadeAtualParticipantes] = time;

			this.quantidadeAtualParticipantes++;

			return true;
		}
		return false;
	}

	/**
	 * Retorna o nome do campeonato.
	 * 
	 * @return O nome do campeonato.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o número de times cadastrados atualmente no campeonato.
	 * 
	 * @return O número de times cadastrados atualmente no campeonato.
	 */
	public int getQuantidadeAtualParticipantes() {
		return this.quantidadeAtualParticipantes;
	}

	/**
	 * Retorna a quantidade máxima de times que se pode cadstrar no campeonato.
	 * 
	 * @return A quantidade máxima de times que se pode cadstrar no campeonato.
	 */
	public int getQuantidadeMaximaParticipantes() {
		return this.quantidadeMaximaParticipantes;
	}

	/**
	 * Retorna se o campeonato está cheio, ou seja, se a quantidade atual de
	 * participantes é igual ou maior que a quantiade máxima.
	 * 
	 * @return Um valor booleano que indica se o campeonato está cheio ou não.
	 */
	public boolean isCheio() {
		return this.quantidadeAtualParticipantes >= this.quantidadeMaximaParticipantes;
	}

	/**
	 * Retorna o array de participantes do campeonato.
	 * 
	 * @return O array de participantes do campeonato.
	 */
	public Time[] getParticipantes() {
		return this.participantes.clone();
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.quantidadeAtualParticipantes + "/" + this.quantidadeMaximaParticipantes;
	}

	@Override
	public int hashCode() {
		return this.nome.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Campeonato)) {
			return false;
		}

		Campeonato outroCampeonato = (Campeonato) obj;

		return this.nome.toLowerCase().equals(outroCampeonato.nome.toLowerCase());
	}
}