package structure;

import java.util.ArrayList;

public class Diccionario {
	private BinarySearchTree<String, String> frenchDic ;
	private BinarySearchTree<String, String> englishDic ;
	
	
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
	
	public int whatLanguage(String token) {
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
		if (whatLanguage(token)==1) {
			return frenchDic.find(token);
		}else if (whatLanguage(token)==2) {
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
	
	
	public void getAssociations() {
		RouteAssociations<String, String> routeEnglish = new RouteAssociations<>();
		englishDic.inOrder2(routeEnglish);
		System.out.print("\nEnglish: ");
		routeEnglish.showWalk();
		
		RouteAssociations<String, String> routeFrench = new RouteAssociations<>();
		frenchDic.inOrder2(routeFrench);
		System.out.print("\nFrench: ");
		routeEnglish.showWalk();
		
	}
	
	public void changeWord(String englishKey, String newEnglish, String frenchKey, String newFrench) {
		englishDic.delete(englishKey);
		englishDic.insert(englishKey, newEnglish);
		frenchDic.delete(frenchKey);
		frenchDic.insert(frenchKey, newFrench);
	}
	public boolean wordExists(String token) {
		if (frenchDic.find(token)!=null||englishDic.find(token)!=null) {
			return true;
		}else {
			return false;
		}
	}
	public void addWord(String englishKey, String newEnglish, String frenchKey, String newFrench) {
		if (wordExists(englishKey) && wordExists(frenchKey)) {
			changeWord(englishKey, newEnglish, frenchKey, newFrench);
		}else {
			englishDic.insert(englishKey, newEnglish);
			frenchDic.insert(frenchKey, newFrench);
		}
	}
	
	public void removeWord(String value) {
		RouteAssociations<String, String> associationsFrench = new RouteAssociations<>();
		RouteAssociations<String, String> associationsEnglish = new RouteAssociations<>();
		englishDic.inOrder2(associationsEnglish);
		frenchDic.inOrder2(associationsFrench);
		if (getId(associationsEnglish, value)!=null && getId(associationsFrench, value)!=null ) {
			englishDic.delete(getId(associationsEnglish, value));
			frenchDic.delete(getId(associationsFrench, value));
			
			
		}else {
			System.out.print("No se pudo eliminar\n");
		}
			
		
	}
	
	private String getId(RouteAssociations<String, String> associations, String value) {
		for (int k = 0 ; k < associations.miLista.size() ; k++) {
			if (associations.miLista.get(k).getValue().equals(value)) {
				return associations.miLista.get(k).getKey();
			}
		}
		return null;
	}
}
