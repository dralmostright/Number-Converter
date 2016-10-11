
public class AllLogic {
	String last="";
	int stor;
	int temp;
	
	public void Convert (int i){
		if(i == 0 || i < 2){
			if(i == 0)
				last ='0'+last;
			else
				last ='1'+last;
		}
		else{
			temp = i%2;
			last = temp + last;
			stor = i/2;
			Convert (stor);
		}
	}

	public void OctConvert (int i){
		if(i == 0 || i < 8){
			last =i+last;
		}
		else{
			temp = i%8;
			last = temp + last;
			stor = i/8;
			OctConvert (stor);
		}
	}
	public void HexConvert(int i){
		if(i <= 15){
			last = con(i)+last;
		}
		else{
			temp = i%16;
			last = con(temp)+last;
			stor = i/16;
			HexConvert (stor);
		}
	}
	
	public String con(int i){
		if(i == 0 || i < 10){
			String h = ""+i;
			return h;
		}
		else if(i == 10){
			return "A";
		}
		else if(i == 11){
			return "B";
		}
		else if(i == 12){
			return "C";
		}
		else if(i == 13){
			return "D";
		}
		else if(i == 14){
			return "E";
		}
		else if(i == 15){
			return "F";
		}
		else 
			return "";
	}
	
	
	
}
