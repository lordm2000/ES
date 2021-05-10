package es;


public class Publicacoes {
	private int numPub;
	private String titulo;
	private int ano;
	private Publicacoes proxP;
	private String dispo;
	private Reserva primRes;
	
	public Publicacoes(int numPub, String titulo, int ano, String dispo) {
		this.numPub = numPub;
		this.titulo = titulo;
		this.ano = ano;
		this.dispo = dispo;
	}
	
	public Reserva getPrimRes() {
		return primRes;
	}

	public void setPrimRes(Reserva primRes) {
		this.primRes = primRes;
	}

	public void addRes(Reserva r) {
		if(primRes==null)
			primRes = r;
		
		else {
			Reserva temp = primRes;
			
			while(temp.getProxUP()!=null)
				temp = temp.getProxUP();
			
			temp.setProxUP(r);
		}
	}
	
	public void imprimeRes() {
		Reserva temp = primRes;
		
		while(temp!=null) {
			System.out.println(temp);
			temp=temp.getProxUP();
		}
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

	public void setDispo() {
		if(dispo.equalsIgnoreCase("Sim"))
			dispo="Nao";
		else
			dispo="Sim";
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
