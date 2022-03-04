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
import android.widget.Toolbar;

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

public class neha_kakkar extends AppCompatActivity {

    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neha_kakkar);
        Objects.requireNonNull(getSupportActionBar()).hide();

        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FMain%20Tera%20Boyfriend%20-%20Raabta%20128%20Kbps.mp3?alt=media&token=f15bb8da-d901-4a79-96f7-4d3ed2a21edc",
        url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2F128-Tu%20Hi%20Yaar%20Mera%20-%20Pati%20Patni%20Aur%20Woh%20128%20Kbps.mp3?alt=media&token=24d8fed3-554e-410f-9ba9-acb675a4d75e",
        url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FDheeme%20Dheeme%20-%20Pati%20Patni%20Aur%20Woh%20128%20Kbps.mp3?alt=media&token=8ebc9cfa-a5cd-4f22-9aae-65616c8712e1",
        url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FDil%20Ko%20Karaar%20Aaya%20-%20Neha%20Kakkar.mp3?alt=media&token=9baeee61-e7be-4ed2-a349-f11d8106c205",
        url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FGarmi%20feat.%20Varun%20Dhawan%20-%20Street%20Dancer%203D%20128%20Kbps.mp3?alt=media&token=157e638d-9333-4ae1-b94d-8a5da3a446b3",
        url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FKala%20Chashma%20-%20Baar%20Baar%20Dekho%20128%20Kbps.mp3?alt=media&token=6edc5aa8-8189-4f00-bcf9-8c0dc4f32d18",
        url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FMile%20Ho%20Tum%20(Reprise)%20-%20Fever%20128%20Kbps.mp3?alt=media&token=8fd2131a-dd29-48d1-b0dd-38900fec903f",
        url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FO%20Saki%20Saki%20-%20Batla%20House%20128%20Kbps.mp3?alt=media&token=0f8b9ff4-bb8f-4c75-8320-96d16c8e8811",
        url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FTaaron%20Ke%20Shehar%20-%20Neha%20Kakkar%20128%20Kbps.mp3?alt=media&token=e8b6dbe6-c184-4965-8984-ca1b23d0f606",
        url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FTeri%20Aankhon%20Mein%20-%20Neha%20Kakkar%20128%20Kbps.mp3?alt=media&token=5968ef11-59e5-425e-bf72-271fc2cea96d",
        url10="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FYaad%20Piya%20Ki%20Aane%20Lagi%20-%20Neha%20Kakkar%2C%20Tanishk%20Bagchi%20128%20Kbps.mp3?alt=media&token=5c0d7854-c9a5-4284-ba44-ba4cbfb37f3f",
        url11="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Neha%20kakkar%2FHauli%20Hauli%20-%20De%20De%20Pyaar%20De%20128%20Kbps.mp3?alt=media&token=46ea6943-6337-4d91-b237-25e5cfab75db";


        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Main Tera Boyfriend",url));
        jcAudios.add(JcAudio.createFromURL("Tu Hi Yaar Mera",url1));
        jcAudios.add(JcAudio.createFromURL("Dheeme Dheeme",url2));
        jcAudios.add(JcAudio.createFromURL("Dil Ko Karaar Aaya",url3));
        jcAudios.add(JcAudio.createFromURL("Garmi",url4));
        jcAudios.add(JcAudio.createFromURL("Kala Chashma",url5));
        jcAudios.add(JcAudio.createFromURL("Mile Ho Tum",url6));
        jcAudios.add(JcAudio.createFromURL("O Saki Saki",url7));
        jcAudios.add(JcAudio.createFromURL("Taaron Ke Shehar",url8));
        jcAudios.add(JcAudio.createFromURL("Teri Aankhon Mein",url9));
        jcAudios.add(JcAudio.createFromURL("Yaad Piya Ki Aane Lagi",url10));
        jcAudios.add(JcAudio.createFromURL("Hauli Hauli",url11));

        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();
        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(neha_kakkar.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(neha_kakkar.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Neha kakkar/Main Tera Boyfriend - Raabta 128 Kbps.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(neha_kakkar.this,"Neha kakkar/Hauli Hauli - De De Pyaar De 128 Kbps.mp3",".mp3",DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {

            }
        });
    }
    public void downloadfiles(Context context, String fileName,String fileExtenstion, String destinationDirectory, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri1 = Uri.parse(url);
        DownloadManager.Request request= new DownloadManager.Request(uri1);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName+fileExtenstion);
        downloadManager.enqueue(request);
    }
}