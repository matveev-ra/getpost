//package ru.homework.getpost;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.bumptech.glide.Glide;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class MainActivity extends AppCompatActivity {
//
//    // переменная-член для хранения ImageView
//    // в который будут загружаться изображения
//
//    ImageView mDogImageView;
//    Button nextDogButton;
//    TextView textView  ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // инициализируем ImageView и кнопку
//        mDogImageView = findViewById(R.id.dogImageView);
//        nextDogButton = findViewById(R.id.nextDogButton);
//        textView = findViewById(R.id.texttop);
//
//        // прикрепление слушателя клика к кнопке, чтобы функция `loadDogImage()`
//        // вызывалась каждый раз после нажатия на кнопку.
//        nextDogButton.setOnClickListener(View -> loadDogImage());
//
//        // изображение собаки будет загружено один раз при запуске приложения
//        loadDogImage();
//
//    }
//
//    // функция для выполнения HTTP-запроса с помощью Volley и
//    // вставки изображения в ImageView с помощью библиотеки Glide
//
//    private void loadDogImage() {
//        // получение новой очереди запросов на залп для выполнения новых запросов
//        RequestQueue volleyQueue = Volley.newRequestQueue(MainActivity.this);
//
//        // url api, через который мы получаем случайные изображения собак
//        String url = "https://dog.ceo/api/breeds/image/random";
//        String url2 = "https://gc-euro.ru/anonim/getresult?id=1&name=ivan";

//        // поскольку ответ, который мы получаем от api, находится в JSON, нам
//        // необходимо использовать `JsonObjectRequest` для разбора ответа на запрос

////        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                // мы используем метод запроса GET HTTP
//                Request.Method.GET,
//
//                // url, на который мы хотим отправить HTTP-запрос
//                url2,
//
//                // этот параметр используется для отправки объекта JSON на
//                // серверу, так как в нашем случае это не требуется,
//                // мы сохраняем его как `null`.
//
//                null,
//
//                // лямбда-функция для обработки случая
//                // когда HTTP запрос успешен

//                (Response.Listener<JSONObject>) response -> {
//
//                    // получаем url изображения из объекта JSON
//                    String dogImageUrl;
//
//                    try {
//                        dogImageUrl = response.getString("name");
//
//                        // загрузите изображение в ImageView, используя Glide.
//                        //Glide.with(MainActivity.this).load(dogImageUrl).into(mDogImageView);

//                        textView.setText(dogImageUrl);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//
//
//                // лямбда-функция для обработки случая
//                // когда HTTP-запрос не удался
//
//                (Response.ErrorListener) error -> {
//                    // произнести тост, сообщающий пользователю.
//                    // что что-то пошло не так
//                    Toast.makeText(MainActivity.this, "Some error occurred! Cannot fetch dog image", Toast.LENGTH_LONG).show();
//                    //  регистрируем сообщение об ошибке в потоке ошибок
//                    Log.e("MainActivity", "loadDogImage error: ${error.localizedMessage}");
//                }
//        );
//
//
//        // добавьте созданный выше объект запроса json
//        // в очередь запросов Volley
//        volleyQueue.add(jsonObjectRequest);
//
//    }
//}