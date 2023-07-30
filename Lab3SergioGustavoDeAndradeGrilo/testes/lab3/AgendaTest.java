package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

public class AgendaTest {

	private Agenda agendaBase;
	private Contato contatoBase;

	// TODO Mudar isso tudo, acho que não é com assertEquals
	
	@BeforeEach
	void preparaAgenda() {
		this.agendaBase = new Agenda();
		this.contatoBase = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
	}

	@Test
	void testCadastraPosicaoVazia() {
		this.agendaBase.cadastraContato(1, this.contatoBase);
		
		assertEquals(this.agendaBase.getContato(1), this.contatoBase);
	}

	@Test
	void testCadastraPosicaoExistente() {
		this.agendaBase.cadastraContato(1, this.contatoBase);

		Contato novoContato = new Contato("Pedro", "Silva", "(84) 98888-1111");
		this.agendaBase.cadastraContato(1, novoContato);

		assertEquals(this.agendaBase.getContato(1), novoContato);
	}

	@Test
	void testCadastraContatoExistente() {
		this.agendaBase.cadastraContato(1, contatoBase);
		this.agendaBase.cadastraContato(3, contatoBase);

		assertNotEquals(this.agendaBase.getContato(3), contatoBase);
	}

	@Test
	void testPosicaoLimite() {
		this.agendaBase.cadastraContato(100, contatoBase);
		
		assertEquals(this.agendaBase.getContato(100), this.contatoBase);
	}
	
	@Test
	void testAcimaPosicaoLimite() {
		this.agendaBase.cadastraContato(101, contatoBase);
		
		assertNotEquals(this.agendaBase.getContato(100), contatoBase);
	}
	
	@Test
	void testAbaixoPosicaoLimite() {
		this.agendaBase.cadastraContato(0, contatoBase);
		
		assertNotEquals(this.agendaBase.getContato(1), contatoBase);
	}
	
	@Test
	void testTelefoneVazio() {
		Contato contato = new Contato("Matheus", "Gaudencio", "");
		this.agendaBase.cadastraContato(1, contato);
		
		assertNotEquals(this.agendaBase.getContato(1), contato);
	}
	
	@Test
	void testNomeVazio() {
		Contato contato = new Contato("", "Gaudencio", "(83) 99999-0000");
		this.agendaBase.cadastraContato(1, contato);
		
		assertNotEquals(this.agendaBase.getContato(1), contato);
	}
	
	@Test
	void exibirContato() {
		this.agendaBase.cadastraContato(1, contatoBase);
		Contato contato = this.agendaBase.getContato(1);
		
		assertEquals(contato.getNome() + " " + contato.getSobrenome() + "\n" + contato.getTelefone(), "Matheus Gaudencio\n(83) 99999-0000");
	}
	
	@Test
	void exibirContatoSemTelefone() {
		this.agendaBase.cadastraContato(1, contatoBase);
		Contato contato = this.agendaBase.getContato(1);
		
		assertEquals(contato.toString(), "Matheus Gaudencio");
	}

	@Test
	void exibirPosicaoSemContato() {
		assertEquals(null, this.agendaBase.getContato(100));
	}
	
	// TODO Descobrir como fazer depois
	@Test
	void exibirPosicaoSuperior() {
		try {
			this.agendaBase.getContato(101);
			fail("Era esperado uma exceção aqui.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro!");
		}
	}
	
	@Test
	void exibirPosicaoInferior() {
		try {
			this.agendaBase.getContato(0);
			fail("Era esperado uma exceção aqui.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro!");
		}
	}
	
	@Test
	void exibirFavorito() {
		this.agendaBase.cadastraContato(1, contatoBase);
		this.agendaBase.cadastraFavorito(1, 1);
		
		assertEquals(contatoBase, this.agendaBase.getFavoritos()[0]);
	}
	
	@Test
	void adicionarFavorito() {
		this.agendaBase.cadastraContato(1, contatoBase);
		this.agendaBase.cadastraFavorito(1, 1);
		
		assertEquals(contatoBase, this.agendaBase.getFavoritos()[0]);
	}
	
	@Test
	void removerFavorito() {
		this.agendaBase.cadastraContato(1, contatoBase);
		this.agendaBase.cadastraFavorito(1, 1);
		this.agendaBase.removeFavorito(1);
		
		assertEquals(null, this.agendaBase.getFavoritos()[0]);
	}
	
	@Test
	void exibirExFavoritado () {
		this.agendaBase.cadastraContato(1, contatoBase);
		this.agendaBase.cadastraFavorito(1, 1);
		this.agendaBase.removeFavorito(1);
		
		assertEquals(contatoBase, this.agendaBase.getContato(1));
	}
}
