package lab2;

import java.util.Scanner;

public class CoisaBonus {
	public static void main(String[] args) {
		registrarDescansoBonus();
		System.out.println("-----");
		controlarDisciplinaBonus();
		System.out.println("-----");
		registrarResumosBonus();
	}
	
	private static void controlarDisciplinaBonus() {
		int[] pesos = {4, 5, 6, 7};
		Disciplina labProg2 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO 2", 4, pesos);
		labProg2.cadastraHoras(8);
		labProg2.cadastraNota(1, 7.0);
		labProg2.cadastraNota(2, 8.0);
		labProg2.cadastraNota(3, 9.0);
		System.out.println(labProg2.aprovado());
		labProg2.cadastraNota(4, 10.0);
		System.out.println(labProg2.aprovado());
		System.out.println(labProg2.toString());
	}
	
	private static void registrarDescansoBonus() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(42);
		descanso.defineNumeroSemanas(1);
		descanso.definirEmoji("¯\\_(ツ)_/¯");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		descanso.definirEmoji(":(");
		System.out.println(descanso.getStatusGeral());
	}
	
	private static void registrarResumosBonus() {
		Scanner scanner = new Scanner(System.in);
		
		RegistroResumos meusResumos = new RegistroResumos(30);
		
		meusResumos.adiciona("Teste", "Hello World!");
		meusResumos.adiciona("ABC", "A, B e C são as trẽs primeiras letras do alfabeto latino.");
		meusResumos.adiciona("ZZZ", "ZZZ é utilizado para representar o som de um ronco.");
		
		String[] resumos = meusResumos.pegaResumos();
		
		for (String s : resumos) {
			System.out.println(s);
		}
		/*
		System.out.println();
		System.out.println("Digite uma chave de busca:");
		
		String chaveDeBusca = scanner.nextLine();
		
		String[] busca = meusResumos.busca(chaveDeBusca);
		
		for (String s : busca) {
			System.out.println(s);
		}
		*/
		
		scanner.close();
	}
}
