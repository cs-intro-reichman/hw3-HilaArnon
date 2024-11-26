/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	//Need this function becuse in preProcess i have to keep the spaces...
	// public static String deleteSpaces(String str) {
	// 	String newStr = "";
	// 	for(int i = 0; i < str.length(); i ++){
	// 		if(str.charAt(i) != ' '){
	// 			newStr += str.charAt(i);
	// 		}
	// 	}
	// 	return newStr;
	// }

	//Need this function becuse in preProcess i have to keep the spaces...
	// public static String preProcessWithSpace(String str) {
	// 	String lowerCaseStr = "";
	// 	String lowerLetters = "abcdefghijklmnopqrstuvwxyz";	 
	// 	String special = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";     
	// 	int i = 0; 
	// 	while(i < str.length()){
	// 		char ch = str.charAt(i);
	// 		if(special.indexOf(ch) == -1){                       //not a special char
	// 			int lowerIndex = lowerLetters.indexOf(ch);
	// 			if (lowerIndex == -1){      //small letter   
	// 					ch += 32;           //ASCII
	// 			}
	// 			lowerCaseStr += ch;
	// 			//System.out.println("lowerCaseStr: " + lowerCaseStr);
	// 		}
	// 		i ++;
	// 	} 
	// 	return lowerCaseStr;
	// } 
			
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		//String checkStr1 = deleteSpaces(preProcess(str1));
		//String checkStr2 = deleteSpaces(preProcess(str2));
		String checkStr1 = preProcess(str1);
		String checkStr2 = preProcess(str2);
		boolean result = true;
		
		if (checkStr1.length() != checkStr2.length()){
			return false;
		}

		for(int i = 0; i < checkStr2.length(); i++){
			int exist = checkStr1.indexOf(checkStr2.charAt(i));
			if (exist == -1){   //if corrent str2's char exist in str1
				result = false;
				break;
			} else {
				checkStr1 = minusChar(checkStr1, exist);     //this char is used so delete him
			}
		}
		return result;
	}

	//Returns the string without the letter in the place position
	public static String minusChar(String str1, int place) {
		String result = "";
		for(int i = 0; i < place; i ++){
			result += str1.charAt(i);
		}
		for(int i = place + 1; i < str1.length(); i ++){
			result += str1.charAt(i);
		}
		return result;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		for(int i = 0; i < str.length(); i ++){
			char chStr = str.charAt(i);
			if((chStr >= 'a' && chStr <= 'z') || chStr == ' '){
				newStr += chStr;
			} else if (chStr >= 'A' && chStr <= 'Z') {
				newStr += (char)(chStr + 32);
			}	
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomStr = "";
		while(str.length() > 0){
			int random = (int)(Math.random() * str.length());
			randomStr += str.charAt(random);
			str = minusChar(str, random);
		}
		return randomStr;
	}
}
