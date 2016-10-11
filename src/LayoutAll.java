import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutAll extends JFrame {

	private static final long serialVersionUID = 1L;
	private String title = "";
	public AllLogic logic = new AllLogic();
	private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN,
			20);
	private static final Font SMALL = new Font("monospaced",Font.ITALIC,15);
	

	// flags
	public boolean reset = false;
	public boolean hex = true;
	public boolean type = false;
	public String main = "";

	public JTextField monitor;
	public JTextField current;
	public JButton clear;
	public JButton rest;
	public JButton one;
	public JButton two;
	public JButton three;
	public JButton four;
	public JButton five;
	public JButton six;
	public JButton seven;
	public JButton eight;
	public JButton nine;
	public JButton zero;
	public JButton a;
	public JButton b;
	public JButton c;
	public JButton d;
	public JButton e;
	public JButton f;
	public JButton sp;

	public JButton Hex;
	public JButton Dec;
	public JButton Oct;
	public JButton Bin;
	public JButton Hex1;
	public JButton Dec1;
	public JButton Oct1;
	public JButton Bin1;

	public LayoutAll() {
		// make the display screen
		JPanel screen = new JPanel();
		screen.setLayout(new GridLayout(2,1,2,2));
		monitor = new JTextField("0", 10);
		monitor.setHorizontalAlignment(JTextField.RIGHT);
		monitor.setFont(BIGGER_FONT);
		monitor.setEditable(false);

		current = new JTextField("",20);
		current.setEditable(false);
		current.setFont(SMALL);
		screen.add(monitor);
		screen.add(current);
		
		
		// make the clear button
		clear = new JButton("Clear");
		clear.setFont(BIGGER_FONT);
		clear.addActionListener(new ClsListener());

		// make the reset button
		rest = new JButton("Reset");
		rest.setFont(BIGGER_FONT);
		rest.addActionListener(new ResetListner());

		// make the number Panel
		String num = "6789234510ABCDEF ";
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 4, 1, 1));

		NumListner numLis = new NumListner();
		// make the button for the numbers
		JButton[] nums = { six, seven, eight, nine, two, three, four, five,
				one, zero, a, b, c, d, e, f, sp };
		int i = 0;
		for (JButton btn : nums) {
			String key = num.substring(i, i + 1);
			btn = new JButton(key);
			// assign the no value for the spaces and make disable
			if (key.equals(" ")) {
				btn.setEnabled(false);
			} else {
				btn.setFont(BIGGER_FONT);
				btn.addActionListener(numLis);
			}
			// add the buttons to the buttonPanel
			buttonPanel.add(btn);
			i++;
		}

		// add rest two gaps with clear and reset button
		buttonPanel.add(clear);
		buttonPanel.add(rest);
		JButton space = new JButton("");
		space.setEnabled(false);
		buttonPanel.add(space);

		// make the navigation panel
		JPanel navPanel = new JPanel();
		navPanel.setLayout(new GridLayout(2, 4, 2, 2));
		// String[] nav =
		// {"HexaDecimal","Decimal","Octal","Binary","@ HexaDecimal","@ Decimal","@ Octal","@ Binary"};
		String[] nav = { "H", "D", "O", "B", "@ H", "@ D", "@ O", "@ B" };
		JButton[] navs = { Hex, Dec, Oct, Bin, Hex1, Dec1, Oct1, Bin1 };
		TypeListner type = new TypeListner();
		MainListner typ = new MainListner();
		i = 0;
		for (JButton jb : navs) {
			jb = new JButton(nav[i]);
			Font fon = new Font("monspaced", Font.PLAIN, 16);
			jb.setFont(fon);

			if (i > 3) {
				jb.addActionListener(type);
			} else {
				jb.addActionListener(typ);
			}

			navPanel.add(jb);
			i++;
		}

		// Finally merge all panels in the single panel
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(2, 3));
		content.add(screen, BorderLayout.NORTH);
		content.add(navPanel, BorderLayout.CENTER);
		content.add(buttonPanel, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setContentPane(content);
		this.pack();
		this.setTitle("Converter");
		this.setResizable(false);
	}

	public class ClsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			monitor.setText("0");
			current.setText(title);

		}

	}

	public class ResetListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			hex = true;
			type = false;
			main = "";
			monitor.setText("0");
			current.setText("");
			title = "";
		}

	}

	public class NumListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String digit = e.getActionCommand(); // Get text from button
			String tex = (monitor.getText().equals("0") ? digit : monitor
					.getText() + digit);
			monitor.setText(tex);
		}

	}

	public class MainListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String digit = e.getActionCommand();
			type = true;
			main = digit;
			monitor.setText("0");
			
			
			if (main.equals("H")) {
				title = "HexaDecimal ~~~>";
				current.setText("HexaDecimal ~~~> ");
			}
			
			else if (main.equals("D")) {
				title = "Decimal ~~~>";
				current.setText("Decimal ~~~> ");
				}
				
			
			else if(main.equals("O")){
				title = "Octal ~~~>";
				current.setText("Octal ~~~> ");
			}
			
			else if(main.equals("B")){
				title = "Binary ~~~>";
				current.setText("Binary ~~~> ");
			}
		} 

	}

	public class TypeListner implements ActionListener {
		public boolean flag;
		public void actionPerformed(ActionEvent e) {
			String to = e.getActionCommand();
			String num = monitor.getText();
			
			if (type) {
				if (main.equals("H")) {
					Hexadecimal hex = new Hexadecimal();
					if (to.equals("@ D")) {
						current.setText(title+" Decimal");
						hex.ConDecimal(num);
						monitor.setText(hex.last);
					} else if (to.equals("@ O")) {
						current.setText(title+" Octal");
						hex.ConOctal(num);
						monitor.setText(hex.last);
					}
					else if (to.equals("@ B")) {
						current.setText(title+" Binary");
						hex.ConBinary(num);
						monitor.setText(hex.last);
					}
					else if (to.equals("@ H")) {
						current.setText(title+" Hexaecimal");
						monitor.setText(num);
					}

				}
				
				else if (main.equals("D")) {
					AllLogic log = new AllLogic();
					if(out(num)){
					if (to.equals("@ D")) {
						current.setText(title+" Decimal");
						monitor.setText(num);
					} else if (to.equals("@ H")) {
						current.setText(title+" Hexaecimal");
						int bin = Integer.parseInt(num);
						log.HexConvert(bin);
						monitor.setText(log.last);
					}
					else if (to.equals("@ B")) {
						current.setText(title+" Binary");
						int bin = Integer.parseInt(num);
						log.Convert(bin);
						monitor.setText(log.last);
					}
					
					else if (to.equals("@ O")) {
						current.setText(title+" Octal");
						int bin = Integer.parseInt(num);
						log.OctConvert(bin);
						monitor.setText(log.last);
					}
					}
					else{
						monitor.setText("Number must be 0-9");
					}

				}
				
				else if(main.equals("O")){
					Octal log = new Octal();
					if(outOct(num)){
					if (to.equals("@ O")) {
						current.setText(title+" Octal");
						monitor.setText(num);
					} else if (to.equals("@ H")) {
						current.setText(title+" Hexaecimal");
						log.ConHexa(num);
						monitor.setText(log.last);
					}
					else if (to.equals("@ B")) {
						current.setText(title+" Binary");
						log.ConBinary(num);
						monitor.setText(log.last);
					}
					
					else if (to.equals("@ D")) {
						current.setText(title+" Decimal");
						log.ConDecimal(num);
						monitor.setText(log.last);
					}
					}
					else{
						monitor.setText("Number must be 0-7");
					}
					
				}
				
				else if(main.equals("B")){
					Binary log = new Binary();
					if(outBin(num)){
					if (to.equals("@ B")) {
						current.setText(title+" Binary");
						monitor.setText(num);
					} else if (to.equals("@ H")) {
						current.setText(title+" Hexaecimal");
						log.ConHexadecimal(num);
						monitor.setText(log.last);
					}
					else if (to.equals("@ O")) {
						current.setText(title+" Octal");
						log.ConOctal(num);
						monitor.setText(log.last);
					}
					
					else if (to.equals("@ D")) {
						current.setText(title+" Decimal");
						log.ConDecimal(num);
						monitor.setText(log.last);
					}
					}
					else{
						monitor.setText("Number must be 0-1");
					}
					
				}
				
				
				
			} else
				monitor.setText("Error !");
		}
		
		public boolean out(String a) {
			boolean flag = true;
			int b = a.length();
			for (int i = 0; i < b; i++) {
				if (a.charAt(i) == '1' || a.charAt(i) == '0' || a.charAt(i) == '2'
						|| a.charAt(i) == '3' || a.charAt(i) == '4' || a.charAt(i) == '8'
						|| a.charAt(i) == '5' || a.charAt(i) == '6' || a.charAt(i) == '9'
						|| a.charAt(i) == '7') {
				} else {
					flag = false;
					break;
				}
			}
			return flag;
		}
		
		public boolean outOct(String a) {
			boolean flag = true;
			int b = a.length();
			for (int i = 0; i < b; i++) {
				if (a.charAt(i) == '1' || a.charAt(i) == '0' || a.charAt(i) == '2'
						|| a.charAt(i) == '3' || a.charAt(i) == '4'
						|| a.charAt(i) == '5' || a.charAt(i) == '6'
						|| a.charAt(i) == '7') {
				} else {
					flag = false;
					break;
				}
			}
			return flag;
		}
		
		public boolean outBin(String a) {
			boolean flag = true;
			int b = a.length();
			for (int i = 0; i < b; i++) {
				if (a.charAt(i) == '1' || a.charAt(i) == '0') {
				} else {
					flag = false;
					break;
				}
			}
			return flag;
		}

	}
}