package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemSulfuras implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        //永不过期，不会降低品质，品质永远是80
        item.sellIn--;
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
        item.quality = 80;
    }
}
