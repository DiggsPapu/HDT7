package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structure.BinarySearchTree;
import structure.Route;
import structure.WordComparator;

class TestBinarySearchTree {


	@Test
	void testInsert() {
		BinarySearchTree<String, String> myBST1 = new BinarySearchTree<String, String>(new WordComparator<String>());
        myBST1.insert("Hola", "test");
        assertEquals(1, myBST1.count());
        assertEquals("test", myBST1.getElements().get(0));
        BinarySearchTree<String, String> myBST = new BinarySearchTree<String, String>(new WordComparator<String>());
        myBST.insert("hola", "cincuenta");
        myBST.insert("buenas tardes", "ochenta");
        myBST.insert("como estas", "noventa");
        myBST.insert("yo bien", "sesenta");
        myBST.insert("y tu", "veinte");
        myBST.insert("veinte quetzales", "diez");
        myBST.insert("el platano", "treinta");
        
        assertEquals(7, myBST.count());
        
        assertEquals("diez", myBST.getElements().get(4));
        assertEquals("veinte", myBST.getElements().get(5));
        assertEquals("treinta", myBST.getElements().get(2));
        assertEquals("cincuenta", myBST.getElements().get(3));
        assertEquals("sesenta", myBST.getElements().get(6));
        assertEquals("ochenta", myBST.getElements().get(0));
        assertEquals("noventa", myBST.getElements().get(1));
	
	}

	@Test
	void testDelete() {
		BinarySearchTree<String, String> myBST1 = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST1.isEmpty());
        
        myBST1.insert("hijk", "cincuenta");
        
        assertEquals(1, myBST1.count());
        
        assertEquals("cincuenta", myBST1.delete("hijk"));
        
        assertEquals(0, myBST1.count());
        
        assertEquals(true, myBST1.isEmpty());
        
        BinarySearchTree<String, String> myBST2 = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST2.isEmpty());
        
        myBST2.insert("largo", "cincuenta");
        myBST2.insert("sorete", "ochenta");
        myBST2.insert("xibalba", "noventa");
        myBST2.insert("marruecos", "sesenta");
        myBST2.insert("bonito", "veinte");
        myBST2.insert("avion", "diez");
        myBST2.insert("buey", "treinta");
        
        assertEquals(7, myBST2.count());
        
        assertEquals("noventa", myBST2.delete("xibalba"));

        Route<String> miRecorrido = new Route<String>();
        myBST2.inOrder(miRecorrido);
        
        assertEquals("diez", miRecorrido.miLista.get(0));
        assertEquals("veinte", miRecorrido.miLista.get(1));
        assertEquals("treinta", miRecorrido.miLista.get(2));
        assertEquals("cincuenta", miRecorrido.miLista.get(3));
        assertEquals("sesenta", miRecorrido.miLista.get(4));
        assertEquals("ochenta", miRecorrido.miLista.get(5));
        
        BinarySearchTree<String, String> myBST = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST.isEmpty());
        
        myBST.insert("d", "cincuenta");
        myBST.insert("f", "ochenta");
        myBST.insert("g", "noventa");
        myBST.insert("e", "sesenta");
        myBST.insert("b", "veinte");
        myBST.insert("a", "diez");
        myBST.insert("c", "treinta");
        
        assertEquals(7, myBST.count());
        
        assertEquals("cincuenta", myBST.delete("d"));

        Route<String> miRecorrido1 = new Route<String>();
        myBST.inOrder(miRecorrido1);
        
        assertEquals("diez", miRecorrido1.miLista.get(0));
        assertEquals("veinte", miRecorrido1.miLista.get(1));
        assertEquals("treinta", miRecorrido1.miLista.get(2));
        assertEquals("sesenta", miRecorrido1.miLista.get(3));
        assertEquals("ochenta", miRecorrido1.miLista.get(4));
        assertEquals("noventa", miRecorrido1.miLista.get(5));
        
	}

	@Test
	void testFind() {
		BinarySearchTree<String, String> myBST = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST.isEmpty());
        
        myBST.insert("d", "cincuenta");
        myBST.insert("f", "ochenta");
        myBST.insert("g", "noventa");
        myBST.insert("e", "sesenta");
        myBST.insert("b", "veinte");
        myBST.insert("a", "diez");
        myBST.insert("c", "treinta");
        
        assertEquals(7, myBST.count());
        
        assertEquals(myBST.find("d"), "cincuenta");
        assertEquals(myBST.find("hola"), null);
        assertEquals(myBST.delete("f"), "ochenta");
        assertEquals(myBST.find("g"), "noventa");
        assertEquals(myBST.isEmpty(), false);
        
	}
	@Test
	void testGetElements() {
		BinarySearchTree<String, String> myBST = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST.isEmpty());
        myBST.insert("10", "villarea");
        myBST.insert("20", "cincuenta");
        myBST.insert("30", "y");
        myBST.insert("90", "cuatro");
        myBST.insert("80", "doce");
        myBST.insert("94302", "dolencia");
        
        assertEquals(myBST.getElements().get(0), "villarea");
	}

	@Test
	void testInOrder() {
BinarySearchTree<String, String> myBST = new BinarySearchTree<String, String>(new WordComparator<String>());
        
        assertEquals(true, myBST.isEmpty());

        myBST.insert("30", "y");
        myBST.insert("10", "villarea");
        myBST.insert("20", "cincuenta");
        myBST.insert("35", "oh");
        myBST.insert("90", "cuatro");
        myBST.insert("80", "doce");
        myBST.insert("94302", "dolencia");
        Route<String> miRecorrido1 = new Route<String>(); 
        myBST.inOrder(miRecorrido1);
        assertEquals(miRecorrido1.miLista.get(0),"villarea");
        assertEquals(miRecorrido1.miLista.get(1),"cincuenta");
        assertEquals(miRecorrido1.miLista.get(2),"y");
        assertEquals(miRecorrido1.miLista.get(3),"oh");
        assertEquals(miRecorrido1.miLista.get(4),"doce");
        assertEquals(miRecorrido1.miLista.get(5),"cuatro");
        assertEquals(miRecorrido1.miLista.get(6),"dolencia");
        Route<String> miRecorrido2 = new Route<String>(); 
        myBST.preOrder(miRecorrido2);
        assertEquals(miRecorrido2.miLista.get(0),"y");
        assertEquals(miRecorrido2.miLista.get(1),"villarea");
        assertEquals(miRecorrido2.miLista.get(2),"cincuenta");
        assertEquals(miRecorrido2.miLista.get(3),"oh");
        assertEquals(miRecorrido2.miLista.get(4),"cuatro");
        assertEquals(miRecorrido2.miLista.get(5),"doce");
        assertEquals(miRecorrido2.miLista.get(6),"dolencia");
        Route<String> miRecorrido3 = new Route<String>(); 
        myBST.postOrder(miRecorrido3);
        assertEquals(miRecorrido3.miLista.get(0),"cincuenta");
        assertEquals(miRecorrido3.miLista.get(1),"villarea");
        assertEquals(miRecorrido3.miLista.get(0),"cincuenta");
        
        
        
	}

}
