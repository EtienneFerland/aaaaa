package interfaces;

import java.awt.EventQueue;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainInterface extends JPanel {

	private final PropertyChangeSupport PCS = new PropertyChangeSupport(this);
	private JPanel contentPane;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		PCS.addPropertyChangeListener(listener);
	}
	
	public TrainInterface(int x, int y, int tailleX, int tailleY) {
		setBounds(100, 100, 904, 608);
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		requestFocusInWindow();
	}
	
	public void back() {
		PCS.firePropertyChange("back", 0, -1);
	}

}
