package lecture5;

public class B extends A {
	public int q;
	private int w;
	protected int s;
	{
		q = w = s = 0;
	}

	public B() {
		super(10);
	}

	public int get_i() {
		qqww();
		return this.i;
	}

	private void qqww() {
		i++;
	}
}
