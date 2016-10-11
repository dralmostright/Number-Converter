import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainBody {

	 public static void main(String[] args) {
		 try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (Exception unused) {
	            ; // Ignore exception because we can't do anything.  Will use default.
	        }
		 
		 	LayoutAll form = new LayoutAll();
			form.setLocationRelativeTo(null);
			form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			form.setVisible(true);
	 }

}
