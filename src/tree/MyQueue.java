package tree;

public class MyQueue {
	
	private Arbre[] tab;
	public static int MAX = 100;
	public int in = 0;
	public int out = 0;
	
	MyQueue () {
		tab = new Arbre[MAX];
	}
	
	public boolean est_vide() {
		return in == out;
	}
	
	public void ajouter(Arbre a) {
		tab[in] = a;
		in++;
	}
	
	public Arbre enlever() {
		Arbre result = tab[out];
		out++;
		return result;
	}
	
	public int size() {
		return in - out ;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder () ;
		b.append('[');
		for (int i = out; i < in; i++) {
			b.append(tab[i] + ", ");
		}
		b.append(']');
		return b.toString();
	}
}
