package lab2;

/**
 * Representação da rotina de descanso de um aluno, especificamente de
 * computação, matriculado na UFCG. É necessário definir as horas totais de
 * descanso do aluno, além da quantidade de semanas de estudo do aluno.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Descanso {
	/**
	 * o número total de horas de descanso acumuladas pelo aluno.
	 */
	private int horasDescanso;

	/**
	 * o número de semanas em que o aluno estudou.
	 */
	private int numeroSemanas;

	// BONUS
	private String emoji;

	// BONUS?

	/**
	 * Constrói a rotina de descanso do aluno, a partir das horas de descanso totais
	 * do aluno e do número de semanas. O aluno começa sem nenhuma hora de descanso
	 * nem número de semanas.
	 */
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroSemanas = 0;

		this.emoji = "";
	}

	/**
	 * Estabelece o número de horas de descanso do aluno como o valor passado como
	 * parâmetro.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}

	/**
	 * Estabelece o número de semanas em que o aluno estudou como o valor passado
	 * como parâmetro.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemanas = valor;
	}

	// BONUS?
	/**
	 * Retorna o status geral do aluno, que revela se ele está cansado ou não. Caso
	 * o número de horas de descanso acumuladas por semana seja maior ou igual a 26,
	 * o aluno é considerado descansado. Caso contrário, ele é classificado como
	 * cansado.
	 */
	public String getStatusGeral() {

		String status = "";

		if ((double) this.horasDescanso / this.numeroSemanas >= 26) {
			status += "descansado";
		} else {
			status += "cansado";
		}

		if (!(this.emoji.isEmpty())) {
			status += " - " + this.emoji;
		}

		return status;
	}

	// BONUS
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
}
