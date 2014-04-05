import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/4/14
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedList {

    class ListNode
    {
        int val;
        ListNode next;
        void setVal(int d)
        {
            val =d;
        }

        void setNext(ListNode n)
        {
            next=n;
        }

        Object getVal()
        {
            return val;
        }

        ListNode getNext()
        {
            return next;
        }
    }


    public class LinkedList
    {
        Scanner in=new Scanner(System.in);
        ListNode start=null;

        void insert_e(int d)
        {
            ListNode t=new ListNode();
            t.setVal(d);
            if(start==null)
                start=t;
            else
            {
                ListNode temp=start;
                while(temp.getNext()!=null)
                    temp=temp.getNext();
                temp.setNext(t);
            }
        }

        void insert_s()
        {
            System.out.println("Enter element to be inserted");
            int d=in.nextInt();
            ListNode t=new ListNode();
            t.setVal(d);
            if(start==null)
                start=t;
            else
            {
                t.setNext(start);
                start=t;
            }
        }


        boolean empty()
        {
            return(start==null);
        }



        void display()
        {
            System.out.println("Linked List: ");
            ListNode temp=start;
            while(temp!=null)
            {
                System.out.print(temp.getVal()+" ");
                temp=temp.getNext();
            }
            System.out.println();
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if(l1 == null )
            return l2;

        if(l2 == null)
            return l1;


        while(l1 != null && l2!=null){


            if(l1.val >= l2.val){



            }
        }

    }
}
