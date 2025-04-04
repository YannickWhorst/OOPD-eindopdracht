package main.logic;

import java.io.*;
import java.util.*;

public class ScoreManager {
    private int currentScore = 0;
    private final String scoreFilePath = "scores.txt";

    public void addScore(int points) {
        currentScore += points;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void resetScore() {
        currentScore = 0;
    }

    public void saveScore(String playerName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoreFilePath, true))) {
            writer.write(playerName + "," + currentScore);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Could not save score: " + e.getMessage());
        }
    }

    public List<ScoreEntry> getTopScores(int maxScores) {
        List<ScoreEntry> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(scoreFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores.add(new ScoreEntry(name, score));
                }
            }
        } catch (IOException e) {
            System.err.println("Could not read scores: " + e.getMessage());
        }

        scores.sort((a, b) -> Integer.compare(b.score(), a.score())); // highest first
        return scores.subList(0, Math.min(maxScores, scores.size()));
    }

    public record ScoreEntry(String name, int score) {}

}
