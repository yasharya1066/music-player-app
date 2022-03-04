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

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class latestsongs extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latestsongs);
        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="";

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("",url));


        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(latestsongs.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(latestsongs.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Neha kakkar/Hauli Hauli - De De Pyaar De 128 Kbps.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(latestsongs.this,"Neha kakkar/Hauli Hauli - De De Pyaar De 128 Kbps.mp3",".mp3",DIRECTORY_DOWNLOADS,url);
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