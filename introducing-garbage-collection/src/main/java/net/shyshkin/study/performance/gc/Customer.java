package net.shyshkin.study.performance.gc;

public class Customer  {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.name = name;
	}

	public Customer(Customer oldCustomer) {
		this.name = oldCustomer.name;
	}


	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("This object is being g.c.'d " + name);
	}
}
