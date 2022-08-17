package ru.homework.getpost;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.BreakIterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {


    Button nextDogButton;
    private TextView textViewResult;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new FilesUploadingTask("../drawable/test_image_foto.png").execute();


        imageView = findViewById(R.id.dogImageView);
        nextDogButton = findViewById(R.id.nextDogButton);
        textViewResult = findViewById(R.id.id_textview);

        //String url = "https://gc-euro.ru/anonim/getresult?id=1&name=test";
        String urlFile = "https://gc-euro.ru/anonim/sendfile";

        // создаем объект OkHttpClient
        OkHttpClient client = new OkHttpClient();

//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);

        File file = new File("drawable/test_image_foto.png");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_image_foto);

       // присваиваем ImageView для проверки вывода картинки на экран
        imageView.setImageBitmap(bitmap);
        //Log.d("MyLog", bitmap.toString());

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),RequestBody.create(MediaType.parse("image/png"), file))
                .addFormDataPart("some-field", "some-value")
                .build();


        Request request = new Request.Builder()
                .url(urlFile)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                // Не удалось позвонить
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                // Успешный вызов
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

//                    Gson gson = new Gson();
//                    UserSimple userObject = gson.fromJson(myResponse, UserSimple.class);
                    textViewResult.setText(myResponse);
                }
            }
        });

    }



// **********  простой GET - запрос *************

//        // Запрос на создание
//        Request request = new Request.Builder()
//                .url(url)
//                .build();

//        // выполнение вызова запроса
//        // Асинхронный запрос - call.enqueue
//        client.newCall(request).enqueue(new Callback() {

//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                // Не удалось позвонить
//                e.printStackTrace();
//            }

//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                // Успешный вызов
//                if (response.isSuccessful()) {
//                    final String myResponse = response.body().string();
//
//                    Gson gson = new Gson();
//                    UserSimple userObject = gson.fromJson(myResponse, UserSimple.class);
//                    textViewResult.setText(userObject.name);
//                }
//            }
//        });

//    }
//
//    public class UserSimple {
//        String id;
//        String name;
//
//    }

    }
