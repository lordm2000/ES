package es;


public interface Utilizador {
	

	Reserva getPrimRes();

	void setPrimRes(Reserva primRes);

	Utilizador getProxU();

	void setProxU(Utilizador proxU);

	int getNumUtilizador();

	String getNome();

	String getPassword();
	
	void addRes(Reserva r);
	
	void imprimeRes();
	
	public String toString();
	
	
	
}
