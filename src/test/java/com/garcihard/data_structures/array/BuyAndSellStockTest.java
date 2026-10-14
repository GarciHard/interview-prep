package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyAndSellStockTest {

    @Test
    void buyAndSellStock() {
        int[] arr1 = { 7, 1, 5, 3, 6, 4 };

        int prof1 = 5;

        assertEquals(prof1, BestTimeToBuyAndSellStocks.maxProfit(arr1));
    }
}
