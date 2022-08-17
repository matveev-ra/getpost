package ru.homework.getpost;

import com.google.gson.annotations.SerializedName;

public class Province {
    // Из содержимого предыдущего URL-адреса мы видим,
    // что другими ключами данных json являются id и name, но значение этих двух ключей слишком широкое.
    // Здесь я назвал их ProvinceId и ProvinceName, которые отображаются через SerializedName
    // Это можно использовать для преобразования данных json в объекты провинции

    @SerializedName("id")
    public String provinceId;

    @SerializedName("name")
    public String provinceName;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}