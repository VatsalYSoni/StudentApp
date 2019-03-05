package com.demo.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.demo.data.local.db.dao.UserDao;
import com.demo.data.model.db.User;

import javax.inject.Singleton;


@Singleton
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
