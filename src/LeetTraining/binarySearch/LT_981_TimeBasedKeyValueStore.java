package LeetTraining.binarySearch;

import java.util.*;
public class LT_981_TimeBasedKeyValueStore {

	/*
	 * Design a time-based key-value data structure that can store multiple values for the same key 
	 * at different time stamps and retrieve the key's value at a certain timestamp. 
	 * Implement the TimeMap class:
	 * TimeMap() Initializes the object of the data structure.
	 * void set(String key, String value, int timestamp) Stores the key key with the value value at the 
	 * given time timestamp.
	 * String get(String key, int timestamp) Returns a value such that set was called previously, with 
	 * timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated 
	 * with the largest timestamp_prev. If there are no values, it returns "".
	 */
	
	
	
	class TimeMap {
		
		class TimeValuePair {
			private int timestamp;
			private String value;
			public TimeValuePair(int timestamp, String value){
				this.timestamp = timestamp;
				this.value = value;
			}
			public int getTimestamp() {return timestamp;}
			public String getValue() {return value;}
		}
		
		Map<String, List<TimeValuePair>> map;

		public TimeMap() {
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			List<TimeValuePair> list = map.get(key);
			if(list == null) {
				list = new ArrayList<>();
				map.put(key, list);
			}
			list.addLast(new TimeValuePair(timestamp, value));
		}
		

		public String get(String key, int timestamp) {
			List<TimeValuePair> list = map.get(key);
			if(list == null || list.isEmpty()|| list.get(0).getTimestamp() > timestamp)
				return "";

			int left = 0;
			int right = list.size() - 1;
			int largestTimePos = -1;
			while(left <= right) {
				int mid = left + (right - left)/2;
				int otherTime = list.get(mid).getTimestamp();
				if(otherTime <= timestamp){//if timestamp_prev <= timestamp, try getting a bigger one, so go right
					largestTimePos = mid;
					left = mid + 1;
				}
				else 
					right = mid - 1;//If not, go left
			}
			return list.get(largestTimePos).getValue();
		}
	}
	
//	private int getInsertPosition(List<TimeValuePair> list, int timestamp) {
//	int left = 0;
//	int right = list.size() - 1;
//	while(left <= right) {
//		int mid = left + (right - left)/2;
//		int otherTime = list.get(mid).getTimestamp();
//		if(otherTime == timestamp) {
//			return mid;
//		}
//		else if(otherTime < timestamp)
//			left = mid + 1;
//		else 
//			right = mid - 1;
//	}
//	return left;
//	
//}
}
