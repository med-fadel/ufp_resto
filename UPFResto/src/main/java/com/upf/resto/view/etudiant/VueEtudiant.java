package com.upf.resto.view.etudiant;

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
		/* TODO
		try {
			Registry registry = LocateRegistry.getRegistry();
			service = (RmiService) registry
					.lookup("RestoService");
		} catch (RemoteException | NotBoundException e) {
			System.exit(0);
		}
		*/

		final JDialog frame = new JDialog(this, "Login", true);
		frame.getContentPane().add(new VueLogin((login, mdp) -> {
			//TODO etudiant = service.auth(login, mdp);
			etudiant = new Etudiant();
			etudiant.setNom("Toto");
			etudiant.setPrenom("Ba");
			etudiant.setDateDeNaissance(new Date());
			etudiant.setSexe("Male");
			etudiant.setEmail("toto@org.com");
			etudiant.setFormation(Formation.CONTINUE);
			etudiant.setSolde(20.0);
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