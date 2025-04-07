package com.webon.goaltracker.src.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "goals")
public class Goal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String goalText;
    private String interests;

    public Goal(String goalText, String interests) {
        this.goalText = goalText;
        this.interests = interests;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getGoalText() { return goalText; }
    public void setGoalText(String goalText) { this.goalText = goalText; }
    public String getInterests() { return interests; }
    public void setInterests(String interests) { this.interests = interests; }
}
