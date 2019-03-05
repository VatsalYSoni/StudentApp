package com.demo.data.local.db;



import com.demo.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;



public interface DbHelper {

    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertUser(final User user);

}
