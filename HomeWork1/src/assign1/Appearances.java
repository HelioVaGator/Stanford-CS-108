package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {

		HashMap<T,Integer> mapA = new HashMap<T, Integer>();
		HashMap<T,Integer> mapB = new HashMap<T, Integer>();
		int sameCount = 0;

		for (T t : a) {
			if(!mapA.containsKey(t)) {
				mapA.put(t, 1);
			} else {
				mapA.replace(t, mapA.get(t), mapA.get(t)+1);
			}
		}

		for (T t : b) {
			if(!mapB.containsKey(t)) {
				mapB.put(t, 1);
			} else {
				mapB.replace(t, mapB.get(t), mapB.get(t)+1);
			}
		}

		//System.out.println(mapA.toString());
		//System.out.println(mapB.toString());

		for (T t : mapA.keySet()) {
			if(mapB.containsKey(t) && mapA.get(t).equals(mapB.get(t))) {
				sameCount++;
			}
		}

		return sameCount;
	}
	
}
