//Assignment 10
//Generics, Arrays and Containers

import java.util.Scanner;

public class SList<T> 
{

	static Link head;

	public static SListIterator iterator(Link head)
	{

		SListIterator iter = new SListIterator(head);
		return iter;

	}

	public static void main(String args[])
	{

		SList sl = new SList();
		head = new Link("Head Link",null);
		SListIterator iter = iterator(head);
		boolean loop = true;
		while(loop)
		{
			System.out.println("Press 'a' to add a new link");
			System.out.println("Press 'r' to remove the last link");
			System.out.println("Press 'p' to print the list");
			System.out.println("Press 'e' to exit");

			Scanner scan = new Scanner(System.in);
			char input = scan.next().charAt(0);
			scan.nextLine();

			switch(input)
			{
				case 'a' :
					System.out.println("give data for new link");
					iter.insert(scan.next());
					break;
			
				case 'r' :
					iter.remove();
					break;
			
				case 'p' :
					iter.iterate();
					break;
				case 'e' : 
					loop = false;
					break;
			
				default :
					loop = false;
					break;
			}
		}

	}

}
class Link<T> 
{

	T val;
	Link<T> next;

	Link(T val, Link<T> next)
	{
		this.val=val;
		this.next=next;
	}
}

class SListIterator<T>
{

	Link head;
	Link current;
	Link previous;
	Link priorToPrevious;

	public SListIterator(Link head) {
		this.head=head;
		current=head;
	}

	void insert(T val)
	{
		Link node = new Link(val,null);
		current.next=node;
		previous=current;
		current=node;
	}

	void remove()
	{
		Link current = head;
		int count = 0;
		while(current.next!=null)
		{
			priorToPrevious = previous;
			previous = current;
			current = current.next;
			count++;
		}

		current = previous;
		current.next = null;
		previous = priorToPrevious;

		if(count > 0)
		{
			System.out.println("last link is removed now");
		}
		else
		{
			System.out.println("There are no links to remove");
		}

	}

	void iterate()
	{
		Link cur = head;
		while(cur != null)
		{
			if(cur != head)
			{
				System.out.print(" -> ");
			}
			System.out.print(cur.val);
			cur=cur.next;
		}
		System.out.println();
	}

}