package com.prgguru.example.exrecyclerview;

import java.util.ArrayList;

/**
 * Created by mind on 22/12/16.
 * Every RecyclerView is backed by a source for data.
 * In this case, we will define a Contact class which represents the data model being displayed by the RecyclerView:
 */

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
