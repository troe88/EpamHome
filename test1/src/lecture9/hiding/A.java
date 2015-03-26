package lecture9.hiding;

public class A {
	int _state = 0;

	public void change() {
		_state++;
	}
	
	public int getState() {
		return _state;
	}
}
