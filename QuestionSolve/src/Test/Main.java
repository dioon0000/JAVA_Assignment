package Test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
class MyFrame extends JFrame{
	public static final int easyField = 90; //10x9
	public static final int nomarlField = 256; //16X16
	public static final int hardField = 480; //30x16
	
	//Constructor
		MyFrame(){
			//Default Setting
			setTitle("MineSweeper");
			setSize(500, 500);
			setLocation(700,100);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Component
			JPanel mainPanel = new JPanel();
			JPanel upperPanel = new JPanel();
			JPanel lowerPanel = new JPanel();
			JLabel mineCounter = new JLabel("Mine Count : 000");
			JLabel timeCounter = new JLabel("Time Count : 000");
			JButton resetButton = new JButton();
			JButton[] buttons = new JButton[100];
			ImageIcon smile = new ImageIcon("C:/Users/dioon/OneDrive/바탕 화면/eclipse/smile.png");
			//add
			resetButton.setIcon(smile);
			upperPanel.add(mineCounter);
			upperPanel.add(resetButton);
			upperPanel.add(timeCounter);
			lowerPanel.setLayout(new GridLayout(10, 9));
			for(int i=0; i<easyField; ++i) {
				lowerPanel.add(buttons[i] = new JButton());
			}
			this.add(upperPanel, BorderLayout.NORTH);
			this.add(lowerPanel, BorderLayout.CENTER);
			
			setVisible(true);
		}
}
//기본 Main 구문
public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//MyFrame 객체 생성
		MyFrame mf = new MyFrame();
	}
}