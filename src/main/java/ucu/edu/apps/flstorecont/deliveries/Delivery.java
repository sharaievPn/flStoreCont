package ucu.edu.apps.flstorecont.deliveries;

import ucu.edu.apps.flstorecont.Item;

import java.util.LinkedList;

public interface Delivery {

    String deliver(LinkedList<Item> items);
}
