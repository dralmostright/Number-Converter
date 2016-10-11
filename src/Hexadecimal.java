public class Hexadecimal {
	public String last = "";
	public int temp;
	public int stor;
	public void ConDecimal(String b) {
			int a = b.length();
			int sum = 0;
			int c = a;
			for (int i = 0; i < a; i++) {
				c = c - 1;
				int temp = Format(b.charAt(i));
				sum += (Math.pow(16, c)) * temp;
			}
			last = ""+sum;
		
	}

	public void ConBinary(String b) {
			int a = b.length();
			int sum = 0;
			int c = a;
			for (int i = 0; i < a; i++) {
				c = c - 1;
				int temp = Format(b.charAt(i));
				sum += (Math.pow(16, c)) * temp;
			}
			AllLogic hex = new AllLogic();
			hex.Convert(sum);
			last = hex.last;
	}

	public void ConOctal(String b) {
			int a = b.length();
			int sum = 0;
			int c = a;
			for (int i = 0; i < a; i++) {
				c = c - 1;
				int temp = Format(b.charAt(i));
				sum += (Math.pow(16, c)) * temp;
			}
			AllLogic hex = new AllLogic();
			hex.OctConvert(sum);
			last = hex.last;
	}

	public boolean out(String a) {
		boolean flag = true;
		int b = a.length();
		for (int i = 0; i < b; i++) {
			if (a.charAt(i) == '1' || a.charAt(i) == '0' || a.charAt(i) == '2'
					|| a.charAt(i) == '3' || a.charAt(i) == '4'
					|| a.charAt(i) == '8' || a.charAt(i) == '5'
					|| a.charAt(i) == '5' || a.charAt(i) == '9'
					|| a.charAt(i) == '7' || a.charAt(i) == 'a'
					|| a.charAt(i) == 'b' || a.charAt(i) == 'c'
					|| a.charAt(i) == 'd' || a.charAt(i) == 'e'
					|| a.charAt(i) == 'A' || a.charAt(i) == 'B'
					|| a.charAt(i) == 'C' || a.charAt(i) == 'D'
					|| a.charAt(i) == 'D' || a.charAt(i) == 'E'
					|| a.charAt(i) == 'f' || a.charAt(i) == 'F'
					|| a.charAt(i) == '6') {

			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public int Format(char a) {
		if (a == '1' || a == '0' || a == '2' || a == '3' || a == '4'
				|| a == '8' || a == '6' || a == '5' || a == '5' || a == '9'
				|| a == '7') {
			String s = "";
			int b = Integer.parseInt(s + a);
			return b;
		} else if (a == 'a' || a == 'A') {
			return 10;
		} else if (a == 'B' || a == 'b') {
			return 11;
		} else if (a == 'c' || a == 'C') {
			return 12;
		} else if (a == 'D' || a == 'D') {
			return 13;
		} else if (a == 'E' || a == 'e') {
			return 14;
		} else if (a == 'F' || a == 'f') {
			return 15;
		} else
			return 0;
	}
}