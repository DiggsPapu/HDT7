package structure;

import java.util.ArrayList;

public class RouteAssociations<V,K> {
	public ArrayList<Association<K,V>> miLista = new ArrayList<Association<K,V>>();
	/**
	 * It is a class to get the route with the associations that are in each node.
	 * @param association
	 */
	public void Walk2(Association<K,V> association) {
		miLista.add(association);
	}
	/**
	 * It shows how the walk finally got.
	 */
	public void showWalk() {
		for (int k = 0 ; k < miLista.size() ; k++ ) {
			System.out.print("("+miLista.get(k).getKey()+","+miLista.get(k).getValue()+"), ");
		}
		System.out.print("\n");
	}

}
