package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {
	private Time time;
	
	@BeforeEach
	void preparaTimes() {
		this.time = new Time("250_PB", "Nacional de Patos", "Canário");
	}
	
	@Test
	void testGetCodigo() {
		assertEquals(this.time.getCodigo(), "250_PB");
	}
	
	@Test
	void testGetNome() {
		assertEquals(this.time.getNome(), "Nacional de Patos");
	}
	
	@Test
	void testToString() {
		assertEquals(this.time.toString(), "[250_PB] Nacional de Patos / Canário");
	}
	
	@Test
	void testEquals() {
		// Todos os atributos iguais.
		Time time2 = new Time("250_PB", "Nacional de Patos", "Canário");
		
		// Mesmo código, nome e mascote diferentes.
		Time time3 = new Time("250_PB", "Sport Lagoa Seca", "Carneiro");
		
		// Código diferente, mesmo nome  e mascote.
		Time time4 = new Time("252_PB", "Nacional de Patos", "Canário");
		
		// Todos os atributos diferentes.
		Time time5 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		
		assertEquals(time, time2);
		assertEquals(time, time3);

		assertNotEquals(time, time4);
		assertNotEquals(time, time5);
	}

}