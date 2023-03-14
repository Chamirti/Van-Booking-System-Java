import java.io.*;
class Vanbooking
{	static int a=0,l,choose,seatsbooked=0,custcount=0,i,c=1;boolean found;String enteredid,route,cost;
	String name[]=new String[200];
	String gender[]=new String[200];
	String address[]=new String[200];
	String phoneno[]=new String[200];
	String custID[]=new String[200];
	String seatno[]=new String[25];
	int routedetails[]=new int[25];
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public static void main(String[]args)throws IOException
{
	
	System.out.println("WELCOME TO MOVE FORWARD VAN BOOKING SYSTEM");
	Vanbooking v1=new Vanbooking();
	for(int i=0;i>-1;i++)
	{	
		System.out.println("\nMAIN MENU:\n1.Add customer details\n2.Book a seat\n3.Edit seat details\n4.Edit customer details\n5.View seat availability\n6.Quit\nEnter your choice");
		int choice=Integer.parseInt(v1.br.readLine());
		switch(choice)	
		{
			case 1:
			v1.acceptcustomer();
			custcount++;
			break;
			case 2:
			v1.bookseat();
			break;
			case 3:
			v1.editseatdetails();
			break;
			case 4:
			v1.custdetchange();
			break;
			case 5:
			v1.viewseatavailability();
			break;
			case 6:
			System.out.println("THANK YOU FOR USING MOVE FORWARD VANBOOKING SYSTEM.PLEASE VISIT AGAIN.");i=-2;	
		}
	}
}
	void acceptcustomer()throws IOException
	{
		System.out.println("Enter your name, gender, address and phone number, in the same order");	
		name[custcount]=br.readLine();
		gender[custcount]=br.readLine();
		address[custcount]=br.readLine();
		phoneno[custcount]=br.readLine();
		System.out.print("Your cusomer id is ");
		String custid="MFVC";
		double a=10000000000.0d;
		long x=(long)(Math.random()*a);
		custid=custid+x;
		custID[custcount]=custid;
		System.out.println(custID[custcount]);
		
	}

