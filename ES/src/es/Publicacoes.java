package es;

public class Publicacoes {
	private int numPub;
	private String titulo;
	private int ano;
	private Publicacoes proxP;
	private String dispo;
	
	public Publicacoes(int numPub, String titulo, int ano, String dispo) {
		this.numPub = numPub;
		this.titulo = titulo;
		this.ano = ano;
		this.dispo = dispo;
	}

	public Publicacoes getProxP() {
		return proxP;
	}

	public void setProxP(Publicacoes proxP) {
		this.proxP = proxP;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	public int getNumPub() {
		return numPub;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	public String toString() {
		return "Número de Publicações: " + numPub + "    Titulo: " + titulo + "    Ano: " + ano + "    Disponibilidade: " + dispo ;
	}
	
	
}
