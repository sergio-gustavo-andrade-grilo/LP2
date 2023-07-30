package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaMrBetTest {

	private Time time1;
	private Time time2;

	private Campeonato campeonato1;
	private Campeonato campeonato2;

	private SistemaMrBet sistema;

	@BeforeEach
	void preparaSistemaMrBet() {
		this.sistema = new SistemaMrBet();

		this.time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		this.time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");

		this.campeonato1 = new Campeonato("Brasileirão série A 2023", 3);
		this.campeonato2 = new Campeonato("Campeonato Paraibano 2023", 1);

	}

	@Test
	void testIncluirNovoTime() {
		assertEquals(sistema.minhaInclusaoDeTimes(time1), "INCLUSÃO REALIZADA!");

	}

	@Test
	void testIncluirTimeExistente() {
		sistema.minhaInclusaoDeTimes(time1);

		assertEquals(sistema.minhaInclusaoDeTimes(time1), "TIME JÁ EXISTE!");

	}

	@Test
	void testRecuperarTimeExistente() {
		sistema.minhaInclusaoDeTimes(time1);

		assertEquals(sistema.recuperarTime(time1.getCodigo()), time1.toString());
	}

	@Test
	void testRecuperarTimeInexistente() {
		assertEquals(sistema.recuperarTime(time1.getCodigo()), "TIME NÃO EXISTE!");
	}

	@Test
	void testCadastrarCampeonato() {
		assertEquals(sistema.adicionarCampeonato(campeonato1), "CAMPEONATO ADICIONADO!");
	}

	@Test
	void testCadastrarCampeonatoExistente() {
		sistema.adicionarCampeonato(campeonato1);

		assertEquals(sistema.adicionarCampeonato(campeonato1), "CAMPEONATO JÁ EXISTE!");
	}

	@Test
	void testIncluirTimeEmCampeonato() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);
		sistema.minhaInclusaoDeTimes(time2);

		assertEquals(sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome()),
				"TIME INCLUÍDO NO CAMPEONATO!");
		assertEquals(sistema.incluirTimeEmCampeonato(time2.getCodigo(), campeonato1.getNome()),
				"TIME INCLUÍDO NO CAMPEONATO!");

	}

	@Test
	void testIncluirTimeRepetidoEmCampeonato() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);
		sistema.minhaInclusaoDeTimes(time2);

		assertEquals(sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome()),
				"TIME INCLUÍDO NO CAMPEONATO!");
		assertEquals(sistema.incluirTimeEmCampeonato(time2.getCodigo(), campeonato1.getNome()),
				"TIME INCLUÍDO NO CAMPEONATO!");
		assertEquals(sistema.incluirTimeEmCampeonato(time2.getCodigo(), campeonato1.getNome()),
				"TIME INCLUÍDO NO CAMPEONATO!");

		assertEquals(campeonato1.getQuantidadeAtualParticipantes(), 2);

	}

	@Test
	void testCadastrarTimeInexistenteEmCampeonato() {
		sistema.adicionarCampeonato(campeonato1);
		Time t = new Time("005_PB", "test", "test");

		assertEquals(sistema.incluirTimeEmCampeonato(t.getCodigo(), campeonato1.getNome()), "TIME NÃO EXISTE!");

	}

	@Test
	void testCadastrarTimeEmCampeonatoInexistente() {
		sistema.minhaInclusaoDeTimes(time1);
		Campeonato c = new Campeonato("Brasileirão série D 2023", 5);

		assertEquals(sistema.incluirTimeEmCampeonato(time1.getCodigo(), c.getNome()), "CAMPEONATO NÃO EXISTE!");

	}

	@Test
	void testIncluirTimeEmCampeonatoCheio() {
		sistema.adicionarCampeonato(campeonato2);

		sistema.minhaInclusaoDeTimes(time1);
		sistema.minhaInclusaoDeTimes(time2);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato2.getNome());

		assertEquals(sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato2.getNome()),
				"TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");

	}

	@Test
	void verificarSeTimePertenceACampeonato() {
		sistema.adicionarCampeonato(campeonato1);

		sistema.minhaInclusaoDeTimes(time1);
		sistema.minhaInclusaoDeTimes(time2);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		assertEquals(sistema.verificarSeTimeEstaEmCampeonato(time1.getCodigo(), campeonato1.getNome()),
				"O TIME ESTÁ NO CAMPEONATO!");
		assertEquals(sistema.verificarSeTimeEstaEmCampeonato(time2.getCodigo(), campeonato1.getNome()),
				"O TIME NÃO ESTÁ NO CAMPEONATO!");

	}

	@Test
	void verificarSeTimePertenceACampeonatoNaoCadastrado() {
		sistema.minhaInclusaoDeTimes(time1);

		assertEquals(sistema.verificarSeTimeEstaEmCampeonato(time1.getCodigo(), campeonato1.getNome()),
				"CAMPEONATO NÃO EXISTE!");

	}

	@Test
	void testSeTimeNaoCadastradoPertenceACampeonato() {
		sistema.adicionarCampeonato(campeonato1);

		assertEquals(sistema.verificarSeTimeEstaEmCampeonato(time1.getCodigo(), campeonato1.getNome()),
				"TIME NÃO EXISTE!");
	}

	@Test
	void exibirCampeonatos() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		assertEquals(sistema.exibirCampeonatosQueOTimeParticipa(time1.getCodigo()),
				"\nCampeonatos do " + time1.getNome() + "\n* " + campeonato1.toString());
	}

	@Test
	void exibirCampeonatosDeTimeInexistente() {
		sistema.adicionarCampeonato(campeonato1);

		assertEquals(sistema.exibirCampeonatosQueOTimeParticipa(time1.getCodigo()), "TIME NÃO EXISTE!");
	}

	@Test
	void testApostar() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 2, 50), "APOSTA REGISTRADA!");
	}

	@Test
	void testApostarTimeInexistente() {
		sistema.adicionarCampeonato(campeonato1);

		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 2, 50), "TIME NÃO EXISTE!");
	}

	@Test
	void testApostarCampeonatoInexistente() {
		sistema.minhaInclusaoDeTimes(time1);

		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 2, 50), "CAMPEONATO NÃO EXISTE!");
	}

	@Test
	void testApostarTimeForaDoCampeonato() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);

		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 2, 50),
				"O TIME NÃO ESTÁ NO CAMPEONATO!");
	}

	@Test
	void testApostarColocacaoInvalida() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 0, 50), "APOSTA NÃO REGISTRADA!");
		assertEquals(sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 4, 50), "APOSTA NÃO REGISTRADA!");
	}

	@Test
	void testStatusDasApostas() {
		sistema.adicionarCampeonato(campeonato1);
		sistema.minhaInclusaoDeTimes(time1);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 2, 50);

		assertEquals(sistema.statusDasApostas(), "Apostas:\n\n1. " + time1.toString() + "\n" + campeonato1.getNome()
				+ "\n2/" + campeonato1.getQuantidadeMaximaParticipantes() + "\nR$ 50.00\n");

	}

	// (Bônus)
	@Test
	void testHistorico() {
		sistema.adicionarCampeonato(campeonato1);

		sistema.minhaInclusaoDeTimes(time1);
		sistema.minhaInclusaoDeTimes(time2);

		sistema.incluirTimeEmCampeonato(time1.getCodigo(), campeonato1.getNome());

		sistema.apostar(time1.getCodigo(), campeonato1.getNome(), 1, 900);

		assertEquals(sistema.historico(),
				"Participação mais frequente em campeonatos\n" + time1.toString()
						+ "\n\nAinda não participou de campeonato\n" + time2.toString() + "\n\nPopularidade em apostas\n"
						+ time1.getNome() + " / " + time1.getPopularidadeApostas());

	}

}