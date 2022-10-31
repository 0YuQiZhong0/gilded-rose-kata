package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemAgedBrie implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        //品质随时间提高，但不超过50
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
