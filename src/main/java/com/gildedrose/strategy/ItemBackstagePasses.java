package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemBackstagePasses implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        //品质随时间提高，剩余10天内+2，5天内+3，过期品质变为0
        item.sellIn--;
        item.quality++;
        if (item.sellIn <= 10) {
            item.quality++;
        }
        if (item.sellIn <= 5) {
            item.quality++;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
    }
}
