package com.upf.resto.view.admin;

import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Formation;
import com.upf.resto.datamodel.Repas;
import com.upf.resto.view.LabeledTextField;

public class AjouterRepasForm extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private LabeledTextField labelPanel;
	private LabeledTextField prixPanel;
	private LabeledTextField quantitePanel;

	public AjouterRepasForm() {
		setLayout(new BoxLayout(this, Y_AXIS));
		labelPanel = new LabeledTextField("Label", 20, 60, true);
		add(labelPanel);
		prixPanel = new LabeledTextField("Prix", 20, 60, true);
		add(prixPanel);
		quantitePanel = new LabeledTextField("Quantite", 20, 60, true);
		add(quantitePanel);
		
	}
	
	public Repas getRepas() {
		Repas res = new Repas();
		res.setLabel(labelPanel.getText());
		res.setPrix(Double.parseDouble(prixPanel.getText()));
		res.setQuantite(Double.parseDouble(quantitePanel.getText()));
		
		labelPanel.setText("");
		prixPanel.setText("");
		quantitePanel.setText("");
		
		return res;
	}
}
