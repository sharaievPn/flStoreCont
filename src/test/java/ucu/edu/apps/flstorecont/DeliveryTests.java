package ucu.edu.apps.flstorecont;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.apps.flstorecont.deliveries.
        DHLDeliveryStrategy;
import ucu.edu.apps.flstorecont.deliveries.
        Delivery;
import ucu.edu.apps.flstorecont.deliveries.
        PostDeliveryStrategy;

import java.util.LinkedList;


public class DeliveryTests {

    private Delivery deliveryDHL;
    private Delivery post;
    private FlowerBucket itemFirst;
    private FlowerBucket itemSecond;
    private Flower flower;
    private Flower flowerSecond;
    private FlowerPack flowerPack;
    private FlowerPack flowerPackSecond;
    private LinkedList<Item> items;



    @BeforeEach
    public void init() {
        itemFirst = new FlowerBucket();
        flower = new Flower(11.5, 11.5, FlowerColor.RED);
        flowerSecond = new Flower(11.5, 11.5, FlowerColor.BLUE);
        flowerPack = new FlowerPack(flower, 15);
        flowerPackSecond = new FlowerPack(flowerSecond, 30);
        itemFirst.add(flowerPack);
        itemSecond = new FlowerBucket();
        itemSecond.add(flowerPackSecond);
        items = new LinkedList<>();
        itemFirst.setDescription("15 Red Flowers");
        itemSecond.setDescription("30 Blue Flowers");
        items.add(itemFirst);
        items.add(itemSecond);

        deliveryDHL = new DHLDeliveryStrategy();
        post = new PostDeliveryStrategy();
    }


    @Test
    public void deliveryDHLProcess() {
        String underDelivery = deliveryDHL.deliver(items);
        System.out.println(underDelivery);
        assert (underDelivery.equals("15 Red Flowers 30 Blue Flowers"));
    }

    @Test
    public void postDeliveryProcess() {
        String postDelivery = post.deliver(items);
        assert (postDelivery.equals("15 Red Flowers 30 Blue Flowers"));
    }

}
