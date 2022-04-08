package structure;

import java.util.Map;

public class Association<K, V> implements java.util.Map.Entry<K, V>{
	private Map.Entry<K, V> map;
	/**
	 * Association in a entry between the key and the value
	 * @param key
	 * @param value
	 */
	public Association(K key, V value) {
		this.map = Map.entry(key, value);
		
	}
	/**
	 * Get key to get the key in the association
	 */
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.map.getKey();
		
	}
	
	/**
	 * Get the value from the map
	 */
	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.map.getValue();
		
	}
	
	/**
	 * Set the value from the map
	 */
	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
