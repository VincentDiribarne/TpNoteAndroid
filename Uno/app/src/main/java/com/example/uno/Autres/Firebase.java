package com.example.uno.Autres;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://unotpnote-default-rtdb.europe-west1.firebasedatabase.app/");

    public void créerDonnées(String path, Object value) {
        DatabaseReference reference = database.getReference("message");
        reference.child(path).push().setValue(value);
    }
}
