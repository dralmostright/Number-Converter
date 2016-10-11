public class Octal {
	public String last = "";
	public int temp;
	public int stor;

	public void ConDecimal(String s) {
		int b = s.length();
		int sum = 0;
		String t = "";
		int c = b;
			for (int i = 0; i < b; i++) {
				c = c - 1;
				int temp = Integer.parseInt(t + s.charAt(i));
				sum += (Math.pow(8, c)) * temp;
			}
			last = ""+sum;
	}

	public void ConBinary(String s) {
		int b = s.length();
		int sum = 0;
		String t = "";
		int c = b;
		for (int i = 0; i < b; i++) {
				c = c - 1;
				int temp = Integer.parseInt(t + s.charAt(i));
				sum += (Math.pow(8, c)) * temp;
			}
			AllLogic bin = new AllLogic();
			bin.Convert(sum);
			last = bin.last;
		
	}

	public void ConHexa(String s) {
		int b = s.length();
		int sum = 0;
		String t = "";
		int c = b;
		for (int i = 0; i < b; i++) {
				c = c - 1;
				int temp = Integer.parseInt(t + s.charAt(i));
				sum += (Math.pow(8, c)) * temp;
			}
		AllLogic bin = new AllLogic();
			bin.HexConvert(sum);
			last = bin.last;
					
		
	}

	public boolean outOct(String a) {
		boolean flag = true;
		int b = a.length();
		for (int i = 0; i < b; i++) {
			if (a.charAt(i) == '1' || a.charAt(i) == '0' || a.charAt(i) == '2'
					|| a.charAt(i) == '3' || a.charAt(i) == '4'
					|| a.charAt(i) == '5' || a.charAt(i) == '5'
					|| a.charAt(i) == '7') {
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}