// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		//(100,000 – 10,000) * 1.05 = 94,500
		//(94,500 – 10,000) * 1.05 = 88,725
		while (n > 0){
			loan = (loan - payment) * (1 + (rate / 100.0));
			n--;
		}
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		//double g = loan / 2.0;
		//while (Math.abs(endBalance(loan, rate, n, g)) > epsilon){
			//g = g - (endBalance(loan, rate, n, g) / (g * (-1 + (rate / -100))));
			//double fX = endBalance(loan, rate, n, g); 
       		//double fXEstimatedDerivative = (endBalance(loan, rate, n, g + epsilon) - fX) / epsilon;  
        	//g = g - (fX / fXEstimatedDerivative);
       		//System.out.println("g: " + g);
			//iterationCounter++;
		//}
		iterationCounter = 0;
        double payment = loan / n;  // Initial guess
        
        while (endBalance(loan, rate, n, payment) > epsilon) {
            payment += 0.001;  // Increment by small amount
            //System.out.println("endBalance(loan, rate, n, payment): " + endBalance(loan, rate, n, payment));
			iterationCounter++;
        }
        
        return payment;
		//return g;
    }
    
    // Uses bisection search to compute an approximation of the *****periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		//System.out.println("iterationCounter: " + iterationCounter);
    	double L = 1.0, H = loan / 2.0;
    	double g = (L + H) / 2.0;
      	while (Math.abs(endBalance(loan, rate, n, g)) >= epsilon){
        //System.out.println("H: " + H);
        //System.out.println("L: " + L);
        if (endBalance(loan, rate, n, g) < 0){
            H = g;
          } else {       //endBalance(loan, rate, n, g) > 0
            L = g;
          }
          g = (L + H) / 2.0;
          iterationCounter++;
		  //System.out.println("iterationCounter: " + iterationCounter);
        }
		
		//iterationCounter --;                          נסיון ראשון במספר 12 ככה
		//System.out.println("iterationCounter: " + iterationCounter);
		return g;
    }
}