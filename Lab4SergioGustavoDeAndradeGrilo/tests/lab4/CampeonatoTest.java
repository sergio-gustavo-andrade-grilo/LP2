package lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTest {
	private Time time1;
	private Time time2;
	
	private Campeonato campeonato;
	
	@BeforeEach
	void preparaCampeonato() {
		this.time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		this.time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		
		this.campeonato = new Campeonato("Campeonato Paraibano 2023", 14);
	}
	
	@Test
	void testAdicionaTime() {
		try {
			this.campeonato.adicionaTime(time1);
		} catch (Exception e) {
			System.out.println("Erro! Não foi possível adicionar o time!");
		}
	}
	
	@Test
	void testGetNome() {
		assertEquals(this.campeonato.getNome(), "Campeonato Paraibano 2023");
	}
	
	@Test
	void testGetQuantidadeMaximaParticipantes() {
		assertEquals(this.campeonato.getQuantidadeMaximaParticipantes(), 14);
	}
	
	@Test
	void testIsCheio() {
		assertFalse(this.campeonato.isCheio());
	}
	
	@Test
	// ERRO!
	void testGetParticipantes() {
		this.campeonato.adicionaTime(time1);
		this.campeonato.adicionaTime(time2);
		
		Time[] participantesTemp = {time1, time2, null, null, null, null, null, null, null, null, null, null, null, null};
		
		boolean out = Arrays.equals(this.campeonato.getParticipantes(), participantesTemp);
		assertTrue(out);
	}
	
	@Test
	void testToString() {
		assertEquals(this.campeonato.toString(), "Campeonato Paraibano 2023 - 0/14");
	}
	
	@Test
	void testEquals() {
		// Todos os atributos iguais.
		Campeonato campeonato2 = new Campeonato("Campeonato Paraibano 2023", 14);
		
		// Mesmo nome, quantidade de participantes diferentes.
		Campeonato campeonato3 = new Campeonato("Campeonato Paraibano 2023", 22);
		
		// Nome diferente, mesma quantidade de participantes.
		Campeonato campeonato4 = new Campeonato("Brasileirão Série A 2023", 14);
		
		// Todos os atributos diferentes.
		Campeonato campeonato5 = new Campeonato("Brasileirão Série A 2023", 22);
		
		assertEquals(this.campeonato, campeonato2);
		assertEquals(this.campeonato, campeonato3);
		
		assertNotEquals(this.campeonato, campeonato4);
		assertNotEquals(this.campeonato, campeonato5);
	}
	

}