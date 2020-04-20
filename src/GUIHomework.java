/*
 * Author: Fahrudin Mujic
 * Class: Object Oriented Programming CPSC-24500
 * Project: This program creates a GUI that allows the user
 * to enter the amount of different coins that they have. The
 * individual coin type total value is displayed as well as a 
 * collective total value is displayed.
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;

public class GUIHomework extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtQuarters;
	private JTextField txtDimes;
	private JTextField txtNickels;
	private JTextField txtPennies;
	private JTextField QuartersVal;
	private JTextField DimesVal;
	private JTextField NickelsVal;
	private JTextField PenniesVal;
	private JTextField TotVal;
	
	double Quarter = 25;
	double Dime = 10;
	double Nickel = 5;
	double Penny = 1;
	
	public GUIHomework() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrencyCalculator = new JLabel("Change Counter");
		lblCurrencyCalculator.setBounds(150, 8, 264, 14);
		contentPane.add(lblCurrencyCalculator);
		
		JLabel lblPrmpt = new JLabel("Enter the number of each coin type and hit, Compute:", SwingConstants.RIGHT);
		lblPrmpt.setBounds(48, 30, 300, 14);
		contentPane.add(lblPrmpt);
		
		JLabel lblQuarters = new JLabel("Quarters:", SwingConstants.RIGHT);
		lblQuarters.setBounds(48, 60, 60, 14);
		contentPane.add(lblQuarters);
		
		txtQuarters = new JTextField();
		txtQuarters.setBounds(110, 60, 60, 20);
		contentPane.add(txtQuarters);
		txtQuarters.setColumns(10);
		
		JLabel lblDimes = new JLabel("Dimes:", SwingConstants.RIGHT);
		lblDimes.setBounds(48, 90, 60, 14);
		contentPane.add(lblDimes);
		
		txtDimes = new JTextField();
		txtDimes.setBounds(110, 90, 60, 20);
		contentPane.add(txtDimes);
		txtDimes.setColumns(10);
		
		JLabel lblNickels = new JLabel("Nickels:", SwingConstants.RIGHT);
		lblNickels.setBounds(48, 120, 60, 14);
		contentPane.add(lblNickels);
		
		txtNickels = new JTextField();
		txtNickels.setBounds(110, 120, 60, 20);
		contentPane.add(txtNickels);
		txtNickels.setColumns(10);
		
		JLabel lblPennies = new JLabel("Pennies:", SwingConstants.RIGHT);
		lblPennies.setBounds(48, 150, 60, 14);
		contentPane.add(lblPennies);
		
		txtPennies = new JTextField();
		txtPennies.setBounds(110, 150, 60, 20);
		contentPane.add(txtPennies);
		txtPennies.setColumns(10);
		
		JButton btnCompute = new JButton("Compute");
		SwingAction action = new SwingAction();
		btnCompute.setAction(action);
		btnCompute.setBounds(65, 180, 100, 20);
		contentPane.add(btnCompute);
		
		JLabel lblQuartersVal = new JLabel("Quarter value: $", SwingConstants.RIGHT);
		lblQuartersVal.setBounds(200, 60, 120, 14);
		contentPane.add(lblQuartersVal);
		
		QuartersVal = new JTextField("0.00", SwingConstants.RIGHT);
		QuartersVal.setBounds(322, 60, 60, 20);
		QuartersVal.setEditable(false);
		contentPane.add(QuartersVal);
		
		JLabel lblDimesVal = new JLabel("Dime value: $", SwingConstants.RIGHT);
		lblDimesVal.setBounds(200, 90, 120, 14);
		contentPane.add(lblDimesVal);
		
		DimesVal = new JTextField("0.00", SwingConstants.RIGHT);
		DimesVal.setBounds(322, 90, 60, 20);
		DimesVal.setEditable(false);
		contentPane.add(DimesVal);
		
		JLabel lblNickelsVal = new JLabel("Nickel value: $", SwingConstants.RIGHT);
		lblNickelsVal.setBounds(200, 120, 120, 14);
		contentPane.add(lblNickelsVal);
		
		NickelsVal = new JTextField("0.00", SwingConstants.RIGHT);
		NickelsVal.setBounds(322, 120, 60, 20);
		NickelsVal.setEditable(false);
		contentPane.add(NickelsVal);
		
		JLabel lblPenniesVal = new JLabel("Penny value: $", SwingConstants.RIGHT);
		lblPenniesVal.setBounds(200, 150, 120, 14);
		contentPane.add(lblPenniesVal);
		
		PenniesVal = new JTextField("0.00", SwingConstants.RIGHT);
		PenniesVal.setBounds(322, 150, 60, 20);
		PenniesVal.setEditable(false);
		contentPane.add(PenniesVal);
		
		JLabel lblTotVal = new JLabel("Total Change value: $", SwingConstants.RIGHT);
		lblTotVal.setBounds(200, 180, 120, 14);
		contentPane.add(lblTotVal);
		
		TotVal = new JTextField("0.00", SwingConstants.RIGHT);
		TotVal.setBounds(322, 180, 60, 20);
		TotVal.setEditable(false);
		contentPane.add(TotVal);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
		putValue(NAME, "Compute");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
		try {
		 if (Integer.parseInt(txtPennies.getText()) < 0
		|| Integer.parseInt(txtQuarters.getText()) < 0 || Integer.parseInt(txtDimes.getText()) < 0
		|| Integer.parseInt(txtNickels.getText()) < 0) {
		 JOptionPane.showMessageDialog(null, "You can not enter negative value");
		 }
		 else {
		 int totalPenny = (int) (Penny * Integer.parseInt(txtPennies.getText()));
		 int totalQuarters = (int) (Quarter * Integer.parseInt(txtQuarters.getText()));
		 int totalDimes = (int) (Dime * Integer.parseInt(txtDimes.getText()));
		 int totalNickels = (int) (Nickel * Integer.parseInt(txtNickels.getText()));
		 int total = totalPenny + totalQuarters + totalDimes + totalNickels;
		 int finalDollars = total / 100;
		 int cents = total % 100;
		 int finalQuarters = totalQuarters / 100;
		 int remainingQuarters = totalQuarters % 100;
		 String quarterDisplay = finalQuarters + "." + remainingQuarters;
		 QuartersVal.setText(quarterDisplay);
		 int finalDimes = totalDimes / 100;
		 int remainingDimes = totalDimes % 100;
		 String dimeDisplay = finalDimes + "." + remainingDimes;
		 DimesVal.setText(dimeDisplay);
		 int finalNickels = totalNickels / 100;
		 int remainingNickels = totalNickels % 100;
		 String nickelDisplay = finalNickels + "." + remainingNickels;
		 NickelsVal.setText(nickelDisplay);
		 int finalPennies = totalPenny / 100;
		 int remainingPennies = totalPenny - (finalPennies * 100);
		 String pennyDisplay;
		 if(remainingPennies < 10) {
			 pennyDisplay = finalPennies + ".0" + remainingPennies;
		 }else {
			 pennyDisplay = finalPennies + "." + remainingPennies;	 
		 }
		 PenniesVal.setText(pennyDisplay);
		 
		 String display = finalDollars + "." + cents;
		 TotVal.setText(display);
		 }
		} catch (NumberFormatException e1) {
		 JOptionPane.showMessageDialog(null, "Numbers must be entered.");
		}
		 }
		}
	

	public static void main(String[] args) {
		GUIHomework frame = new GUIHomework();
		frame.setVisible(true);

	}

}
