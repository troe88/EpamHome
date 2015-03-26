package lecture9.inheritance;

public class ColoredWindow extends Window{
	int _backgroundColor;

	public int getBackgroundColor() {
		return _backgroundColor;
	}

	public void setBackgroundColor(final int backgroundColor) {
		this._backgroundColor = backgroundColor;
	}
}
