package interfaces;

import java.awt.EventQueue;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import composanteGraphique.Graphique;
import composanteGraphique.Ligne;
import composanteGraphique.Point;
import gestionInformation.ReseauTMP;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarteInterface extends JPanel {

	private JPanel contentPane;
	private final PropertyChangeSupport PCS = new PropertyChangeSupport(this);
	private Graphique graphique;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		PCS.addPropertyChangeListener(listener);
	}

	
	public CarteInterface(int x, int y, int tailleX, int tailleY) {
		
		setBounds(100, 100, 1000, 511);
		setLayout(null);
		
		JButton btnReservation = new JButton("Reservation");
		
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation();
			}
		});
		
		btnReservation.setBounds(10, 477, 122, 23);
		add(btnReservation);
		
		JButton btnStation = new JButton("Station");
		btnStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				station();
			}
		});
		btnStation.setBounds(142, 477, 122, 23);
		add(btnStation);
		
		JButton btnTrain = new JButton("Train");
		btnTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train();
			}
		});
		btnTrain.setBounds(274, 477, 122, 23);
		add(btnTrain);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		btnLogout.setBounds(406, 477, 122, 23);
		add(btnLogout);
		
		ArrayList<Point> listePoints = ReseauTMP.ajouterStation();
		ArrayList<Ligne> listeLignes = ReseauTMP.ajouterRails(listePoints);
		graphique = new Graphique(5972, listePoints, listeLignes);
		graphique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("postion X:"+e.getX()+" position y:"+ e.getY());
				graphique.getPpm();
				for(int i =0;i<graphique.getPoints().size();i++) {
					
					if(graphique.getPoints().get(i).contains(e.getX() / graphique.getPpm(), (graphique.getHeight() - e.getY()) / graphique.getPpm())) {
						station();
						break;
					}
				}
			}
		});
		graphique.setBounds(10, 11, 980, 455);
		add(graphique);
		requestFocusInWindow();
		
		
		
	}
	public void reservation() {
		PCS.firePropertyChange("passerReservation", 0, -1);
	}
	public void station() {
		PCS.firePropertyChange("passerStation", 0, -1);
	}
	public void train() {
		PCS.firePropertyChange("passerTrain", 0, -1);
	}
	public void logout() {
		PCS.firePropertyChange("logout", 0, -1);
	}
}
