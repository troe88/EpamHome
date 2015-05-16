package lecture19.Bus;

public class B extends Member {

	public B(final Bus bus) {
		super(bus);
	}

	@Override
	public void accept(final Command c) {
		System.out.println(this);
	}

}
