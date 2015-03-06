/**
 * This class helps make a node in the tree
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Node {
	//variable to hold value of element
	String data;
	//variable to refer to left leaf node
	Node left;
	//variable to refer to right leaf node
	Node right;

	//constructor to set current value 
	public Node(String data) {
		this.data = data;
	}
}