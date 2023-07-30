package documin.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaTest {
	private Lista l1;

	@BeforeEach
	void preparaLista() {
		HashMap<String, String> propriedades = new HashMap<>();
		propriedades.put("Separador", "/");
		propriedades.put("Caractere", "-");

		l1 = new Lista("Exemplo / de uma lista / de 3 termos", 4, propriedades);
	}

	@Test
	void testGetPrioridade() {
		assertEquals(l1.getPrioridade(), 4);
	}

	@Test
	void testRepresentacaoCompleta() {
		assertEquals(l1.representacaoCompleta(),
				"- Exemplo" + System.lineSeparator() + "- de uma lista" + System.lineSeparator() + "- de 3 termos");
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals(l1.representacaoResumida(),
				"Exemplo / de uma lista / de 3 termos");
	}
	
	@Test
	void testEquals() {
		assertNotEquals(l1, null);
		assertNotEquals(l1, 3);
		
		HashMap<String, String> propriedades = new HashMap<>();
		propriedades.put("Separador", "sep");
		propriedades.put("Caractere", "-");
		
		assertEquals(l1, new Lista("Exemplo sep de uma lista sep de 3 termos", 3, propriedades));
	}

}
