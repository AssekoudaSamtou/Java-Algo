package tree;

public class Arbre {
	private int valeur;
	private Arbre sousArbreGauche, sousArbreDroit;

	public Arbre(int x) {
		valeur = x;
	}
	
	public Arbre() {}
	
	public Arbre(int[] tab) {
		valeur = tab[0];
		for (int i=1; i < tab.length; i++) {
			this.insertion(tab[i]);
		}
	}

	public Arbre(int x, Arbre g, Arbre d) {
		valeur = x;
		sousArbreGauche = g;
		sousArbreDroit = d;
	}

	public int getValeur() {
		return(valeur);
	}

	public Arbre getSousArbreGauche() {
		return(sousArbreGauche);
	}

	public Arbre getSousArbreDroit() {
		return(sousArbreDroit);
	}

	public String toString() {
//		return toString("\t");
		return "";
	}

	public void toString1() {
		
		System.out.println("" + valeur);
		
//		if (sousArbreGauche != null) {
//			if (sousArbreDroit != null) 
//				return(s + valeur + "\n" + sousArbreGauche.toString(s + "\t") + sousArbreDroit.toString(s+"\t"));
//			else
//				return(s+valeur+"\n"+sousArbreGauche.toString(s+"\t")+"\n");
//		}
//		else {
//			if (sousArbreDroit!=null) 
//				return(s+valeur+"\n\n"+sousArbreDroit.toString(s+"\t"));
//			else
//				return(s+valeur+"\n");
//		}
	}
	
//	public void toString2() {
////		String result = "\t";
//		List<Arbre> tmp = new ArrayList<Arbre>();
//		tmp.add(this);
//		List<Arbre> tab;
//		for (int i = hauteur(this); i > 0; i--) {
//			tab = new ArrayList<Arbre>();
//			System.out.print(tabulation(i-1));
//			for (Arbre arb : tmp) {
//				System.out.print(arb.valeur + "      ");
//				tab.add(arb.sousArbreGauche);
//				tab.add(arb.sousArbreDroit);
//			}
//			tmp = new ArrayList<Arbre>(tab);
//			System.out.print("\n");
//		}
//	}
	
