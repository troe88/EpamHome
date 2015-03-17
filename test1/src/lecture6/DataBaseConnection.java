package lecture6;

public class DataBaseConnection {
	private static final int MAX_CONNECTIONS = 3;
	private static int Counter;

	{
		Counter++;
	}
	
	public static DataBaseConnection create() {
		if (Counter >= 3)
			return null;

		return new DataBaseConnection();
	}

	
	public static void freeAny(){
		Counter--;
	}
	
	
	public void free(){
		Counter--;
	}
	
	private DataBaseConnection() {
		
	}
	
}
