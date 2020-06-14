package com.upf.resto.view.etudiant;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Formation;
import com.upf.resto.service.RmiService;

public class VueEtudiant extends JFrame{

	private static final long serialVersionUID = 1L;
	private RmiService service;
	private Etudiant etudiant;

	public VueEtudiant() {
		try {
			Registry registry = LocateRegistry.getRegistry();
			service = (RmiService) registry
					.lookup("RestoService");
		} catch (RemoteException | NotBoundException e) {
			System.exit(0);
		}

		final JDialog frame = new JDialog(this, "Login", true);
		frame.getContentPane().add(new VueLogin((login, mdp) -> {
			etudiant = service.auth(login, mdp);
			if(etudiant == null) System.exit(0);
			frame.setModal(false);
			frame.setVisible(false);
		}));

		frame.pack();
		frame.setVisible(true);

		VueRepasListe vueRepasListe = new VueRepasListe(etudiant, service);
		VueCommandeListe vuecommandeListe = new VueCommandeListe(etudiant, service);

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.add("Ajouter Commande", vueRepasListe);
		tabbedPane.add("Commandes", vuecommandeListe);

		setContentPane(tabbedPane);
		pack();
		setResizable(false);
		setTitle("Etudiant");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new VueEtudiant();
	}
}