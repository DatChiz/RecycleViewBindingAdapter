package framgia.bindrecycle.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.widget.ImageView;
import android.widget.TextView;

import framgia.bindrecycle.BR;

/**
 * Created by MyPC on 21/04/2017.
 */

public class User extends BaseObservable {

    private String name;
    private int age;

    @ColorRes
    private int resId;

    public User(String name, int age, int resId) {
        this.name = name;
        this.age = age;
        this.resId = resId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }


    public void setResId(int resId) {
        this.resId = resId;
        notifyPropertyChanged(BR.resId);
    }

    @Bindable
    public int getResId() {
        return resId;
    }
}
