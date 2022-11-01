import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BookButton extends JButton{
	private int MAX_TEXT_LENGTH = 20;
	private String ELLIPSES = "...";
	private Book book;
	
	
	
	public BookButton(Book b) {
		this.book = b;
		setTitleText();
		setToolTipText(book.getTitle()+ "      " + book.getAuthor() + "      " + book.getGenre());
		
	}
	
	public Book getBook() {
		return book;
		
	}
	
	public void setTitleText() {
		if(book.getTitle().length()>MAX_TEXT_LENGTH) {
			setText(book.getTitle().substring(0, MAX_TEXT_LENGTH));
		}else {		
			setText(book.getTitle());
			
		}
			
		
	}
	
		

}
