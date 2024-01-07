// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.util.Comparator;
import prj5.DLList.Node;

/**
 * Provides Sorting functionalities for a DLList.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.19
 */
public class InsertionSorter {
    /**
     * Sort by trad engagement
     * 
     * @param list description
     * @return sorted list
     */
    public DLList<Influencer> sortByTraditonalEngagement(
        DLList<Influencer> list) {
        return insertionSort(list, new CompareByTraditionalEngagement());
    }

    /**
     * Sort by reach engagement
     * 
     * @param list description
     * @return sorted list
     */
    public DLList<Influencer> sortByReachEngagement(
        DLList<Influencer> list) {
        return insertionSort(list, new CompareByReachEngagement());
    }

    /**
     * Sort by name
     * 
     * @param list description
     * @return sorted list
     */
    public DLList<Influencer> sortByName(
        DLList<Influencer> list) {
        return insertionSort(list, new CompareByName());
    }
    
    /**
     * Insertion sort 
     * 
     * @param list description
     * @param compare description
     * @return sorted list based on inserted comparator
     */
    public DLList<Influencer> insertionSort(
        DLList<Influencer> list, Comparator<Influencer> compare) {
        Node<Influencer> head = list.getNodeAtIndex(0);
        if (head.next() != null) {
            Node<Influencer> sorted = head;
            Node<Influencer> unsorted = head.next();
            sorted.setNext(null);
            sorted.setPrevious(null);
            unsorted.setPrevious(null);
            
            while (unsorted.getData() != null) {
                Node<Influencer> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                nodeToInsert.setNext(null);
                sorted = insertInOrder(sorted, nodeToInsert, compare);
            }
            list.clear();
            while (sorted != null && sorted.getData() != null) {
                list.add(sorted.getData());
                sorted = sorted.next();
            }
        }
        return list;
    }
    
    /**
     * Insertion sort helper 
     * 
     * @param head description
     * @param nodeToInsert description
     * @param compare description
     * @return sorted portion of list
     */
    private Node<Influencer> insertInOrder(
        Node<Influencer> head, Node<Influencer> nodeToInsert, 
        Comparator<Influencer> compare) {
        Influencer item = nodeToInsert.getData();
        Node<Influencer> currentNode = head;
        Node<Influencer> previousNode = null;
        
        while ((currentNode != null) &&
            (compare.compare(item, currentNode.getData()) > 0)) {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        
        if (previousNode != null) {
            nodeToInsert.setPrevious(previousNode);
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        // insert at beginning of list when previousNode is null
        else {
            nodeToInsert.setPrevious(null);
            nodeToInsert.setNext(currentNode);
            head = nodeToInsert;
        }
        return head;
    }
}