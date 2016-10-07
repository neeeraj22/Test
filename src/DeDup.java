import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		printArray(removeDuplicatesUsingLinkedHashSet());
		System.out.println();
		printArray(removeDuplicateWithoutUsingCollectionAPI());
		System.out.println();
		printArray(removeDuplicatesUsingJava8());
		System.out.println();
		printArray(removeDuplicatesUsingHashSet());
	}

	// method to remove duplicate using LinkedHashSet which will maintain the
	// original order as well.
	public static Integer[] removeDuplicatesUsingLinkedHashSet() {
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			set.add(randomIntegers[i]);
		}
		return set.toArray(new Integer[0]);
	}

	// method to remove duplicate using HashSet which will not maintain the
	// original order as well.
	public static Integer[] removeDuplicatesUsingHashSet() {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			set.add(randomIntegers[i]);
		}
		return set.toArray(new Integer[0]);
	}

	// remove duplicates without using java collection which will also maintain
	// the original order of element
	public static Integer[] removeDuplicateWithoutUsingCollectionAPI() {

		int end = randomIntegers.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (randomIntegers[i] == randomIntegers[j]) {
					int shiftLeft = j;

					for (int k = j + 1; k < end; k++, shiftLeft++) {
						randomIntegers[shiftLeft] = randomIntegers[k];
					}

					end--;
					j--;
				}
			}
		}

		Integer[] whitelist = new Integer[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = randomIntegers[i];
		}
		return whitelist;

	}

	// Below is the way to remove duplicate using java 8 stream
	public static Integer[] removeDuplicatesUsingJava8() {
		int[] temp = Arrays.stream(randomIntegers).distinct().toArray();
		Integer[] whitelist = new Integer[temp.length];
		for (int i = 0; i < temp.length; i++) {
			whitelist[i] = randomIntegers[i];
		}
		return whitelist;
	}

	// print the Integer array
	public static void printArray(Integer[] randomIntegers) {
		for (int i = 0; i < randomIntegers.length; i++) {
			System.out.print(randomIntegers[i] + ",");
		}

	}

}
