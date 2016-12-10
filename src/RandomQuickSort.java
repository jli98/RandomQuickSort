import java.io.*;
import java.util.*;

public class RandomQuickSort {

	public static void Quicksort(int arr[], int left, int right) {
		int f, t;
		int rtemp, ltemp;

		ltemp = left;
		rtemp = right;
		Random rand = new Random();
		int r = left + rand.nextInt(right - left + 1);
		f = arr[r];
		while (ltemp < rtemp) {
			while (arr[ltemp] < f) {
				++ltemp;
			}
			while (arr[rtemp] > f) {
				--rtemp;
			}
			if (ltemp <= rtemp) {
				t = arr[ltemp];
				arr[ltemp] = arr[rtemp];
				arr[rtemp] = t;
				--rtemp;
				++ltemp;
			}
		}
		if (ltemp == rtemp) {
			ltemp++;
		}
		if (left < rtemp) {
			Quicksort(arr, left, ltemp - 1);
		}
		if (ltemp < right) {
			Quicksort(arr, rtemp + 1, right);
		}
	}

	public static void main(String[] a) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("hw3.dat"));
		int size = s.nextInt();
		int[] b = new int[size];
		for (int i = 0; i < size; i++)
			b[i] = s.nextInt();
		s.close();
		Quicksort(b, 0, b.length - 1);
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");

	}
}
