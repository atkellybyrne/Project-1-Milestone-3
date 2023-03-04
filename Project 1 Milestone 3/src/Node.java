
public class Node {

	private int data;
	private Node nxtPoint;
	private Node prevPoint;

	public Node(int datas) {
		data = datas;
		nxtPoint = null;
		prevPoint = null;
	}
	
	public Node() {
		data = -1;
		nxtPoint = null;
		prevPoint = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int datas) {
		data = datas;
	}

	public Node getNext() {
		return nxtPoint;
	}

	public void setNext(Node nextPointer) {
		nxtPoint = nextPointer;
	}
	
	public Node getPrev() {
		return prevPoint;
	}
	
	public void setPrev(Node prevPointer) {
		prevPoint = prevPointer;
	}

}
