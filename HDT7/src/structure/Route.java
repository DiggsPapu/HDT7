package structure;

import java.util.ArrayList;

public class Route<V> implements ITreeTraversal<V>{
	public ArrayList<V> miLista = new ArrayList<V>();
	/**
	 * It is the method to walk across the BST and get the order and add it in an arraylist.
	 */
	@Override
	public void Walk(V value) {
		miLista.add(value);
	}


}
