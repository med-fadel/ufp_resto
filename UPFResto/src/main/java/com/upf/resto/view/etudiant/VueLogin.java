package com.upf.resto.view.etudiant;

import static javax.swing.BoxLayout.Y_AXIS;

import java.util.function.BiConsumer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.upf.resto.view.LabeledTextField;

public class VueLogin extends JPanel{

	private static final long serialVersionUID = 1L;

	private LabeledTextField loginPanel;
	private LabeledTextField mdpPanel;

	public VueLogin(BiConsumer<String, String> c) {
		setLayout(new BoxLayout(this, Y_AXIS));
		loginPanel = new LabeledTextField("Login", 20, 60, true);
		add(loginPanel);
		mdpPanel = new LabeledTextField("Mot de passe", 20, 60, true);
		add(mdpPanel);
		
		JButton b = new JButton("Login");
		b.addActionListener((event)->{
			c.accept(loginPanel.getText(), mdpPanel.getText());
		});
		add("South", b);
		
	}
}
