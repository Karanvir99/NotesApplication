package notes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestHarness extends AllNotes {
    public static void main(String[] args) {
        TestHarness th = new TestHarness();
    }
    
    public TestHarness() {
        ArrayList<Note> n = new ArrayList<>();
        n = getAllNotes();
        JOptionPane.showMessageDialog(null, n.size());
    }
}
