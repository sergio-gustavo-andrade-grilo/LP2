package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermosTest {
	private Termos t1;
	private Termos t2;
	private Termos t3;

	@BeforeEach
	void setUp() {
		HashMap<String, String> propriedades1 = new HashMap<>();
		propriedades1.put("Separador", "/");
		propriedades1.put("Ordem", "NENHUM");

		HashMap<String, String> propriedades2 = new HashMap<>();
		propriedades2.put("Separador", "°");
		propriedades2.put("Ordem", "ALFABÉTICA");

		HashMap<String, String> propriedades3 = new HashMap<>();
		propriedades3.put("Separador", "¬");
		propriedades3.put("Ordem", "TAMANHO");

		t1 = new Termos("Sem / ordem", 1, propriedades1);
		t2 = new Termos("alfabética ° Ordem ° Ordem ° alfabética", 2, propriedades2);
		t3 = new Termos("Ordem ¬ tamanho ¬ Ordem ¬ de ¬ tamanho ¬ de", 3, propriedades3);
	}

	@Test
	void testGetPrioridade() {
		assertEquals(t1.getPrioridade(), 1);
		assertEquals(t2.getPrioridade(), 2);
		assertEquals(t3.getPrioridade(), 3);
	}

	@Test
	void testRepresentacaoCompleta() {
		assertEquals(t1.representacaoCompleta(), "Total termos: 2" + System.lineSeparator() + "- Sem, ordem");
		assertEquals(t2.representacaoCompleta(), "Total termos: 4" + System.lineSeparator() + "- alfabética, alfabética, Ordem, Ordem");
		assertEquals(t3.representacaoCompleta(), "Total termos: 6" + System.lineSeparator() + "- de, de, Ordem, Ordem, tamanho, tamanho");
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals(t1.representacaoResumida(), "Sem / ordem");
		assertEquals(t2.representacaoResumida(), "alfabética ° alfabética ° Ordem ° Ordem");
		assertEquals(t3.representacaoResumida(), "de ¬ de ¬ Ordem ¬ Ordem ¬ tamanho ¬ tamanho");
	}
	
	@Test
	void testEquals() {
		assertNotEquals(t1, null);
		assertNotEquals(t2, true);
		
		HashMap<String, String> propriedades1 = new HashMap<>();
		propriedades1.put("Separador", "/");
		propriedades1.put("Ordem", "NENHUM");

		HashMap<String, String> propriedades2 = new HashMap<>();
		propriedades2.put("Separador", "°");
		propriedades2.put("Ordem", "ALFABÉTICA");

		HashMap<String, String> propriedades3 = new HashMap<>();
		propriedades3.put("Separador", "¬");
		propriedades3.put("Ordem", "TAMANHO");
		
		assertEquals(t1, new Termos("Sem / ordem", 3, propriedades1));
		assertEquals(t2, new Termos("alfabética ° alfabética ° Ordem ° Ordem", 4, propriedades2));
		assertEquals(t3, new Termos("tamanho ¬ tamanho ¬ de ¬ de ¬ Ordem ¬ Ordem", 5, propriedades3));
	}

}
