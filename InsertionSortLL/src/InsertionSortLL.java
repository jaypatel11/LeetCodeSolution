import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/17/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */

class Node
{
    int data;
    Node next;
    void setData(int d)
    {
        data=d;
    }

    void setNext(Node n)
    {
        next=n;
    }

    int getData()
    {
        return data;
    }

    Node getNext()
    {
        return next;
    }
}


class LinkedList
{
    Scanner in=new Scanner(System.in);
    Node start=null;

    void insert_e(int d)
    {
        Node t=new Node();
        t.setData(d);
        if(start==null)
            start=t;
        else
        {
            Node temp=start;
            while(temp.getNext()!=null)
                temp=temp.getNext();
            temp.setNext(t);
        }
    }

    void insert_s()
    {
        System.out.println("Enter element to be inserted");
        int d=in.nextInt();
        Node t= new Node();
        t.setData(d);
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
        Node temp=start;
        while(temp!=null)
        {
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println();
    }
}

public class InsertionSortLL {

    public static  void main(String args[]){

        LinkedList ll = new LinkedList();
        ll.insert_e(5);
        ll.insert_e(2);
        ll.insert_e(4);
        ll.insert_e(6);
        ll.insert_e(1);
        ll.insert_e(3);
        insertionSort(ll.start);
        ll.display();

    }

    private static Node insertionSort(Node head) {

        if( head == null || head.next == null)
            return head;

        Node ptr = head;
        Node

        int key = 1;
        while(ptr != null ){

            Node current = ptr;
            Node ptrNext = ptr.next;
            int tempKey = key;
            Node innerptr =
            while(tempKey >= 0){

                tempKey--;
                Node next = current.next;
                if(current.data > next.data){

                    Node temp = current;
                    current = next;
                    next = temp;
                }
                else break;
            }
            key++;
            ptr = ptrNext;

        }

        return
    }



}
