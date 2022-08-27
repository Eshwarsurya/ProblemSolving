package level3;
/* 
 It is a fusion of two popular games TicTocToe and Rummy.
It consist of 32 cards.It was like four symbols named HR,CL,DM,SP and each symbolshaving numbers from 2to9.
It was a 3*3 Board and each cell having one card Like [HR,2],[DM,7],[SP,8].
There are four points like SimpleSet,Set,SimpleRun,Run.
SimpleSet- Same symbol and different values gives 10 points
Set - Different symbol and same values gives 15 points.
SimpleRun - Different names and values are in increasing or decreasing order gives 15 points.
Run - Samenames and values are in increasing or decreasing order gives 15 points.
This game consist of sinlge player and you have two options deal or done.
The board shows you the cards.
If you choose deal,it will give a new card from the deck and you can place it anywhere in your board.
If you choose done,it will show the results of the game.*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacRummy 
{
	public static String check(List<List<String>> boardList,int i,int j,int k)
	{
		String run="run",simpleRun="simpleRun",set="set",simpleSet="simpleSet";
		if(boardList.get(i).get(0).equals(boardList.get(j).get(0))&&boardList.get(j).get(0).equals(boardList.get(k).get(0)))
		{
			if(Integer.parseInt(boardList.get(i).get(1))>Integer.parseInt(boardList.get(j).get(1)) && Integer.parseInt(boardList.get(j).get(1))>Integer.parseInt(boardList.get(k).get(1)))
			{
				return run;
			}
			else if(Integer.parseInt(boardList.get(i).get(1))<Integer.parseInt(boardList.get(j).get(1)) && Integer.parseInt(boardList.get(j).get(1))<Integer.parseInt(boardList.get(k).get(1)))
			{
				return run;
			}
			else
			{
				return simpleSet;
			}
		}
		else
		{
			if(Integer.parseInt(boardList.get(i).get(1))>Integer.parseInt(boardList.get(j).get(1)) && Integer.parseInt(boardList.get(j).get(1))>Integer.parseInt(boardList.get(k).get(1)))
			{
				return simpleRun;
			}
			else if(Integer.parseInt(boardList.get(i).get(1))<Integer.parseInt(boardList.get(j).get(1)) && Integer.parseInt(boardList.get(j).get(1))<Integer.parseInt(boardList.get(k).get(1)))
			{
				return simpleRun;
			}
			else if(boardList.get(i).get(1).equals(boardList.get(j).get(1))&&boardList.get(j).get(1).equals(boardList.get(k).get(1)))
			{
				return set;
			}
		}
		return "";
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		int score=0;
		List<List<String>> deck=new ArrayList<List<String>>();
		List<List<String>> boardList=new ArrayList<List<String>>();
		for(int i=2;i<10;i++)
		{
			List<String> card=new ArrayList<String>();
			card.add("HR");
			card.add(""+i);
			deck.add(card);
			
		}
		for(int i=2;i<10;i++)
		{
			List<String> card=new ArrayList<String>();
			card.add("DM");
			card.add(""+i);
			deck.add(card);
		}
		for(int i=2;i<10;i++)
		{
			List<String> card=new ArrayList<String>();
			card.add("CL");
			card.add(""+i);
			deck.add(card);
		}
		for(int i=2;i<10;i++)
		{
			List<String> card=new ArrayList<String>();
			card.add("SP");
			card.add(""+i);
			deck.add(card);
		}
		Collections.shuffle(deck);
		for(int i=0;i<9;i++)
		{
			boardList.add(deck.get(i));
		}
		Object[][] board=new Object[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]=deck.get(0);
				deck.remove(0);
			}
		}
		System.out.println("Welcome to the game");
		boolean loop=true;
		while(loop)
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(board[i][j]);
				}
				System.out.println("");
			}
			System.out.println("Cards left to play : "+deck.size());
			System.out.println("Deal or Done? >>");
			Scanner input=new Scanner(System.in);
			String option=input.nextLine();
			if(option.equalsIgnoreCase("deal"))
			{
				score--;
				System.out.println("Score : "+score+" New card: "+deck.get(0)+" enter the place to be inserted(row,col) : ");
				boolean inloop=true;
				while(inloop)
				{
					try
					{
						Scanner sc =new Scanner(System.in);
						int newRow=sc.nextInt();
						int newColumn=sc.nextInt();
						board[newRow][newColumn]=deck.get(0);
						if(newRow==0 && newColumn==0)
						{
							boardList.remove(0);
							boardList.add(0, deck.get(0));
							deck.remove(0);
						}
						if(newRow==0 && newColumn==1)
						{
							boardList.remove(1);
							boardList.add(1, deck.get(0));
							deck.remove(0);
						}
						if(newRow==0 && newColumn==2)
						{
							boardList.remove(2);
							boardList.add(2, deck.get(0));
							deck.remove(0);
						}
						if(newRow==1 && newColumn==0)
						{
							boardList.remove(3);
							boardList.add(3, deck.get(0));
							deck.remove(0);
						}
						if(newRow==1 && newColumn==1)
						{
							boardList.remove(4);
							boardList.add(4, deck.get(0));
							deck.remove(0);
						}
						if(newRow==1 && newColumn==2)
						{
							boardList.remove(5);
							boardList.add(5, deck.get(0));
							deck.remove(0);
						}
						if(newRow==2 && newColumn==0)
						{
							boardList.remove(6);
							boardList.add(6, deck.get(0));
							deck.remove(0);
						}
						if(newRow==2 && newColumn==1)
						{
							boardList.remove(7);
							boardList.add(7, deck.get(0));
							deck.remove(0);
						}
						if(newRow==2 && newColumn==2)
						{
							boardList.remove(8);
							boardList.add(8, deck.get(0));
							deck.remove(0);
						}
						inloop=false;
					}
					catch(Exception e)
					{
						System.out.println("Enter correctly");
					}
				}
			}
			else if(option.equalsIgnoreCase("done"))
			{
				loop=false;
			}
			else
			{
				System.out.println("Enter correct option");
			}
		}
		String temp1=check(boardList,0,1,2);
		String temp2=check(boardList,0,3,6);
		String temp3=check(boardList,0,4,8);
		String temp4=check(boardList,2,5,8);
		String temp5=check(boardList,2,4,6);
		String temp6=check(boardList,8,7,6);
		String temp7=check(boardList,1,4,7);
		String temp8=check(boardList,3,4,5);
		if(temp1.equals("run")||temp2.equals("run")||temp3.equals("run")||temp4.equals("run")||temp5.equals("run")||temp6.equals("run")||temp7.equals("run")||temp8.equals("run"))
		{
			score+=25;
			System.out.println("Congrats,Yow have got Run on the board, Your Score is :"+score);
		}
		else if(temp1.equals("simpleRun")||temp2.equals("simpleRun")||temp3.equals("simpleRun")||temp4.equals("simpleRun")||temp5.equals("simpleRun")||temp6.equals("simpleRun")||temp7.equals("simpleRun")||temp8.equals("simpleRun"))
		{
			score+=20;
			System.out.println("Congrats,Yow have got SimpleRun on the board, Your Score is :"+score);
		}
		else if(temp1.equals("set")||temp2.equals("set")||temp3.equals("set")||temp4.equals("set")||temp5.equals("set")||temp6.equals("set")||temp7.equals("set")||temp8.equals("set"))
		{
			score+=15;
			System.out.println("Congrats,Yow have got Set on the board, Your Score is :"+score);
		}
		else if(temp1.equals("simpleSet")||temp2.equals("simpleSet")||temp3.equals("simpleSet")||temp4.equals("simpleSet")||temp5.equals("simpleSet")||temp6.equals("simpleSet")||temp7.equals("simpleSet")||temp8.equals("simpleSet"))
		{
			score+=10;
			System.out.println("Congrats,Yow have got SimpleSet on the board, Your Score is :"+score);
		}
		else
		{
			System.out.println("Lost, You have got zero score");
		}
	}
}
