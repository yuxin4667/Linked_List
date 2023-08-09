class Dnode
{
	int data;
	Dnode prev=null;
	Dnode next=null;
	public Dnode(Dnode p, int i, Dnode n)
	{
		prev=p;
		data=i;
		next=n;
	}
	public static Dnode p1=null;
}

public class DLL 
{
	static int count=0;
	public static void main(String[] args) 
	{
		//1創造開頭
		Dnode.p1=new Dnode(null, 50, null);
		list();
		
		//2插入尾端
		Dnode.p1.next=new Dnode(Dnode.p1, 60, null);
		list();
		
		//3插入開頭
		Dnode.p1=new Dnode(null, 30, Dnode.p1);
		Dnode.p1.next.prev=Dnode.p1;
		list();
		
		//4插入中間
		Dnode.p1.next=new Dnode(Dnode.p1, 40, Dnode.p1.next);
		Dnode.p1.next.next.prev=Dnode.p1.next;
		list();
		
		//5存取第2個節點資料於variable x1;第3個節點資料於variable x2;
		int x1;
		x1=Dnode.p1.next.data;
		int x2;
		x2=Dnode.p1.next.next.data;
		count++;
		System.out.println(count+".");
		System.out.println("x1 = "+x1+", x2 = "+x2);
		System.out.println("");
		
		//6刪除中間node
		Dnode.p1.next=Dnode.p1.next.next;
		Dnode.p1.next.prev=Dnode.p1;
		list();
		
		//7更改第2個節點資料為55
		Dnode.p1.next.data=55;
		list();
		
		//8刪除尾端node
		Dnode.p1.next.next=null;
		list();

		//9更改節點頭到尾的順序
		Dnode.p1=Dnode.p1.next;
		Dnode.p1.next=Dnode.p1.prev;
		Dnode.p1.prev=null;
		Dnode.p1.next.prev=Dnode.p1;
		Dnode.p1.next.next=null;
		list();
		
		//10插入中間
		Dnode.p1.next=new Dnode(Dnode.p1, 45, Dnode.p1.next);
		Dnode.p1.next.next.prev=Dnode.p1.next;
		list();
		
		//11刪除尾端節點並製作環狀串列
		Dnode.p1.next.next=Dnode.p1;
		Dnode.p1.prev=Dnode.p1.next;
		count++;
		System.out.println(count+".");
		Dnode tmp=Dnode.p1;
		for(int i=0;i<5;i++) 
		{
			System.out.print(tmp.data+"->");
			tmp=tmp.next;
		}
		System.out.println(tmp.data+"...");
	}
	
	public static void list() 
	{
		Dnode temp=Dnode.p1;
		count++;
		System.out.println(count+". ");
		
		System.out.print("List from head to tail: ");
		while(temp.next!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp.data+"->null");
		
		System.out.print("List from tail to head: ");
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.prev;
		}
		System.out.println("null");
		System.out.println("");
	}

}