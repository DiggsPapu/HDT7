package structure;

import java.util.Map;

public class Association<K, V> implements java.util.Map.Entry<K, V>{
	private Map.Entry<K, V> map;
	
	public Association(K key, V value) {
		this.map = Map.entry(key, value);
		
	}
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.map.getKey();
		
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.map.getValue();
		
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
