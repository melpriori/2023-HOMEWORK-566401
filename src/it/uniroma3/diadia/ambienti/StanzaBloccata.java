package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private String direzioneBloccata;
	

	public StanzaBloccata(String nome,String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.setAttrezzoSbloccante(attrezzoSbloccante);
		this.setDirezioneBloccata(direzioneBloccata);
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.attrezzoSbloccante) && direzione==this.direzioneBloccata) {
			return this;
		}
		else {
			Stanza stanza = null;
			for(int i=0; i<this.getNumeroStanzeAdiacenti(); i++)
				if (this.getDirezione(i).equals(direzione))
					stanza = this.getStanzaAdiacente(i);
			return stanza;
		}
	}
	
	@Override
	public String getDescrizione() {
		
		return this.toString() + "\nL'attrezzo bloccante è: " + this.attrezzoSbloccante +
				"\nLa direzione bloccata è: " + this.direzioneBloccata;
	}
	
	public String getAttrezzoSbloccante() {
		return attrezzoSbloccante;
	}

	public void setAttrezzoSbloccante(String attrezzoSbloccante) {
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}
}
