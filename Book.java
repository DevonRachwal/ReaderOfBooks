import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Book implements BookInterface{
	private String title;
	private String author;
	private String genre;
	private String filename;
	
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		genre = null;
		filename = null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return this.author;
	}

	@Override
	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		this.author = author;
	}

	@Override
	public String getGenre() {
		// TODO Auto-generated method stub
		return this.genre;
	}

	@Override
	public void setGenre(String genre) {
		// TODO Auto-generated method stub
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return this.filename;
	}

	@Override
	public void setFilename(String filename) {
		// TODO Auto-generated method stub
		this.filename = filename;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(this.title == null || this.author == null || this.genre == null || this.filename == null) {
			return false;
		}else{ 
			return true;
		}
	}
	
	public String toString() {
		return "Title: " + this.getTitle() + "\tAuthor: " + this.getAuthor() + "\tGenre: " + this.getGenre() + "\tFileName: " + this.getFilename();
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		File file = new File(filename);
		String text = "";
		if(file.isFile() && file.exists()) {
			try {
				Scanner fScan = new Scanner(file);
				while(fScan.hasNextLine()) {
					text += fScan.nextLine() + "\n";
					
				}
				fScan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				text = "file Does Not Exist";
			}
		}
		return text;
	}

}
