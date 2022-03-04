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

public class divine extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divine);
        Objects.requireNonNull(getSupportActionBar()).hide();

        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2F01%20-%20Gully%20Boy%20(2019)%20-%20Apna%20Time%20Aayega.mp3?alt=media&token=41ba5f09-80ed-4ea4-befa-96507b958756",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2F16%20-%20Gully%20Boy%20(2019)%20-%20Mere%20Gully%20Mein.mp3?alt=media&token=863fd06a-f2c4-4c0d-8a1b-c7c7430fb4d6",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2F3%2059%20AM%20-%20Divine.mp3?alt=media&token=d062802c-2c38-450c-b36c-e3819d94f5e8",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FBombay%20to%20Punjab%20-%20Deep%20Jandu.mp3?alt=media&token=1dc8eb36-82db-4ff8-b75d-8ac9bd76a698",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FDivine%20Chal%20Bombay%20(Club%20Remix)%20-%20Dj%20Royden%20Dubai(PagalWorld).mp3?alt=media&token=0a6019bb-9671-4581-8f8a-33d56e1bc1b2",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FKaam%2025%20-%20Divine.mp3?alt=media&token=122e4fdd-8955-4839-9d89-489da149eb81",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FMera%20Bhai%20-%20Divine.mp3?alt=media&token=aac5557b-a1b8-407f-ba96-137dd1ebfc0c",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FMirchi%20-%20DIVINE.mp3?alt=media&token=fbe09b0a-a25f-431e-bafb-1a2000141596",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FNo%20Competition%20-%20Jass%20Manak.mp3?alt=media&token=53a733e6-b862-4ff9-bceb-9a216e78c3dd",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Divine%2FSatya%20-%20Divine.mp3?alt=media&token=e19d2f45-db69-4d86-9d18-9864f9d1cc74";

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Apna time Ayega",url));
        jcAudios.add(JcAudio.createFromURL("Mere Gully mein",url1));
        jcAudios.add(JcAudio.createFromURL("3 59 AM",url2));
        jcAudios.add(JcAudio.createFromURL("Bombay To Punjab",url3));
        jcAudios.add(JcAudio.createFromURL("Chal Bombay",url4));
        jcAudios.add(JcAudio.createFromURL("Kaam 25",url5));
        jcAudios.add(JcAudio.createFromURL("Mera Bhai",url6));
        jcAudios.add(JcAudio.createFromURL("Mirchi",url7));
        jcAudios.add(JcAudio.createFromURL("No Competition",url8));
        jcAudios.add(JcAudio.createFromURL("Satya",url9));


        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(divine.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(divine.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Divine/01 - Gully Boy (2019) - Apna Time Aayega.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(divine.this,"Divine/01 - Gully Boy (2019) - Apna Time Aayega",".mp3",DIRECTORY_DOWNLOADS,url);
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