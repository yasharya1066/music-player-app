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

public class sidhu_moose extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidhu_moose);
        Objects.requireNonNull(getSupportActionBar()).hide();
        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2F295%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=cf604b79-33ba-489e-a975-d259ef0d63ee",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FBambiha%20Bole%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=56a5ba19-1124-45b6-96f2-37d8c197636a",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FBurberry.mp3?alt=media&token=7cc41043-e1c4-4da8-8307-0a081685aa46",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FCalaboose%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=e02512cf-b6cc-407a-acc1-3736838fe278",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FDark%20Love%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=a57fe326-7235-46e0-adbe-9a7e9139b85e",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FDollar%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=f5a27593-6d9e-4c2c-84af-75f7328b72c9",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FFamous%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=574b2256-0acf-4003-b209-ef3d7ec69896",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FGame%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=ad5ca085-1c25-476f-88c6-929d6e081b88",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FJust%20Listen%20-%20Sidhu%20Moose%20Wala%20190Kbps.mp3?alt=media&token=06594b22-b2b9-4a0b-b947-a7ac43280a74",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FOutlaw%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=aaca7eac-3cb6-48ae-8f1d-bfcf2a11e932",
                url10="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FSame%20Beef%20-%20Bohemia.mp3?alt=media&token=1c589b3e-a8d7-4bc1-8efb-fe8d855f6299",
                url11="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FSo%20High%20-%20Sidhu%20Moose%20Wala%20190Kbps.mp3?alt=media&token=67d4f225-9db1-4b0b-b21e-681c12a6db38",
                url12="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Sidhu%20moose%2FTochan%20-%20Sidhu%20Moose%20Wala.mp3?alt=media&token=902b2c4a-142d-41e6-9678-47ec27675b51";



        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("295",url));
        jcAudios.add(JcAudio.createFromURL("Bambiha Bole",url1));
        jcAudios.add(JcAudio.createFromURL("Burberry",url2));
        jcAudios.add(JcAudio.createFromURL("Calaboose",url3));
        jcAudios.add(JcAudio.createFromURL("Dark Love",url4));
        jcAudios.add(JcAudio.createFromURL("Dollar",url5));
        jcAudios.add(JcAudio.createFromURL("Famous",url6));
        jcAudios.add(JcAudio.createFromURL("Game",url7));
        jcAudios.add(JcAudio.createFromURL("Just Listen",url8));
        jcAudios.add(JcAudio.createFromURL("Outlaw",url9));
        jcAudios.add(JcAudio.createFromURL("Same Beef",url10));
        jcAudios.add(JcAudio.createFromURL("So High",url11));
        jcAudios.add(JcAudio.createFromURL("Tochan",url12));



        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(sidhu_moose.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(sidhu_moose.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Sidhu moose/295 - Sidhu Moose Wala.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                
                String url =uri.toString();
                downloadfiles(sidhu_moose.this,"Sidhu moose/295 - Sidhu Moose Wala",".mp3",DIRECTORY_DOWNLOADS,url);
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