package com.upf.resto.view.admin;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.business.CommandeManager;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Repas;

public class VueCommandeListe extends JPanel{

	private static final long serialVersionUID = 1L;

	private @Autowired CommandeManager commandeManager;
	private List<Commande> commandes = new ArrayList<>();

	public VueCommandeListe() {
		commandes = commandeManager.listerCommandes();
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		JTable table = new JTable(new CommandeTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		p.add(scrollPane);
		add("Center", p);
		
		JButton validButton = new JButton("Valider");
		validButton.addActionListener((event)->{
			int index = table.getSelectedRow();
			if(index>= 0) {
				Commande commande = commandes.get(index);
				commandeManager.validerCommande(commande.getId());
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
				String collect = commande.getRepas().stream().map(Repas::getLabel).collect(Collectors.joining(","));
				return collect;
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
