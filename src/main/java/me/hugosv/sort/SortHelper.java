package me.hugosv.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo Sanchez
 * @param <T>
 */
public class SortHelper<T extends Comparable<T>> {
	
	public void shell(T[] a) {
		int inc = a.length / 2;
		
		while(inc > 0) {
			for (int i = inc; i < a.length; i++) {
				int j = i;
				T temp = a[i];
				while(j >= inc && a[j - inc].compareTo(temp) > 0) {
					a[j] = a[j - inc];
					j = j - inc;
				}
				a[j] = temp;
			}
			if(inc == 2)
				inc = 1;
			else
				inc *= (5.0 / 11);
		}
	}
	
	public List<T> quickSort(List<T> arr) {
		if (!arr.isEmpty()) {
			T pivot = arr.get((arr.size() - 1) / 2);

			List<T> less = new ArrayList<>();
			List<T> pivotList = new ArrayList<>();
			List<T> more = new ArrayList<>();

			// Partition
			for (T i: arr) {
				if (i.compareTo(pivot) < 0)
					less.add(i);
				else if (i.compareTo(pivot) > 0)
					more.add(i);
				else
					pivotList.add(i);
			}

			// Recursively sort sublists
			less = quickSort(less);
			more = quickSort(more);

			// Concatenate results
			less.addAll(pivotList);
			less.addAll(more);
			return less;
		}
		return arr;
	}
	
}
