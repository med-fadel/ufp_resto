package com.upf.resto.view;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Form extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel content;
	private int labelWidth = 100;
	public Form() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		content = new JPanel();
		add(content);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
	}
	
	public Form(int labelWidth) {
		this();
		this.labelWidth=labelWidth;
	}
	
	public Form(String title, int labelWidth) {
		this(labelWidth);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " " + title + " : "));
	}
	
	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}
	
	public void add(String label, int size) {
		LabeledTextField l1 = new LabeledTextField(label, size, labelWidth);
		content.add(l1);
	}
	
	public String getText(int index){
		LabeledTextField l = (LabeledTextField)content.getComponent(index);
		return l.getText();
	}
	public void setText(int index, String text){
		LabeledTextField l = (LabeledTextField)content.getComponent(index);
		l.setText(text);
	}
}
