package pizza;
import java.io.Serializable;

public class Pizza implements Serializable {

	private int size;
	private String crust;
	/**
	 * The default UID is 1
	 */
	private static final long serialVersionUID = 1L;
	
	public Pizza(int size, String crust) {
		setSize(size);
		setCrust(crust);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}
}
