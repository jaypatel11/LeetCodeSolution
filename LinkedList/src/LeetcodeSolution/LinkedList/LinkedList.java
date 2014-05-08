package LeetcodeSolution.LinkedList;

import java.util.Scanner;

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


public class LinkedList
{
    Node head =null;

    Scanner in=new Scanner(System.in);

    void insert_e()
    {

        System.out.println("Enter element to be inserted");
        int d=in.nextInt();
        Node t=new Node();
        t.setData(d);
        if(head ==null)
            head =t;
        else
        {
            Node temp= head;
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
        if(head ==null)
            head =t;
        else
        {
            t.setNext(head);
            head =t;
        }
    }


    boolean empty()
    {
        return(head ==null);
    }



    void display()
    {
        System.out.println("Linked List: ");
        Node temp= head;
        while(temp!=null)
        {
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    void reverse(){

       reverseLLHelper(head);
    }

    void iterativeReverse(){

        Node prev = null;
        Node current  = head;

        while(current != null ){

            Node temp = current.next;

            current.next = prev;

            prev = current;

            current = temp;

        }
        head = prev;

    }
    Node reverseLLHelper(Node current){

        if(current == null || current.getNext() == null)
            return current;

        Node reverseList = reverseLLHelper(current.getNext());
        Node nextElem = current.getNext();
        current.setNext(null);

        nextElem.setNext(current);
        return reverseList;

    }
    public static void main(String args[]){

        LinkedList ll = new LinkedList();

        for(int i = 0; i < 5; i++)
            ll.insert_e();

        ll.display();
        ll.iterativeReverse();
        ll.display();
    }
}