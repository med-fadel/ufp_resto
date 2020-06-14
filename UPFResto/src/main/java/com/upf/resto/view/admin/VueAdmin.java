package com.upf.resto.view.admin;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class VueAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public VueAdmin() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VueCommandeListe vueAdmin = new VueCommandeListe();
		VueGestionCompte vueGestionCompte = new VueGestionCompte();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.add("Commandes", vueAdmin);
		tabbedPane.add("Comptes", vueGestionCompte);
		
		setContentPane(tabbedPane);
		pack();
		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
