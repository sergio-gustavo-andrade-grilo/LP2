package lab4;

import java.util.Scanner;

public class MainMrBet {
	public static void main(String[] args) {
		SistemaMrBet sistema = new SistemaMrBet();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String opcao = menu(scanner);
			comando(sistema, opcao, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do usuário, transformando-a em uma string
	 * com caracteres maiúsculos e sem espaços em branco.
	 * 
	 * @param scanner O scanner utilizado para receber a entrada do usuário.
	 * @return O comando escolhido, representado por um único caractere maiúsculo.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("\n" + "---\n" + "MENU\n" + "(M)Minha inclusão de times\n" + "(R)Recuperar time\n"
				+ "(.)Adicionar campeonato\n"
				+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
				+ "(E)Exibir campeonatos que o time participa\n" + "(T)Tentar a sorte e status\n" + "(H)Histórico"
				+ "(!)Já pode fechar o programa!\n" + "\n" + "Opção> ");

		return scanner.nextLine().toUpperCase().trim();
	}

	/**
	 * Interpreta e processa a opção escolhida pelo usuário do sistema.
	 * 
	 * @param sistema O sistema que realiza alguma ação, dependendo da opção
	 *                selecionada.
	 * @param opcao   Opção digitada pelo usuário.
	 * @param scanner Scanner aplicado em comandos que necessitam de entradas do
	 *                usuário.
	 */
	private static void comando(SistemaMrBet sistema, String opcao, Scanner scanner) {
		if (opcao == null) {
			throw new NullPointerException("ERRO! ENTRADA VAZIA!");
		} else if (opcao.isBlank()) {
			throw new IllegalArgumentException("ERRO! ENTRADA VAZIA!");
		}

		String codigo;
		String nome;
		String mascote;
		int numeroParticipantes;

		switch (opcao) {
		case "M":
			System.out.print("Código: ");
			codigo = scanner.nextLine();

			System.out.print("Nome: ");
			nome = scanner.nextLine();

			System.out.print("Mascote: ");
			mascote = scanner.nextLine();

			Time time = new Time(codigo, nome, mascote);

			System.out.println(sistema.minhaInclusaoDeTimes(time));
			break;

		case "R":
			System.out.print("Código: ");
			codigo = scanner.nextLine();

			System.out.println(sistema.recuperarTime(codigo));
			break;

		case ".":
			System.out.print("Campeonato: ");
			nome = scanner.nextLine();

			System.out.print("Participantes: ");
			numeroParticipantes = Integer.parseInt(scanner.nextLine());

			Campeonato campeonato = new Campeonato(nome, numeroParticipantes);

			System.out.println(sistema.adicionarCampeonato(campeonato));
			break;

		case "B":
			// Submenu
			System.out.println(boraIncluirTimeEmCampeonatoEVerificarSeTimeEstáEmCampeonato(sistema, scanner)); 
			break;

		case "E":
			System.out.print("Time: ");
			codigo = scanner.nextLine();

			System.out.println(sistema.exibirCampeonatosQueOTimeParticipa(codigo));
			break;

		case "T":
			// Submenu
			System.out.println(tentarASorteEStatus(sistema, scanner));
			break;

		case "H":
			System.out.println(sistema.historico());
			break;

		case "!":
			System.out.println("\nPor hoje é só, pessoal!");
			System.exit(0);
			break;

		default:
			System.out.println("\nOPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Leva o usuário a um submenu que contém duas opções. Uma delas inclui um time
	 * no campeonato. A outra verifica se o time existe no campeonato.
	 * 
	 * @param sistema O sistema em que os comandos operam.
	 * @param scanner O scanner utilizado para processar as entradas do usuário.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public static String boraIncluirTimeEmCampeonatoEVerificarSeTimeEstáEmCampeonato(SistemaMrBet sistema,
			Scanner scanner) {
		System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String opcao = scanner.nextLine().toUpperCase().trim();

		if (opcao == null) {
			throw new NullPointerException("ERRO! ENTRADA VAZIA!");
		} else if (opcao.isBlank()) {
			throw new IllegalArgumentException("ERRO! ENTRADA VAZIA!");
		}

		String codigo;
		String nome;

		switch (opcao) {
		case "I":
			System.out.print("Código: ");
			codigo = scanner.nextLine();

			System.out.println("Campeonato: ");
			nome = scanner.nextLine();

			return sistema.incluirTimeEmCampeonato(codigo, nome);

		case "V":
			System.out.print("Código: ");
			codigo = scanner.nextLine();

			System.out.println("Campeonato: ");
			nome = scanner.nextLine();

			return sistema.verificarSeTimeEstaEmCampeonato(codigo, nome);

		default:
			return "OPÇÃO INVÁLIDA!";
		}
	}

	/**
	 * Leva o usuário a um submenu que contém duas opções. Uma delas realiza uma
	 * aposta. A outra imprime os status das apostas.
	 * 
	 * @param sistema O sistema em que os comandos operam.
	 * @param scanner O scanner utilizado para processar as entradas do usuário.
	 * @return Uma String que reporta o resultado da utilização do comando.
	 */
	public static String tentarASorteEStatus(SistemaMrBet sistema, Scanner scanner) {
		System.out.print("(A)Apostar ou (S)Status das Apostas? ");
		String opcao = scanner.nextLine().toUpperCase().trim();

		if (opcao == null) {
			throw new NullPointerException("ERRO! ENTRADA VAZIA!");
		} else if (opcao.isBlank()) {
			throw new IllegalArgumentException("ERRO! ENTRADA VAZIA!");
		}

		String codigo;
		String nome;
		int colocacao;
		int valor;

		switch (opcao) {
		case "A":
			System.out.print("Código: ");
			codigo = scanner.nextLine();

			System.out.println("Campeonato: ");
			nome = scanner.nextLine();

			System.out.println("Colocação: ");
			colocacao = Integer.parseInt(scanner.nextLine());

			System.out.println("Valor da Aposta: ");
			valor = scanner.nextInt();
			scanner.nextLine();

			return sistema.apostar(codigo, nome, colocacao, valor);

		case "S":
			return sistema.statusDasApostas();

		default:
			return "OPÇÃO INVÁLIDA!";
		}
	}
}
