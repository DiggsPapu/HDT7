package structure;


public class Dictionary {
	private BinarySearchTree<String, String> spanishDic;
	private BinarySearchTree<String, String> englishDic;
	private BinarySearchTree<String, String> frenchDic;
	
	protected BinarySearchTree<String, String> getSpanishDic() {
		return spanishDic;
	}
	protected BinarySearchTree<String, String> getEnglishDic() {
		return englishDic;
	}
	protected BinarySearchTree<String, String> getFrenchDic() {
		return frenchDic;
	}
	
	
	protected Route<String> getValuesSpanish() {
		Route<String> values = new Route<>();
		spanishDic.inOrder(values);
		return values;
	}
	protected Route<String> getValuesEnglish() {
		Route<String> values = new Route<>();
		englishDic.inOrder(values);
		return values;
	}
	protected Route<String> getValuesFrench() {
		Route<String> values = new Route<>();
		frenchDic.inOrder(values);
		return values;
	}
	protected int tokenExists(String token) {
		if (spanishDic.find(token)!=null) {
			return 1;
		}else if (frenchDic.find(token)!=null) {
			return 2;
		}else if (englishDic.find(token)!=null) {
			return 3;
		}else {
			return 0;
		}
	}
	
}
