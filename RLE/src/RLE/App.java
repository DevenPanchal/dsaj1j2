package RLE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static String encode(String source){
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for(int i=0;i<source.length();i++){
			int runLength = 1;
			
			while( i+1 < source.length() && source.charAt(i) == source.charAt(i+1) ){
				runLength++;
				i++;
			}
			
			stringBuffer.append(runLength); // AAAA -> 4 
			stringBuffer.append(source.charAt(i)); // A
		}
		
		return stringBuffer.toString();
	}
	
	public static String decode(String source){

		StringBuffer stringBuffer = new StringBuffer();
		
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(source);
		
		while( matcher.find() ){
			int num = Integer.parseInt(matcher.group());
			matcher.find();
			while( num-- != 0 ){
				stringBuffer.append(matcher.group());
			}
		}
		
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		
		String s = "3A2B";
		System.out.println(decode(s));
		
	}
}
