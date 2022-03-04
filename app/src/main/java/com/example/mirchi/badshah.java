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

public class badshah extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badshah);
        Objects.requireNonNull(getSupportActionBar()).hide();
        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FBuzz%20-%20Badshah.mp3?alt=media&token=47038563-58ba-44c1-9b1b-10d748a28738",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FDJ%20Waley%20Babu%20-%20Badshah.mp3?alt=media&token=d8c8019a-cdd1-4000-bb66-68d7367af0ee",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FGarmi%20feat.%20Varun%20Dhawan%20-%20Street%20Dancer%203D%20128%20Kbps.mp3?alt=media&token=e2fe371a-61c1-4d86-8f53-226edaf23e45",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FGenda%20Phool%20-%20Badshah.mp3?alt=media&token=a16a938f-e04a-43c3-934b-7c2ad527673d",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FKar%20Gayi%20Chull.mp3?alt=media&token=d2a17c53-e282-46bd-b8b4-eef6b43a74ee",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FLoveratri%202018%20-%20Akh%20Lad%20Jaave.mp3?alt=media&token=ce9710b9-2bca-4bfb-b39e-57d10d5b1b88",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FMercy%20-%20Badshah.mp3?alt=media&token=ea119c52-4d76-47b6-8121-0f9f1a6fd12a",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FNamaste%20England%202018%20-%20Proper%20Patola.mp3?alt=media&token=a44d07b5-e93f-406f-99e5-a79b37e7cd10",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FPaagal%20-%20Badshah.mp3?alt=media&token=46537949-3225-4d39-9320-1d05f3ba75d6",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FSawan%20Mein%20Lag%20Gayi%20Aag%20-%20Ginny%20Weds%20Sunny(2020).mp3?alt=media&token=afbf024a-0a44-4cd9-8b96-06f3e7953134",
                url10="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FShe%20Move%20It%20Like%20-%20Badshah.mp3?alt=media&token=ce240a23-69df-4964-9364-f355b1839835",
                url11="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Badshah%2FWakhra%20Swag%20-%20Badshah.mp3?alt=media&token=dcaa598b-09ef-4456-b34e-853c549b525e";



        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Buzz",url));
        jcAudios.add(JcAudio.createFromURL("DJ Waley Babu",url1));
        jcAudios.add(JcAudio.createFromURL("Garmi",url2));
        jcAudios.add(JcAudio.createFromURL("Genda Phool",url3));
        jcAudios.add(JcAudio.createFromURL("Kar Gayi Chull",url4));
        jcAudios.add(JcAudio.createFromURL("Loveratri",url5));
        jcAudios.add(JcAudio.createFromURL("Mercy",url6));
        jcAudios.add(JcAudio.createFromURL("Proper Patola",url7));
        jcAudios.add(JcAudio.createFromURL("Paagal",url8));
        jcAudios.add(JcAudio.createFromURL("Sawan Mein Lag Gayi Aag",url9));
        jcAudios.add(JcAudio.createFromURL("She Move It Like",url10));
        jcAudios.add(JcAudio.createFromURL("Wakhra Swag",url11));


        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(badshah.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(badshah.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Badshah/Buzz - Badshah.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(badshah.this,"Badshah/Buzz - Badshah",".mp3",DIRECTORY_DOWNLOADS,url);
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