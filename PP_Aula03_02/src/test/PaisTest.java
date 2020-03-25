package test;


import static org.junit.Assert.assertEquals;

import javax.print.PrintService;

import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	PrintService paisService;
	static int id = 0;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Vaticano");
		pais.setPopulacao("831");
		pais.setArea("0.44");
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Vaticano");
		copia.setPopulacao("831");
		copia.setArea("0.44");
		paisService = new PrintService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("China");
		fixture.setPopulacao("1415045928");
		fixture.setArea("9388211");
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao("1111111");
		copia.setPopulacao("111111");		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(null);
		copia.setArea(null);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}

	private void assertEquals(String string, Pais pais2, Pais copia2) {
		
		
	}
}