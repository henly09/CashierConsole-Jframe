// Final Project CC103
// Authors:
// Cyrex Joshua Cuizon
// John Henly Montera
// Leah Mae Mamaril

package cashiersystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 

public class CashierSystem{ 
        
    static Scanner sc = new Scanner(System.in);
		
    
        static int foodcount = 0, drinkcount = 0, drinkitem = 0, fooditem = 0, c, a;
	static String waw="" , foodc ="", drinkc ="";
        static int quant;
        static double total ,change, Cash, payment;
        static char D1;
        static String all = "", order = "";
        static String passcode = "12345";
        static String ItemNames[] = new String[500];
        static String FoodNm[] = new String [500];
        static String DrinkNm[] = new String [500];
        static double FoodCh[] = new double [500]; 
        static double DrinkCh[] = new double [500];
        static double ItemsPrice[] = new double [500];
        static boolean loop = true;

    public static void Intro(){
        
        int input;

        System.out.println(
                "Options: "+"\n"+
                "[1] Start System "+"\n"+
                "[2] Register Items"+"\n"+
                "[3] Exit");
        input = sc.nextInt();

        switch (input){
            case 1:
                SysStart();
                break;
            case 2:
                Register();
                break;
            case 3:
                Exit();
                break;
            default:
                Intro();
                break;
        }

    }

    //REGISTER
    
    public static void Register(){
        
        
        System.out.println("How many Items do You want to Register?: ");
        a = sc.nextInt();
        
        
        for (int b=1;b<=a;b++){
            
            System.out.println( "Enter The Items Name: ");
            ItemNames[b] = sc.next();
            
            System.out.println( "Enter The Items Price: ");
            ItemsPrice[b] = sc.nextDouble();
            
            waw=ItemNames[b]+"\t\t\t\t" +"₱"+ItemsPrice[b]+"\n";
        
        System.out.println("Choose a category of your registered Item" + "\n" +
                           "[1] Food " + "\n" +
                           "[2] Drinks ");
        
        c = sc.nextInt();
        
        switch (c) {
            case 1:
                
                foodc+= foodcount+" - "+waw;
                FoodCh[fooditem] = ItemsPrice[b];
                FoodNm[fooditem] = ItemNames[b];
                System.out.println(foodc);
                foodcount++;
                fooditem++;
                break;
            case 2:
                drinkc+= drinkcount+" - "+waw;
                DrinkCh[drinkitem] = ItemsPrice[b];
                DrinkNm[drinkitem] = ItemNames[b];
                System.out.println(drinkc);
                drinkcount++;
                drinkitem++;
                break;
            default:
                System.out.println("");
                System.out.println("------------------------------------------------------");
                System.out.println("       	    Invalid Input Please Try Again");
                Register();
          }    
           
        }
        
         loop = true;
         Intro();   
    }
 
    //SYSTEM START
 
    public static void SysStart(){
       String Choice;
       char FinalDecision;

        do
		{
                        
			System.out.println("------------------------------------------------------");
			System.out.println("\nSelect Category\n");
			System.out.println("1 - Food");
			System.out.println("2 - Drinks");
			System.out.println("3 - Exit");
			System.out.print("\nEnter Choice: ");
			Choice = sc.next();
                        
			switch (Choice)
			{
			case "1":
				Food();
				break;
			case "2":
				Drinks();
				break;
			case "3":
				Exit();
				break;
			default :
				System.out.println("");
				System.out.println("------------------------------------------------------");
				System.out.println("       	    Invalid Input Please Try Again");
			}
			System.out.print("        Do You Still Want To Continue? [Y/N]: ");
			FinalDecision = sc.next().charAt(0);
		}
		while(( FinalDecision == 'Y' || FinalDecision == 'y' ));
                Final();

    }

    //CATEGORY FOR FOOD

    private static void Food(){
                System.out.println();
		System.out.println("------------------------------------------------------");
		int op;
		System.out.println();
		System.out.println("   <Type of Food>\t\t       <Food Price>\n");
		System.out.println(foodc);
		System.out.print("\nSelect: ");
		op = sc.nextInt();
               
                Ask();
                
                quant = sc.nextInt();
                total+= FoodCh[op] * quant;
                all += "\n" + FoodNm[op] + "\t\t\t\t" + FoodCh[op] + "\t" + quant + "\t" +(FoodCh[op] * quant);
                order += "\n" + FoodNm[op] + "\t\t\t\t" + FoodCh[op] + "\t" + quant + "\t" +(FoodCh[op] * quant);
                
                System.out.print("Would You Like To Add More? [Y/N]: ");
		D1 = sc.next().charAt(0);
		if( D1 == 'Y' || D1 == 'y')
		{
			SysStart();
		}
		else
		{
			Total();
		}
     
    }

    private static void Drinks()
	{
		int opp = 0;
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("\n<Type of Drinks>\t\t      <Drink Price>\n");
		System.out.println(drinkc);
		System.out.print("\nSelect: ");
		opp = sc.nextInt();
                
                Ask();
                
                quant = sc.nextInt();
                total+= DrinkCh[opp] * quant;
                all += "\n" + DrinkNm[opp] + "\t\t\t\t" + DrinkCh[opp] + "\t" + quant + "\t" +(DrinkCh[opp] * quant);
                order += "\n" + DrinkNm[opp] + "\t\t\t\t" + DrinkCh[opp] + "\t" + quant + "\t" +(DrinkCh[opp] * quant);
                
		System.out.print("Would You Like To Add More? [Y/N]: ");
		D1 = sc.next().charAt(0);
		if( D1 == 'Y' || D1 == 'y') 
		{
			SysStart();
		}
		else 
		{
			Total();
		}
        
	}

