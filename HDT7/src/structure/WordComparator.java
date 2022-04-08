package structure;

import java.util.Comparator;

public class WordComparator<K> implements Comparator<K> {
	/**
	 * It is the method that implements comparator interface
	 * This is to comparate between words and get which word has a higher priority
	 */
	@Override
	public int compare(K o1, K o2) {
		// TODO Auto-generated method stub
		String val1 = o1.toString();
		String val2 = o2.toString();
		return val1.toLowerCase().compareTo(val2.toLowerCase());
		}
	
	
}
