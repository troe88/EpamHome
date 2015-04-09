package Misha_1;

public class Str {
	public static void main(final String[] args) {

		if (args.length != 3) {
			help();
			System.exit(0);
		}

		if (args[2].length() != 1) {
			help();
			System.exit(0);
		}

		try {
			int shift_count = Integer.parseInt(args[1]);
			switch (args[2].charAt(0)) {
			case 'r':
				System.out.println(shift(args[0], shift_count, true));
				break;
			case 'l':
				System.out.println(shift(args[0], shift_count, false));
				break;
			default:
				help();
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
			help();
		}
	}

	private static void help() {
		System.out.println("Usage: java prg <text> <shift_count> <way(r/l)>");
		System.out.println("Example: java prg qwer 1 r");
	}

	// true - right
	// false - left
	private static String shift(final String str, final int c, final boolean way) {
		
		int shift_count = c;
		
		if((c % str.length()) == 0 || 0 == c || str.length() < 2){
			return str;
		}
		
		if(c > str.length()){
			shift_count -= str.length();
		}
		
		StringBuilder b = new StringBuilder(str);
		for (int i = 0; i < shift_count; i++) {
			if (way) {
				b.insert(0, b.charAt(b.length() - 1));
				b.deleteCharAt(b.length() - 1);
			} else {
				b.append(b.charAt(0));
				b.deleteCharAt(0);
			}
		}
		return b.toString();
	}
}
