 //import package
 import java.util.Scanner;
 
public class TaxAccountant 
{
    public static void main(String[] args)    
	{
		// declare variables
        int customerID;
        double totalEarnings = 0.0;
        double federalTaxesWH = 0.0;
        double stateTaxWH = 0.0;
        double deductions = 0.0;
        double taxableIncome = 0.0;
        double federalTax = 0.0;
        double stateRefund = 0.0;
        double stateTax = 0.0;
        double federalRefund = 0.0;
        
        
         
   //result string to store output table
   

    String result = "";

    result += "Cust.                   Taxable "

    + "Federal State Federal State Federal State\n";

   

    result += " ID   Income Deductions Income    "

    + "Tax    Tax    W/H    W/H Refund Refund\n";

   

    result += "===== ====== ========== ======= "

    + "======= ===== ======= ===== ======= ======\n";

        // Create a Scanner input object

        Scanner scan = new Scanner(System.in);

        // Begin first customer
        System.out.print("Please enter customer ID: ");

        // Get first Customer ID
        customerID =scan.nextInt();
 
        //while loop runs unless customer ID sentinel value -1 is entered
        while(customerID != -1)
        {
           // Get income and withholding information
           System.out.print("Enter total earnings: ");

           totalEarnings = scan.nextDouble();
 
           System.out.print("Enter federal taxes withheld: ");

           federalTaxesWH = scan.nextDouble();

           System.out.print("Enter state taxes withheld: ");

           stateTaxWH = scan.nextDouble();

           System.out.print("Enter tax amount deductions: ");

           deductions = scan.nextDouble();


            // Calculate taxes due/refunds

             taxableIncome = totalEarnings - deductions;

                
               double tax_pay = taxableIncome;

      //federal tax greater than 70,000 is 30%

      if(taxableIncome > 70000)

      {

        federalTax += (tax_pay - 70000) * 0.3;

        

        tax_pay = 70000;

      }
    
      //fedearal tax greater than 45,000 is 20%
     
      if(taxableIncome > 45000)

      {

        federalTax += (tax_pay - 45000) * 0.2;
        

        tax_pay = 45000;

      }
      

     //federal tax greater than 10,000 is 15%

      if(taxableIncome > 10000)

      {

        federalTax += (tax_pay - 10000) * 0.15;

       

        tax_pay = 10000;

      }
   
     
      if (taxableIncome <= 10000)
      {
         federalTax = 0.0;
         
         tax_pay = 0;
      }
      


      stateTax = federalTax * 0.07;


      federalRefund = federalTaxesWH - federalTax;

      stateRefund = stateTaxWH - stateTax;   
                  


            // Add data to result output String
    result += String.format("%-5d $%5.0f $%9.0f "

      + "$%6.0f $%6.0f $%4.0f $%6.0f $%4.0f $%6.0f "

      + "$%5.0f\n",

      customerID, totalEarnings, deductions,

      taxableIncome, federalTax, stateTax,

      federalTaxesWH, stateTaxWH, federalRefund,

      stateRefund);

      // Get next Customer ID

      System.out.print("\nEnter customer ID: (or -1 to exit) ");

      customerID = scan.nextInt();
      


            

        

        }

        // Print out table of data and end program

          System.out.println(result); 
          
   }
}