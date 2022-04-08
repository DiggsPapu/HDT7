package structure;

import java.util.ArrayList;

public class RouteAssociations<V,K> {
	public ArrayList<Association<K,V>> miLista = new ArrayList<Association<K,V>>();
	public void Walk2(Association<K,V> association) {
		miLista.add(association);
	}
	public void showWalk() {
		for (int k = 0 ; k < miLista.size() ; k++ ) {
			System.out.print("("+miLista.get(k).getKey()+","+miLista.get(k).getValue()+"), ");
		}
		System.out.print("\n");
	}

}
