package mn.moco.music.gogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import butterknife.Bind;
import butterknife.ButterKnife;
import mn.moco.music.gogo.Adapters.MultipleViewAdapter;
import mn.moco.music.gogo.Models.ModelRadioCategory;
import mn.moco.music.gogo.Utils.Utils;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    @Bind(R.id.header)
    RecyclerViewHeader header;

    private Utils utils;
    private int itemSize = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        utils = new Utils(this);

        int sizeOfHeader = utils.getDisplayPoints().x;
        header.setLayoutParams(new FrameLayout.LayoutParams(sizeOfHeader, sizeOfHeader));

        MultipleViewAdapter adapter = new MultipleViewAdapter(this, utils);

        for (int i = 0; i < itemSize; i++) {
            ModelRadioCategory item = new ModelRadioCategory();
            item.setCategoryId(i);
            item.setTitle("Title ->" + (i + 1));
            adapter.setData(item);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        header.attachTo(recyclerView, true);
    }
}
