class node{
	int data;
	node next;
	public node(int i, node n)
	{
		data=i;
		next=n;
	}
	public static node p1=null, tail=null;
}

public class SLL 
{
	static int count=0;
	public static void main(String[] args) 
	{
		//1插入開頭
		node.tail=node.p1=new node(40, null);
		list();
		
		//2插入開頭
		node.p1=new node(30, node.p1);
		list();
		
		//3插入尾端
		node.tail=node.p1.next.next=new node(50, null);
		list();
		
		//4插入尾端
		node.tail=node.p1.next.next.next=new node(60, null);
		list();
		
		//5插入中間
		node.p1.next=new node(35, node.p1.next);
		list();
		
		//6插入中間
		node.p1.next.next.next=new node(45, node.p1.next.next.next);
		list();
		
		//7刪除開頭node
		node.p1=node.p1.next;
		list();
		
		//8刪除尾端node
		node temp=node.p1;
		while(temp.next.next!=null)
			temp=temp.next;
		temp.next=null;
		node.tail=temp;
		list();
		
		//9刪除中間node
		int num=0;
		node.p1.next.next=node.p1.next.next.next;
		list();
		
		//10變成環狀
		node.tail.next=node.p1;

		temp=node.p1;
		System.out.print("10. ");
		for(int i=0;i<9;i++)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp.data+"...");
		System.out.println(" ");
		
		node.tail.next=null;//把環狀串列改回一般串列
		
		//11所有node資料相加
		int sum=0;
		temp=node.p1;
		while(temp!=null)
		{
			sum=sum+temp.data;
			temp=temp.next;
		}
		System.out.println("11. sum = "+sum);
	}
	
	public static void list() 
	{
		int num=0;
		node temp=node.p1;
		count++;
		System.out.print(count+". ");
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
			num++;
		}
		System.out.println("null");
		System.out.println("");
	}
}
