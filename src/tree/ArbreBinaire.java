package tree;

public class ArbreBinaire {
	
	private Noeud root;
	static final String Tabulation = "    ";
	
	public ArbreBinaire(Noeud root) {
		super();
		this.root = root;
	}

	public void ajouterNoeud(Noeud n) {
		Noeud r = recc(this.root, n);

		if ( n.getValeur() > r.getValeur() ) {
			r.setDroite(n);
		}else if ( n.getValeur() < r.getValeur() ) {
			r.setGauche(n);
		}
	}
	
	public static Noeud recc(Noeud root, Noeud n) {
		if (n.getValeur() > root.getValeur()) {
			if (root.getDroite() != null) {

				return recc(root.getDroite(), n);
			}
			else {
				return root;
			}
		}
		else if(n.getValeur() < root.getValeur()) {
			if (root.getGauche() != null) {

				return recc(root.getGauche(), n);
			}
			else {
				return root;
			}
			
		}
		
		return recc(root, n);
	}

	@Override
	public String toString() {
		return root.toString();
	}
	
	public static void main(String[] args) {
		Noeud root = new Noeud(3);
//		root.setDroite(new Noeud(4));
		ArbreBinaire manguier = new ArbreBinaire(root);
		
		manguier.ajouterNoeud(new Noeud(4));
		System.out.println(manguier);
	}
}
