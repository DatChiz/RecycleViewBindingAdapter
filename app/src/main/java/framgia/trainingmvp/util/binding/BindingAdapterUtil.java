package framgia.trainingmvp.util.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by MyPC on 25/04/2017.
 */

public class BindingAdapterUtil {
    @BindingAdapter("bind:adapter")
    public static void setRecyclerAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("bind:layoutManager")
    public static void setRecyclerLayoutManager(RecyclerView recyclerView,
            RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }
}
