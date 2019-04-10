package tree;

public class Noeud {
	
	private int valeur;
	private int niveau;
	private Noeud gauche;
	private Noeud droite;
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	static final String Tabulation = "    ";
	
	public Noeud(int valeur) {
		super();
		this.valeur = valeur;
	}
	
	public Noeud copy() {
		Noeud copie = new Noeud(this.valeur);
		copie.gauche = this.gauche;
		copie.droite = this.droite;
		return copie;
	}
	
	public boolean is_full() {
		return this.gauche != null && this.droite != null;
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Noeud getGauche() {
		return gauche;
	}

	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}

	public Noeud getDroite() {
		return droite;
	}

	public void setDroite(Noeud droite) {
		this.droite = droite;
	}

	@Override
	public String toString() {
		String s = Tabulation + "[" + this.getValeur() + "]" + "\r" + this.gauche + Tabulation + this.droite;
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(new Noeud(4));
	}
}
