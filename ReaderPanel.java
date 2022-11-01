import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReaderPanel extends JPanel{
	private int pageNum;
	private int pageTotal;
	private int scrollBarSize;
	private int scrollBarTop;
	private int scrollBarBottom;
	private int scrollBarPosition;
	private JPanel infoPanel;
	private JPanel navPanel;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JLabel pageLabel;
	private JTextArea bookTextArea;
	private JScrollPane bookTextScrollPane;
	private JButton pageUpButton;
	private JButton pageDownButton;
	
	
	public ReaderPanel() {
		setPreferredSize(new Dimension(400, 500));
		setLayout(new BorderLayout());
		infoPanel = new JPanel();
		add(infoPanel, BorderLayout.NORTH);
		infoPanel.setLayout(new GridLayout(1, 3));
		titleLabel = new JLabel("Title");
		authorLabel = new JLabel("author");
		pageLabel = new JLabel("Page");
		infoPanel.add(titleLabel);
		infoPanel.add(authorLabel);
		infoPanel.add(pageLabel);
		
		
		Scroller scroll = new Scroller();
		bookTextArea = new JTextArea();
		add(bookTextArea, BorderLayout.CENTER);
		bookTextScrollPane = new JScrollPane(bookTextArea);
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("A Book a Day..."));
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookTextScrollPane.getVerticalScrollBar().addAdjustmentListener(scroll);
		add(bookTextScrollPane);
		
		navPanel = new JPanel();
		pageUpButton = new JButton("Page Up");
		pageUpButton.addActionListener(new PageUpButton());
		pageDownButton = new JButton("Page Down");
		pageDownButton.addActionListener(new PageDownButton());
		navPanel.add(pageUpButton);
		navPanel.add(pageDownButton);
		add(navPanel, BorderLayout.SOUTH);
	}
	
	public void setTitleLable(String s) {
		titleLabel.setText(s);
			}
	
	public void setAuthorLable(String s) {
		authorLabel.setText(s);
			}
	
	public void setPageLable(String s) {
		pageLabel.setText(s);
			}
	
	public void setBookTextArea(String s) {
		this.bookTextArea.setText(s);
			}
	public class Scroller implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			scrollBarTop = bookTextScrollPane.getVerticalScrollBar().getMinimum();
			scrollBarBottom = bookTextScrollPane.getVerticalScrollBar().getMaximum();
			scrollBarPosition = bookTextScrollPane.getVerticalScrollBar().getValue();
			scrollBarSize = bookTextScrollPane.getVerticalScrollBar().getBlockIncrement(1);
			
			if(scrollBarPosition==scrollBarTop && scrollBarPosition + scrollBarSize == scrollBarBottom){
				bookTextScrollPane.getVerticalScrollBar().setValue(0);
				pageNum = 1;
				pageUpButton.setVisible(false);
				pageDownButton.setVisible(false);
				
			}else if(scrollBarPosition==scrollBarTop) {
				bookTextScrollPane.getVerticalScrollBar().setValue(0);
				pageNum = 1;
				pageUpButton.setVisible(false);
				pageDownButton.setVisible(true);
			}else if(scrollBarPosition + scrollBarSize == scrollBarBottom) {
				pageUpButton.setVisible(true);
				pageDownButton.setVisible(false);
			}else {
				pageUpButton.setVisible(true);
				pageDownButton.setVisible(true);
			}
			pageNum = scrollBarPosition/scrollBarSize+1;
			pageTotal = scrollBarBottom/ scrollBarSize;
			pageLabel.setText(pageNum + "/ " + pageTotal); 
		}
	}
		
	private class PageUpButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		bookTextScrollPane.getVerticalScrollBar().setValue(scrollBarPosition - scrollBarSize);
		pageLabel.setText(pageNum + "/ " + pageTotal);
		revalidate();
		}
			
	}
	private class PageDownButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		bookTextScrollPane.getVerticalScrollBar().setValue(scrollBarPosition + scrollBarSize);
		pageLabel.setText(pageNum + "/ " + pageTotal);
		revalidate();
		}
			
	}
		

}
