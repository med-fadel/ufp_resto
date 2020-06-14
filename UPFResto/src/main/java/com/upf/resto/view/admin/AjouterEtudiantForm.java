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
import com.upf.resto.view.LabeledTextField;

public class AjouterEtudiantForm extends JPanel{

	private static final long serialVersionUID = 1L;
	private String s;
	private LabeledTextField loginPanel;
	private LabeledTextField mdpPanel;
	private LabeledTextField nomPanel;
	private LabeledTextField prenomPanel;
	private JDatePickerImpl datePicker;
	private LabeledTextField emailPanel;
	private JComboBox<Formation> formations;
	private LabeledTextField soldePanel;

	public AjouterEtudiantForm() {
		setLayout(new BoxLayout(this, Y_AXIS));
		loginPanel = new LabeledTextField("Login", 20, 60, true);
		add(loginPanel);
		mdpPanel = new LabeledTextField("Mdp", 20, 60, true);
		add(mdpPanel);
		
		nomPanel = new LabeledTextField("Nom", 20, 60, true);
		add(nomPanel);
		prenomPanel = new LabeledTextField("Prenom", 20, 60, true);
		add(prenomPanel);

		JPanel dn = new JPanel();
		datePicker = newDatePicker();
		dn.add(new JLabel("Date de naissance : "));
		dn.add(datePicker);
		add(dn);

		JPanel sexe = new JPanel();
		sexe.setLayout(new BoxLayout(sexe, X_AXIS));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton male = new JRadioButton("Male");
		male.addActionListener(e->s="Male");
		JRadioButton female = new JRadioButton("Female");
		female.addActionListener(e->s="Female");
		sexe.add(new JLabel("Sexe : "));
		bg.add(male);
		bg.add(female);
		sexe.add(male);
		sexe.add(female);
		add(sexe);

		emailPanel = new LabeledTextField("Email", 20, 60, true);
		add(emailPanel);

		JPanel formation = new JPanel();
		formations = new JComboBox<>(new Formation[] {Formation.INITIAL, Formation.CONTINUE});
		formation.add(new JLabel("Formation : "));
		formation.add(formations);
		add(formation);

		soldePanel = new LabeledTextField("Solde", 20, 60, true);
		add(soldePanel);
	}
	
	public Etudiant getEtudiant() {
		Etudiant res = new Etudiant();
		res.setLoging(loginPanel.getText());
		res.setPrenom(mdpPanel.getText());
		res.setNom(nomPanel.getText());
		res.setPrenom(prenomPanel.getText());
		res.setDateDeNaissance(((Date)datePicker.getModel().getValue()));
		res.setSexe(s);
		res.setEmail(emailPanel.getText());
		res.setFormation((Formation)formations.getSelectedItem());
		res.setSolde(Integer.parseInt(soldePanel.getText()));
		
		nomPanel.setText("");
		prenomPanel.setText("");
		emailPanel.setText("");
		soldePanel.setText("");
		
		return res;
	}

	private JDatePickerImpl newDatePicker() {
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		return new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}

	private class DateLabelFormatter extends AbstractFormatter {
		private static final long serialVersionUID = 1L;

		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}
	}
}
