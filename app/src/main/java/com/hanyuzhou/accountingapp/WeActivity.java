package com.hanyuzhou.accountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class WeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we);
        TextView scrollableTextView = findViewById(R.id.textViewAboutUs);
        scrollableTextView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(R.id.buttonPrivacyPolicy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextDialog();
            }
        });
    }


        private void showTextDialog() {
            // Load the text from the assets folder.
            String text = loadTextFromAssets("tengen.txt");

            // Inflate a layout for the dialog.
            LayoutInflater inflater = LayoutInflater.from(this);
            View view = inflater.inflate(R.layout.dialog_text, null);

            // Find the TextView in the inflated layout and set the text.
            TextView dialogTextView = view.findViewById(R.id.dialog_text_view);
            dialogTextView.setMovementMethod(LinkMovementMethod.getInstance());
            dialogTextView.setText(text);

            // Create and show the AlertDialog.
            new AlertDialog.Builder(this)
                    .setTitle("UR Text")
                    .setView(view)
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        private String loadTextFromAssets(String fileName) {
            StringBuilder text = new StringBuilder();

            try {
                InputStream is = getAssets().open(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }

                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return text.toString();
        }
}