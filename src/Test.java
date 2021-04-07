import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	static String adminId="admin";
	static String adminPIN="0000";
	static ArrayList<User> users;
public static void main(String[] args) {
	
	users=new ArrayList<User>();
	boolean condtion1=true;
	
	do {
		
	System.out.println("***** ATM *****");
	System.out.println("1)Admin\n2)User\n3)Exit");
	Scanner input= new Scanner(System.in);
	String choice1= input.nextLine();
	if (choice1.equals("1")) {
		boolean condtion2=true;
		
		
			System.out.println("Enter Id: ");
			String id=input.nextLine();
			System.out.println("Enter PIN: ");
			String pin=input.nextLine();
			if (id.equals(adminId)&& pin.equals(adminPIN)) {
				do {
					System.out.println("1)Create New User\n2)View Users\n3)Back to Menu");
					String choice2=input.nextLine();
					if (choice2.equals("1")) {
						System.out.println("Enter Id: ");
						String id2=input.nextLine();
						System.out.println("Enter PIN: ");
						int pin2=input.nextInt();
						input.nextLine();
						System.out.println("Enter Account Number: ");
						String No=input.nextLine();
						System.out.println("Enter Balance: ");
						double balance=input.nextDouble();
						input.nextLine();
						
						Account account= new Account(No,balance);
						User user= new User(id2, pin2, account);
						users.add(user);
						System.out.println("User is Added Successfully!");
						
					}
					else if (choice2.equals("2")) {
						for (int i = 0; i < users.size(); i++) {
							System.out.println("User("+i+") Details: "+users.get(i).getId()+"  "+users.get(i).getPIN()+"  "+users.get(i).getAccount().getAccountNo()+"  "+users.get(i).getAccount().getBalance()+"\n");
						}
					}
					else if (choice2.equals("3")) {
						condtion2=false;
					}
				} while (condtion2);
			}
			
			else {
				System.out.println("Incorrect Id or Password!");
			}
			
	}
	else if (choice1.equals("2")) {
		System.out.println("Enter User Id: ");
		String id=input.nextLine();
		System.out.println("Enter User PIN: ");
		int pin=input.nextInt();
		input.nextLine();
		int index=-1;
		boolean userExists=false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPIN()==pin) {
				 index= users.indexOf(users.get(i));
				userExists=true;
				break;
			}
		}
		
		if (userExists) {
			boolean condtion3=true;
			do {
				System.out.println("1)Transactions History\n2)Withdraw\n3)Deposit\n4)Transfer\n5)Quit");
				String choice=input.nextLine();
				if (choice.equals("1")) {
					
				}
				
				else if (choice.equals("2")) {
					System.out.println("Enter Amount of Money You Wish to Withdraw: ");
					double amount=input.nextDouble();
					input.nextLine();
					double balance=users.get(index).getAccount().getBalance();
					if (balance>=amount) {
						balance-=amount;
						users.get(index).getAccount().setBalance(balance);
						System.out.println("$"+amount+"Withdrawn >> Current Balance= "+"$"+balance);
					}
					else {System.out.println("Not Enough Balance to Cover This Withdrawal!");}
				}
				
				else if (choice.equals("3")) {
					System.out.println("Enter Amount of Money You Wish to Deposit: ");
					double amount=input.nextDouble();
					input.nextLine();
					double balance=users.get(index).getAccount().getBalance();
					
						balance+=amount;
						users.get(index).getAccount().setBalance(balance);
						System.out.println("$"+amount+"Deposited >> Current Balance= "+"$"+balance);
						
				}
				
				else if (choice.equals("4")) {
					System.out.println("Enter Account Number You Wish to Transfer to:  ");
					int index2=-1;
					String No=input.nextLine();
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getAccount().getAccountNo().equals(No)) {
							index2=i;
							break;
						}
					}
					if (index==-1) {
						System.out.println("Account Doesn't Exists!");
					}
					else {
						System.out.println("Enter Amount of Money You Wish to Transfer: ");
						double amount=input.nextDouble();
						input.nextLine();
						double balance2=users.get(index2).getAccount().getBalance();
						double balance=users.get(index).getAccount().getBalance();
						if (balance>=amount) {
							balance-=amount;
							balance2+=amount;
							users.get(index).getAccount().setBalance(balance);
							users.get(index2).getAccount().setBalance(balance2);
							System.out.println("$"+amount+"Transfered >> Current Balance= "+"$"+balance);
						}
						else {System.out.println("Not Enough Balance to Cover This Transfer!");}
					}
					
						
				}
				
				else if (choice.equals("5")) {
					condtion3=false;	
				}
				else {
					System.out.println("Bad Input! Please Enter a Number [1-5]");
				}
				
				
			} while (condtion3);
		}
		
	}
	
    else if (choice1.equals("3")) {
		condtion1=false;
	}
	
	else {
		System.out.println("Bad Input. Please Enter 1 or 2");
	}
	} while (condtion1);
}
}



