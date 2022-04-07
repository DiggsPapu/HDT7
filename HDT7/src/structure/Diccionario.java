package structure;

import java.util.ArrayList;

public class Diccionario {
	BinarySearchTree<String, String> frenchDic ;
	BinarySearchTree<String, String> englishDic ;
	
	public BinarySearchTree<String, String> getFrenchDic() {
		return frenchDic;
	}

	public BinarySearchTree<String, String> getEnglishDic() {
		return englishDic;
	}

	public Diccionario() {
		this.frenchDic = new BinarySearchTree<String, String>(new WordComparator<String>());
		this.englishDic = new BinarySearchTree<String, String>(new WordComparator<String>());
	}
	
	public int wordExists(String token) {
		if (frenchDic.find(token)!=null) {
			return 1;
			
		}else if (englishDic.find(token)!= null) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	public String searchWord(String token) {
		if (wordExists(token)==1) {
			return frenchDic.find(token);
		}else if (wordExists(token)==2) {
			return englishDic.find(token);
		}else {
			return null;
		}
	}
	
	public void loadDic(ArrayList<ArrayList<String>> words) {
		
		for (int k = 0 ; k < words.size() ; k++ ) {
			ArrayList<String> list = words.get(k);
			frenchDic.insert(list.get(2), list.get(1));
			englishDic.insert(list.get(0), list.get(1));
		}
		
	}
	
	
	
	
}
