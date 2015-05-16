package Gra.Brez.Jarv;

import java.util.Collections;
import java.util.LinkedList;

public class Jarv2 extends Jarv {
	public static void calc() {
		int n = p.size();
		LinkedList<Integer> P = new LinkedList<>();
		for (int i = 0; i < n; i++)
			P.add(i);

		for (int i = 0; i < P.size(); i++) {
			if (p.get(P.get(i)).x() < p.get(P.get(0)).x())
				Collections.swap(P, 0, i);
		}

		ip.add(P.get(0));
		P.remove(0);
		P.offer(ip.get(0));
		while (true) {
			int right = 0;

			for (int i = 0; i < P.size(); i++) {
				if (rotate(p.get(ip.getLast()), p.get(P.get(right)),
						p.get(P.get(i))) < 0) {
					right = i;
				}
			}
			if (P.get(right) == ip.getFirst()) {
				break;
			} else {
				ip.offerLast(P.get(right));
				P.remove(right);
			}

		}

	}

	private static float rotate(final Point2d A, final Point2d B,
			final Point2d C) {
		return (B.x() - A.x()) * (C.y() - B.y()) - (B.y() - A.y())
				* (C.x() - B.x());
	}
}
