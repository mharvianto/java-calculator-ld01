import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Calculator {
	
	JFrame frame = new JFrame();
	
	JPanel btnPanel = new JPanel();
	JButton btn[] = new JButton[]{
			new JButton("AC"),
			new JButton("%"),
			new JButton("sqrt"),
			new JButton("x^2"),
			new JButton("7"),
			new JButton("8"),
			new JButton("9"),
			new JButton("÷"),
			new JButton("4"),
			new JButton("5"),
			new JButton("6"),
			new JButton("x"),
			new JButton("1"),
			new JButton("2"),
			new JButton("3"),
			new JButton("-"),
			new JButton("0"),
			new JButton("."),
			new JButton("="),
			new JButton("+"),
	};
	
	JLabel display = new JLabel("0");
	
	double old = 0;
	String operator = null;
	
	ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton sourceButton = (JButton)e.getSource();
			System.out.println("btn di click");
//			JOptionPane.showMessageDialog(null, "Click " + 
//					sourceButton.getText());
			if(sourceButton.getText().equals("1") || 
					sourceButton.getText().equals("2") ||
					sourceButton.getText().equals("3") ||
					sourceButton.getText().equals("4") ||
					sourceButton.getText().equals("5") ||
					sourceButton.getText().equals("6") ||
					sourceButton.getText().equals("7") ||
					sourceButton.getText().equals("8") ||
					sourceButton.getText().equals("9") ||
					sourceButton.getText().equals("0") ||
					sourceButton.getText().equals(".")){
				if(display.getText().equals("0") && 
						sourceButton.getText().equals(".") == false){
					display.setText(sourceButton.getText());
				}else if(!(sourceButton.getText().equals(".") &&
						display.getText().contains("."))){
					display.setText(display.getText() + 
							sourceButton.getText());
				}
			}else if(sourceButton.getText().equals("%")){
				double temp = Double.valueOf(display.getText());
				display.setText("" + (temp/100));
			}else if(sourceButton.getText().equals("sqrt")){
				double temp = Double.valueOf(display.getText());
				display.setText("" + Math.sqrt(temp));
			}else if(sourceButton.getText().equals("x^2")){
				double temp = Double.valueOf(display.getText());
				display.setText("" + (temp * temp));
			}else if(sourceButton.getText().equals("÷") || 
					sourceButton.getText().equals("x") ||
					sourceButton.getText().equals("-") ||
					sourceButton.getText().equals("+")){
				old = Double.valueOf(display.getText());
				operator = sourceButton.getText();
				display.setText("0");
			}else if(sourceButton.getText().equals("=")){
				double temp = Double.valueOf(display.getText());
				double result = 0;
				if(operator.equals("+")){
					result = old + temp;
				}else if(operator.equals("-")){
					result = old - temp;
				}else if(operator.equals("x")){
					result = old * temp;
				}else if(operator.equals("÷")){
					result = old / temp;
				}
				display.setText("" + result);
			}else if(sourceButton.getText().equals("AC")){
				display.setText("0");
				old = 0;
				operator = null;
			}
		}
	};
	
	public Calculator() {
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(btnPanel);
		
		btnPanel.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < btn.length; i++) {
			btn[i].setFont(new Font("Arial", Font.PLAIN, 20));
			btn[i].addActionListener(actionListener);
			btnPanel.add(btn[i]);
		}
		
		
		//btn.addActionListener(actionListener);
		
		display.setFont(new Font("Arial", Font.PLAIN, 30));
		display.setHorizontalAlignment(JLabel.RIGHT);
		frame.add(display, BorderLayout.NORTH);
	}
	

	public static void main(String[] args) {
		new Calculator();
	}

}
