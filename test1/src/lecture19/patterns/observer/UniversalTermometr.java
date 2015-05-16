package lecture19.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class UniversalTermometr {

	int _current_temperature;

	public void increase() {
		_current_temperature++;
		fireTemeratureChangeEvent();
	}

	public void decrease() {
		_current_temperature--;
		fireTemeratureChangeEvent();
	}
	
	private void fireTemeratureChangeEvent() {
		for (TermometrListener listener : _listeners) {
			listener.currentTemperature(_current_temperature);
		}
	}



	// listeners
	List<TermometrListener> _listeners = new ArrayList<TermometrListener>();

	public void addListener(final TermometrListener listener) {
		_listeners.add(listener);
	}

	public void removeListener(final TermometrListener listener) {
		_listeners.remove(listener);
	}
}
