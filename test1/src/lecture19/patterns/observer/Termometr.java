package lecture19.patterns.observer;

public class Termometr {
	private static final int MAX_TEMP = 3;
	int _current_temperature;
	private FirePrevSystem _system;

	public Termometr(final FirePrevSystem system) {
		_system = system;
	}

	public void increase() {
		_current_temperature++;

		if (_current_temperature > MAX_TEMP) {
			_system.turnSignalOn();
		}

	}

	public void decrease() {
		_current_temperature--;
	}
}
