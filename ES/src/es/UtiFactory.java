package es;

public class UtiFactory {

	public Utilizador getUtilizador(String tipo, int num, String pass, String nome) {
		if(tipo.equalsIgnoreCase("Estudante")) 
			return new Estudante(num,nome,pass);
		
		else if(tipo.equalsIgnoreCase("Docente"))
			return new Docente(num,nome,pass);
		
		else if(tipo.equalsIgnoreCase("NDocente"))
			return new NDocente(num,nome,pass);
		
		else return null;
	}
}
