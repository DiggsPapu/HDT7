package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structure.Association;
import structure.BinarySearchTree;
import structure.WordComparator;

class TestAssociations {

	@Test
	void AssociationsTest() {
		BinarySearchTree<String, String> BST = new BinarySearchTree<String, String>(new WordComparator<String>());
		
		for (int k = 0 ; k < 10 ; k++ ) {
			String key = String.valueOf(k);
			String value = String.valueOf(k*3);
			BST.insert(key, value);
			Association<String, String> ass1 = new Association<String, String>(key, value);
			BST.insert(ass1.getKey(), ass1.getValue());
			
		}
		for (int k = 0 ; k < BST.getElements().size() ; k ++) {
			assertEquals(BST.getElements().get(k), String.valueOf(k*3));
		}
		
	}

}
