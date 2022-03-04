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

public class oldsongs extends AppCompatActivity {
    Button menu_icon;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldsongs);
        Objects.requireNonNull(getSupportActionBar()).hide();
        JcPlayerView jcplayerView = findViewById(R.id.jcplayer);
        String url="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F01.%20Maye%20Ni%20Maye.mp3?alt=media&token=76caebfc-4680-4bb0-b9e1-aa6717111d47",
                url1="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F01.%20Mere%20Mehboob%20Qayamat%20Hogi-I.mp3?alt=media&token=85b5d27e-b480-4b98-bfc8-9a665373c9cd",
                url2="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F02.%20Mera%20Joota%20Hai%20Japani.mp3?alt=media&token=1b8af43d-b3f7-4156-bcc1-a5fca61db300",
                url3="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F03.%20Kisiki%20Muskurahaton%20Pe%20Ho%20Nisaar.mp3?alt=media&token=449ac5f9-997f-49ac-abb2-2cc3e79a5bb1",
                url4="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F03.%20Lag%20Ja%20Gale%20Se.mp3?alt=media&token=dae58e96-90f0-40ee-8924-9e3a654546d5",
                url5="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F05.%20Pyaar%20Deewana%20Hota%20Hai.mp3?alt=media&token=dfac41db-1368-4330-b7c3-b5243c4a83c6",
                url6="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FBambai%20Se%20Aaya%20Mera%20Dost.mp3?alt=media&token=6e32e9e1-a587-44de-8fa4-09e43dfbb0e7",
                url7="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FChura%20Liya%20Hai%20Tumne%20Jo%20Dil%20Ko%20-%20(amlijatt.in).mp3?alt=media&token=4df1f3f1-d5d8-424f-b19f-9c06ae188bc1",
                url8="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FKK%201976%20-%20Tere%20Chehre%20Se%20Nazar.mp3?alt=media&token=6671bd5c-22d8-43fa-9a16-b00ab5f60e6b",
                url9="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FMJS-O%20Mere%20Dil%20Chain.mp3?alt=media&token=8baa779c-e245-466b-aa92-8e54fc9254c4",
                url10="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FMKM-Jane%20Kyon%20Log%20Mohabbat.mp3?alt=media&token=23e41032-5f36-418a-8897-593234adb898",
                url11="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FMKS%201978%20-%20O%20Saathi%20Re%20Tere%20Bina.mp3?alt=media&token=ee2c55c1-3590-44f6-b708-0397ada6a7c2",
                url12="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FPal%20Bhar%20Ke%20Liye%20-%20Johny%20Mera%20Naam.mp3?alt=media&token=b1e76cec-986f-4f9a-b8d6-c278a9f1c9fb",
                url13="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2FPal%20Pal%20Dil%20Ke%20Paas%20-%20Kishore%20Kumar%20190Kbps%20(Original).mp3?alt=media&token=3585350f-0019-4bc3-ae87-10c603705f4c",
                url14="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2F_Kya%20Khoob%20Lagti%20Ho(PagalWorld.com).mp3?alt=media&token=5d70f22a-0828-407f-ab05-6b46e3601291",
                url15="https://firebasestorage.googleapis.com/v0/b/mirchi-a8682.appspot.com/o/Old%20songs%2Fek_ajnabee_haseena_se.mp3?alt=media&token=ebb2c4a0-e5c9-4b62-acf5-c72d09ed324d";

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Maye Ni Maye",url));
        jcAudios.add(JcAudio.createFromURL("Mere Mehboob Qayament",url1));
        jcAudios.add(JcAudio.createFromURL("Mera Joot Hai Japani",url2));
        jcAudios.add(JcAudio.createFromURL("Kisiki Muskurahaton Pe",url3));
        jcAudios.add(JcAudio.createFromURL("Lag Ja Gale Se",url4));
        jcAudios.add(JcAudio.createFromURL("Pyar Deewana Hota Hai",url5));
        jcAudios.add(JcAudio.createFromURL("Bambai Se Aaya Mera",url6));
        jcAudios.add(JcAudio.createFromURL("Chura Liya Hai Tumne Jo Dil Ko",url7));
        jcAudios.add(JcAudio.createFromURL("Tere Chehre Se Nazar",url8));
        jcAudios.add(JcAudio.createFromURL("Mere Dil Chain",url9));
        jcAudios.add(JcAudio.createFromURL("Jane Kyon Log Mohabbat",url10));
        jcAudios.add(JcAudio.createFromURL("O Saathi Re Tere Bina",url11));
        jcAudios.add(JcAudio.createFromURL("Pal Bhar Ke Liye",url12));
        jcAudios.add(JcAudio.createFromURL("Kya Khoob Lagti Ho",url14));
        jcAudios.add(JcAudio.createFromURL("ek ajnabee haseena se",url15));
        jcAudios.add(JcAudio.createFromURL("Pal Pal Dil Ke Paas",url13));


        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();

        menu_icon=findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(oldsongs.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(oldsongs.this, "Downloading", Toast.LENGTH_SHORT).show();
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
        ref=storageReference.child("Old songs/01. Maye Ni Maye.mp3");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url =uri.toString();
                downloadfiles(oldsongs.this,"Old songs/01. Maye Ni Maye",".mp3",DIRECTORY_DOWNLOADS,url);
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