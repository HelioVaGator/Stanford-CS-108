/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	List<T> rules;
	int length;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
		this.length = rules.size();
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set<T> set = new HashSet<T>();

		for (int i = 0; i < length - 1; i++) {
			if(rules.get(i).equals(elem) && rules.get(i+1)!=null) {
				set.add(rules.get(i+1));
			}
		}
		
		 return set;
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		Set<T> set = new HashSet<T>();
		int listLength = list.size();

		int i = 0;

		while (i < listLength) {
			set = noFollow(list.get(i));
			while ((i + 1) < listLength && set.contains(list.get(i + 1))) {
				list.remove(i + 1);
				listLength--;
			}

			i++;
		}

		
	}
}
