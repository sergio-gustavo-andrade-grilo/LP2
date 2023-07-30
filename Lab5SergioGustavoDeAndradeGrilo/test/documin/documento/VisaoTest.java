package documin.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisaoTest {
	private Visao vCom;
	private Visao vRes;
	private Visao vPri;
	private Visao vTit;
	
	@BeforeEach
	void preparaVisao() {
		Documento doc = new Documento("Documento");
		doc.criarTexto("Texto", 5);
		doc.criarTitulo("Título1", 5, 3, true);
		doc.criarTitulo("Título2", 2, 5, false);
		
		vCom = new Visao(doc, "COMPLETA");
		vRes = new Visao(doc, "RESUMIDA");
		vPri = new Visao(doc, "PRIORITÁRIA", 4);
		vTit = new Visao(doc, "TÍTULOS");
	}

	@Test
	void testExibirVisao() {
		String[] repCom = {"Texto", "3. Título1 -- 3-TÍTULO1", "5. Título2"};
		assertTrue(Arrays.equals(vCom.exibirVisao(), repCom));
		
		String[] repRes = {"Texto", "3. Título1", "5. Título2"};
		assertTrue(Arrays.equals(vRes.exibirVisao(), repRes));
		
		String[] repPri = {"Texto", "3. Título1 -- 3-TÍTULO1"};
		assertTrue(Arrays.equals(vPri.exibirVisao(), repPri));
		
		String[] repTit = {"3. Título1", "5. Título2"};
		assertTrue(Arrays.equals(vTit.exibirVisao(), repTit));
		
		Visao vErr = new Visao(new Documento("Documento"), "TIPO_INEXISTENTE");
		assertThrows(IllegalArgumentException.class, () -> vErr.exibirVisao());
	}

}
