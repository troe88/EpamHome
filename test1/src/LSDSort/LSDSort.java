package LSDSort;

import java.util.Random;

public class LSDSort {

	final public static int MAX = 10000000;
	private final static int BITS_PER_BYTE = 8;

	public static void genRandArray(int[] arr, boolean is_negative) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			if (is_negative)
				arr[i] = rand.nextInt(MAX) - MAX / 2;
			else
				arr[i] = rand.nextInt(MAX);
		}
	}

	public static void sort(String[] s, int W) {
		int R = 256;
		int N = s.length;
		String[] aux = new String[N];

		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];

			for (int i = 0; i < N; i++) {
				char c = s[i].charAt(d);
				int ii = c;
				count[ii + 1]++;
			}

			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			for (int i = 0; i < N; i++) {
				char c = s[i].charAt(d);
				int ii = c;
				int iii = count[ii]++;
				aux[iii] = s[i];
			}

			for (int i = 0; i < N; i++) {
				s[i] = aux[i];
			}

		}

	}

	public static void sort(String[] s) {
		int R = 255;
		int[] count = new int[R + 1];
		int N = s.length;
		String[] aux = new String[N];

		for (int i = 0; i < N; i++)
			count[s[i].toCharArray()[0] + 1]++;

		for (int r = 0; r < R; r++)
			count[r + 1] += count[r];

		for (int i = 0; i < N; i++) {
			int ii = s[i].toCharArray()[0];
			int iii = count[ii];
			aux[iii] = s[i];
		}

		System.arraycopy(aux, 0, s, 0, N);
	}

	public static void sort_(int[] src) {
		int W = 32 / BITS_PER_BYTE; // sizeof(int)
		int R = 256; // one byte 0-256
		int MASK = 0xFF; // for each iteration need only last 8 bits
		int N = src.length; // length of input array
		int[] aux = new int[N]; // temp array for sort

		int neg_count = 0; // count negative numbers

		// —ортировка 32-bit целых чисел
		// —ортируем каждые 8 бит числа начина€ с конца
		for (int d = 0; d < W; d++) {

			// ¬спомогательный масси дл€ хранени€ кол-ва индексов.
			int[] count = new int[R + 1];

			// ѕроходим по начальному массиву, и
			// 1. если число отрицательное, увеличиваем счетчик на 1
			// 2. сдвигаем начальное число на 8 * номер_итерации и берем
			// последние 8 бит
			// 3. в счетчике индексов увеличиваем полученный в п.2 индекс на 1
			for (int i = 0; i < N; i++) {
				if (src[i] < 0)
					neg_count++;

				int temp = (src[i] >> BITS_PER_BYTE * d) & MASK;
				count[temp + 1]++;
			}

			// ѕреобразовываем индексы в счетчике индексов в реальные индексы
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// «аполн€ем вспомогательный массив реальными данными солгаснго
			// счетчику индексов
			for (int i = 0; i < N; i++) {
				int temp = (src[i] >> BITS_PER_BYTE * d) & MASK;
				aux[count[temp]++] = src[i];
			}

			//  опируем значени€ из вспомогательного массива в исходный
			System.arraycopy(aux, 0, src, 0, N);
		}

		// ¬ычисл€ем реальное количество отрицательных э-тов
		neg_count /= W;

		// ≈сли в массиве всего 1 отрицательный элемент, выполн€ем перестановку
		// 0 и последнего э-та
		if (neg_count == 1) {
			int temp = src[N - 1];
			src[N - 1] = src[0];
			src[0] = temp;
		}
		// ≈сли в массиве более 1 отрицательного элемента, то
		// 1. —оздаем вспомогательный массив n_temp дл€ отрицательных элементов
		// 2.  опируем все отрицальные элементы из исходного отсортированного
		// массива src в вспомогательный массив n_temp
		// 3. —мещаем все положительные элементы в конец исходного
		// отсортированного массива src
		// 4.  опируем все элементы из вспомогательного массива n_temp в
		// исходный отсортированный массив src
		else if (neg_count > 1) {
			int[] n_temp = new int[neg_count];
			int p = N - neg_count;
			System.arraycopy(src, p, n_temp, 0, neg_count);
			System.arraycopy(src, 0, src, neg_count, p);
			System.arraycopy(n_temp, 0, src, 0, neg_count);
		}
	}

	public static void sort(int[] a) {
		int BITS = 32; // each int is 32 bits
		int W = BITS / BITS_PER_BYTE; // each int is 4 bytes
		int R = 1 << BITS_PER_BYTE; // each bytes is between 0 and 255
		int MASK = R - 1; // 0xFF

		int N = a.length;
		int[] aux = new int[N];

		for (int d = 0; d < W; d++) {

			// compute frequency counts
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				// int t = a[i];
				// t = (t >> BITS_PER_BYTE * d) & MASK;
				int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
				count[c + 1]++;
			}

			// compute cumulates
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];

			// for most significant byte, 0x80-0xFF comes before 0x00-0x7F
			if (d == W - 1) {
				int shift1 = count[R] - count[R / 2];
				int shift2 = count[R / 2];
				for (int r = 0; r < R / 2; r++)
					count[r] += shift1;
				for (int r = R / 2; r < R; r++)
					count[r] -= shift2;
			}

			// move data
			for (int i = 0; i < N; i++) {
				int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
				aux[count[c]++] = a[i];
			}

			// copy back
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}
	}
}
