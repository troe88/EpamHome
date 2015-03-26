package lecture9.inheritance.restriction;

public class B extends A {
	@Override
	protected void one() {
		// TODO Auto-generated method stub
		super.one();
	}

	@Override
	protected void two() {
		// TODO Auto-generated method stub
		super.two();
	}

	@Override
	public void there() {
		throw new UnsupportedOperationException("this operation is prohibbited");
	}

}
