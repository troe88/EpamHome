package lecture19.Bus;

public class A extends Member {

	public A(final Bus bus) {
		super(bus);
	}
	
	public void change() {
		System.out.println("I'm changed");
		_bus.broadcast(new ChangedCommand(this));
	}

	@Override
	public void accept(final Command c) {
		// ignore
	}
	
}
