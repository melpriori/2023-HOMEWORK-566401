package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;



public class ComandoPrendiTest {
	private Partita partita;
	private Stanza stanzaCorrente;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPieno;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoRiempi;
	private ComandoPrendi comando;
	private Labirinto labirinto;
	private Giocatore giocatore;
	

	@Before
	public void setUp() throws Exception {
		comando = new ComandoPrendi();
		giocatore = new Giocatore();
		labirinto = new Labirinto();
		partita = new Partita();
		attrezzoPesante = new Attrezzo("zaino", 11);
		attrezzo= new Attrezzo("patata", 1);
		attrezzoPieno= new Attrezzo("iphone", 1);
		attrezzoRiempi= new Attrezzo("fazzoletti", 0);
		stanzaCorrente = new Stanza("N11");
		
		stanzaCorrente.addAttrezzo(attrezzo);
		stanzaCorrente.addAttrezzo(attrezzoPieno);
		stanzaCorrente.addAttrezzo(attrezzoPesante);
		
		labirinto.setStanzaCorrente(stanzaCorrente);
		
		partita.setLabirinto(labirinto);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		partita.setGiocatore(giocatore);
		
		
	}
	
	@Test
	public void testPreso() {
		comando.setParametro("patata");
		comando.esegui(partita);
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("patata"));
		
	}
	
	@Test
	public void testNonPresenteInStanza() {
		comando.setParametro("patata");
		comando.esegui(partita);
		assertFalse(this.stanzaCorrente.hasAttrezzo("patata"));
		
	}
	
	@Test
	public void testAttrezzoPesante() {
		comando.setParametro("zaino");
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("zaino"));
		assertTrue(this.stanzaCorrente.hasAttrezzo("zaino"));
		
	}
	
	@Test
	public void testTroppiAttrezzi() {
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		giocatore.getBorsa().addAttrezzo(attrezzoRiempi);
		comando.setParametro("iphone");
		comando.esegui(partita);
		
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("iphone"));
		assertTrue(this.stanzaCorrente.hasAttrezzo("iphone"));
	}
	
//	@Test
//	public void testNonPreso() {
//		assertFalse(this.giocatore.getBorsa().hasAttrezzo("patata"));
//		
//	}
//	
//	@Test
//	public void testPresenteInStanza() {
//		assertTrue(this.stanzaCorrente.hasAttrezzo("patata"));
//		
//	}
	
}
