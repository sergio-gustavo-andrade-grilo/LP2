package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do(a) usuário(a).
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * 
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n---\nMENU\n" + "(C)adastrar Contato\n" + "(L)istar Contatos\n" + "(E)xibir Contato\n"
				+ "(F)avoritos\n" + "(A)dicionar Favorito\n" + "(R)emover Favorito\n" + "(S)air\n" + "\n" + "Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "R":
			removeFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime a lista de contatos favoritados.
	 * 
	 * @param agenda a agenda a ser manipualda.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\nLista de favoritos: ");
		Contato[] favoritos = agenda.getFavoritos();

		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
	}

	/**
	 * Cadastra um contato como favorito no array de favoritos.
	 * 
	 * @param agenda  a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicaoContato = scanner.nextInt();

		if (!agenda.posicaoValida(posicaoContato, agenda.getContatos())
				|| agenda.getContato(posicaoContato) == null) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}

		for (Contato c : agenda.getFavoritos()) {
			if (c != null && c.toString().toLowerCase()
					.equals(agenda.getContato(posicaoContato - 1).toString().toLowerCase())) {
				System.out.println("CONTATO JÁ FAVORITADO");
				return;
			}
		}

		System.out.print("\nPosição> ");
		int posicaoFavorito = scanner.nextInt();

		if (!agenda.posicaoValida(posicaoFavorito, agenda.getFavoritos())) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}

		agenda.cadastraFavorito(posicaoFavorito, posicaoContato);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + (posicaoFavorito) + "!");
	}

	/**
	 * Remove um contato da lista de favoritos em uma determinada posição.
	 * 
	 * @param agenda  a agenda a ser manipulada.
	 * @param scanner o scanner para pedir informações.
	 */
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("\nPosição> ");
		int posicao = scanner.nextInt();

		if (!agenda.posicaoValida(posicao, agenda.getFavoritos())) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}

		if (agenda.getFavoritos()[posicao - 1] == null) {
			System.out.println("FAVORITO INVÁLIDO");
			return;
		}

		agenda.removeFavorito(posicao);
	}

	/**
	 * Imprime lista de contatos da agenda, incluindo a posição, nome e sobrenome de
	 * cada contato.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda, incluindo nome, sobrenome e
	 * telefone do contato. Se o contato for marcado como favorito, um coração derá
	 * exibido antes dessas informações.
	 * 
	 * @param agenda  A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();

		if (!agenda.posicaoValida(posicao, agenda.getContatos()) || agenda.getContato(posicao) == null) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return;
		}

		Contato contato = agenda.getContato(posicao);
		String out = "Dados do contato:\n";

		for (Contato favorito : agenda.getFavoritos()) {
			if (favorito != null && (favorito.equals(contato))) {
				out += "❤️ ";
			}
		}

		out += contato.getNome() + " " + contato.getSobrenome() + "\n" + contato.getTelefone();

		System.out.println(out);
	}

	/**
	 * Formata um contato para impressão na interface.
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return (posicao + 1) + " - " + contato;
	}

	/**
	 * Cadastra um contato em uma determinada posição na agenda.
	 * 
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();

		if (!agenda.posicaoValida(posicao, agenda.getContatos())) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}

		System.out.print("\nNome> ");
		String nome = scanner.next();

		if (nome.isEmpty()) {
			System.out.println("CONTATO INVÁLIDO");
			return;
		}

		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.next();

		if (sobrenome.isEmpty()) {
			System.out.println("CONTATO INVÁLIDO");
			return;
		}

		for (Contato contato : agenda.getContatos()) {
			Contato novoContato = new Contato(nome, sobrenome, "");
			if (contato != null && contato.equals(novoContato)) {
				System.out.println("CONTATO JÁ CADASTRADO");
				return;
			}
		}

		System.out.print("\nTelefone> ");
		String telefone = scanner.next();

		if (telefone.isEmpty()) {
			System.out.println("CONTATO INVÁLIDO");
			return;
		}
		
		Contato contato = new Contato(nome, sobrenome, telefone);
		agenda.cadastraContato(posicao, contato);
	}

	/**
	 * Sai da aplicação, por meio do encerramento de sua execução.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv.
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda          A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();

		int carregados = leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + (carregados - 1) + " registros.");
	}
}
