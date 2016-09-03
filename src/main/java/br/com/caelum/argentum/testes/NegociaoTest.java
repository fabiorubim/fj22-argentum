package br.com.caelum.argentum.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociaoTest {
	@Test
	public void mesmoMilissegundoEhDoMesmoDIa(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
    public void comHorariosDiferentesEhNoMesmoDia(){
    	//usando GregorianCalendar(ano,mes,dia,hora,minuto)
    	Calendar manha = new GregorianCalendar(2011,10,20,8,30);
    	Calendar tarde = new GregorianCalendar(2011,10,20,15,30);
    	
    	Negociacao negociacao = new Negociacao(40.0,100,manha);
    	Assert.assertTrue(negociacao.isMesmoDia(tarde));
    }
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
		//usando GregorianCalendar(ano,mes,dia,hora,minuto)
    	Calendar setembro = new GregorianCalendar(2011,9,20,8,30);
    	Calendar outubro = new GregorianCalendar(2011,10,20,15,30);
    	
    	Negociacao negociacao = new Negociacao(40.0,100,setembro);
    	Assert.assertFalse(negociacao.isMesmoDia(outubro));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
		//usando GregorianCalendar(ano,mes,dia,hora,minuto)
    	Calendar Ano2011 = new GregorianCalendar(2011,10,20,8,30);
    	Calendar Ano2012 = new GregorianCalendar(2012,10,20,15,30);
    	
    	Negociacao negociacao = new Negociacao(40.0,100,Ano2011);
    	Assert.assertFalse(negociacao.isMesmoDia(Ano2012));
	}
	

}
