package br.com.caelum.argentum.reader;


import br.com.caelum.argentum.modelo.Negociacao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LeitorXMLTest {

	@Test
	public void carrgaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>"+
							"  <negociacao>"+
							"    <preco>43.5</preco>"+
							"<quantidade>1000</quantidade>"+
							"    <data>"+
							"      <time>1322233344455</time>"+
							"    </data>"+
							"  </negociacao>"+
							"</list>";//xml vai aqui
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco(),0.0001);
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
		
		
		
		
	}

}
