package com.upf.resto.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextField extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public LabeledTextField(String label, int size, boolean active) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label = label + " : ";
		JLabel l1 = new JLabel(label);
		JTextField t1;
		t1 = new JTextField(size);
		t1.setEditable(active);
		t1.setHorizontalAlignment(JTextField.CENTER);
		add(l1);
		add(t1);
	}
	
	public LabeledTextField(String label, int size,int labelWidth, boolean active) {
		this(label,size, active);
		JLabel l1=(JLabel)getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth,20));
	}
	
	public void setText(String text){
		JTextField t = (JTextField)getComponent(1);
		t.setText(text);
	}
	
	public String getText(){
		JTextField t = (JTextField)getComponent(1);
		return t.getText();
	}
}
