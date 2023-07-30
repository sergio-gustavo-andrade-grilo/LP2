package lab4;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * O sistema que gerencia todos os times e campeonatos cadastrados e as
 * operações sobre eles.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class SistemaMrBet {
	/**
	 * Um mapa de times, utilizado para armazená-los.
	 */
	private HashMap<String, Time> times;
	/**
	 * Um mapa de campeonatos, utilizado para armazená-los.
	 */
	private HashMap<String, Campeonato> campeonatos;
	/**
	 * Uma lista de apostas, utilizada para armazená-las.
	 */
	private ArrayList<Aposta> apostas;

	/**
	 * Cria um novo sistema, inicializando os mapa de times e de campeonatos.
	 */
	public SistemaMrBet() {
		this.times = new HashMap<String, Time>();
		this.campeonatos = new HashMap<String, Campeonato>();
		this.apostas = new ArrayList<Aposta>();
	}

	/**
	 * Adiciona um time no mapa de times. Caso o time já exista, ele não será
	 * adicionado.
	 * 
	 * @param time O time a ser adicionado.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public String minhaInclusaoDeTimes(Time time) {

		if (this.times.containsKey(time.getCodigo())) {
			return "TIME JÁ EXISTE!";
		} else {
			this.times.put(time.getCodigo(), time);
			return "INCLUSÃO REALIZADA!";
		}

	}

	/**
	 * Retorna algum time do mapa de times, procurando-o a partir de seu código.
	 * 
	 * @param codigo O código identificador do time a ser procurado.
	 * @return Um time, pertencente ao mapa de times, que possui o mesmo código.
	 *         passado como parâmetro. Caso nenhum time com um código
	 *         correspondente. exista no mapa de times, será retornada uma string
	 *         que informa que o time não existe.
	 */
	public String recuperarTime(String codigo) {
		if (this.times.containsKey(codigo)) {
			return this.times.get(codigo).toString();
		}
		return "TIME NÃO EXISTE!";

	}

	/**
	 * Adiciona um campeonato no mapa de campeonatos. Caso o campeonato já exista,
	 * ele não será adicionado.
	 * 
	 * @param campeonato O campeonato a ser adicionado.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public String adicionarCampeonato(Campeonato campeonato) {

		if (this.campeonatos.containsKey(campeonato.getNome())) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		this.campeonatos.put(campeonato.getNome(), campeonato);
		return "CAMPEONATO ADICIONADO!";

	}

	/**
	 * Inclui um time, a partir do seu código identificador, em um dos campeonatos
	 * do sistema, selecionado a partir de seu nome.
	 * 
	 * @param codigo O código identificador do time a ser incluído em um campeonato.
	 * @param nome   O nome do campeonato em qe o time será incluído.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public String incluirTimeEmCampeonato(String codigo, String nome) {
		if (!this.times.containsKey(codigo)) {
			return "TIME NÃO EXISTE!";
		}

		if (!this.campeonatos.containsKey(nome)) {
			return "CAMPEONATO NÃO EXISTE!";
		}

		Time time = this.times.get(codigo);
		Campeonato campeonato = this.campeonatos.get(nome);

		if (campeonato.isCheio()) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}

		for (Time t : campeonato.getParticipantes()) {
			if (t != null && t.equals(time)) {
				return "TIME INCLUÍDO NO CAMPEONATO!"; // Não adiciona time no campeonato, mas mostra essa mensagem
														// mesmo assim.
			}
		}

		campeonato.adicionaTime(time);
		time.incrementarFrequencia();

		return "TIME INCLUÍDO NO CAMPEONATO!";
	}

	/**
	 * Verifica se um time está incluso em um campeonato, ambos selecionados pelo
	 * usuário.
	 * 
	 * @param codigo O código identificador do time selecionado.
	 * @param nome   O nome do campeonato selecionado.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public String verificarSeTimeEstaEmCampeonato(String codigo, String nome) {
		if (!this.times.containsKey(codigo)) {
			return "TIME NÃO EXISTE!";
		}

		if (!this.campeonatos.containsKey(nome)) {
			return "CAMPEONATO NÃO EXISTE!";
		}

		Time time = this.times.get(codigo);
		Campeonato campeonato = this.campeonatos.get(nome);

		for (Time t : campeonato.getParticipantes()) {
			if (t != null && t.equals(time)) {
				return "O TIME ESTÁ NO CAMPEONATO!";
			}
		}

		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
	}

	/**
	 * Exibe os campeonatos em que o time participa, além da quantidade de times
	 * cadastrados e quantos times o campeonato pode ter, no máximo.
	 * 
	 * @param codigo O código identificador do time selectionado.
	 * @return A listagem de campeonatos aos quais o time pertence.
	 */
	public String exibirCampeonatosQueOTimeParticipa(String codigo) {
		if (!this.times.containsKey(codigo)) {
			return "TIME NÃO EXISTE!";
		}

		Time time = this.times.get(codigo);

		String out = "\nCampeonatos do " + time.getNome();

		for (Campeonato c : this.campeonatos.values()) {
			for (Time t : c.getParticipantes()) {
				if (t != null && t.equals(time)) {
					out += "\n* " + c.toString();
					break;
				}
			}
		}

		return out;
	}

	/**
	 * Realiza uma nova aposta, considerando o código identificador de um time, o
	 * nome de um campeonato, a colocação do time e o valor da aposta passados como
	 * parâmetros.
	 * 
	 * @param codigo    O código identificador do time.
	 * @param nome      O nome do campeonato.
	 * @param colocacao A colocação do time no campeonato.
	 * @param valor     O valor apostado.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public String apostar(String codigo, String nome, int colocacao, int valor) {
		if (!this.times.containsKey(codigo)) {
			return "TIME NÃO EXISTE!";
		}

		if (!this.campeonatos.containsKey(nome)) {
			return "CAMPEONATO NÃO EXISTE!";
		}

		Time time = this.times.get(codigo);
		Campeonato campeonato = this.campeonatos.get(nome);

		if (verificarSeTimeEstaEmCampeonato(codigo, nome).equals("O TIME NÃO ESTÁ NO CAMPEONATO!")) {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}

		if (colocacao <= 0 || colocacao > campeonato.getQuantidadeMaximaParticipantes()) {
			return "APOSTA NÃO REGISTRADA!";
		}

		Aposta aposta = new Aposta(time, campeonato, colocacao, valor);

		this.apostas.add(aposta);

		if (colocacao == 1) {
			time.incrementarPopularidade();
		}

		return "APOSTA REGISTRADA!";
	}

	/**
	 * Retorna um relatório das apostas cadstradas, cada uma com o time, campeonato,
	 * colocação e valor correspondentes.
	 * 
	 * @return Uma String que representa a lista de apostas do sistema.
	 */
	public String statusDasApostas() {
		String out = "Apostas:\n\n";

		for (int i = 0; i < this.apostas.size(); i++) {
			out += (i + 1) + ". " + apostas.get(i).toString() + "\n";
		}

		return out;
	}

	/**
	 * Retorna o histórico do sistema Mr. Bet, informando quais times participam de
	 * mais campeonatos, quais times não estão cadastrados em nenhum campeonato e
	 * quais times possuem popularidade (a quantidade de vezes em que o time foi
	 * avaliado como 1º colocado de um campeonato em uma aposta).
	 * 
	 * @return O histórico do sistema Mr. Bet.
	 */
	public String historico() {
		String out = "Participação mais frequente em campeonatos\n";

		int maiorFrequencia = 0;

		for (Campeonato c : campeonatos.values()) {
			for (Time t : c.getParticipantes()) {
				if (t != null && t.getFrequenciaCampeonatos() > maiorFrequencia) {
					maiorFrequencia = t.getFrequenciaCampeonatos();
				}
			}
		}

		for (Campeonato c : campeonatos.values()) {
			for (Time t : c.getParticipantes()) {
				if (t != null && t.getFrequenciaCampeonatos() == maiorFrequencia) {
					out += t.toString() + "\n";
				}
			}
		}

		out += "\nAinda não participou de campeonato\n";

		for (Time t : this.times.values()) {
			if (t.getFrequenciaCampeonatos() == 0) {
				out += t.toString() + "\n";
			}
		}

		out += "\nPopularidade em apostas\n";

		for (Campeonato c : campeonatos.values()) {
			for (Time t : c.getParticipantes()) {
				if (t != null && t.getPopularidadeApostas() > 0) {
					out += t.getNome() + " / " + t.getPopularidadeApostas();
				}
			}
		}

		return out;
	}

}