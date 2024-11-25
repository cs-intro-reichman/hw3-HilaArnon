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
   		System.out.println(mod(25,7));   // 25 % 7				   4  ===
   		System.out.println(mod(120,6));  // 120 % 6  				   0  
   		System.out.println(sqrt(36));								//     6
		System.out.println(sqrt(263169));							//     513
   		System.out.println(sqrt(76123));						    //     275
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
		} 
		
		boolean x1IsPositive = x1 > 0;
		boolean x2IsPositive = x2 > 0;
		if (!x1IsPositive){
			x1 = minus(0, x1);
		}
		if (!x2IsPositive){
			x2 = minus(0, x2);
		}
								
		while (x2 > 0) {
			answer = plus(answer, x1);
			x2 --;
		}

		if ((!x1IsPositive && x2IsPositive) || (x1IsPositive && !x2IsPositive)){ //one of them negative
			answer = minus(0, answer);
		}
		
		return answer;   
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		boolean xIsPositive = x > 0;
		if (!xIsPositive){
			x = minus(0, x);
		}

		int answer = 1;
		if (n == 0){
			return 1;
		} else {
			while (n > 0){
				answer = times(answer, x);
				n --;
			}
		}

		if (!xIsPositive && (mod(n,2) == 0)){
			answer = minus(0, answer);
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
		// 25 % 5      31 % 7      31 - ((31 / 7)* 7)
		if(x2 == 0){
			return 0;
		}

		int answer = 0;			 
		boolean x1IsPositive = x1 > 0;
		boolean x2IsPositive = x2 > 0;
		if (!x1IsPositive){
			x1 = minus(0, x1);
		}
		if (!x2IsPositive){
			x2 = minus(0, x2);
		}

		answer = minus(x1, times(div(x1, x2), x2));
		//answer = minus(x2,times(div(x2,x1), x1));
		//if (answer < 0) {                               //ok???
		//	answer = plus(answer, x1);  
		//}

		//x1 negative and x2 positive       or  x1 negative and x2 negative
		if ((!x1IsPositive && x2IsPositive) || (!x1IsPositive && !x2IsPositive) ){
			answer = minus(0,answer);
		}

		return answer;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x <= 0){
			return 0;
		}

		int mid = 1;
		while(pow(mid,2) < x){
			mid++;
		}
		
		if (pow(mid,2) == x){
			return mid;
		}
		return minus(mid,1);
	}	  	  
}