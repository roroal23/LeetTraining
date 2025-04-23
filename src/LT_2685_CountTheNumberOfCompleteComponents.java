import java.util.*;

public class LT_2685_CountTheNumberOfCompleteComponents {
	public static int countCompleteComponents(int n, int[][] edges) {
        
		//edges[][] is a list of edges, edges[i] = [v1,v2]
		//Kruskal algorithm
		//If two nodes are connected each of the node contained with its component are connected
		int[] components = new int[n];
		for(int i = 0; i < n; i++)//At the beggining each node is part of a different component
			components[i] = i;
		
		for(int[] edge: edges) {//We iterate through the edges
			System.out.println(Arrays.toString(edge) +  ": " + Arrays.toString(components));
			int leftComp = components[edge[0]];
			int rightComp = components[edge[1]];
			if(leftComp != rightComp) {//If the nodes are part of a different component
				int minComponent = Math.min(rightComp, leftComp);
				int maxComponent = Math.max(rightComp, leftComp);
				for(int i = 0; i < components.length; i++) {
					if(components[i] == maxComponent) {
						components[i] = minComponent;
					}
				}
			}
		}
		
		//We groups the nodes by their component
		Map<Integer, Set<Integer>> groups = new HashMap<>();
		for(int i = 0; i < n; i++) {
			int comp = components[i];
			Set<Integer> nodes = groups.get(comp);
			if(nodes == null) {
				nodes = new HashSet<>();
				groups.put(comp, nodes);
			}
			nodes.add(i);
		}
		
		//For each component we count its edges
		Map<Integer, Integer> edgeCount = new HashMap<>();
		for(int[] edge: edges) {
			int comp = components[edge[0]];
			int count = edgeCount.getOrDefault(comp, 0);
			edgeCount.put(comp, count + 1);
		}
		
		//We expect to get n*(n-1) /2 edges on each component
		int completeComps = 0;
		for(int comp: groups.keySet()) {
			int actualCount = edgeCount.getOrDefault(comp, 0);
			int len = groups.get(comp).size();
			int expectedCount = (len * (len-1)) /2;
			if(actualCount == expectedCount)
				completeComps++;
		}
		
		return completeComps;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
		System.out.println(countCompleteComponents(n, edges));
	}
}
