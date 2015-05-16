package lecture19.Bus;

public abstract class Member {
	protected Bus _bus;

	public Member(final Bus bus) {
		_bus = bus;
		_bus.addMember(this);
	}

	public abstract void accept(Command c);
}
