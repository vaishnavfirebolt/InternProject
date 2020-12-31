package com.example.internproject.ui.inviteFriends;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.internproject.R;

public class InviteFriendsFragment extends Fragment {

    private ImageView  whatsApp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_invite_friends, container, false);

        whatsApp = root.findViewById(R.id.img_whatsapp);

        whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });
        return root;
    }

    private void openWhatsApp() {
        Intent whatsAppIntent = new Intent(Intent.ACTION_SEND);
        whatsAppIntent.setType("text/plain");
        whatsAppIntent.setPackage("com.whatsapp");
        whatsAppIntent.putExtra(Intent.EXTRA_TEXT, "you are invited to join use the app");
        try {
            getActivity().startActivity(whatsAppIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext() , "WhatsApp not installed" , Toast.LENGTH_SHORT).show();
        }
    }
}