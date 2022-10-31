package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemConjured implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        //品质下降速度快一倍
        item.sellIn--;
        item.quality -= 2;
        if (item.sellIn < 0) {
            item.quality -= 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
