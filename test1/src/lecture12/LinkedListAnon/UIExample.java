package lecture12.LinkedListAnon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIExample {

	static class ButtonClickProc implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println(e.getActionCommand());
		}
	}

	public static void main(final String[] args) {
		JFrame frame = new JFrame("example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Push me!") {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(150, 20);
			}
		};
		button.setSize(100, 30);
		button.setLocation(95, 45);

		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(final MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseReleased");

			}

			@Override
			public void mousePressed(final MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mousePressed");
			}

			@Override
			public void mouseExited(final MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseExited");

			}

			@Override
			public void mouseEntered(final MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseEntered");
			}

			@Override
			public void mouseClicked(final MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseClicked");
			}
		});

		JPanel contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		contentPane.add(button);

		frame.setContentPane(contentPane);
		frame.setSize(310, 125);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}
