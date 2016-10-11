

public class Binary {
	public String last = "";
	public int temp;
	public int stor;

	public void Convert(int i) {
		if (i == 0 || i < 2) {
			last = '1' + last;
			System.out.println("The conversion is :" + last);
		} else {
			temp = i % 2;
			last = temp + last;

			stor = i / 2;
			Convert(stor);
		}
	}

	/*
	 * This function takes the input by the user and formats it and 
	 * and does the validation work and returns true if the input is valid
	 * and returns false if not valid.*/
	public boolean out(String a) {
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

	public void ConDecimal(String a) {
		int b = a.length();
		int sum = 0;
		String t = "";
		int j = b-1;
		for (int i = 0 ; i <  b ; i++) {
				int temp = Integer.parseInt(t + a.charAt(i));
				sum += (Math.pow(2, j)) * temp;
				//System.out.println(sum+"+"+temp+"+"+i);
				j--;
			}
		last = ""+sum;
	}
	
	public void ConOctal(String a){
		int b = a.length();
		int sum = 0;
		int c = b;
		String t = "";
		for (int i =0; i < b; i++) {
				c= c-1;
				int temp = Integer.parseInt(t + a.charAt(i));
				sum += (Math.pow(2, c)) * temp;
			}
			AllLogic deci = new AllLogic();
			deci.OctConvert(sum);
			last = deci.last;
	}
	
	public void ConHexadecimal(String a){
		int b = a.length();
		int sum = 0;
		int c = b;
		String t = "";
		for (int i =0; i < b; i++) {
				c= c-1;
				int temp = Integer.parseInt(t + a.charAt(i));
				sum += (Math.pow(2, c)) * temp;
			}
			AllLogic deci = new AllLogic();
			deci.HexConvert(sum);
			last = deci.last;
	}
}