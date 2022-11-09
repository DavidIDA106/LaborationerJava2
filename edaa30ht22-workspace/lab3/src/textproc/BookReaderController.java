package textproc;

import java.awt.Container;
import java.util.Comparator;
import java.util.Map;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {

            SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));

        }
        private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container pane = frame.getContentPane();

            JPanel panel = new JPanel();
            JButton freq = new JButton("Frequency");
            JButton alph = new JButton("Alphabetically");
            SortedListModel slm = new SortedListModel<>(counter.getWordList());
            JList<SortedListModel> wordList = new JList(slm);
            JScrollPane scroller = new JScrollPane(wordList);

            freq.addActionListener(e -> {
                System.out.println("frequency motherfucker");
            });

            Comparator<Map.Entry<String, Integer>> alphComp = (e1, e2) -> e1.getKey().compareTo(e2.getKey());
            Comparator<Map.Entry<String, Integer>> freqComp = (e1, e2) -> e2.getValue() - e1.getValue();
            alph.addActionListener(e -> {slm.sort(alphComp);});
            freq.addActionListener(e -> {slm.sort(freqComp);});
            panel.add(freq);
            panel.add(alph);


            pane.setLayout(new BorderLayout(20, 15));
            pane.add(scroller);
            pane.add(panel, BorderLayout.SOUTH);

            
            
            // pane är en behållarkomponent till vilken de övriga komponenterna
            //(listvy, knappar etc.) ska läggas till.

            frame.pack();
            frame.setVisible(true);
        }
}
