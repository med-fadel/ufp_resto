package com.upf.resto.view.admin;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.business.EtudiantManager;
import com.upf.resto.datamodel.Etudiant;

public class VueGestionCompte extends JPanel{

	private static final long serialVersionUID = 1L;

	private @Autowired EtudiantManager etudiantManager;
	private List<Etudiant> etudiants = new ArrayList<>();

	public VueGestionCompte() {
		//TODO etudiants = etudiantManager.listerEtudiants();
		setLayout(new BorderLayout());
		AjouterEtudiantForm ajouterEtudiant = new AjouterEtudiantForm();

		JPanel p = new JPanel();
		JTable table = new JTable(new CommandeTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		p.add(scrollPane);
		add("Center", p);
		add("East", ajouterEtudiant);

		JButton b = new JButton("Ajouter");
		b.addActionListener((event)->{
			Etudiant etudiant = ajouterEtudiant.getEtudiant();
			//TODO etudiantManager.ajouterEtudiant(etudiant);
			etudiants.add(etudiant);
			((AbstractTableModel)table.getModel()).fireTableDataChanged();
		});
		add("South", b);


	}

	@SuppressWarnings("serial")
	class CommandeTableModel extends AbstractTableModel {
		private String[] names = new String[] {"Nom", "Prenom", "Date de Naissance", "Sexe", "Email", "Formation", "Solde", "Validite"};

		@Override
		public int getRowCount() {
			return etudiants.size();
		}

		@Override
		public int getColumnCount() {
			return names.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Etudiant etudiant = etudiants.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return etudiant.getNom();
			case 1:
				return etudiant.getPrenom();
			case 2:
				return etudiant.getDateDeNaissance();
			case 3:
				return etudiant.getSexe();
			case 4:
				return etudiant.getEmail();
			case 5:
				return etudiant.getFormation();
			case 6:
				return etudiant.getSolde();
			case 7:
				return etudiant.getValidite();
			default: return null;		
			}
		}

		@Override
		public String getColumnName(int column) {
			return names[column];
		}

	}
}