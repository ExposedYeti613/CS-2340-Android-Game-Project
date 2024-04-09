package com.example.game;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import models.Player;

public class Sprint3Tests {

    @Test
    public void testIsColliding_true() {
        Player player = Player.getPlayerInstance();
        int[] playerLocation = {100, 100};
        int[] otherLocation = {80, 80};
        assertTrue(player.isColliding(playerLocation, otherLocation));
    }

    @Test
    public void testIsCollidingAgain_true() {
        Player player = Player.getPlayerInstance();
        int[] playerLocation = {200, 100};
        int[] otherLocation = {120, 90};
        assertTrue(player.isColliding(playerLocation, otherLocation));
    }

    @Test
    public void testIsColliding_false() {
        Player player = Player.getPlayerInstance();
        int[] playerLocation = {100, 100};
        int[] otherLocation = {200, 200};
        assertFalse(player.isColliding(playerLocation, otherLocation));
    }

    @Test
    public void testIsColliding_boundary() {
        Player player = Player.getPlayerInstance();
        int[] playerLocation = {100, 100};
        int[] otherLocation = {122, 122};
        assertTrue(player.isColliding(playerLocation, otherLocation));
    }
}