	public static String tabulation(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "    ";
		}
		return result;
	}
	
	public static void parcours_en_largeur(Arbre a) {
		MyQueue file = new MyQueue();
		Arbre tmp;
		file.ajouter(a);
		while (!file.est_vide()) {
			tmp = file.enlever();
			if (tmp.sousArbreGauche != null)
				file.ajouter(tmp.sousArbreGauche);
			
			if (tmp.sousArbreDroit != null)
				file.ajouter(tmp.sousArbreDroit);
			
			System.out.print(tmp.valeur + " ");

		}	
	}

	public void ParcoursPrefixe() {
		System.out.println(getValeur());
		if (getSousArbreGauche() != null)
			getSousArbreGauche().ParcoursPrefixe();
		if (getSousArbreDroit() != null)
			getSousArbreDroit().ParcoursPrefixe();
	}

	public void ParcoursInfixe() {
		if (getSousArbreGauche() != null)
			getSousArbreGauche().ParcoursInfixe();
		
		System.out.print(getValeur() + " ");
		
		if (getSousArbreDroit() != null)
			getSousArbreDroit().ParcoursInfixe();
	}

	public void ParcoursPostfixe() {
	if (getSousArbreGauche() != null)
		getSousArbreGauche().ParcoursPostfixe();
	if (getSousArbreDroit() != null)
		getSousArbreDroit().ParcoursPostfixe();
	System.out.println(getValeur());
	}

	public static boolean arbresEgaux(Arbre a, Arbre b) {
		if ((a == null) && (b == null))
			return true;
		if ((a == null) && (b != null))
			return false;
		if ((a != null) && (b == null))
			return false;
	
		// A ce point, a et b != null, on peut acceder a leurs champs
		if (a.getValeur() != b.getValeur())
			return false;
		return (arbresEgaux(a.getSousArbreGauche(), b.getSousArbreGauche()) && arbresEgaux(a.getSousArbreDroit(), b.getSousArbreDroit()));
	}
		
	public static int hauteur(Arbre a) {
		
		if (a == null)
			return 0;
		else
			return (1 + Math.max(hauteur(a.getSousArbreGauche()), hauteur(a.getSousArbreDroit())));
	}
	
	static int taille(Arbre a) {
	  
		if (a == null)
			return 0;
		return 1 + taille(a.getSousArbreGauche()) + taille(a.getSousArbreDroit());
	}

	public static boolean estABR(Arbre a) {
	if (a == null)
		return true;
	if ((a.getSousArbreGauche() != null) && (a.getSousArbreGauche().getValeur() > a.getValeur()))
		return false;
	if ((a.getSousArbreDroit() != null) && (a.getValeur() > a.getSousArbreDroit().getValeur()))
		return false;
	return (estABR(a.getSousArbreGauche()) && estABR(a.getSousArbreDroit()));
	}
	
	public boolean recherche(int value) {
		
		if (value == getValeur())
			return true;
		
		if ((value < getValeur()) && (getSousArbreGauche() != null))
			return (getSousArbreGauche().recherche(value));
		
		if ((value > getValeur()) && (getSousArbreDroit() != null))
			return (getSousArbreDroit().recherche(value));
		
		return false;
	}
	
	public void insertion(int value) {
		if (this == null) 
			this.valeur = value;
		
		if (value <= getValeur()) {
			if (getSousArbreGauche() != null)
				getSousArbreGauche().insertion(value);
			else
				sousArbreGauche = new Arbre(value);
		}else {
			if (getSousArbreDroit() != null)
				getSousArbreDroit().insertion(value);
			else 
				sousArbreDroit = new Arbre(value);
		}
	}
		
	public void insertion(int [] l) {
		for (int i = 0; i < l.length; i++) {
			insertion( (int)l[i] );
		}
	}

//	public static Arbre supprimer(int valeur, Arbre a) {
//		if (a == null)
//			return a;
//
//		if (valeur == a.valeur)
//			return supprimerRacine(a);
//
//		if (valeur < a.getValeur())
//			a.sousArbreGauche = supprimer(valeur, a.sousArbreGauche);
//
//		else 
//			a.sousArbreDroit = supprimer(valeur, a.sousArbreDroit);
//		
//		return a;
//	}
	
//	static Arbre supprimerRacine(Arbre a) {
//		if (a.sousArbreGauche == null)
//			return a.sousArbreDroit;
//
//		if (a.sousArbreDroit == null)
//			return a.sousArbreGauche;
//
//		Arbre f = dernierDescendant(a.sousArbreGauche);
//		a.valeur = f.valeur;
//		a.sousArbreGauche = supprimer(f.valeur, a.sousArbreGauche);
//	}
	
	static Arbre dernierDescendant(Arbre a) {
		if (a.sousArbreDroit == null)
			return a;
		return dernierDescendant(a.sousArbreDroit);
	}
	
	public void parcoursTrie() {
		if (getSousArbreGauche() != null) 
			getSousArbreGauche().parcoursTrie();
		
		System.out.print(getValeur() + " ");
		
		if (getSousArbreDroit() != null) 
			getSousArbreDroit().parcoursTrie();
	}
	
	static void parcoursInfixe(Arbre a) 
	{
	  if (a == null)
	    return;
	  parcoursInfixe(a.getSousArbreGauche());
	  System.out.print(a.getValeur() + " ");
	  parcoursInfixe(a.getSousArbreDroit());
	}
	
	public static void main(String[] arg) {
		
		Arbre b = new Arbre(5, new Arbre(4), new Arbre(6));
		Arbre c = new Arbre(9, new Arbre(8), new Arbre(10));       
//		Arbre a = new Arbre(7, b, c);
		
		int[] tab = {7, 9, 8, 5, 10, 4, 6};
		Arbre a = new Arbre(tab);
		
		parcours_en_largeur(a);
	}
}
