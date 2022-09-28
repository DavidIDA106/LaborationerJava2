package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("edaa30ht22-workspace/lab2/undantagsord.txt"), "UTF-8");
		Scanner s  = new Scanner(new File("edaa30ht22-workspace/lab2/nilsholg.txt"), "UTF-8");
		scan.findWithinHorizon("\uFEFF", 1);
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		
		Set<String> stopwords = new HashSet<>();

		while(scan.hasNext()){
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		
		List<TextProcessor> list = new ArrayList<TextProcessor>();
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor n = new SingleWordCounter("norge");
		TextProcessor multi = new MultiWordCounter(REGIONS);
        TextProcessor r = new GeneralWordCounter(stopwords);
		
		list.add(p);
		list.add(n);
		list.add(multi);
		list.add(r);

		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			//list.get(0).process(word);
			list.forEach((a) -> a.process(word));
			

		}

		s.close();

		p.report();
		n.report();
		multi.report();
		r.report();
	}
}