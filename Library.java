import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library implements LibraryInterface{
	private ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	@Override
	public ArrayList<Book> getBooks() {
		// TODO Auto-generated method stub
		ArrayList<Book> copyBooks = books;
		return copyBooks;
	}

	@Override
	public void addBook(Book newBook) {
		// TODO Auto-generated method stub
		books.add(newBook);
	}

	@Override
	public void removeBook(int index) {
		// TODO Auto-generated method stub
		if(index >= 0 && index < books.size()) {
			books.remove(index);			
		}
	}

	@Override
	public Book getBook(int index) {
		// TODO Auto-generated method stub
		if(index >= 0 && index < books.size()) {
			return books.get(index);			
		}else {
			return null;			
		}
	}
	
	public String toString() {
		int i = 0;
		String s = "";
		for(Book b: books) {
			s= s.concat("Index: " + i + "\t" + b.toString()) + "\n";
			i++;
		}
		return s;
		
	}

	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		// TODO Auto-generated method stub
		File file = new File(csvFilename);
		if(file.exists() && file.isFile()) {
			try {
				Scanner fScan = new Scanner(file);
				while(fScan.hasNextLine()) {
					String line= fScan.nextLine();
					Scanner lScan = new Scanner(line);
					lScan.useDelimiter(",");
					while (lScan.hasNext()) {
						String title = lScan.next();
						String author = lScan.next();
						String genre = lScan.next();
						String filepath = lScan.next();
						Book b = new Book(title, author);
						b.setGenre(genre);
						b.setFilename(filepath);
						books.add(b);
					}
					lScan.close();
				}
				System.out.println("loaded " + books.size()+ " books!");
				fScan.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File Not found");
				System.exit(1);
			}
			
		}else {
			System.out.println("Unable to Load File");
			
		}
	}

}
