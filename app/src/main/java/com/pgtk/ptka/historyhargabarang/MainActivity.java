package com.pgtk.ptka.historyhargabarang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    long urutan = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref= database.getReference("barang");

        final TableLayout table = findViewById(R.id.tabel);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                barang B = dataSnapshot.getValue(barang.class);

                TableRow row = new TableRow(MainActivity.this);

                TextView col1 = new TextView(MainActivity.this);
                TextView col2 = new TextView(MainActivity.this);
                TextView col3 = new TextView(MainActivity.this);
                TextView col4 = new TextView(MainActivity.this);

                col1.setText(urutan+"");
                col2.setText(B.KD_BARANG);
                col3.setText(B.NM_BARANG);
                col4.setText(B.SATUAN);

                row.addView(col1);
                row.addView(col2);
                row.addView(col3);
                row.addView(col4);

                table.addView(row);
                urutan++;

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
