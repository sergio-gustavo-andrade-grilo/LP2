package lab4;

/**
 * Uma representação de uma aposta do sistema Mr. Bet.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class Aposta {

	/**
	 * O nome do time informado na aposta.
	 */
	private String time;

	/**
	 * O nome do campeonato informado na aposta.
	 */
	private String campeonato;

	/**
	 * A colocação informada na aposta.
	 */
	private int colocacao;

	/**
	 * A quantidade de participantes do campeonato.
	 */
	private int participantes;

	/**
	 * O valor a ser apostado.
	 */
	private int valor;

	/**
	 * Cria uma nova aposta, a partir do time, do campeonato, da colocação e do
	 * valor escolhidos.
	 * 
	 * @param time       O time escolhido.
	 * @param campeonato O campeonato em que o time participa.
	 * @param colocacao  A colocação do time no campeonato.
	 * @param valor      O valor apostado.
	 */
	public Aposta(Time time, Campeonato campeonato, int colocacao, int valor) {
		this.time = time.toString();
		this.campeonato = campeonato.getNome();
		this.colocacao = colocacao;
		this.participantes = campeonato.getQuantidadeMaximaParticipantes();
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.time + "\n" + this.campeonato + "\n" + this.colocacao + "/" + this.participantes + "\nR$ "
				+ this.valor + ".00";
	}
}
