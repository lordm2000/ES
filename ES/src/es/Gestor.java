package es;


public class Gestor {
	private String password;
	private Utilizador primU;
	private Publicacoes primP;
	private int numRes;
	private static Gestor instancia = new Gestor("admin");
	
	private Gestor(String password) {
		this.password = password;
		numRes=0;
	}
	
	public static Gestor getInstancia() {
		return instancia;
	}
	
	
	/**
	 * Autenticar administrador
	 * @param pass
	 * @return
	 */
	public boolean loginAdmin(String pass) {
		if(pass.equals(password))
			return true;
		
		return false;
	}
	
	
	/**
	 * Autenticar utilizador
	 * @param cod
	 * @param pass
	 * @return 
	 */
	public Utilizador loginUti(int cod, String pass) {
		Utilizador refU=procUti(cod);
		
		if(refU==null)
			System.out.println("Utilizador não encontrado");
		
		else {
			if(!pass.equals(refU.getPassword())) {
				System.out.println("Password errada");
				return null;
			}		
		}
		
		return refU;
	}
	
	
	/**
	 * Adicionar Utilizador
	 * @param num
	 * @param password
	 * @param nome
	 */
	public void addUtilizador(String tipo, int num, String pass, String nome) {
		
		UtiFactory factory = new UtiFactory();

		Utilizador novoU = factory.getUtilizador(tipo, num, pass, nome);
		
		if(novoU==null) {
			System.out.println("Tipo de requisitante inexistente");
		}
		
		else {
			if(primU==null) {
				primU=novoU;
				System.out.println("Utilizador registrado com sucesso");
			}
				
			else {
				if(procUti(num)==null){
					
					if(nome.compareTo(primU.getNome())<0) {
						novoU.setProxU(primU);
						primU = novoU;
						System.out.println("Utilizador registrado com sucesso");
					}
					
					else {
						Utilizador ant = primU;
						Utilizador temp = primU.getProxU();
						
						while(temp!=null && nome.compareTo(temp.getNome())>0)
							temp = temp.getProxU();
						
						novoU.setProxU(temp);
						ant.setProxU(novoU);
						System.out.println("Utilizador registrado com sucesso");
					}
				}
				
				else
					System.out.println("O número já está sendo utilizado");
			}
		}
		
	}
	
	
	/**
	 * Procurar utilizador
	 * @param num
	 * @return
	 */
	public Utilizador procUti(int num) {
		Utilizador temp = primU;
		
		while(temp!=null && temp.getNumUtilizador()!=num) 
			temp = temp.getProxU();
		
		return temp;
	}

	
	/**
	 * Imprimir utilizador
	 */
	public void imprimeUti() {
		Utilizador temp = primU;
		
		while(temp!=null) {
			System.out.println(temp);
			temp = temp.getProxU();
		}
	}
	
	
	/**
	 * Procurar publicações
	 * @param cod
	 * @return
	 */
	public Publicacoes procPub(int cod) {
		Publicacoes d = primP;
		
		while(d!=null && cod!=d.getNumPub())
			d = d.getProxP();
		
		return d;
	}
	
	
	/**
	 * Adicionar publicações
	 * @param numPub
	 * @param titulo
	 * @param ano
	 * @param dispo
	 */
	public void addPub(int numPub, String titulo, int ano) {
		Publicacoes novoP = new Publicacoes(numPub,titulo,ano);
		
		if(procPub(numPub)==null) {
			
				if(primP == null) {
					primP = novoP;
				
					
					System.out.println("Publicação registrada com sucesso");
				}
					
				
				else {
					
					if(titulo.compareTo(primP.getTitulo())<0) {
						novoP.setProxP(primP);
						primP = novoP;
						
						System.out.println("Publicação registrada com sucesso");
					}
					
					else {
						Publicacoes ant = primP;
						Publicacoes temp = primP.getProxP();
						
						while(temp!=null && temp.getTitulo().compareToIgnoreCase(titulo)<0) {
							ant = temp;
							temp = temp.getProxP();
						}
						
						novoP.setProxP(temp);
						ant.setProxP(novoP);
						
						System.out.println("Publicação registrada com sucesso");
					}
					
				}
			
		}
		
		else
			System.out.println("Já existe publicação com o número inserido!");
	}
	
	
	/**
	 * Imprimir publicações
	 */
	public void imprimePub() {
		Publicacoes temp = primP;
		
		while(temp!=null) {
			System.out.println(temp);
			temp = temp.getProxP();
		}
	}
	
	
	/**
	 * Reservar Publicação
	 * @param codigo
	 * @param data
	 * @param codU
	 * @param codP
	 */
	public void resPub(int codigo, String data, int codU, int codP) {
		
		Utilizador refU = procUti(codU);
		Publicacoes refP = procPub(codP);
		
		if(refU==null) 
			System.out.println("Utilizador não encontrado");
		
		else {
			if(refP==null) 
				System.out.println("Publicação não encontrado");
				
			else {
				Reserva novo = new Reserva(codigo,data,refU,refP);
				refP.addRes(novo);
				refU.addRes(novo);
				System.out.println("Reserva efetuada com sucesso");
			}	
		}
	}
	
	/**
	 * Procurar reservar de uma publicação
	 * @param cod
	 * @param numPub
	 * @return
	 */
	public Reserva procRes(int cod, int numPub) {
		Publicacoes pub = procPub(numPub);
		
		Reserva temp = pub.procReserva(cod);
		
		return temp;
	}
	
	
	/**
	 * Imprimir reservas de uma dada publicação
	 * @param cod
	 */
	public void imprimeResPub(int cod) {
		Publicacoes refP = procPub(cod);
		
		if(refP==null)
			System.out.println("Publicações não encontrado");
		
		else {
			refP.imprimeRes();
		}
	}
	
	
	/**
	 * Imprimir reservas de um utilizador
	 * @param cod
	 */
	public void imprimeResUti(int cod) {
		Utilizador refU=procUti(cod);
		
		if(refU==null)
			System.out.println("Utilizador não encontrado");
		
		else {
			refU.imprimeRes();
		}
	}
	
	
	public Utilizador getPrimU() {
		return primU;
	}

	public void setPrimU(Utilizador primU) {
		this.primU = primU;
	}

	public Publicacoes getPrimP() {
		return primP;
	}

	public void setPrimP(Publicacoes primP) {
		this.primP = primP;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
