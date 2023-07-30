package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TituloTest {
	private Titulo t1;
	private Titulo t2;
	
	@BeforeEach
	void preparaTitulo() {
		HashMap<String, String> propriedades1 = new HashMap<>();
		propriedades1.put("Nível", "2");
		propriedades1.put("Linkável", "true");
		
		t1 = new Titulo("Título Linkável", 5, propriedades1);
		
		HashMap<String, String> propriedades2 = new HashMap<>();
		propriedades2.put("Nível", "1");
		propriedades2.put("Linkável", "false");
		
		t2 = new Titulo("Título Não Linkável", 5, propriedades2);
	}
	
	@Test
	void testGetPrioridade() {
		assertEquals(t1.getPrioridade(), 5);
		assertEquals(t1.getPrioridade(), 5);
	}
	
	@Test
	void testRepresentacaoCompleta() {
		assertEquals(t1.representacaoCompleta(), "2. Título Linkável -- 2-TÍTULOLINKÁVEL");
		assertEquals(t2.representacaoCompleta(), "1. Título Não Linkável");
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals(t1.representacaoResumida(), "2. Título Linkável");
		assertEquals(t2.representacaoResumida(), "1. Título Não Linkável");
	}
	
	@Test
	void testEquals() {
		HashMap<String, String> propriedades = new HashMap<>();
		propriedades.put("Nível", "2");
		propriedades.put("Linkável", "true");
		
		
		assertNotEquals(t1, null);
		assertNotEquals(t1, "Strings não são do tipo Titulo");
		assertEquals(t1, new Titulo("Título Linkável", 5, propriedades));
	}

}