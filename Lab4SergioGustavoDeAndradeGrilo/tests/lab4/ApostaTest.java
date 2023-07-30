package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApostaTest {
	private Time time;
	private Campeonato campeonato;

	private Aposta aposta;
	
	private int colocacao;
	private int valor;

	@BeforeEach
	void setUp() {
		this.time = new Time("250_PB", "Nacional de Patos", "Canário");
		this.campeonato = new Campeonato("Campeonato Paraibano 2023", 14);

		this.aposta = new Aposta(time, campeonato, colocacao, valor);
	}

	@Test
	void testToString() {
		String msg = this.time.toString() + "\n" + this.campeonato.getNome() + "\n" + this.colocacao + "/"
				+ this.campeonato.getQuantidadeMaximaParticipantes() + "\nR$ " + this.valor + ".00";

		assertEquals(this.aposta.toString(), msg);
	}

}