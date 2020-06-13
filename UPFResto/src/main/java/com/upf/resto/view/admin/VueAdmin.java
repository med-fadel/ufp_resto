package com.upf.resto.view.admin;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VueAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public VueAdmin() {
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
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new VueAdmin();
	}
}
