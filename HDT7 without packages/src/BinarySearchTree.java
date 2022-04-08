package structure;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Moises Alonso
 * Este metodo es el usado por moises aunque yo le agregue dos metodos mas
 * El metodo search in order 2 y el metodo inOrder2
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {
	
	private int count;
	private TreeNode<K, V> root;
	private Comparator<K> keyComparator;
	/**
	 * It's the BST constructor
	 * @param _keyComparator
	 */
	public BinarySearchTree(Comparator<K> _keyComparator) {
		this.keyComparator = _keyComparator;
		root = null;
		count = 0;
	}
	
/**
 * Insert with the id the value inside the BST
 */
	@Override
	public void insert(K id, V value) {
		
		if (isEmpty()) {
			root = new TreeNode<K, V>(id, value);
			count++;
		} else {
			internalInsert(root, id, value);
		}
	}
	/**
	 * Delete the node with the id
	 */
	@Override
	public V delete(K id) {
		if (!isEmpty()) {
			int result = keyComparator.compare(root.getId(), id);
			
			if (result > 0) {
				return internalDelete(root.getLeft(), id, true);
			} else if (result < 0) {
				return internalDelete(root.getRight(), id, false);
			} else { //Root is the deleted node
				
				if (count() == 1) {
					
					V temp = root.getValue();
					root = null;
					count--;
					return temp;
					
				} else {
					
					V tempValue = root.getValue();
					
					if (root.getRight() != null) { //Buscar hijo derecho mas izquierdo
							
						TreeNode<K, V> leftOfTheRights = root.getRight();
						
						while(leftOfTheRights.getLeft() != null) {
							leftOfTheRights = leftOfTheRights.getLeft(); 
						}
						
						//Assigning the left side
						leftOfTheRights.setLeft(root.getLeft());
						if (leftOfTheRights.getLeft() != null)
							leftOfTheRights.getLeft().setParent(leftOfTheRights);
						
						//Assiginig the right side
						if (keyComparator.compare(root.getRight().getId(), leftOfTheRights.getId()) != 0) { //Only if the leftOfTheRights is different than root.right
							leftOfTheRights.getParent().setLeft(null);
							
							TreeNode<K, V> newRootRight = leftOfTheRights;
							
							while (newRootRight.getRight() != null) {
								newRootRight = newRootRight.getRight();
							}
							
							newRootRight.setRight(root.getRight());
							if (newRootRight.getRight() != null) {
								newRootRight.getRight().setParent(newRootRight);;
							}
							
						}
						
						//Assginig the new parents
						if (leftOfTheRights.getRight() != null)
							leftOfTheRights.getRight().setParent(leftOfTheRights);
						
						leftOfTheRights.setParent(null);
						root = leftOfTheRights;
						
						count--;
						return tempValue;
						
					} else { //Buscar hijo izquierdo mas derecho
						
						TreeNode<K, V> rightOfTheLefts = root.getLeft();
						
						while(rightOfTheLefts.getRight() != null) {
							rightOfTheLefts = rightOfTheLefts.getRight(); 
						}
						
						//Assigning the right side
						rightOfTheLefts.setRight(root.getRight());
						if (rightOfTheLefts.getRight() != null)
							rightOfTheLefts.getRight().setParent(rightOfTheLefts);
						
						//Assiginig the left side
						if (keyComparator.compare(root.getLeft().getId(), rightOfTheLefts.getId()) != 0) { //Only if the rightOfTheLefts is different than root.left
							rightOfTheLefts.getParent().setRight(null);
							
							TreeNode<K, V> newRootLeft = rightOfTheLefts;
							
							while (newRootLeft.getLeft() != null) {
								newRootLeft = newRootLeft.getLeft();
							}
							
							newRootLeft.setLeft(root.getLeft());
							if (newRootLeft.getLeft() != null) {
								newRootLeft.getLeft().setParent(newRootLeft);;
							}
							
						}
						
						//Assginig the new parentes
						if (rightOfTheLefts.getLeft() != null)
							rightOfTheLefts.getLeft().setParent(rightOfTheLefts);
						
						rightOfTheLefts.setParent(null);
						root = rightOfTheLefts;
						
						count--;
						return tempValue;
						
						
					}
					
					
				}
				
			}
		}
		
		return null;
	}
	
	/**
	 * Find the value with the id
	 */
	@Override
	public V find(K id) {
		return internalFind(root, id);
	}
	/**
	 * Count the amount of values
	 */
	@Override
	public int count() {
		return count;
	}
	/**
	 * It is empty
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Get elements and returns an arrayList
	 */
	@Override
	public ArrayList<V> getElements() {
		ArrayList<V> list = new ArrayList<V>();
		
		internalGetElements(list, root);
		
		return list;
	}
	
	/**
	 * In Order it does not return something
	 *   
	 */
	@Override
	public void inOrder(ITreeTraversal<V> traversal) {
		internalInOrder(root, traversal);
	}
	/**
	 * Pre order 
	 */
	@Override
	public void preOrder(ITreeTraversal<V> traversal) {
		internalPreOrder(root, traversal);
		
	}
	/**
	 * Post order
	 */
	@Override
	public void postOrder(ITreeTraversal<V> traversal) {
		internalPostOrder(root, traversal);
	}
	
	/**
	 * Method inOrder2 
	 * @param traversal
	 * @return
	 */
	public RouteAssociations<V,K> inOrder2(RouteAssociations<V,K> traversal) {
		internalInOrder2(root, traversal);
		return traversal;
	}
	/**
	 * Method internalInOrder2
	 * @param actual
	 * @param traversal
	 */
	private void internalInOrder2(TreeNode<K, V> actual, RouteAssociations<V,K> traversal) {
		if (actual != null) {
			internalInOrder2(actual.getLeft(), traversal);
			Association<K,V> actualAssociation = new Association<K,V>(actual.getId(),actual.getValue());
			traversal.Walk2(actualAssociation);
			
			internalInOrder2(actual.getRight(), traversal);
		}
	}
	/**
	 * Internal Insert the method to insert in the tree 
	 * @param actual 
	 * @param id
	 * @param value
	 */
	private void internalInsert(TreeNode<K, V> actual, K id, V value) {
		
		int result = keyComparator.compare(actual.getId(), id);
		
		if (result > 0) { //actual id is greater than new id then search in the left side
			
			if (actual.getLeft() == null) { //Doesn't have left children
				TreeNode<K, V> newNode = new TreeNode<K, V>(id, value);
				actual.setLeft(newNode);
				newNode.setParent(actual);
				count++;
			} else {
				internalInsert(actual.getLeft(), id, value);
			}
			
		} else if (result < 0) { //actual id is smaller than the new then search in the right
			if (actual.getRight() == null) { //Doesn't have left children
				TreeNode<K, V> newNode = new TreeNode<K, V>(id, value);
				actual.setRight(newNode);
				newNode.setParent(actual);
				count++;
			} else {
				internalInsert(actual.getRight(), id, value);
			}
		}
		
	}
	/**
	 * Internal in order to move in the tree in order and it appends in a Route class, where it will generate a list with the values in order.
	 * @param actual
	 * @param traversal
	 */
	private void internalInOrder(TreeNode<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
			internalInOrder(actual.getLeft(), traversal);
			
			traversal.Walk(actual.getValue());
			
			internalInOrder(actual.getRight(), traversal);
		}
	}
	/**
	 * Internal Pre Order 
	 * @param actual
	 * @param traversal
	 */
	private void internalPreOrder(TreeNode<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
			traversal.Walk(actual.getValue());
			
			internalPreOrder(actual.getLeft(), traversal);
			
			internalPreOrder(actual.getRight(), traversal);
		}
	}
	
	private void internalPostOrder(TreeNode<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
		
			internalPostOrder(actual.getLeft(), traversal);
			
			internalPostOrder(actual.getRight(), traversal);
			
			traversal.Walk(actual.getValue());
		}
	}
	/**
	 * Method to find inside the tree a value
	 * @param actual
	 * @param id
	 * @return
	 */
	private V internalFind(TreeNode<K, V> actual, K id) {
		if (actual != null) {
			int result = keyComparator.compare(actual.getId(), id);
			
			if (result > 0) {
				return internalFind(actual.getLeft(), id);
			} else if (result < 0) {
				return internalFind(actual.getRight(), id);
			} else {
				return actual.getValue();
			}
			
		} else {
			return null;
		}
	}
	/**
	 * Method to get elements
	 * @param list
	 * @param actual
	 */
	private void internalGetElements(ArrayList<V> list, TreeNode<K, V> actual) {
		if (actual != null) {
			internalGetElements(list, actual.getLeft());
			
			list.add(actual.getValue());
			
			internalGetElements(list, actual.getRight());
		}
	}
	
	private V internalDelete(TreeNode<K, V> actual, K id, boolean isLeft) {
		if (actual != null) {
			int result = keyComparator.compare(actual.getId(), id);
			
			if (result > 0) { //search in the left side
				return internalDelete(actual.getLeft(), id, true);
			} else if (result < 0) {//search in the right side
				return internalDelete(actual.getRight(), id, false);
			} else { //actual is the node to be deleted
				
				//The actual node is a leaft
				if ( (actual.getLeft() == null) && (actual.getRight() == null) ) { // If is a leaft
					V tempValue = actual.getValue();
					if (isLeft) {
						actual.getParent().setLeft(null);
						actual.setParent(null);
					} else {
						actual.getParent().setRight(null);
						actual.setParent(null);
					}
					count--;
					return tempValue;
				} else { //Is intermediate node
				
					V tempValue = actual.getValue();
					
					if (actual.getRight() != null) { //Buscar hijo derecho mas izquierdo
						
						TreeNode<K, V> leftOfTheRights = actual.getRight();
						
						while(leftOfTheRights.getLeft() != null) {
							leftOfTheRights = leftOfTheRights.getLeft(); 
						}
						
						//Assigning the left side
						leftOfTheRights.setLeft(actual.getLeft());
						if (leftOfTheRights.getLeft() != null)
							leftOfTheRights.getLeft().setParent(leftOfTheRights);
						
						//Assiginig the right side
						if (keyComparator.compare(actual.getRight().getId(), leftOfTheRights.getId()) != 0) { //Only if the leftOfTheRights is different than root.right
							leftOfTheRights.getParent().setLeft(null);
							
							TreeNode<K, V> newRootRight = leftOfTheRights;
							
							while (newRootRight.getRight() != null) {
								newRootRight = newRootRight.getRight();
							}
							
							newRootRight.setRight(actual.getRight());
							if (newRootRight.getRight() != null) {
								newRootRight.getRight().setParent(newRootRight);;
							}
							
						}
						
						//Assginig the new parentes
						if (leftOfTheRights.getRight() != null)
							leftOfTheRights.getRight().setParent(leftOfTheRights);
						
						//Assigning new son to the parent
						leftOfTheRights.setParent(actual.getParent());
						if (isLeft) {
							leftOfTheRights.getParent().setLeft(leftOfTheRights);
						} else {
							leftOfTheRights.getParent().setRight(leftOfTheRights);
						}
						
						count--;
						return tempValue;
						
					} else { //Buscar hijo izquierdo mas derecho
						
						TreeNode<K, V> rightOfTheLefts = actual.getLeft();
						
						while(rightOfTheLefts.getRight() != null) {
							rightOfTheLefts = rightOfTheLefts.getRight(); 
						}
						
						//Assigning the right side
						rightOfTheLefts.setRight(actual.getRight());
						if (rightOfTheLefts.getRight() != null)
							rightOfTheLefts.getRight().setParent(rightOfTheLefts);
						
						//Assiginig the left side
						if (keyComparator.compare(actual.getLeft().getId(), rightOfTheLefts.getId()) != 0) { //Only if the rightOfTheLefts is different than root.left
							rightOfTheLefts.getParent().setRight(null);
							
							TreeNode<K, V> newRootLeft = rightOfTheLefts;
							
							while (newRootLeft.getLeft() != null) {
								newRootLeft = newRootLeft.getLeft();
							}
							
							newRootLeft.setLeft(actual.getLeft());
							if (newRootLeft.getLeft() != null) {
								newRootLeft.getLeft().setParent(newRootLeft);;
							}
							
						}
						
						//Assginig the new parentes
						if (rightOfTheLefts.getLeft() != null)
							rightOfTheLefts.getLeft().setParent(rightOfTheLefts);
						
						rightOfTheLefts.setParent(actual.getParent());
						if (isLeft) {
							rightOfTheLefts.getParent().setLeft(rightOfTheLefts);
						} else {
							rightOfTheLefts.getParent().setRight(rightOfTheLefts);
						}
						
						count--;
						return tempValue;
						
						
					}
					
					
					
					
					
					
					
					
				}
				
			}
			 
		} else {
			return null;
		}
	}

}
