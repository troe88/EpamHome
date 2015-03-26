package lecture10;

public class A implements Changeable{
	int _state;

	@Override
	public void change() {
		_state++;
	}
}
