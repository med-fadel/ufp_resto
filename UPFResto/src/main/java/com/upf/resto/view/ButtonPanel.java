package com.upf.resto.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public ButtonPanel(String labels[]) {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		for (int i = 0; i < labels.length; i++) {
			JButton b=new JButton(labels[i]);
			add(b);
		}
	}
	
	public void addActionListner(ActionListener al){
		for (int i = 0; i < getComponentCount(); i++) {
			JButton b = (JButton)getComponent(i);
			b.addActionListener(al);
		}
	}
}
