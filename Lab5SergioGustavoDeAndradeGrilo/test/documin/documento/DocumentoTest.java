package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoTest {
	private Documento d1;
	private Documento d2;
	
	@BeforeEach
	void preparaDocumento() {
		d1 = new Documento("Documento Ilimitado");
		d2 = new Documento("Documento Limitado", 2);
	}
	
	@Test
	void testAdicionarElemento() {
		assertEquals(d1.criarTexto("Texto", 1), 0);
		assertEquals(d1.criarTexto("Texto", 5), 1);
		assertEquals(d1.criarTitulo("Título", 1, 2, true), 2);
		assertEquals(d1.criarLista("A / B / C / D", 4, "/", ">"), 3);
		assertEquals(d1.criarTermos("1 / 2 / 3 / 4", 4, "/", "NENHUM"), 4);
	}
	
	@Test
	void testAdicionarElementoInvalido() {
		assertEquals(d1.criarTexto("Texto", 0), -1);
		assertEquals(d1.criarTexto("Texto", 6), -1);
		
		
		assertEquals(d1.criarTitulo("Título", 0, 1, true), -1);
		assertEquals(d1.criarTitulo("Título", 6, 1, false), -1);
		assertEquals(d1.criarTitulo("Título", 1, 0, true), -1);
		assertEquals(d1.criarTitulo("Título", 1, 6, false), -1);
		assertEquals(d1.criarLista("A / B / C / D", 6, "/", ">"), -1);
		assertEquals(d1.criarLista("A / B / C / D", 0, "/", ">"), -1);
		assertEquals(d1.criarTermos("1 / 2 / 3 / 4", 6, "/", "NENHUM"), -1);
		assertEquals(d1.criarTermos("1 / 2 / 3 / 4", 0, "/", "NENHUM"), -1);
	}

	@Test
	void testAdicionarElementoLimitado() {
		assertEquals(d2.criarTexto("Texto", 1), 0);
		assertEquals(d2.criarTitulo("Título", 1, 1, true), 1);
		
		assertEquals(d2.criarTexto("Texto", 1), -1);
		assertEquals(d2.criarTitulo("Título", 1, 4, true), -1);
		assertEquals(d2.criarLista("A / B / C / D", 4, "/", ">"), -1);
		assertEquals(d2.criarTermos("1 / 2 / 3 / 4", 4, "/", "NENHUM"), -1);
		
		assertEquals(d2.contarElementos(), 2);
		
	}
	
	@Test
	void testContarElementos() {
		assertEquals(d1.contarElementos(), 0);
		
		d1.criarTexto("Texto", 1);
		assertEquals(d1.contarElementos(), 1);
		
		d1.criarTexto("Texto", 0);
		assertEquals(d1.contarElementos(), 1);

	}
	
	@Test
	void testExibirDocumento() {
		String valor = "Texto";
		int prioridade = 1;
		Texto t1 = new Texto(valor, prioridade);
		
		String[] elementos = {t1.representacaoResumida()};
		
		assertEquals(elementos.length, 1);
		
		d1.criarTexto(valor, prioridade);
		assertEquals(d1.contarElementos(), 1);
		
		assertTrue(Arrays.equals(d1.exibirDocumento(), elementos));
		
	}
	
	@Test
	void testGetElementos() {
		String valor = "Texto";
		int prioridade = 1;
		Texto t1 = new Texto(valor, prioridade);
		
		ArrayList<Elemento> elementos = new ArrayList<>();
		elementos.add(t1);
		
		d1.criarTexto(valor, prioridade);
		
		assertEquals(elementos, d1.getElementos());
	}
	
	@Test
	void testPegarRepresentacaoCompleta() {
		d1.criarTexto("ABC", 1);
		assertEquals(d1.pegarRepresentacaoCompleta(0), "ABC");
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		d1.criarTexto("ABC", 1);
		assertEquals(d1.pegarRepresentacaoResumida(0), "ABC");
	}
	
	@Test
	void testApagarElemento() {
		d1.criarTexto("ABC", 1);
		assertEquals(d1.contarElementos(), 1);
		
		assertFalse(d1.apagarElemento(-1));
		assertFalse(d1.apagarElemento(1));
		assertTrue(d1.apagarElemento(0));
		
		assertEquals(d1.contarElementos(), 0);
	}
	
	@Test
	void testMoverParaCima() {
		d1.criarTexto("ABC", 1);
		d1.criarTexto("DEF", 1);
		
		d1.moverParaCima(-1);
		d1.moverParaCima(1);
		
		d1.moverParaCima(0);
		
		String[] out = {"DEF", "ABC"};
		assertTrue(Arrays.equals(d1.exibirDocumento(), out));
	}

	@Test
	void testMoverParaBaixo() {
		d1.criarTexto("ABC", 1);
		d1.criarTexto("DEF", 1);
		
		d1.moverParaBaixo(0);
		d1.moverParaBaixo(2);
		
		d1.moverParaBaixo(1);
		
		String[] out = {"DEF", "ABC"};
		assertTrue(Arrays.equals(d1.exibirDocumento(), out));
	}
	
	@Test
	void testGetSetHasAtalho() {
		assertFalse(d1.getHasAtalho());
		d1.setHasAtalho(true);
		assertTrue(d1.getHasAtalho());
	}
	
	@Test
	void testIncrementaDecrementaAtalho() {
		assertEquals(d1.getVezesAtalho(), 0);
		d1.incrementaVezesAtalho();
		assertEquals(d1.getVezesAtalho(), 1);
		d1.decrementaVezesAtalho();
		assertEquals(d1.getVezesAtalho(), 0);
	}
	
	@Test
	void testCriarAtalho() {
		d1.criarTexto("", 2);
		d2.criarTexto("", 2);
		d2.criarTexto("", 2);
		
		assertEquals(d2.criarAtalho(d1), -1);
		assertEquals(d1.criarAtalho(d2), 1);
	}
	
	@Test
	void testGetTitulo() {
		assertEquals(d1.getTitulo(), "Documento Ilimitado");
	}
}