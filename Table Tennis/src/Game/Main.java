package Game; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Table extends JFrame{
	public final static int WIDTH = 720; //가로
	public final static int HEIGHT = 480; //세로
	public static int speed = 1;
	int ball_x = 50, ball_y = 50;
	int stick_y = 0;
	int ball_x_increment = speed, ball_y_increment = speed;
	
	class Tool extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//스틱
			g.setColor(Color.BLUE);
			g.fillRect(0, stick_y, 10, 80);
			//볼
			g.setColor(Color.RED);
			g.fillOval(ball_x, ball_y, 30, 30);
			ball_x += ball_x_increment; ball_y+= ball_y_increment;
			
			if(ball_y >= 410)	ball_y_increment = -speed;
			if(ball_x >= 675) ball_x_increment = -speed;
			if(ball_y <= 0) ball_y_increment = speed;
			if(ball_x <= 10 && stick_y <= ball_y && stick_y+80 >= ball_y) ball_x_increment = speed;
			if(ball_x < -20) {
				System.out.println("GAME OVER!");
				System.exit(-1);
			}
		}
	}
	//생성자
	Table(){
		//기본 세팅
		setTitle("Table Tennis");
		setSize(WIDTH, HEIGHT);
		setLocation(700,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Tool t = new Tool();
		t.requestFocus();
		t.setFocusable(true);
		t.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch(code) {
				case KeyEvent.VK_UP: 
					if(stick_y>0)
						stick_y-=30;
					break;
				case KeyEvent.VK_DOWN:
					if(stick_y<360)
						stick_y+=30;
					break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		this.add(t);
		setVisible(true);
		while(true) {
            try {
                Thread.sleep(2);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }// While문 끝
	} // 생성자 끝
} // Table 끝


//기본 Main 구문
public class Main {
	public static void main(String[] args) {
		Table table = new Table();
	}
}