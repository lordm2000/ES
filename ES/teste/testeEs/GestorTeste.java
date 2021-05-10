package testeEs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import es.Gestor;

@TestMethodOrder(OrderAnnotation.class)
class GestorTeste {

	static Gestor instancia;
	
	@BeforeAll
	 public static void setup() {
		 System.out.println("Inicializa a classe Gestor antes dos testes");
		 instancia = Gestor.getInstancia();
	 }
	
	@Test
	@Order(1)
	@DisplayName("Teste de inserção de utilizadores")
	void testInsereUtilizador() {
		instancia.addUtilizador("estudante", 222, "222", "Joao Tavares");
		instancia.addUtilizador("docente", 111, "111", "Maria Paula");
		instancia.addUtilizador("Ndocente", 444, "444", "Ana Bastos");
		instancia.addUtilizador("nenhum", 555, "555", "Pedro Soares");
		instancia.addUtilizador("Estudante", 222, "222", "Vasco Silva");
	}
	
	@Test
	@Order(2)
	@DisplayName("Teste de pesquisa de utilizadores")
	void testPesquisaUtilizador() {
		assertEquals(instancia.procUti(222).getNome(),"Joao Tavares");
		assertEquals(instancia.procUti(111).getNome(),"Maria Paula");
		assertEquals(instancia.procUti(444).getNome(),"Ana Bastos");
	}
	
	@Test
	@Order(3)
	@DisplayName("Teste de inserção publicações")
	void testInserePublicacao() {
		instancia.addPub(1, "A ira de Joao Paulo", 2000);
		instancia.addPub(22, "Java", 2010);
	}
	
	@Test
	@Order(4)
	@DisplayName("Teste de pesquisa de publicações")
	void testPesquisaPublicacao() {
		assertEquals(instancia.procPub(1).getAno(),2000);
		assertEquals(instancia.procPub(22).getTitulo(),"Java");
	}
	
	@Test
	@Order(5)
	@DisplayName("Teste de criação de reservas")
	void testInsereReserva() {
		instancia.resPub(1, "21-12-2019", 222, 1);
		instancia.resPub(2, "12-10-2020", 111, 22);
		instancia.resPub(3, "01-04-2019", 222, 1);
	}
	
	@Test
	@Order(6)
	@DisplayName("Teste de pesquisa de reservas")
	void testPesquisaReserva() {
		assertEquals(instancia.procRes(2, 22).getRefU().getNome(),"Maria Paula");
		assertEquals(instancia.procRes(1, 1).getData(),"21-12-2019");
		assertEquals(instancia.procRes(3, 1).getRefP().getTitulo(),"A ira de Joao Paulo");
	}

}
