package main;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import composanteGraphique.Graphique;
import composanteGraphique.Ligne;
import composanteGraphique.Point;
import gestionInformation.ReseauTMP;
import interfaces.CarteInterface;
import interfaces.LoginInterface;
import interfaces.ReservationInterface;
import interfaces.StationInterface;
import interfaces.TrainInterface;

public class Main extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CarteInterface carte = new CarteInterface(getX(),getY(),getWidth(),getHeight());
	private LoginInterface login = new LoginInterface(getX(),getY(),getWidth(),getHeight());
	private ReservationInterface reservation = new ReservationInterface (getX(),getY(),getWidth(),getHeight());
	private StationInterface station = new StationInterface(getX(),getY(),getWidth(),getHeight());
	private TrainInterface train = new TrainInterface(getX(),getY(),getWidth(),getHeight());


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.login.requestFocusInWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(login);
		
		login.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
				case "passerCarte":
					login.setVisible(false);
					carte.setVisible(true);
					setContentPane(carte);
					carte.requestFocusInWindow();
					break;
				}
			}
		}
		);
		
		carte.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
				case "passerReservation":
					carte.setVisible(false);
					reservation.setVisible(true);
					setContentPane(reservation);
					reservation.requestFocusInWindow();
					break;
				case "passerStation":
					carte.setVisible(false);
					station.setVisible(true);
					setContentPane(station);
					station.requestFocusInWindow();
					break;
				case "passerTrain":
					carte.setVisible(false);
					train.setVisible(true);
					setContentPane(train);
					train.requestFocusInWindow();
					break;
				case "logout":
					carte.setVisible(false);
					login.setVisible(true);
					setContentPane(login);
					login.requestFocusInWindow();
					break;
				}
			}
		}
		);
		reservation.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
				case "back":
					reservation.setVisible(false);
					carte.setVisible(true);
					setContentPane(carte);
					carte.requestFocusInWindow();
					break;
				}
			}
		}
		);
		station.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
				case "back":
					station.setVisible(false);
					carte.setVisible(true);
					setContentPane(carte);
					carte.requestFocusInWindow();
					break;
				}
			}
		}
		);
		train.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent evt) {
				switch (evt.getPropertyName()) {
				case "back":
					train.setVisible(false);
					carte.setVisible(true);
					setContentPane(carte);
					carte.requestFocusInWindow();
					break;
				}
			}
		}
		);
	}

}
