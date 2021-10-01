package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaCalcularBonusZeroParaSalarioAlto() {
		BonusService bonusService = new BonusService();
		
		assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Funcionario", LocalDate.now() , new BigDecimal("25000"))));	
	
//		try {
//			bonusService.calcularBonus(new Funcionario("Funcionario", LocalDate.now() , new BigDecimal("25000")));
//			fail();
//		} catch (Exception e) {
//			assertEquals("Não tem direito ao bônus", e.getMessage());
//		}
	
	}
	
	@Test
	void deveriaCalcularBonusDe10PorCentoDoSalario() {
		BonusService bonusService = new BonusService();
		BigDecimal calcularBonus = bonusService.calcularBonus(new Funcionario("Funcionario", LocalDate.now() , new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), calcularBonus);	
	}
	
	@Test
	void deveriaCalcularBonusde10PorCentoParaSalarioDe10000() {
		BonusService bonusService = new BonusService();
		BigDecimal calcularBonus = bonusService.calcularBonus(new Funcionario("Funcionario", LocalDate.now() , new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), calcularBonus);	
	}

}
