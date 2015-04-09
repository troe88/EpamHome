package lecture14;

public class EvilStack extends MyStack{

	public EvilStack(final int capacity) throws MyStackFullExseption {
		super(capacity);
	}

	@Override
	public Object pop(){
		try {
			return super.pop();
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void push(final Object o) {
		super.push(o);
	}
}
