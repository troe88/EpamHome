package lecture10;

public class Multiplier implements Changeable, Cleanable{

	int _state = 1;
	
	@Override
	public void change() {
		_state *= 2;
	}

	@Override
	public void clean() {
		System.out.println("cleaning");
		_state = 0;
	}

}
