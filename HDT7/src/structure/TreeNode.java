package structure;

public class TreeNode<K, V> {

	private V value;
	private K id;
	private TreeNode<K, V> left;
	private TreeNode<K, V> right;
	private TreeNode<K, V> parent;
	/**
	 * Constructor with the tree node
	 * @param id
	 * @param value
	 */
	public TreeNode(K id, V value) {
		setId(id);
		setValue(value);
		setLeft(null);
		setRight(null);
		setParent(null);
	}
	
	/**
	 * It is to get the value in the node.
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * To set the value
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
	/**
	 * To get which ID the node has
	 * @return the id
	 */
	public K getId() {
		return id;
	}
	/**
	 * To set the id that exists in the node
	 * @param id the id to set
	 */
	public void setId(K id) {
		this.id = id;
	}
	/**
	 * It is to get the left node in the node
	 * @return the left
	 */
	public TreeNode<K, V> getLeft() {
		return left;
	}
	/**
	 * It is to set the left node in the node
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<K, V> left) {
		this.left = left;
	}
	/**
	 * It is to get the right node in the node
	 * @return the right
	 */
	public TreeNode<K, V> getRight() {
		return right;
	}
	/**
	 * It is to set the right node in the node
	 * @param right the right to set
	 */
	public void setRight(TreeNode<K, V> right) {
		this.right = right;
	}
	/**
	 * It is to get the parent node in the node
	 * @return the parent
	 */
	public TreeNode<K, V> getParent() {
		return parent;
	}
	/**
	 * It is to set the parent node in the node
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode<K, V> parent) {
		this.parent = parent;
	}
	
	
}
