package LZW;

import java.util.List;

public class App {

	public static void main(String[] args) {
		
		LZW lzw = new LZW();
		
		List<Integer> compressedString = lzw.compress("CARRARCARCAR");
		System.out.println(compressedString);
		String decompressedString = lzw.decompress(compressedString);
		System.out.println(decompressedString);

	}
}
