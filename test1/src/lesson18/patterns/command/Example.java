package lesson18.patterns.command;

public class Example {

	static abstract class Command {
		Service _service;
		public Command(final Service service) {
			_service = service;
		}
		abstract public void exec();
	}
	
	static class Do2Command extends Command {

		public Do2Command(final Service service) {
			super(service);
		}

		@Override
		public void exec() {
			_service.doTomething2();
		}
		
	}

	public static void main(final String[] args) {
		System.out.println("start");
		Service service = new Service();
		service.doTomething();
		service.doTomething2();
		service.doTomething3();
		
		Command command = new Do2Command(service);
		command.exec();
		
		System.out.println("finish");
	}
}
