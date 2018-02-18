import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NetworkTest {

	@Test
	public void test1() {
		Network network = new Network();
		List<String> dict = Arrays.asList("HI", "HERE", "THERE", "HER", "HE", "SHE", "HEAR", "HALLOW");
		network.buildGraph(dict);
		int size = network.getSize("HE");
		assertEquals(size, 7);
	}
	
	@Test
	public void test2() {
		Network network = new Network();
		List<String> dict = Import.readLines("C:\\Users\\Jiasheng\\Downloads\\codeChallenge\\very_small_test_dictionary.txt");
		network.buildGraph(dict);
		int size = network.getSize("LISTY");
		assertEquals(size, 5);
	}

}
