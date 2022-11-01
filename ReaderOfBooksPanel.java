import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ReaderOfBooksPanel extends JPanel{
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;
	
	
	
	public ReaderOfBooksPanel() {
		setLayout(new BorderLayout());
		BookButtonListener b = new BookButtonListener();
		libraryPanel = new LibraryPanel(b);
		libraryPanel.setBackground(Color.GREEN);
		readerPanel = new ReaderPanel();
		readerPanel.setBackground(Color.BLUE);
		add(libraryPanel, BorderLayout.WEST);
		add(readerPanel, BorderLayout.CENTER);
		
		
		
	}
	
	private class BookButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			BookButton bookButt =  (BookButton) e.getSource();
			if(bookButt.getBook().isValid()) {
				String text = bookButt.getBook().getText();
				String title = bookButt.getBook().getTitle();
				String author = bookButt.getBook().getAuthor();
				readerPanel.setTitleLable(title);
				readerPanel.setAuthorLable(author);
				readerPanel.setBookTextArea(text);
				revalidate();				
			}
		}
	}

}
