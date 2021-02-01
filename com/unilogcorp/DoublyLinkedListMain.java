package com.unilogcorp;

import java.util.Scanner;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        NodeOperation<String> nodeOperation = new NodeOperation<String>();

        // add node at first index
        // nodeOperation.addFirst(1);

        // add node at last index
        // nodeOperation.addLast(2);
        // nodeOperation.addLast(3);
        // nodeOperation.addLast(4);
        // nodeOperation.addLast(5);

        // display doubly linked list
        // nodeOperation.display();

        // add node at any index
        // nodeOperation.addAtIndex(3, 3);
        // nodeOperation.addAtIndex(4, 2);
        // nodeOperation.addAtIndex(5, 2);
        // nodeOperation.addAtIndex(6, 1);
        // nodeOperation.display();

        // remove node at first index
        // nodeOperation.removeFirst();
        // nodeOperation.display();

        // remove node at last index
        // nodeOperation.removeLast();
        // nodeOperation.display();

        // remove node at any index
        // nodeOperation.removeAtIndex(2);
        // nodeOperation.display();
        // nodeOperation.removeAtIndex(3);
        // nodeOperation.display();

        // search node in doubly linked list
        // System.out.println(nodeOperation.search(2));

        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n\nNode Operation Menu\n-----------------------");
                System.out.println(
                        "1. Add Node First.\n2. Add Node Last.\n3. Add Node at an Index.\n4. Remove First Node.\n5. Remove Last Node.\n6. Remove Node at an Index.\n7. Find a Node.\n8. Display Node.\n9. Exit.");
                System.out.print("Enter your choice :-\t");
                choiceInMenu(sc.nextInt(), sc, nodeOperation);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        } finally {
            sc.close();
        }

    }

    private static void choiceInMenu(int choice, Scanner sc, NodeOperation<String> nodeOperation) {

        String data;
        int index;
        System.out.println();
        switch (choice) {
            case 1: {
                System.out.println("Enter data for first position");
                data = sc.next();
                nodeOperation.addFirst(data);
                System.out.println("Node added at first index");
                break;
            }
            case 2: {
                System.out.println("Enter data for last position");
                data = sc.next();
                nodeOperation.addLast(data);
                System.out.println("Node added at last index");
                break;
            }
            case 3: {
                System.out.println("Enter data");
                data = sc.next();
                System.out.println("Enter insertion index");
                index = sc.nextInt();
                try {
                    nodeOperation.addAtIndex(data, index);
                    System.out.println("Node added at " + index + " index");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4: {
                try {
                    nodeOperation.removeFirst();
                    System.out.println("Node removed from first index");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 5: {
                try {
                    nodeOperation.removeLast();
                    System.out.println("Node removed from last index");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            }
            case 6: {
                System.out.println("Enter deletion element index");
                index = sc.nextInt();
                try {
                    nodeOperation.removeAtIndex(index);
                    System.out.println("Node removed from " + index + " index");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 7: {
                System.out.println("Enter element to be search");
                data = sc.next();
                index = nodeOperation.search(data);
                if (index > 0) {
                    System.out.println("Node index is " + index);
                } else {
                    System.out.println("Node not found");
                }
                break;
            }
            case 8: {
                nodeOperation.display();
                break;
            }
            case 9: {
                System.out.println("Exit");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Invalid Choice");
            }

        }

    }
}