package es;

public class Reserva {
	private int codReserva;
	private String data;
	private Publicacoes refP;
	private Utilizador refU;
	private Reserva proxPU;
	private Reserva proxUP;
	
	public Reserva(int codReserva, String data, Utilizador refU, Publicacoes refP) {
		this.codReserva=codReserva;
		this.data=data;
		this.refU=refU;
		this.refP=refP;
	}

	public Reserva getProxPU() {
		return proxPU;
	}

	public void setProxPU(Reserva proxPU) {
		this.proxPU = proxPU;
	}

	public Reserva getProxUP() {
		return proxUP;
	}

	public void setProxUP(Reserva proxUP) {
		this.proxUP = proxUP;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public String getData() {
		return data;
	}

	public Publicacoes getRefP() {
		return refP;
	}

	public Utilizador getRefU() {
		return refU;
	}
	
	public String toString() {
		return "Código da reserva: "+codReserva+ "    Data: "+data+"    Número da publicação: "+refP.getNumPub()+"    Número do Utilizador: "+refU.getNumUtilizador();
	}
	
}
