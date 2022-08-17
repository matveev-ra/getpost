package ru.homework.getpost;

import okhttp3.OkHttpClient;
import okhttp3.Request;

class HttpUtil {
    // Создание общедоступных классов и общедоступных статических методов, которые можно вызывать напрямую, когда это необходимо, для увеличения повторного использования кода

    /**
     *
     * @param  адрес URL-адрес, который нужно посетить
     * @param  обратный вызов Добавить метод обратного вызова
     */
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        // Ниже приведены шаги по использованию OkHttp
        // Сначала создаем объект OkHttpClient
        OkHttpClient client = new OkHttpClient();
        // Связывание URL путем создания объекта запроса
        Request request = new Request.Builder().url(address).build();
        // Добавляем метод обратного вызова, чтобы использование OkHttp было полным,
        // вам нужно вызывать этот метод только тогда, когда вам нужно получить доступ к сети

        client.newCall(request).enqueue(callback);

    }
}
