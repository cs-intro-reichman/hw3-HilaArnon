// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.
//The only algebraic operations that you are allowed to use are ++ (add 1), -- (subtract 1), <, <=, >,
//>=, ==, and !=. You can also use any other Java element that we learned, like while and for.


public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3                     5
	    System.out.println(minus(7,2));  // 7 - 2                     5
   		System.out.println(minus(2,7));  // 2 - 7                    -5
 		System.out.println(times(3,4));  // 3 * 4                    12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2     10
   		System.out.println(pow(5,3));      // 5^3					   125
   		System.out.println(pow(3,5));      // 3^5					   243
   		System.out.println(div(12,3));   // 12 / 3    			   4
   		System.out.println(div(5,5));    // 5 / 5                    1
   		System.out.println(div(25,7));   // 25 / 7      			   3
   		System.out.println(mod(25,7));   // 25 % 7				   4
   		System.out.println(mod(120,6));  // 120 % 6  				   0  
   		System.out.println(sqrt(36));								//     6
		System.out.println(sqrt(263169));							//     513
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		//1 + (-2)
		//-1 + (-2)
		//1 + 2     
		//-1 + 2
		if (x2 >= 0){				 // x2 >= 0
			while (x2 > 0) {		//Dose not metter is x1 >=0 or < 0
				x1 ++;
				x2 --;
			}
		} else {   					//x2 < 0
			while (x2 < 0) {	   
				x1 --;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		//1 -(-2)
		//-1 - (-2)
		//1 - 2
		//-1 - 2
		if (x2 >= 0){		         // x2 >= 0
			while (x2 > 0) {		//Dose not metter is x1 >=0 or < 0
				x1 --;
				x2 --;
			}
		} else {  					 //x2 < 0
			while (x2 < 0) {
				x1 ++;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int answer = 0;
		if (x1 == 0 || x2 == 0){						 //x1 == 0 || x2 == 0
			return answer;
		} else {
			if (x2 > 0){								 //x2 > 0
				while (x2 > 0) {
					answer = plus(answer, x1) ;
					x2 --;
				}
			} else if (x2 < 0) {  						 //x2 < 0
				while (x2 >= 0) {
					answer = plus(answer, x1) ;
					x2 ++;
				}
				answer = minus(0, answer) ;          
			}
		}
		return answer;
		// 3 * 4           
		// 3 + 3 + 3 + 3
		// 3 * 4 * -1
		// 3 + 3 + 3 + 3    
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int answer = 1;
		if (n == 0){
			return 1;
		} else {
			while (n > 0){
				answer = times(answer, x);
				n --;
			}
		}
		return answer;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0 || x2 == 0){
			return 0;
		}

		int counter = 0;
		boolean x1IsPositive = x1 > 0;
		boolean x2IsPositive = x2 > 0;
		if (!x1IsPositive){
			x1 = minus(0, x1);
		}
		if (!x2IsPositive){
			x2 = minus(0, x2);
		}

		while (x1 >= x2){
			counter ++;
			x1 = minus(x1, x2);
		}

		if ((!x1IsPositive && x2IsPositive) || (x1IsPositive && !x2IsPositive)){
			counter = minus(0,counter) ;
		}

		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// 25 % 5      8 % 7
		int counter = 0;
		boolean x1IsPositive = x1 > 0;
		boolean x2IsPositive = x2 > 0;

		
		return 0;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		return 0;
	}	  	  
}