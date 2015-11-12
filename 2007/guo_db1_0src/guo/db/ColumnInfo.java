package guo.db;

public class ColumnInfo {

	public ColumnInfo() {
	}

	public ColumnInfo(String name, String className) {
		this.name = name;
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public String getName() {
		return name;
	}

	public void setClassName(String string) {
		className = string;
	}

	public void setName(String string) {
		name = string;
	}

	public String toString() {
		return name;
	}

	private String name;
	private String className;
}
