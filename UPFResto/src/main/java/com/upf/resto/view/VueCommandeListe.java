package com.upf.resto.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.business.CommandeManager;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Repas;

public class VueCommandeListe extends JPanel{

	private static final long serialVersionUID = 1L;

	private @Autowired CommandeManager commandeManager;
	private List<Commande> commandes = new ArrayList<>();
	private JTable table;

	public VueCommandeListe() {
		setLayout(new BorderLayout());

		//Commande List
		JPanel p = new JPanel();
		table = new JTable(new CommandeTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		p.add(scrollPane);
		add("Center", p);

		JButton b = new JButton("Ajouter");
		b.addActionListener((event)->{
			Commande c = new Commande();
			c.setId("C123");
			c.setPrixTotal(100.00);
			c.setValide(false);

			Etudiant e = new Etudiant();
			e.setNom("MoMo");
			c.setEtudiant(e);

			Repas r = new Repas();
			r.setId("R123");
			c.setRepas(r);
			commandes.add(c);
			((AbstractTableModel)table.getModel()).fireTableDataChanged();
		});
		add("North", b);
		
		JButton validButton = new JButton("Valider");
		validButton.addActionListener((event)->{
			int index = table.getSelectedRow();
			if(index>= 0) {
				Commande commande = commandes.get(index);
				commande.setValide(true);
				((AbstractTableModel)table.getModel()).fireTableDataChanged();
			}
			
		});
		add("South", validButton);
	}

	@SuppressWarnings("serial")
	class CommandeTableModel extends AbstractTableModel {
		private String[] names = new String[] {"Id", "Etudiant", "Repas", "Prix", "Validee"};

		@Override
		public int getRowCount() {
			return commandes.size();
		}

		@Override
		public int getColumnCount() {
			return names.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Commande commande = commandes.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return commande.getId();
			case 1:
				return commande.getEtudiant().getNom();
			case 2:
				return commande.getRepas().getId();
			case 3:
				return commande.getPrixTotal();
			case 4:
				return commande.getValide();
			default: return null;		
			}
		}

		@Override
		public String getColumnName(int column) {
			return names[column];
		}

	}
}