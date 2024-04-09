package com.example.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static models.ScoreEntry.checkNegativeScore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import views.GameActivity1;
import java.util.List;
import models.Wall;
import com.google.android.material.color.utilities.Score;

import org.junit.Before;
import org.junit.Test;

import models.Player;
import viewmodels.InitialConfigActivityViewModel;
import java.util.List;

import models.LeaderboardManager;
import models.ScoreEntry;

import views.EndScreenActivity;
import java.lang.reflect.Method;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    private GameActivity1 gameActivity1;
    private Player player;

    // Chris Lee Test Cases
    @Test
    public void checkValidName() {
        InitialConfigActivityViewModel vm = new InitialConfigActivityViewModel();
        assertTrue(vm.isValidName("Valid Name"));
        assertTrue(vm.isValidName("      v "));
        assertTrue(vm.isValidName("  Hello  "));
        assertTrue(vm.isValidName("Apple     "));
        assertTrue(vm.isValidName("      Bye"));
    }
    @Test
    public void checkInvalidName() {
        InitialConfigActivityViewModel vm = new InitialConfigActivityViewModel();
        assertFalse(vm.isValidName(""));
        assertFalse(vm.isValidName(" "));
        assertFalse(vm.isValidName("       "));
    }

    //Arthur Yao Test Cases
    @Test
    public void checkStartingLives() {
        InitialConfigActivityViewModel vm = new InitialConfigActivityViewModel();
        assertEquals(100, vm.checkHealth("Easy"));
        assertEquals(75, vm.checkHealth("Medium"));
        assertEquals(50, vm.checkHealth("Hard"));
    }

    @Test
    public void checkScoreIsCorrect() {
        assertTrue(checkNegativeScore(0));
        assertTrue(checkNegativeScore(1));
        assertTrue(checkNegativeScore(10));
        assertFalse(checkNegativeScore(-1));
    }

    @Test
    public void checkPlayerXCoordinate() {
        InitialConfigActivityViewModel vm = new InitialConfigActivityViewModel();
        assertTrue(vm.checkValidXCoordinates(100));
        assertTrue(vm.checkValidXCoordinates(0));
        assertFalse(vm.checkValidXCoordinates(1001));
        assertFalse(vm.checkValidXCoordinates(-1));
    }

    @Test
    public void checkPlayerYCoordinate() {
        InitialConfigActivityViewModel vm = new InitialConfigActivityViewModel();
        assertTrue(vm.checkValidYCoordinates(499));
        assertTrue(vm.checkValidYCoordinates(20));
        assertTrue(vm.checkValidYCoordinates(0));
        assertFalse(vm.checkValidYCoordinates(502));
        assertFalse(vm.checkValidYCoordinates(-1));
    }


    // Pranav Kondapalli Test Cases
    @Before
    public void setUp() {
        LeaderboardManager.getInstance().clear();
    }

    @Test
    public void testAddScoreEntry() {
        LeaderboardManager manager = LeaderboardManager.getInstance();
        ScoreEntry entry = new ScoreEntry("Player 1", 100, "2023-10-10 10:00:00");
        manager.addScoreEntry(entry);
        List<ScoreEntry> leaderboard = manager.getLeaderboard();
        System.out.println(leaderboard);
        assertEquals(1, leaderboard.size());
        assertEquals(entry, leaderboard.get(0));
    }

    @Test
    public void testLeaderboardSorting() {
        LeaderboardManager manager = LeaderboardManager.getInstance();
        ScoreEntry entry1 = new ScoreEntry("Player 1", 100, "2023-10-10 10:00:00");
        ScoreEntry entry2 = new ScoreEntry("Player 2", 200, "2023-10-10 10:05:00");
        manager.addScoreEntry(entry1);
        manager.addScoreEntry(entry2);
        List<ScoreEntry> leaderboard = manager.getLeaderboard();
        assertEquals(entry2, leaderboard.get(0));
        assertEquals(entry1, leaderboard.get(1));
    }

    @Test
    public void testLeaderboardSizeLimit() {
        LeaderboardManager manager = LeaderboardManager.getInstance();
        for (int i = 0; i < 15; i++) {
            ScoreEntry entry = new ScoreEntry("Player " + i, i, "2023-10-10 10:0" + i);
            manager.addScoreEntry(entry);
        }
        List<ScoreEntry> leaderboard = manager.getLeaderboard();
        assertEquals(10, leaderboard.size());
    }

    @Test
    public void checkValidButton() {
        EndScreenActivity ea = new EndScreenActivity();
        assertTrue(ea.hasValidButton());
    }

    @Test
    public void checkLeaderboardDisplay() {
        EndScreenActivity ea = new EndScreenActivity();
        assertTrue(ea.validLeaderBoard());
    }
}