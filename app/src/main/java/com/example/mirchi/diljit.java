package com.example.mirchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class diljit extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diljit);
        Objects.requireNonNull(getSupportActionBar()).hide();
        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2F5%20Taara.mp3?alt=media&token=8bfae64b-5574-41e4-8cd4-ac09081c0604",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FBorn%20To%20Shine.mp3?alt=media&token=29c39808-83ab-4dc9-9db5-9cb5ceda5702",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FClash%20-%20Diljit%20Dosanjh.mp3?alt=media&token=234af3d2-fb9c-4d0c-9a33-2e8f8a237938",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FG.O.A.T.%20Remix.mp3?alt=media&token=e15b5389-ca3c-41ca-94a8-ee4a59151a8a",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FJind%20Mahi.mp3?alt=media&token=485e19ca-811e-44b6-94fa-a6ee1bff9ee3",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FMood.mp3?alt=media&token=e7895d2a-2f04-44ae-b67c-00889015279d",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FNamaste%20England%202018%20-%20Proper%20Patola.mp3?alt=media&token=074e8290-44f4-4a17-ba61-d93b6a974c0c",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FNavi%20Navi%20Yaari%20-%20Diljit%20Dosanjh.mp3?alt=media&token=755a4947-cb07-4461-93e0-5b55cdaed567",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FSauda%20Khara%20Khara%20-%20Good%20Newwz.mp3?alt=media&token=c25b5499-f548-4f6c-817b-4c397e02c5e5",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Diljit%2FWelcome%20To%20My%20Hood.mp3?alt=media&token=8a9451cf-3970-4e89-b6c7-1c7bd0c1e41d";

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("5 Taara",url));
        jcAudios.add(JcAudio.createFromURL("Born To Shine",url1));
        jcAudios.add(JcAudio.createFromURL("Clash",url2));
        jcAudios.add(JcAudio.createFromURL("G.O.A.T.",url3));
        jcAudios.add(JcAudio.createFromURL("Jind",url4));
        jcAudios.add(JcAudio.createFromURL("Mood",url5));
        jcAudios.add(JcAudio.createFromURL("Proper Patola",url6));
        jcAudios.add(JcAudio.createFromURL("Navi Navi Yaari",url7));
        jcAudios.add(JcAudio.createFromURL("Sauda Khara Khara",url8));
        jcAudios.add(JcAudio.createFromURL("Welcome To My Hood",url9));



        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(diljit.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(diljit.this, "Downloading", Toast.LENGTH_SHORT).show();
                                download();



                                return true;
                            case R.id.comingsoon:
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
    public void download(){
        storageReference = firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Diljit/5 Taara.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(diljit.this,"Diljit/5 Taara",".mp3",DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {

            }
        });
    }
    public void downloadfiles(Context context, String fileName, String fileExtenstion, String destinationDirectory, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri1 = Uri.parse(url);
        DownloadManager.Request request= new DownloadManager.Request(uri1);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName+fileExtenstion);
        downloadManager.enqueue(request);
    }
}