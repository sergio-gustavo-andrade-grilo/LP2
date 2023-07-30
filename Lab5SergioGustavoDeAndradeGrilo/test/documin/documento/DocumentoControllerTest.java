package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoControllerTest {
	private DocumentoController dC;
	private Throwable e;

	@BeforeEach
	void preparaDocumentoController() {
		this.dC = new DocumentoController();
	}

	@Test
	void testCriarDocumento() {
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarDocumento("  "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarDocumento("  ", 20));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarDocumento("A", 0));
		assertEquals(e.getMessage(), "Erro! O tamanho não pode ser menor ou igual a 0!");

		assertTrue(dC.criarDocumento("DocIlimitado"));
		assertTrue(dC.criarDocumento("DocLimitado", 5));
		assertFalse(dC.criarDocumento("DocIlimitado"));
		assertFalse(dC.criarDocumento("DocLimitado", 10));
	}

	@Test
	void testRemoverDocumento() {
		dC.criarDocumento("Doc");

		e = assertThrows(IllegalArgumentException.class, () -> dC.removerDocumento("  "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.removerDocumento("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertDoesNotThrow(() -> dC.removerDocumento("Doc"));
	}

	@Test
	void testContarElementos() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 1);

		e = assertThrows(IllegalArgumentException.class, () -> dC.contarElementos("  "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.contarElementos("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertEquals(dC.contarElementos("Doc"), 1);

	}

	@Test
	void testExibirDocumento() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.exibirDocumento("  "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.exibirDocumento("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		String[] out = { "Texto" };
		assertTrue(Arrays.equals(dC.exibirDocumento("Doc"), out));
	}

	@Test
	void testCriarTexto() {
		dC.criarDocumento("Doc");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarTexto("  ", "Texto", 3));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarTexto("DocInexistente", "Texto", 3));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertEquals(dC.criarTexto("Doc", "Texto", 3), 0);
	}

	@Test
	void testCriarTitulo() {
		dC.criarDocumento("Doc");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarTitulo("  ", "Título", 3, 3, false));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarTitulo("DocInexistente", "Título", 3, 3, false));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertEquals(dC.criarTitulo("Doc", "Título", 3, 3, false), 0);
	}

	@Test
	void testCriarLista() {
		dC.criarDocumento("Doc");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarLista("   ", "Lista / Lista", 3, "/", "-"));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class,
				() -> dC.criarLista("DocInexistente", "Lista / Lista", 3, "/", "-"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertEquals(dC.criarLista("Doc", "Lista / Lista", 3, "/", "-"), 0);
	}

	@Test
	void testCriarTermos() {
		dC.criarDocumento("Doc");

		e = assertThrows(IllegalArgumentException.class,
				() -> dC.criarTermos("   ", "Termos / Termos", 3, "/", "NENHUM"));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class,
				() -> dC.criarTermos("DocInexistente", "Termos / Termos", 3, "/", "NENHUM"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		assertEquals(dC.criarTermos("Doc", "Termos / Termos", 3, "/", "NENHUM"), 0);
	}

	@Test
	void testPegarRepresentacaoCompleta() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.pegarRepresentacaoCompleta("   ", 0));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.pegarRepresentacaoCompleta("DocInexistente", 0));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.pegarRepresentacaoCompleta("Doc", 0), "Texto");
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.pegarRepresentacaoResumida("   ", 0));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.pegarRepresentacaoResumida("DocInexistente", 0));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.pegarRepresentacaoResumida("Doc", 0), "Texto");
	}
	
	@Test
	void testApagarElemento() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.apagarElemento("   ", 0));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.apagarElemento("DocInexistente", 0));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.apagarElemento("Doc", 0), true);
	}
	
	@Test
	void testMoverParaCima() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto1", 3);
		dC.criarTexto("Doc", "Texto2", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.moverParaCima("    ", 0));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.moverParaCima("DocInexistente", 0));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		dC.moverParaCima("Doc", 0);
	}
	
	@Test
	void testMoverParaBaixo() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto1", 3);
		dC.criarTexto("Doc", "Texto2", 3);

		e = assertThrows(IllegalArgumentException.class, () -> dC.moverParaBaixo("    ", 1));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.moverParaBaixo("DocInexistente", 1));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		dC.moverParaBaixo("Doc", 1);
	}
	
	@Test
	void testCriarAtalho() {
		dC.criarDocumento("Doc1");
		dC.criarTexto("Doc1", "Texto1", 3);
		
		dC.criarDocumento("Doc2");
		dC.criarTexto("Doc2", "Texto2", 3);
		
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarAtalho("Doc1", "   "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");
		e = assertThrows(NoSuchElementException.class, () -> dC.criarAtalho("Doc1", "DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");

		e = assertThrows(IllegalArgumentException.class, () -> dC.criarAtalho("    ", "Doc2"));
		assertEquals(e.getMessage(), "Erro! Título inválido!");
		e = assertThrows(NoSuchElementException.class, () -> dC.criarAtalho("DocInexistente", "Doc2"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.criarAtalho("Doc1", "Doc2"), 1);
		
		e = assertThrows(IllegalStateException.class, () -> dC.criarAtalho("Doc2", "Doc1"));
		assertEquals(e.getMessage(), "O documento não pode ser um atalho!");
		
		dC.criarDocumento("Doc3");
		e = assertThrows(IllegalStateException.class, () -> dC.criarAtalho("Doc3", "Doc1"));
		assertEquals(e.getMessage(), "O atalho não pode ter atalhos!");
		
		dC.apagarElemento("Doc1", 1);
		assertEquals(dC.criarAtalho("Doc3", "Doc1"), 1);
		
	}

	
	@Test
	void testCriarVisaoCompleta() {
		dC.criarDocumento("Doc");
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarVisaoCompleta("    "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarVisaoCompleta("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.criarVisaoCompleta("Doc"), 0);
	}
	
	@Test
	void testCriarVisaoResumida() {
		dC.criarDocumento("Doc");
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarVisaoResumida("    "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarVisaoResumida("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.criarVisaoResumida("Doc"), 0);
	}
	
	@Test
	void testCriarVisaoPrioritaria() {
		dC.criarDocumento("Doc");
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarVisaoPrioritaria("    ", 4));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarVisaoPrioritaria("DocInexistente", 4));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.criarVisaoPrioritaria("Doc", 4), 0);
	}
	
	@Test
	void testCriarVisaoTitulo() {
		dC.criarDocumento("Doc");
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.criarVisaoTitulo("    "));
		assertEquals(e.getMessage(), "Erro! Título inválido!");

		e = assertThrows(NoSuchElementException.class, () -> dC.criarVisaoTitulo("DocInexistente"));
		assertEquals(e.getMessage(), "Erro! Não há documento com esse título!");
		
		assertEquals(dC.criarVisaoTitulo("Doc"), 0);
	}
	
	@Test
	void testExibirVisao() {
		dC.criarDocumento("Doc");
		dC.criarTexto("Doc", "Texto", 3);
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.exibirVisao(-1));
		assertEquals(e.getMessage(), "Erro! ID inválido!");
		
		e = assertThrows(IllegalArgumentException.class, () -> dC.exibirVisao(1));
		assertEquals(e.getMessage(), "Erro! ID inválido!");
		
		dC.criarVisaoCompleta("Doc");
		String[] out = {"Texto"};
		assertTrue(Arrays.equals(dC.exibirVisao(0), out));
	}
}
