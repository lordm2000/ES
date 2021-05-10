package es;

import java.util.Scanner;


public class Teste {

	
	public static void mainMenu(){
		
		System.out.println("-------------Bem vindo � biblioteca UPT-------------");
		System.out.println("                 1.Administrador");
		System.out.println("                 2.Aluno/Docente");
		System.out.println("                     0.Sair");
	}
	
	
	public static void menuReq() {
		
		System.out.println("1.Mostrar meus dados");
		System.out.println("2.Mostrar minhas reservas");
		System.out.println("3.Reservar publica��o");
		System.out.println("0.Sair");
	}
	
	
	public static void menuAdmin() {
		
		System.out.println("1.Adicionar utilizador");
		System.out.println("2.Mostrar todos os utilizadores");
		System.out.println("3.Adicionar publica��o");
		System.out.println("4.Mostrar todas as publica��es");
		System.out.println("5.Reservar publica��o");
		System.out.println("6.Mostrar todas as reservas de uma dada publica��o");
		System.out.println("7.Mostrar todas as reservas de um dado utilizador");
		System.out.println("0.Sair");
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		int res = 0;
		Gestor biblio = new Gestor("admin");
		
		int op;
		
		mainMenu();
		do {
			op = input.nextInt();
		}
		while(op<0||op>2);
		
		while(op!=0){
			
			switch(op) {
			case 1:{
				System.out.print("C�digo de acesso: ");
				String cod = input.next();
				
				if(biblio.loginAdmin(cod)) {
					menuAdmin();
					do {
						op = input.nextInt();
					}
					while(op<0||op>7);
					while(op!=0) {
						switch(op) {
						case 1:{
							System.out.print("N�mero de utilizador: ");
							int num = input.nextInt();
							System.out.print("Password: ");
							String password = input2.nextLine();
							System.out.print("Nome: ");
							String nome = input2.nextLine();
			
							biblio.addUtilizador(num, password, nome);
						}	
					
						break;
						
						case 2:{
							biblio.imprimeUti();
						}
						break;
						
						
						case 3:{
							System.out.print("N�mero da Publica��o: ");
							int codRef = input.nextInt();
							String dispo;
							System.out.print("Disponibilidade: ");
							do {
								dispo = input2.nextLine();
							}
							while(!dispo.equalsIgnoreCase("sim") && !dispo.equalsIgnoreCase("nao"));
							
							System.out.print("Titulo: ");
							String titulo = input2.nextLine();
							System.out.print("Ano: ");
							int ano = input.nextInt();
							
							biblio.addPub(codRef, titulo, ano, dispo);
						}
						break;
	
						
						case 4:{
							biblio.imprimePub();
						}
						break;
						
						
						case 5:{
							System.out.print("C�digo da Publica��o: ");
							int codP = input.nextInt();
							System.out.print("C�digo do utilizador: ");
							int codU = input.nextInt();
							System.out.print("Data: ");
							String data = input.next();
							
							biblio.resPub(res++, data, codU, codP);
						}
						break;
						
						
						case 6:{
							System.out.print("N�mero da Publica��o: ");
							int codP = input.nextInt();
							biblio.imprimeResPub(codP);
						}
						break;
						
						
						case 7:{
							System.out.print("C�digo do utilizador: ");
							int codU = input.nextInt();
							biblio.imprimeResUti(codU);
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
					System.out.println("C�digo de acesso errado;");
				
				
			}
			
			break;
			
			
			
			
			
			case 2:{
				System.out.print("Numero do Utilizador: ");
				int cod = input.nextInt();
				System.out.print("Password: ");
				String pass = input.next();
				if(biblio.loginUti(cod, pass)!=null) {
					
					menuReq();
					do {
						op = input.nextInt();
					}
					while(op<0||op>3);
					
					while(op!=0) {
						switch(op) {
						case 1:{
							System.out.println(biblio.procUti(cod));
							
						}
						break;
						
						
						case 2:{
							biblio.imprimeResUti(cod);
						}
						break;
						
						case 3:{
							System.out.print("N�mero da publica��o: ");
							int codP = input.nextInt();
							System.out.print("Data: ");
							String data = input.next();
							
							biblio.resPub(res++, data, cod, codP);
						}
						break;
						
						
						}
						menuReq();
						do {
							op = input.nextInt();
						}
						while(op<0||op>17);
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
