package es;


public class Gestor {
	private String password;
	private Utilizador primU;
	private Publicacoes primP;
	
	
	public Gestor(String password) {
		this.password = password;
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
			System.out.println("Utilizador n�o encontrado");
		
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
	public void addUtilizador(int num, String pass, String nome) {
		Utilizador novoU = new Utilizador(num, nome, pass);
		
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
				System.out.println("O n�mero j� est� sendo utilizado");
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
	 * Procurar publica��es
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
	 * Adicionar publica��es
	 * @param numPub
	 * @param titulo
	 * @param ano
	 * @param dispo
	 */
	public void addPub(int numPub, String titulo, int ano, String dispo) {
		Publicacoes novoP = new Publicacoes(numPub,titulo,ano,dispo);
		
		if(procPub(numPub)==null) {
			
				if(primP == null) {
					primP = novoP;
				
					
					System.out.println("Publica��o registrada com sucesso");
				}
					
				
				else {
					
					if(titulo.compareTo(primP.getTitulo())<0) {
						novoP.setProxP(primP);
						primP = novoP;
						
						System.out.println("Publica��o registrada com sucesso");
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
						
						System.out.println("Publica��o registrada com sucesso");
					}
					
				}
			
		}
		
		else
			System.out.println("J� existe publica��o com o n�mero inserido!");
	}
	
	
	/**
	 * Imprimir publica��es
	 */
	public void imprimePub() {
		Publicacoes temp = primP;
		
		while(temp!=null) {
			System.out.println(temp);
			temp = temp.getProxP();
		}
	}
	
	
	/**
	 * Reservar Publica��o
	 * @param codigo
	 * @param data
	 * @param codR
	 * @param codD
	 */
	public void resPub(int codigo, String data, int codU, int codP) {
		
		Utilizador refU = procUti(codU);
		Publicacoes refP = procPub(codP);
		
		if(refU==null) 
			System.out.println("Utilizador n�o encontrado");
		
		else {
			if(refP==null) 
				System.out.println("Publica��o n�o encontrado");
				
			else {
				Reserva novo = new Reserva(codigo,data,refU,refP);
				refP.addRes(novo);
				refU.addRes(novo);
			}	
		}
	}
	
	
	/**
	 * Imprimir reservas de uma dada publica��o
	 * @param cod
	 */
	public void imprimeResPub(int cod) {
		Publicacoes refP = procPub(cod);
		
		if(refP==null)
			System.out.println("Publica��es n�o encontrado");
		
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
			System.out.println("Utilizador n�o encontrado");
		
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
