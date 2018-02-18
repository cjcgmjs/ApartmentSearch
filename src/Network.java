import java.util.*;

public class Network {
	private final int RADIUS = 1;
	private List<List<Integer>> graph;
	private Map<String, Integer> map;
	
	public void buildGraph(List<String> dict) {
		if (dict == null) {
			System.out.println("input is null");
		} else {
			graph = new ArrayList<List<Integer>>();
			map = new HashMap<String, Integer>();
			for (int i = 0; i < dict.size(); i++) {
				map.put(dict.get(i), i);
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < dict.size(); i++) {
				for (int j = i + 1; j < dict.size(); j++) {
					if (EditDistance.editDistance(dict.get(i), dict.get(j)) <= RADIUS) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
				System.out.println(graph.get(i));
			}
		}
		
	}
	
	public int getSize(String word) {
		int size = 1;
		Integer index = map.get(word);
		if (index == null) {
			System.out.println("word " + word + " is not in dictionary");
			return size;
		}
		//De-dup
		Set<Integer> set = new HashSet<>();
		//BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		set.add(index);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> neighbors = graph.get(node);
			for (Integer nei : neighbors) {
				if (!set.contains(nei)) {
					size++;
					queue.offer(nei);
					set.add(nei);
					//System.out.println(nei);
				}
			}
		}
		return size;
	}
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		Network network = new Network();
		/*Test case 1 */
		/*List<String> dict1 = Arrays.asList("HI", "HERE", "THERE", "HER", "HE", "SHE", "HEAR", "HALLOW");
		network.buildGraph(dict1);
		System.out.println(network.getSize("HE"));*/
		
		/*Test case 2*/
		/*List<String> dict2 = Import.readLines("C:\\Users\\Jiasheng\\Downloads\\codeChallenge\\very_small_test_dictionary.txt");
		network.buildGraph(dict2);
		System.out.println(network.getSize("LISTY"));
		long t2 = System.currentTimeMillis();*/
		
		List<String> dict = Import.readLines("C:\\Users\\Jiasheng\\Downloads\\codeChallenge\\dictionary.txt");
		network.buildGraph(dict);
		System.out.println(network.getSize("LISTY"));
		long t2 = System.currentTimeMillis();
		System.out.println("Time: " + (t2 - t1));
	}
} 
