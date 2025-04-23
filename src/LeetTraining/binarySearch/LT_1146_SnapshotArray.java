package LeetTraining.binarySearch;
import java.util.*;

public class LT_1146_SnapshotArray {

	/*
	 * Implement a SnapshotArray that supports the following interface:
	 * SnapshotArray(int length) initializes an array-like data structure with the given length. Initially,
	 * each element equals 0.
	 * void set(index, val) sets the element at the given index to be equal to val.
	 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called
	 * snap() minus 1.
	 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with
	 * the given snap_id
	 */
	class SnapshotArray {

		private int snapId;
		private int[] arr;
		private List<List<Integer>> snapshots;
		
		public SnapshotArray(int length) {
			snapId = 0;
			arr =  new int[length];
			snapshots = new ArrayList<>(length);
		}

		public void set(int index, int val) {
			arr[index] = val;
		}

		public int snap() {
			+
			
			for(int i = 0;  i < arr.length; i++) {
				int currentVal = arr[i];
				
			}
			
			snapId++;
			snapshots.put(snapId, Arrays.copyOf(arr, arr.length));
			return snapId;
		}

		public int get(int index, int snap_id) {
			int[] snap = snapshots.get(snap_id);
			return snap[index];
		}
	}

}
