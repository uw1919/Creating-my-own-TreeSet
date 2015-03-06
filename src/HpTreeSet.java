/*
 * HpTreeSet.java
 * 
 * @version
 * $Id: HpTreeSet.java, Version 1.0 10/19/2014 $
 * 
 * @revision
 * $Log initial version $
 * 
 */

//import statements for classes used in program
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * This class extends TreeSet of Collections and overrides its methods
 * for our own implementation
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class HpTreeSet extends TreeSet<Object> {

	//counter variable to keep track of number of elements 
	static int counter = 0;
	//variable to keep track of root node in every iteration
	static Node root;
	//iteratorCounter increases for every iteration
	static int iteratorCounter = 0;
	//array of type Node to hold the elements of the tree
	Node[] hpArray;

	/**
	 * default constructor for class HpTreeSet
	 * 
	 */
	public HpTreeSet() {
	}
	
	/**
	 * Method to add element to tree 
	 * @param 	Object e 	pass object of type array to the tree
	 * @return 	boolean		returns true or false if object can be added
	 */
	public boolean add(Object e) {
		
		//type cast passed value to string data type
		String data = (String) e;
		//make a new object of type Node and pass data as its value
		Node newHpTreeObject = new Node(data);
		
		/*
		 * if root is null create a new node using Node, if root is not
		 * null, make a new object as root node for the next branch
		 * 
		 */
		if (root == null) {
			root = newHpTreeObject;
			++counter;
			return true;
		} else {                                 
			Node aHpTreeObject = root;
			Node parent;
			
			/*
			 * while loop to add objects to the tree. If data passed is same, 
			 * return false. If not equal, then make a new leaf node using 
			 * Node
			 */
			while (true) {
				parent = aHpTreeObject;
				
				//if value of element is same, reject it
				if (data.equals(aHpTreeObject.data))
					return false;
				
				/*
				 * depending on the value of the element passed, add child node
				 * on the left or right side
				 */
				if (data.compareTo(aHpTreeObject.data) < 0) {
					aHpTreeObject = aHpTreeObject.left;

					if (aHpTreeObject == null) {
						parent.left = newHpTreeObject;
						++counter;
						return true;
					}
				} else {
					aHpTreeObject = aHpTreeObject.right;
					if (aHpTreeObject == null) {
						parent.right = newHpTreeObject;
						++counter;
						return true;
					}
				}
			}
		}
	}

	/**
	 * Method to check if an elements exists in the tree
	 * @param 	Object o	pass the element
	 * @return 	boolean		returns true or false
	 */
	public boolean contains(Object o) {
		//type cast passed value to String data type
		String data = (String) o;
		Node aHpTreeObject = root;
		
		/*
		 * if no element exists return false else while value is not found, 
		 * compare the value to left and right child nodes and traverse 
		 * accordingly
		 */
		if (aHpTreeObject == null) {
			return false;
		} else {
			while (!data.equals(aHpTreeObject.data)) {

				if (data.compareTo(aHpTreeObject.data) < 0) {
					aHpTreeObject = aHpTreeObject.left;
				} else {
					aHpTreeObject = aHpTreeObject.right;
				}

				if (aHpTreeObject == null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * method to clear the tree by making root node null
	 */
	public void clear() {
		root = null;
		counter = 0;
	}

	/**
	 * method to return size of the tree that is number of elements in the tree
	 * @return	counter		returns number of elements
	 */
	public int size() {
		return counter;
	}

	/**
	 * Method to check if the tree is empty
	 * @return	boolean		returns true or false by checking if root node
	 * 						is null
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * This method implements logic to traverse through the tree using iterator
	 */
	public Iterator iterator() {
		//create a new array hpArray of the same size as current size of tree
		hpArray  = new Node[this.size()];
		//declare an Iterator of type Node
		Iterator<Node> hpIterate = null;
		//pass an empty iterator if isEmpty() is true
		if(isEmpty()) {
			hpIterate = Arrays.asList(hpArray).iterator();
		}
		//pass root node as the argument and traverse through the tree
		else {
			traverse(root);
			hpIterate = Arrays.asList(hpArray).iterator();
			int test = hpArray.length;
		}
		
		return hpIterate;
	}
	
	/**
	 * Method to traverse through the tree using current node
	 * @param	 current	root node passed by calling object
	 */
	public void traverse(Node current) {
		//traverse the right nodes or left nodes by comparing size 
		if(current != null && iteratorCounter < this.size()) {
			traverse(current.left);
			hpArray[iteratorCounter++] = current;
			//iteratorCounter++;
			traverse(current.right);
		}
	}
}
