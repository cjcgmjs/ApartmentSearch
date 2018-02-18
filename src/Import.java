import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Import {
	public static List<String> readLines(String filename) {
		List<String> lines = new ArrayList<String>();
		String line = null;
		try {
			FileReader fileReader = new FileReader(filename);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			

			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}

			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(lines);
		return lines;
	}
}