	void bookseat() throws IOException
	{

			if(seatsbooked==25)                                                                                                           
			{
				System.out.println("Sorry,all the seats have been booked,please come back later");
			}
			else
			{int b;
			System.out.println("Please enter your customer id");
			enteredid=br.readLine();
			for(i=0;i<custID.length;i++)
			{	
				boolean a=enteredid.equals(custID[i]);
				if(a==true)
				{
					found=true;
					i++;
					break;
				}
			}
			if(found==false)
			System.out.println("Your customer id is invalid");
			else
			{
				i--;		
				if(seatno[i]!=null)
				System.out.println("Sorry, you have already booked a seat and only one seat per customer can be booked");
				else
				{
					
					do		
					{		                                                                                                                					System.out.println("Choose a route:\n1.Point A to School\n2.School to Point A\n3.Point B to School\n4.School to Point B\n5.Bothways(From either of the points to school and return to that point)\nEnter your choice"); 
						choose=Integer.parseInt(br.readLine());
						System.out.println("You have chosen option "+choose);
						if(choose==1||choose==2)
							cost="Rs.40";
						else if(choose==3||choose==4)
							cost="Rs.50";	
						else
							cost="Rs.100";
						System.out.println("Your cost is "+cost);
						System.out.println("Please confirm the above.\n1.I would like to confirm the above.\n2.I would like to change my choice");
						int choice1=Integer.parseInt(br.readLine());
						switch(choice1)
						{
							case 1:
							long x=(long)(Math.random()*Math.pow(10,7));
							seatno[i]="MFV"+x;
							System.out.print("Customer id:"+enteredid+"\nCustomer Name:"+name[i]+"\nSeat number:"+seatno[i]+"\nRoute details:");
							if(choose==1)
							route="Point A to School";
							else if(choose==2)
							route="School to Point A";
							else if(choose==3)
							route="Point B to School";
							else if(choose==4)
							route="School to Point B";
							else
							route="Bothways(From either of the points to school and return to that point)";
							System.out.println(route+"\nCost="+cost);
							seatsbooked++;
							routedetails[i]=choose;
							a=0;
							break;
							case 2:
							a=1;
						}
					}while(a==1);
				System.out.println("Would you like to:\n1.Book a seat\n2.Back to main menu");
				int choice5=Integer.parseInt(br.readLine());
				if(choice5==1)
				System.out.println("Sorry, you have already booked a seat and only one seat per customer can be booked");
				}
			}
			}
	}
	void editseatdetails()throws IOException
	{
		boolean found;
		int i;
		do
		{
			System.out.println("Please enter your seat number");
			String enteredseatno=br.readLine();
			for(i=0;i<seatno.length;i++)
			{
				if(enteredseatno==seatno[i])
				{
					found=true;i++;
					break;
				}
				else
				found=false;
					
			}
			i--;
			if(found=false)
			System.out.println("The seat number you have entered is invalid.");
			else
			{
				System.out.println("Choose a route:\n1.Point A to School:40 rs\n2.School to Point A:40rs\n3.Point B to School:50 rs\n4.School to Point B:50 rs\n5.Bothways(From either of the points to school and return to that point):100 rs.\nEnter your choice."); 			
				routedetails[i]=Integer.parseInt(br.readLine());
				System.out.println("Your seat details have been edited.Would you like to:\n1.Edit seat details\n2.Go back to main menu");
				int inp=Integer.parseInt(br.readLine());
				switch(inp)
				{
					case 1:
					c=2;
					break;
					case 2:
					c=1;
				}
			}
		}while(c==2);
	}
	void custdetchange()throws IOException
	{	
		System.out.println("Please enter your customer id");
		enteredid=br.readLine();
		for(i=0;i<custID.length;i++)
		{	
			boolean a=enteredid.equals(custID[i]);
			if(a==true)
			{
				found=true;
				i++;
				break;
			}
		}
		if(found==false)
		{
			System.out.println("Your customer id is not valid");
		}
		else
		{
			i--;
			do
			{
				l=0;
				System.out.println("Enter your name, gender, address and phone number, in the same order");	
				String name1=br.readLine();
				String gender1=br.readLine();
				String address1=br.readLine();
				String phoneno1=br.readLine();
				boolean a=name1.equalsIgnoreCase((name[i]));
				boolean b=gender1.equalsIgnoreCase(gender[i]);
				boolean c=address1.equalsIgnoreCase(address[i]);
				boolean d=phoneno1.equalsIgnoreCase(phoneno[i]);
				if(a==false)
				name[i]=name1;
				if(b==false)
				gender[i]=gender1;
				if(c==false)
				address[i]=address1;
				if(d==false)
				phoneno[i]=phoneno1;
				System.out.println("Your details after editing are:");
				System.out.println("Name:"+name[i]);
				System.out.println("Gender:"+gender[i]);
				System.out.println("Address:"+address[i]);
				System.out.println("Phone number:"+phoneno[i]);
				System.out.println("Would you like to:\n1.Edit customer details\n2.Back to main menu");
				int choice4=Integer.parseInt(br.readLine());
				switch(choice4)
				{
					case 1:
					l++;
					case 2:
					break;
				}
			}while(l==1);
		}
	}
	void viewseatavailability()throws IOException
	{
		System.out.println("Please enter your customer id");
		enteredid=br.readLine();
		for(i=0;i<custID.length;i++)
		{	
			boolean a=enteredid.equals(custID[i]);
			if(a==true)
			{
				found=true;
				i++;
				break;
			}
		}
		if(found==false)
		{
			System.out.println("Your customer id is invalid");
		}
		else
		{
			i--;
			System.out.println((25-seatsbooked)+" seats are available for booking.");
			System.out.println("Name:"+name[i]);
			System.out.println("Gender:"+gender[i]);
			System.out.println("Address:"+address[i]);
			System.out.println("Phone number:"+phoneno[i]);
			if(seatno[i]!=null)
			{
				System.out.println("Seat number:"+seatno[i]);
				if(routedetails[i]==1)
				{
					route="Point A to School";
					cost="40rs";
				}
				else if(routedetails[i]==2)
				{
					route="School to Point A";
					cost="40rs";
				}
				else if(routedetails[i]==3)
				{
					route="Point B to School";
					cost="50rs";
				}
				else if(routedetails[i]==4)
				{
					route="School to Point B";
					cost="50rs";
				}
				else
				{
					route="Bothways(From either of the points to school and return to that point)";
					cost="100rs";
				}
				System.out.println("Route details:"+route);
				System.out.println("Cost:"+cost);
			}
			else
			System.out.println("You have not booked a seat");
		}
	}
}




