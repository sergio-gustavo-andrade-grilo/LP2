package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextoTest {

	private Texto t;
	
	@BeforeEach
	void preparaTexto() {
		t = new Texto("Lorem ipsum dolor sit amet", 5);
	}
	
	@Test
	void testGetPrioridade() {
		assertEquals(t.getPrioridade(), 5);
	}

	@Test
	void testRepresentacaoCompleta() {
		assertEquals(t.representacaoCompleta(), "Lorem ipsum dolor sit amet");
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals(t.representacaoResumida(), "Lorem ipsum dolor sit amet");
	}
	
	@Test
	void testEquals() {
		assertNotEquals(t, null);
		assertNotEquals(t, "Strings não são do tipo Texto");
		assertEquals(t, new Texto("Lorem ipsum dolor sit amet", 6));
	}

}