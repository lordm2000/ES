package es;

import java.util.Scanner;


public class Teste {

	
	public static void mainMenu(){
		
		System.out.println("-------------Bem vindo á biblioteca UPT-------------");
		System.out.println("                 1.Administrador");
		System.out.println("                 2.Aluno/Docente");
		System.out.println("                     0.Sair");
	}
	
	
	public static void menuReq() {
		
		System.out.println("1.Mostrar meus dados");
		System.out.println("2.Mostrar minhas reservas");
		System.out.println("3.Reservar publicação");
		System.out.println("0.Sair");
	}
	
	
	public static void menuAdmin() {
		
		System.out.println("1.Adicionar utilizador");
		System.out.println("2.Mostrar todos os utilizadores");
		System.out.println("3.Adicionar publicação");
		System.out.println("4.Mostrar todas as publicações");
		System.out.println("5.Reservar publicação");
		System.out.println("6.Mostrar todas as reservas de uma dada publicação");
		System.out.println("7.Mostrar todas as reservas de um dado utilizador");
		System.out.println("0.Sair");
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		int res = 0;
		
		Gestor instancia = Gestor.getInstancia();
		
		int op;
		
		mainMenu();
		do {
			op = input.nextInt();
		}
		while(op<0||op>2);
		
		while(op!=0){
			
			switch(op) {
			case 1:{
				System.out.print("Código de acesso: ");
				String cod = input.next();
				
				if(instancia.loginAdmin(cod)) {
					menuAdmin();
					do {
						op = input.nextInt();
					}
					while(op<0||op>7);
					while(op!=0) {
						switch(op) {
						case 1:{
							String tipo;
							System.out.println("Qual o tipo de utilizador(Estudante, Docente ou NDocente)?");
							do {
								tipo = input2.nextLine();
							}
							while(!tipo.equalsIgnoreCase("Estudante") && !tipo.equalsIgnoreCase("Docente") && !tipo.equalsIgnoreCase("NDocente"));
							System.out.print("Número de utilizador: ");
							int num = input.nextInt();
							System.out.print("Password: ");
							String password = input2.nextLine();
							System.out.print("Nome: ");
							String nome = input2.nextLine();
			
							instancia.addUtilizador(tipo, num, password, nome);
						}	
					
						break;
						
						case 2:{
							instancia.imprimeUti();
						}
						break;
						
						
						case 3:{
							System.out.print("Número da Publicação: ");
							int codRef = input.nextInt();
						
							
							System.out.print("Titulo: ");
							String titulo = input2.nextLine();
							System.out.print("Ano: ");
							int ano = input.nextInt();
							
							instancia.addPub(codRef, titulo, ano);
						}
						break;
	
						
						case 4:{
							instancia.imprimePub();
						}
						break;
						
						
						case 5:{
							System.out.print("Código da Publicação: ");
							int codP = input.nextInt();
							System.out.print("Código do utilizador: ");
							int codU = input.nextInt();
							System.out.print("Data: ");
							String data = input.next();
							
							instancia.resPub(res++, data, codU, codP);
						}
						break;
						
						
						case 6:{
							System.out.print("Número da Publicação: ");
							int codP = input.nextInt();
							instancia.imprimeResPub(codP);
						}
						break;
						
						
						case 7:{
							System.out.print("Código do utilizador: ");
							int codU = input.nextInt();
							instancia.imprimeResUti(codU);
						}
						break;
						
						
						
						}
						
						
						menuAdmin();
						do {
							op = input.nextInt();
						}
						while(op<0||op>7);
						
						
					}
				}
				else 
					System.out.println("Código de acesso errado;");
				
				
			}
			
			break;
			
			
			
			
			
			case 2:{
				System.out.print("Numero do Utilizador: ");
				int cod = input.nextInt();
				System.out.print("Password: ");
				String pass = input.next();
				if(instancia.loginUti(cod, pass)!=null) {
					
					menuReq();
					do {
						op = input.nextInt();
					}
					while(op<0||op>3);
					
					while(op!=0) {
						switch(op) {
						case 1:{
							System.out.println(instancia.procUti(cod));
							
						}
						break;
						
						
						case 2:{
							instancia.imprimeResUti(cod);
						}
						break;
						
						case 3:{
							System.out.print("Número da publicação: ");
							int codP = input.nextInt();
							System.out.print("Data: ");
							String data = input.next();
							
							instancia.resPub(res++, data, cod, codP);
						}
						break;
						
						
						}
						menuReq();
						do {
							op = input.nextInt();
						}
						while(op<0||op>3);
					}
				}
					
			}
			break;
			}
			
			mainMenu();
			do {
				op = input.nextInt();
			}
			while(op<0||op>2);
		}
		
		

	}
	
}
