import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/8/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
class Node
{
    Object data;
    Node next;
    void setData(Object d)
    {
        data=d;
    }

    void setNext(Node n)
    {
        next=n;
    }

    Object getData()
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

    void insert_e()
    {
        System.out.println("Enter element to be inserted");
        int d=in.nextInt();
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
        Node t=new Node();
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
        System.out.println("Linked List: ");
        Node temp=start;
        while(temp!=null)
        {
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        Node currPointer1 = l1;
        Node currPointer2 = l2;
        if(currPointer1 == null || currPointer2 == null){

            return null;
        }
        ArrayList<Integer> elements1 =  new ArrayList<Integer>();
        ArrayList<Integer> elements2 =  new ArrayList<Integer>();

        while(currPointer1 != null){

            elements1.add((Integer)currPointer1.getData());
            currPointer1 = currPointer1.getNext();

        }
        while(currPointer2 != null){

            elements2.add((Integer)currPointer2.getData());
            currPointer2 = currPointer2.getNext();

        }

        int lenDiff = Math.abs(elements1.size()-elements2.size());

        if(elements1.size() > elements2.size()){

            for(int i=0 ; i< lenDiff; i++){

                elements2.add(0);
            }
        }
        else{

            for(int i=0 ; i< lenDiff; i++){

                elements1.add(0);
            }
        }



        System.out.println(elements1);
        System.out.println("bamboo");
        System.out.println(elements2);
        int len = elements1.size();
        int i =0;
        int data;
        int carry = 0;
        Node head = null;
        while(i < len){

            data = elements2.get(i) + elements1.get(i) + carry;
            Node newNode = new Node();
            if(head == null){

                  head = newNode;
                  head.setNext(null);
            }
            else{

                 Node ptr = head;
                 while(ptr.getNext()!=null){

                     ptr = ptr.getNext();
                 }
                 ptr.setNext(newNode);
            }
            if(data >= 10){

                 carry = 1;
                 data = data - 10;


            }
            else{

                carry = 0;
            }
            newNode.setData(data);

            if(i == len -1 && carry == 1){

                Node carryNode = new Node();
                carryNode.setData(carry);
                newNode.setNext(carryNode);
                carryNode.setNext(null);

            }
            i++;

        }
        return head;
    }
}
public class AddNumbersLinkedList {



    public static void main(String args[]){


        System.out.println("Enter linked lists:");

        LinkedList LL1 = new LinkedList();
        LinkedList LL2 = new LinkedList();

        System.out.println("First LL");
        LL1.insert_e();
       // LL1.insert_e();
        //LL1.insert_e();
        System.out.println("Second LL");
        //LL2.insert_e();
        LL2.insert_e();
        LL2.insert_e();
        System.out.println("Printing added nodessss");
        printAllNodes(LinkedList.addTwoNumbers(LL1.start, LL2.start));
    }

    private static void printAllNodes(Node node) {

        Node currPtr = node;

        while(currPtr!=null){

            System.out.println(currPtr.getData());
            currPtr = currPtr.getNext();
        }
    }
}
