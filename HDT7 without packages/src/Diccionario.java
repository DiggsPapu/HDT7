package structure;

import java.util.ArrayList;

public class Diccionario {
	private BinarySearchTree<String, String> frenchDic ;
	private BinarySearchTree<String, String> englishDic ;
	
	/**
	 * This method is for get the french dictionary
	 * @return BinarySearchTree<String, String>
	 */
	public BinarySearchTree<String, String> getFrenchDic() {
		return frenchDic;
	}
	/**
	 * this method is for get the english dictionary
	 * @return BinarySearchTree<String, String>
	 */
	public BinarySearchTree<String, String> getEnglishDic() {
		return englishDic;
	}
	
	/**
	 * It's a method dictionary, it initialized BST 4 french and english
	 */
	public Diccionario() {
		this.frenchDic = new BinarySearchTree<String, String>(new WordComparator<String>());
		this.englishDic = new BinarySearchTree<String, String>(new WordComparator<String>());
	}
	/**
	 * Method to define what language it is, french or english
	 * @param token
	 * @return 
	 */
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
	/**
	 * Method to search word in the dictionary.
	 * @param token
	 * @return
	 */
	public String searchWord(String token) {
		if (whatLanguage(token.toLowerCase().trim() )==1) {
			return frenchDic.find(token.toLowerCase().trim() );
		}else if (whatLanguage(token.toLowerCase().trim() )==2) {
			return englishDic.find(token.toLowerCase().trim() );
		}else {
			return null;
		}
	}
	/**
	 * Method to load the dictionary associations
	 * 
	 * @param words
	 */
	public void loadDic(ArrayList<ArrayList<String>> words) {
		
		for (int k = 0 ; k < words.size() ; k++ ) {
			ArrayList<String> list = words.get(k);
			frenchDic.insert(list.get(2).toLowerCase().trim(), list.get(1).toLowerCase().trim());
			englishDic.insert(list.get(0).toLowerCase().trim(), list.get(1).toLowerCase().trim());
		}
	}
	
	/**
	 * GetAssociations 
	 */
	public void getAssociations() {
		RouteAssociations<String, String> routeEnglish = new RouteAssociations<>();
		englishDic.inOrder2(routeEnglish);
		System.out.print("\nEnglish: ");
		routeEnglish.showWalk();
		
		RouteAssociations<String, String> routeFrench = new RouteAssociations<>();
		frenchDic.inOrder2(routeFrench);
		System.out.print("\nFrench: ");
		routeFrench.showWalk();
		
	}
	/**
	 * Method change word so we ask for the new value and the english key to change. 
	 * @param englishKey is a string
	 * @param newValue is a string
	 */
	public void changeWord(String englishKey, String newValue) {
		
		String old = englishDic.delete(englishKey.toLowerCase().trim() );
		englishDic.insert(englishKey.toLowerCase().trim(), newValue.toLowerCase().trim() );
		RouteAssociations<String, String> routeFrench = new RouteAssociations<>();
		frenchDic.inOrder2(routeFrench);
		
		frenchDic.delete( getId(routeFrench, old.toLowerCase().trim() ) );
		frenchDic.insert( getId(routeFrench, old.toLowerCase().trim()) , newValue.toLowerCase().trim() );
		
	}
	
	/**
	 * Word Exists 
	 * @param token
	 * @return
	 */
	public boolean wordExists(String token) {
		if (frenchDic.find(token.toLowerCase().trim() )!=null||englishDic.find(token.toLowerCase().trim() )!=null) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Add word, is to add a new word to the french, english and the new value
	 * @param englishKey
	 * @param frenchKey
	 * @param newValue
	 */
	public void addWord(String englishKey, String frenchKey, String newValue) {
		if (wordExists(englishKey.toLowerCase().trim() ) && wordExists(frenchKey.toLowerCase().trim() )) {
			changeWord(englishKey.toLowerCase().trim(), newValue.toLowerCase().trim() );
		}else {
			englishDic.insert(englishKey.toLowerCase().trim(), newValue.toLowerCase().trim() );
			frenchDic.insert(frenchKey.toLowerCase().trim(), newValue.toLowerCase().trim() );
		}
	}
	/**
	 * Remove a word it is the method to remove a word
	 * @param value
	 */
	public void removeWord(String value) {
		RouteAssociations<String, String> associationsFrench = new RouteAssociations<>();
		RouteAssociations<String, String> associationsEnglish = new RouteAssociations<>();
		englishDic.inOrder2(associationsEnglish);
		frenchDic.inOrder2(associationsFrench);
		if (getId(associationsEnglish, value)!=null && getId(associationsFrench, value)!=null ) {
			englishDic.delete(getId(associationsEnglish, value.toLowerCase().trim() ));
			frenchDic.delete(getId(associationsFrench, value.toLowerCase().trim() ));
			
		}else {
			System.out.print("No se pudo eliminar\n");
		}
			
		
	}
	/**
	 * GetId is the method to get the id 
	 * @param associations
	 * @param value
	 * @return
	 */
	private String getId(RouteAssociations<String, String> associations, String value) {
		for (int k = 0 ; k < associations.miLista.size() ; k++) {
			if (associations.miLista.get(k).getValue().equals( value.toLowerCase().trim() )) {
				return associations.miLista.get(k).getKey();
			}
		}
		return null;
	}
}
