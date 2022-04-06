package structure;

import java.util.ArrayList;

public class Route<V> implements ITreeTraversal<V>{
public ArrayList<V> miLista = new ArrayList<V>();
	
	@Override
	public void Walk(V value) {
		miLista.add(value);
	}


}
