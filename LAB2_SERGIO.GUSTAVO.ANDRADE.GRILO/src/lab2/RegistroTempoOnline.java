package lab2;

/**
 * Representação do registro de tempo online do aluno, que gerencia as
 * informações a respeito da quantidade de horas de internet que ele tem
 * dedicado a uma específica disciplina remota.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class RegistroTempoOnline {
	/**
	 * O nome da disciplina remota cursada pelo aluno
	 */
	private String nomeDisciplina;

	/**
	 * O dobro da quantidade de horas que espera-se que o aluno dedique para cursar
	 * a disciplina especificada.
	 */
	private int tempoOnlineEsperado;

	/**
	 * A quantidade de horas online que o aluno realmente dedicou à disciplina. Essa
	 * quantidade pode, inclusive, ultrapassar a quantidade de horas esperada.
	 */
	private int tempoOnline;

	/**
	 * Constrói um registro de tempo online, utilizando como parâmetro o nome da
	 * disciplina. Por padrão, a quantidade de horas esperada é definida como 120. O
	 * aluno começa com 0 horas dedicadas à disciplina.
	 * 
	 * @param nomeDisciplina o nome da disciplina em que o aluno está matriculado.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
		this.tempoOnline = 0;
	}

	/**
	 * Constrói um registro de tempo online, utilizando como parâmetro não apenas o
	 * nome da disciplina, mas também a quantidade de horas online esperadas.
	 * 
	 * @param nomeDisciplina      o nome da disciplina em que o aluno está
	 *                            matriculado.
	 * @param tempoOnlineEsperado a quantidade de horas que espera-se que o aluno
	 *                            dedique à disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		this.tempoOnline = 0;
	}

	/**
	 * Adiciona a quantidade de tempo passada como parâmetro à quantidade de horas
	 * totais dedicadas ao estudo da disciplina.
	 * 
	 * @param tempo o número de horas a serem adicionadas à quantidade total de
	 *              tempo decidada à disciplina.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}

	/**
	 * Retorna um valor booleano que indica se o aluno atingiu ou não o número de
	 * horas que espera-se que ele dedique ao estudo da dsiciplina.
	 */
	public boolean atingiuMetaTempoOnline() {
		return this.tempoOnline >= this.tempoOnlineEsperado;
	}

	/**
	 * Retorna uma String que representa o registro de tempo online. Essa String
	 * contém o nome da disciplina, o tempo online dedicado e o tempo online
	 * esperado.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoOnline + "/" + this.tempoOnlineEsperado;
	}
}
