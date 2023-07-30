package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

public class ContatoTest {

	private Contato contatoBase;

	@BeforeEach
	void preparaContatos() {
		this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
	}

	@Test
	void testNomeCompleto() {
		String msg = "Esperando obter o nome completo";
		assertEquals("Matheus Gaudencio", this.contatoBase.toString(), msg);
	}

	@Test
	void testEquals() {
		Contato contatoComparado = new Contato("Matheus", "Gaudencio", "8666-0078");
		assertEquals(this.contatoBase, contatoComparado);
		assertNotEquals(this.contatoBase, null);
		assertNotEquals(this.contatoBase, "String");
	}
	
	@Test
	void testGetNome() {
		assertEquals("Matheus", this.contatoBase.getNome());
	}
	
	@Test
	void testGetSobrenome() {
		assertEquals("Gaudencio", this.contatoBase.getSobrenome());
	}
	
	@Test
	void testGetTelefone() {
		assertEquals("555-5551", this.contatoBase.getTelefone());
	}
}
