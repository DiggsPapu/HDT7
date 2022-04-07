package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import structure.Diccionario;
import structure.Route;

class TestDictionary {

	@Test
	void testDictionary() {
		Diccionario dic = new Diccionario();
		ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>(); 
		
		for (int k = 0 ; k < 10 ; k++ ) {
			ArrayList<String> array = new ArrayList<String>();
			array.add(String.valueOf(k*2));
			array.add(String.valueOf(k));
			array.add(String.valueOf(k*2));
			words.add(array);
		}
		
		dic.loadDic(words);
		Route<String> ruta = new Route<>();
		dic.getFrenchDic().preOrder(ruta);
		for (int k = 0 ; k < ruta.miLista.size() ; k++ ) {
			assertEquals(dic.getEnglishDic().getElements().get(k), dic.getFrenchDic().getElements().get(k));
			
		}
		
		Diccionario dic1 = new Diccionario();
		ArrayList<ArrayList<String>> words1 = new ArrayList<ArrayList<String>>(); 
		
		for (int k = 0 ; k < 10 ; k++ ) {
			ArrayList<String> array = new ArrayList<String>();
			array.add(String.valueOf(k*2+1));
			array.add(String.valueOf(k));
			array.add(String.valueOf(k*2));
			words1.add(array);
		}
		
		dic1.loadDic(words1);
		
		for (int k = 1 ;  k < 10 ; k++) {
			assertEquals(dic1.wordExists(String.valueOf(k*2+1)), 2);
			assertEquals(dic1.searchWord(String.valueOf(k*2+1)), String.valueOf(k));
			assertEquals(dic1.wordExists(String.valueOf(k*2)), 1);
			assertEquals(dic1.searchWord(String.valueOf(k*2)), String.valueOf(k));
			assertEquals(dic1.wordExists(String.valueOf(k*40)), 0);
			
		}
		
		
	}



}
