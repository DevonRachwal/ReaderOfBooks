import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LibraryPanel extends JPanel{
	private Library library;
	private ActionListener bookButtonListener;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private JPanel loadLibraryPanel;
	private  JTextField fileNameTextField;
	private JButton loadButton;
	
	
	
	
	public LibraryPanel(ActionListener b) {
		this.bookButtonListener = b;
		setLayout(new BorderLayout());
		library = new Library();
		
		bookListPanel = new JPanel();
		bookListPanel.setBorder(BorderFactory.createTitledBorder("Your Books"));
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
		bookListScrollPane = new JScrollPane(bookListPanel);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(bookListPanel, BorderLayout.CENTER);
		
		loadLibraryPanel = new JPanel();
		loadButton = new JButton ("LOAD");
		loadButton.addActionListener(new loadButtonListener());
		fileNameTextField = new JTextField(20);
		loadLibraryPanel.add(fileNameTextField);
		loadLibraryPanel.add(loadButton);
		add(loadLibraryPanel, BorderLayout.SOUTH);
		
		
		
		
	}
	
	private class loadButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			library.loadLibraryFromCSV(fileNameTextField.getText());
			for(Book b: library.getBooks()) {
				BookButton bookButt = new BookButton(b);
				bookButt.setTitleText();
				bookListPanel.add(bookButt);
				bookButt.addActionListener(bookButtonListener);
				revalidate();
			}
		}
			
	}
	

}
