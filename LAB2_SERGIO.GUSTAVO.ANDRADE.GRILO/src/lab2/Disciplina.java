package lab2;

/**
 * Representação de uma disciplina cursada por um aluno, especificamente, do
 * curso de ciências da computação da UFCG. Cada disciplina apresenta 4 notas.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Disciplina {

	/**
	 * O nome da disciplina cursada pelo aluno.
	 */
	private String nomeDisciplina;

	/**
	 * A quantidade de horas dedicadas ao estudo da disciplina.
	 */
	private int horasEstudo;

	/**
	 * Um Array contendo as notas da disciplina obtidas pelo aluno.
	 */
	double[] notas;

	// BONUS
	int[] pesos;

	/**
	 * Constrói uma disciplina, sendo necessário apenas passar como parãmetro o seu
	 * nome. Por padrão, é criado um Array de 4 notas; e o número de horas dedicadas
	 * à disciplina é zero.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[4];
	}

	// BONUS
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[numeroDeNotas];
	}

	// BONUS
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[numeroDeNotas];
		this.pesos = pesos;
	}

	/**
	 * Estabelece a quantidade de horas estudadas como o valor do parâmetro passado.
	 * 
	 * @param horas o número de horas a ser estabelecido como o tempo total de
	 *              estudo da disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo = horas;
	}

	/**
	 * Registra uma das notas do aluno, atruibuindo a ela um valor, passado como
	 * parâmetro.
	 * 
	 * @param nota      a enésima nota à qual será atribuído um valor.
	 * @param valorNota o valor atribuído à nota especificada.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Retorna a média aritmética das notas do aluno na disciplina.
	 *
	 * @param notas o Array que contém as notas do aluno.
	 */
	private double calculaMedia(double[] notas) {
		double soma = 0;

		for (double nota : notas) {
			soma += nota;
		}

		return soma / notas.length;
	}

	// BONUS
	private double calculaMedia(double[] notas, int[] pesos) {
		double somaNotas = 0;
		double somaPesos = 0;

		for (int i = 0; i < this.notas.length; i++) {
			somaNotas += notas[i] * pesos[i];
			somaPesos += pesos[i];
		}

		return somaNotas / somaPesos;
	}

	/**
	 * Retorna um valor booleano que representa se o aluno foi aprovado na
	 * disciplina ou não, considerando que, para passar por média, é necessário ter
	 * uma média de 7.0 ou superior.
	 */
	public boolean aprovado() {
		double media = calculaMedia(this.notas);

		return media >= 7.0;
	}

	/**
	 * Retorna uma String contendo diversas informações sobre a disciplina cursada,
	 * incluindo seu nome, o total de horas de estudo dedicadas pelo aluno, a média
	 * dele e as notas obtidas por ele.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia(this.notas) + " [" + this.notas[0]
				+ ", " + this.notas[1] + ", " + this.notas[2] + ", " + this.notas[3] + "]";
	}
}
