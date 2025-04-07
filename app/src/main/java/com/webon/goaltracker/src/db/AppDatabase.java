package com.webon.goaltracker.src.db;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.webon.goaltracker.src.dao.GoalDao;
import com.webon.goaltracker.src.model.Goal;

@Database(entities = {Goal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GoalDao goalDao();
}
