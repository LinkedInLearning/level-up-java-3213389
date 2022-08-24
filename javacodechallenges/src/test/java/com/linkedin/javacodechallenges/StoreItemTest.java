package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class StoreItemTest {

    @Test
    public void getSetName() {
        StoreItem recordPlayerItem = new StoreItem("Record Player", 108.50, .65);
        assertEquals("Record Player", recordPlayerItem.getName());
        recordPlayerItem.setName("Pink Record Player");
        assertEquals("Pink Record Player", recordPlayerItem.getName());
    }

    @Test
    public void getSetRetailPrice() {
        StoreItem recordPlayerItem = new StoreItem("Record Player", 108.50, .65);
        assertEquals(108.50, recordPlayerItem.getRetailPrice(), 0);
        recordPlayerItem.setRetailPrice(99.99);
        assertEquals(99.99, recordPlayerItem.getRetailPrice(), 0);
    }

    @Test
    public void getSetDiscount() {
        StoreItem recordPlayerItem = new StoreItem("Record Player", 108.50, .65);
        assertEquals(.65, recordPlayerItem.getDiscount(), 0);
        recordPlayerItem.setDiscount(.75);
        assertEquals(.75, recordPlayerItem.getDiscount(), 0);
    }

    @Test
    public void toStringy() {
        StoreItem recordPlayerItem = new StoreItem("Record Player", 108.50, .65);
        assertEquals("Name: Record Player, Retail price: 108.5, Discount 0.65", recordPlayerItem.toString());
    }

    @Test
    public void findLeastExpensive() {
        StoreItem leastExpensive = new StoreItem("Dress", 34.99, .75);

        List<StoreItem> items = List.of(
                new StoreItem("T-Shirt", 19.99, .4),
                leastExpensive,
                new StoreItem("Record Player", 92.99, .75),
                new StoreItem("Hat", 23.99, .1),
                new StoreItem("Jeans", 54.99, .65));

        assertEquals(Optional.of(leastExpensive), StoreItem.findLeastExpensive(items));
    }

    @Test
    public void findLeastExpensive_emptyItems() {
        List<StoreItem> items = List.of();
        assertEquals(Optional.empty(), StoreItem.findLeastExpensive(items));
    }

    @Test
    public void findLeastExpensive_oneItem() {
        StoreItem leastExpensive = new StoreItem("Hat", 23.99, .1);
        List<StoreItem> items = List.of(leastExpensive);
        assertEquals(Optional.of(leastExpensive), StoreItem.findLeastExpensive(items));
    }

    @Test
    public void findLeastExpensive_sameItems() {
        StoreItem leastExpensive = new StoreItem("T-Shirt", 19.99, .4);
        List<StoreItem> items = List.of(leastExpensive, leastExpensive, leastExpensive);

        assertEquals(Optional.of(leastExpensive),
                StoreItem.findLeastExpensive(items));
    }

    @Test
    public void findLeastExpensive_sameItemsDifferentDiscounts() {
        StoreItem leastExpensive = new StoreItem("T-Shirt", 19.99, .9);
        StoreItem secondLeastExpensive = new StoreItem("T-Shirt", 19.99, .7);
        StoreItem thirdLeastExpensive = new StoreItem("T-Shirt", 19.99, .6);

        List<StoreItem> items = List.of(thirdLeastExpensive,
                secondLeastExpensive, leastExpensive);

        assertEquals(Optional.of(leastExpensive),
                StoreItem.findLeastExpensive(items));
    }

}
