package lesson18.patterns.command;

public class Calculator {
	int total = 0;

	abstract class Command {
		public void exec() {
			realExec();
			System.out.println(total);
		}
		
		abstract void realExec();
	}
	
	class Plus extends Command {
		int _value;
		public Plus(final int value) {
			_value = value;
		}
		@Override
		void realExec() {
			total += _value;
		}
	}

	public class Minus extends Plus {
		Minus(final int value){
			super(-value);
		}
	}

	public class Clear extends Command {
		@Override
		void realExec() {
			total = 0;
		}
	}
	
	public class Get extends Command {
		@Override
		void realExec() {
			// nothing to do
		}
	}
}
