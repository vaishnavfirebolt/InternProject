package com.example.internproject.ui.contactUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.internproject.R;

public class ContactUsFragment extends Fragment {

    private ImageView sendArrow;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);

        sendArrow = root.findViewById(R.id.img_sendEmail);
        sendArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmail();
            }
        });

        return root;
    }

    private void openEmail() {
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Query Regarding -> ");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}