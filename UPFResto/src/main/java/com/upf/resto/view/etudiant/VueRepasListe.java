package com.upf.resto.view.etudiant;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Repas;
import com.upf.resto.service.RmiService;
import com.upf.resto.view.LabeledTextField;

public class VueRepasListe extends JPanel{

	private static final long serialVersionUID = 1L;

	private RmiService service;
	private Etudiant etudiant;
	private List<Repas> repas = new ArrayList<>();

	public VueRepasListe(Etudiant etudiant, RmiService service) {
		this.etudiant = etudiant;
		this.service = service;
		//TODO repas = service.getListRepas();
		
		setLayout(new BorderLayout());
		
		LabeledTextField soldePanel = new LabeledTextField("Solde", 20, 60, true);
		soldePanel.setText(etudiant.getSolde()+"");
		add("North",soldePanel);

		JPanel p = new JPanel();
		JTable table = new JTable(new CommandeTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		p.add(scrollPane);
		add("Center", p);

		/*JButton b = new JButton("Ajouter");
		b.addActionListener((event)->{
			Repas r = new Repas();
			r.setLabel("Pannini");
			r.setPrix(20.0);
			r.setQuantite(18.0);
			repas.add(r);
			((AbstractTableModel)table.getModel()).fireTableDataChanged();
		});
		add("East", b);*/
		
		JButton b1 = new JButton("Ajouter");
		b1.addActionListener((event)->{
			Repas r = repas.get(table.getSelectedRow());
			Commande commande = new Commande();
			commande.setEtudiant(etudiant);
			commande.setRepas(Arrays.asList(r));
			
			
			//TODO service.ajouterCommande(commande);
		});
		add("South", b1);
	}

	@SuppressWarnings("serial")
	class CommandeTableModel extends AbstractTableModel {
		private String[] names = new String[] {"Label", "Prix", "Quantité"};

		@Override
		public int getRowCount() {
			return repas.size();
		}

		@Override
		public int getColumnCount() {
			return names.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Repas r = repas.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return r.getLabel();
			case 1:
				return r.getPrix();
			case 2:
				return r.getQuantite();
			default: return null;		
			}
		}

		@Override
		public String getColumnName(int column) {
			return names[column];
		}

	}
}
