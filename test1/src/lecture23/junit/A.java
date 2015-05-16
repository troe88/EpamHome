package lecture23.junit;

public class A {
	int state;
	
	public void change(){
	
		state++;
		if(state > 2)
			state = 0;
	}

	public void dec() {
		state--;
	}
	
}
