package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtalhoTest {
	private Atalho atalho;
	
	@BeforeEach
	void preparaAtalho() {
		Documento docReferenciado = new Documento("Documento");
		docReferenciado.criarTexto("Texto1", 1);
		docReferenciado.criarTitulo("Título1", 5, 1, true);
		
		this.atalho = new Atalho(docReferenciado);
	}

	@Test
	void testGetPrioridade() {
		assertEquals(this.atalho.getPrioridade(), 3);
	}
	
	@Test
	void testRepresentacaoCompleta() {
		assertEquals(this.atalho.representacaoCompleta(), "1. Título1 -- 1-TÍTULO1");
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals(this.atalho.representacaoResumida(), "1. Título1");
	}
	
	@Test
	void testGetTituloDocReferenciado() {
		assertEquals(this.atalho.getTituloDocReferenciado(), "Documento");
	}

	@Test
	void testEquals() {
		assertNotEquals(this.atalho, null);
		assertNotEquals(this.atalho, 3.14);
		
		Documento doc2 = new Documento("Documento");
		doc2.criarTexto("Texto1", 1);
		doc2.criarTitulo("Título1", 5, 1, true);
		
		Atalho atalho2 = new Atalho(doc2);
		
		assertEquals(this.atalho, atalho2);
		
	}
}
