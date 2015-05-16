package lecture19.Bus;

public class ChangedCommand implements Command {

	private Member _m;

	public ChangedCommand(final Member m) {
		_m = m;
	}
	
	@Override
	public void exec() {
		System.out.println(this);
	}

}
