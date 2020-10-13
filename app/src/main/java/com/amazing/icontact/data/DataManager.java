package com.amazing.icontact.data;

import android.content.Context;

import java.util.ArrayList;

public class DataManager {

    private static volatile DataManager instance = null;
    private DataManager() {}

    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }

        return instance;
    }

    private ArrayList<Contact> contacts;
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void prepareContacts(Context context) {
        contacts = ContactUtils.getAllContacts(context);
    }
}
