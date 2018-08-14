package sayantan;

public class Node<T> {

	private T data = null;
	private Node<T> left = null;
	private Node<T> right = null;
	
	private Node<T> parent = null;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node<T> addChild(Node<T> child) {
		
		if(left == null)
			left = child;

		else if(right == null)
			right = child;
		else
			left = child;
		
		child.setParent(this);
		return child;
	}
	
	public Node<T> addChild(Node<T> ref,  Node<T> child) {
		
		if(ref == null)
			return null;

		Node<T> refNode = searchNode(ref);
		refNode.addChild(child);
		child.setParent(ref);
		return child;
	}
	
	public Node<T> searchNode(Node<T> key) {
		
		if(this.data == key.getData())
			return this;
		
		if(this.left != null)
			this.left.searchNode(key);
		
		if(this.right != null)
			this.right.searchNode(key);
		
		if(left != null && left.data == key.getData()) {
			return left;
		}
		else if(right != null && right.data == key.getData()) {
			return right;
		}
		else {
			return null;
		}
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	public Node<T> getLeft() {
		return left;
	}
	
	public Node<T> getRight() {
		return right;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
		
		left.setParent(this);
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
		
		right.setParent(this);
	}
	
	/**
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	
}
