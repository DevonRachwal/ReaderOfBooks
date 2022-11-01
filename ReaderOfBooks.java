import javax.swing.JFrame;

public class ReaderOfBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Reader Of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReaderOfBooksPanel robPanel = new ReaderOfBooksPanel();
		frame.getContentPane().add(robPanel);
		
		frame.pack();
		frame.setVisible(true);
		

	}

}