    private static void Total(){
                System.out.println("------------------------------------------------------");
		System.out.printf("\nTotal Order: Php %.2f" + " ", total);
		System.out.println("\n");
		System.out.print("Would You Like To Continue Ordering? [Y/N] : ");
		D1 = sc.next().charAt(0);
		if (D1 == 'Y' || D1 == 'y')
		{
			SysStart();
		}
		else
		{
			Compute();
		}

    }

    private static void Compute()
	{
		char FinalDecision;
		System.out.print("\nEnter Cash: Php ");
		Cash = sc.nextDouble();

		if ( Cash >= total)
		{
			change = Cash - total;
			System.out.print("\nDo you want a Official Receipt? [Y/N] : ");
			FinalDecision = sc.next().charAt(0);
			if (( FinalDecision == 'Y' || FinalDecision == 'y'))
			{
				Receipt();
			}
			else
			{
				System.out.println("------------------------------------------------------");
				System.out.printf("\nTotal Order: Php %.2f" + " ", total);
				System.out.printf("\nCash Rendered: Php %.2f" + " ", Cash);
				System.out.printf("\nChange Php %.2f" + " ", change);
				System.out.println("\n______________________________________________________\n");
				System.out.println("           \"Thank You For Using This Program\"");
				System.out.println("               \"Have A Wonderful Day :D\"");
				System.out.println("______________________________________________________\n\n******************************************************");
				System.exit(0);
			}

		}
		else
		{
			System.out.println("------------------------------------------------------");
			System.out.println("______________________________________________________\n");
			System.out.println("                  \" Insufficient Money\"");
			System.out.println("______________________________________________________\n");
			Compute();
		}

	}

    public static void Receipt()
	{
		DateFormat dateFormat = new SimpleDateFormat("        EE MMMM dd yyyy HH:mm:ss aa");
		Date date = new Date();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n______________________________________________________\n");
		System.out.print("");
		System.out.println("" +
				" _    _ _   _                       __           \r\n" +
				"/  |_//  (_   /   _  | . _ . _  _   (    | _ _ \r\n" +
				"\\__| \\\\____)  \\__(|)| )|(-| || )()  _)\\/_)|_(-|||\r\n" +
				"                                  _/      /          ");
		System.out.println("              Grocery Cashier System Inc.             ");
		System.out.println("                                                      ");
		System.out.println("                   Store#: XXXXXXXX");
		System.out.println(dateFormat.format(date) + " Jobillee Inc. ");
		System.out.println("__________________________________________________");
		System.out.println("\nOrder\t\t\t\tPrice\tQnty\tTotal\n"+all+"\n---------------------------"
				+ "---------------------------\nTotal\t\t\t\t\t\t"+total+"\n------------------------------------------------------");
		System.out.print("Cash Rendered\t\t\t\t\t" + Cash);
		System.out.print("\nChange\t\t\t\t\t\t" + change + "\n");
		System.out.println("\n______________________________________________________");
		System.out.println("\n******************************************************");
		System.out.println("______________________________________________________\n");
		System.out.println("           \"Thank You For Using This Program\"");
		System.out.println("               \"Have A Wonderful Day :D\"");
		System.out.println("______________________________________________________\n\n******************************************************");
		System.out.println("");
                
                System.out.println("Press Any Key To Continue...");
                new java.util.Scanner(System.in).nextLine();
                
                SysStart();

	}

    public static void Final(){
               char FinalDecision;
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.print("    Are You Sure You Don't Want To Continue? [Y/N]: ");
		FinalDecision = sc.next().charAt(0);
		if (( FinalDecision == 'Y' || FinalDecision == 'y'))
		{
			System.out.println("------------------------------------------------------");
			System.out.println("\n******************************************************");
			System.out.println("______________________________________________________\n");
			System.out.println("           \"Thank You For Using This Program\"");
			System.out.println("               \"Have A Wonderful Day :D\"");
			System.out.println("______________________________________________________\n\n******************************************************");
			System.exit(0);
		}
		else
		{
			SysStart();
		}

    }

    public static void Heading(){

                DateFormat dateFormat = new SimpleDateFormat("        EE MMMM dd yyyy HH:mm:ss aa");
		Date date = new Date();
		System.out.println("\n------------------------------------------------------");
		System.out.println(" _    _ _   _                       __           \r\n" +
				"/  |_//  (_   /   _  | . _ . _  _   (    | _ _ \r\n" +
				"\\__| \\\\____)  \\__(|)| )|(-| || )()  _)\\/_)|_(-|||\r\n" +
				"                                  _/      /          "
				);
		System.out.println("------------------------------------------------------");
		System.out.println("              Utility Cashier System Inc.             ");
		System.out.println("                                                      ");
		System.out.println("                   Store#: XXXXXXXX");
		System.out.println(                dateFormat.format(date) + " Jobillee Inc. ");
    }
		
    private static void Ask(){
			System.out.println("");
			System.out.print("");
			System.out.println("------------------------------------------------------");
			System.out.print("How much is the order quantity?: ");
    }
    public static void Exit(){

        System.exit(0);
    }
   
}
