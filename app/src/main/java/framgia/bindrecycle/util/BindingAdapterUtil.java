package framgia.bindrecycle.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import framgia.bindrecycle.model.RecyclerConfiguration;

/**
 * Created by MyPC on 21/04/2017.
 */

public class BindingAdapterUtil {
    @BindingAdapter("android:textColor")
    public static void setColorResource(TextView textView, int resource){
        textView.setTextColor(resource);
    }

    @BindingAdapter("app:configuration")
    public static void configureRecyclerView(RecyclerView recyclerView, RecyclerConfiguration configuration){
        recyclerView.setLayoutManager(configuration.getLayoutManager());
        recyclerView.setAdapter(configuration.getAdapter());
    }
}
