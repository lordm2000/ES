package es;

public class Utilizador {
	private int numUtilizador;
	private String nome;
	private String password;
	private Reserva primRes;
	private Utilizador proxU;
	
	public Utilizador(int numUtilizador, String nome, String password) {
		this.numUtilizador = numUtilizador;
		this.nome = nome;
		this.password = password;
	}

	public Reserva getPrimRes() {
		return primRes;
	}

	public void setPrimRes(Reserva primRes) {
		this.primRes = primRes;
	}

	public Utilizador getProxU() {
		return proxU;
	}

	public void setProxU(Utilizador proxU) {
		this.proxU = proxU;
	}

	public int getNumUtilizador() {
		return numUtilizador;
	}

	public String getNome() {
		return nome;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Número de Utilizador: " + numUtilizador + "    Nome: " + nome;
	}
	
	
	
}
