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

public class arijit extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arijit);
        Objects.requireNonNull(getSupportActionBar()).hide();

        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F01%20-%20Ghungroo%20-%20War%20(2019).mp3?alt=media&token=6586f50b-3b80-4e4c-83c7-de7987f81527",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F01%20-%20Shayad%20-%20Love%20Aaj%20Kal%20(2020).mp3?alt=media&token=d192433f-0c6e-4a98-a932-c8db34730bdb",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F02%20-%20Haan%20Main%20Galat%20-%20Love%20Aaj%20Kal%20(2020).mp3?alt=media&token=f5ed5c92-7094-4c99-847b-711febd6d8ca",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F02%20-%20Pal%20Pal%20Dil%20Ke%20Paas%20(Title)%20-%20PPDKP%20(2019).mp3?alt=media&token=a6cf0891-4dc5-480c-b854-2d8ab970321d",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F02%20-%20Tujhe%20Kitna%20Chahne%20Lage%20-%20Kabir%20Singh%20(2019).mp3?alt=media&token=744e1816-b2ed-4a96-a1fc-b78729f10fe9",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F03%20-%20Thodi%20Jagah%20-%20Marjaavaan%20(2019).mp3?alt=media&token=33e0692f-44b2-4305-a9c8-28ef1ff1a37d",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F06%20-%20Khairiyat%20(Happy)%20-%20Chhichhore%20(2019).mp3?alt=media&token=1ddcc45c-4907-4911-9c28-b221adc518cc",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2F07%20-%20Ve%20Maahi%20-%20PagalSongs.com.mp3?alt=media&token=edd9488b-5247-451f-8779-bbc986a86497",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FABCD%202%20-%20Chunar.mp3?alt=media&token=58fff34a-411d-4b26-83ce-572cfd06c66c",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FEV%20-%20Hamdard.mp3?alt=media&token=f6e55057-fd93-45ae-8af4-720590a0a681",
                url10="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FHAK%20-%20Hamari%20Adhuri%20Kahani.mp3?alt=media&token=2d1d2d59-4647-489a-82f0-fe976f076b97",
                url11="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FHG%202017%20-%20Phir%20Bhi%20Tumko%20Chaahunga.mp3?alt=media&token=490eeb5c-41f8-4565-9762-8e55b936e0b3",
                url12="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FPachtaoge%20-%20Arijit%20Singh.mp3?alt=media&token=ec8b944e-47f0-40e2-be5d-c8e52d9a5957",
                url13="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FSKTKS%20-%20Tera%20Yaar%20Hoon%20Main.mp3?alt=media&token=540b0e2f-2a16-42f0-8789-fb82c949d4d6",
                url14="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Arijit%2FSR%202016%20-%20Sanam%20Re.mp3?alt=media&token=7effb47a-bb4e-4d43-abae-380ef574f7a2";

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Ghungroo",url));
        jcAudios.add(JcAudio.createFromURL("Shayad",url1));
        jcAudios.add(JcAudio.createFromURL("Haan Main Galat",url2));
        jcAudios.add(JcAudio.createFromURL("Pal Pal Dil Ke Paas",url3));
        jcAudios.add(JcAudio.createFromURL("Tujhe Kitna Chahne Lage",url4));
        jcAudios.add(JcAudio.createFromURL("Thodi Jagah",url5));
        jcAudios.add(JcAudio.createFromURL("Khairiyat",url6));
        jcAudios.add(JcAudio.createFromURL("Ve Maahi",url7));
        jcAudios.add(JcAudio.createFromURL("Chunar",url8));
        jcAudios.add(JcAudio.createFromURL("Hamdard",url9));
        jcAudios.add(JcAudio.createFromURL("Hamari Adhuri Kahani",url10));
        jcAudios.add(JcAudio.createFromURL("Phir Bhi Tumko Chaahunga",url11));
        jcAudios.add(JcAudio.createFromURL("Pachtaoge",url12));
        jcAudios.add(JcAudio.createFromURL("Tera Yaar Hoon Main",url13));
        jcAudios.add(JcAudio.createFromURL("Sanam Re",url14));



        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(arijit.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(arijit.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Arijit/01 - Ghungroo - War (2019).mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(arijit.this,"Arijit/01 - Ghungroo - War (2019)",".mp3",DIRECTORY_DOWNLOADS,url);
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