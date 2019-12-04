package devenSearch;

//you can add other public classes to this editor in any order
public class Vertex {
	String name;
	int data;
	Vertex[] childvertices;
	boolean visited;

	public Vertex(String name, int data, boolean visited) {
		this.name = name;
		this.data = data;
		this.visited = visited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Vertex[] getChildvertices() {
		return childvertices;
	}

	public void setChildvertices(Vertex[] childvertices) {
		this.childvertices = childvertices;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
