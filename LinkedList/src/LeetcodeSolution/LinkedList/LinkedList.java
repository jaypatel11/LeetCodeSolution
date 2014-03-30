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
}