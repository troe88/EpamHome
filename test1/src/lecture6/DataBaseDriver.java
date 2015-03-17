package lecture6;

public class DataBaseDriver {
	public static void main(final String[] args) {
		DataBaseConnection connection1 = DataBaseConnection.create();
		DataBaseConnection connection2 = DataBaseConnection.create();
		DataBaseConnection connection3 = DataBaseConnection.create();
		DataBaseConnection connection4 = DataBaseConnection.create();
		
		
		if(connection4 == null){
			DataBaseConnection.freeAny();
			connection3.free();
		}
		System.out.println(connection1);
		System.out.println(connection2);
		System.out.println(connection3);
		System.out.println(connection4);
	}
}
