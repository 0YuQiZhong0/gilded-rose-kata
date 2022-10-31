package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static Map<String, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put("Aged Brie", new ItemAgedBrie());
        itemStrategyMap.put("Backstage passes to a TAFKAL80ETC concert", new ItemBackstagePasses());
        itemStrategyMap.put("Conjured Mana Cake", new ItemConjured());
        itemStrategyMap.put("Sulfuras, Hand of Ragnaros", new ItemSulfuras());
    }

    public void updateQuality() {
        for (Item item : items) {
            //判断该物品是否有特殊的规则
            ItemStrategy itemBase = itemStrategyMap.get(item.name);
            if (itemBase != null) {
                itemBase.updateQuality(item);
                continue;
            }
            //若没有则执行默认规则(销售期限和品质每天-1，若过期，则品质双倍下降，品质不会为负值)
            item.sellIn--;
            item.quality--;
            if (item.sellIn < 0) {
                item.quality--;
            }
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }

}
