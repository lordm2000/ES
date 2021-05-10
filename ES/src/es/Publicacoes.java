package es;


public class Publicacoes {
	private int numPub;
	private String titulo;
	private int ano;
	private Publicacoes proxP;
	private Reserva primRes;
	
	public Publicacoes(int numPub, String titulo, int ano) {
		this.numPub = numPub;
		this.titulo = titulo;
		this.ano = ano;
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
	
	public Reserva procReserva(int cod) {
		Reserva temp=primRes;
		
		while(temp!=null && temp.getCodReserva()!=cod)
			temp = temp.getProxUP();
		
		
		return temp;
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
		return "Número de Publicações: " + numPub + "    Titulo: " + titulo + "    Ano: " + ano ;
	}
	
	
}
