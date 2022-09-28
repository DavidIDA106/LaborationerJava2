package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		List<TextProcessor> list = new ArrayList<TextProcessor>();
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor n = new SingleWordCounter("norge");
		list.add(p);
		list.add(n);

		TextProcessor multi = new MultiWordCounter(REGIONS);
		
		Scanner s  = new Scanner(new File("edaa30ht22-workspace/lab2/nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			//list.get(0).process(word);
			list.forEach((a) -> a.process(word));
			multi.process(word);

		}

		s.close();

		p.report();
		n.report();
		multi.report();
	}
}