package mn.saina.test;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MultipleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<ModelBundle> bundleList = new ArrayList<>();

    private static final int TYPE_3 = 3;
    private static final int TYPE_6 = 0;
    private static final int TYPE_6_2 = 1;
    private static final int TYPE_LEFT = 4;
    private static final int TYPE_RIGHT = 2;

    private static final int TYPE_FOOTER_3 = 10;
    private static final int TYPE_FOOTER_LEFT = 11;
    private static final int TYPE_FOOTER_RIGHT = 14;

    private Context context;
    private Point point;
    private ModelBundle bundle;
    private boolean isNewBundleCreated = true;

    public MultipleViewAdapter(Context context) {
        this.context = context;
        this.point = getDisplayPoints();
        bundle = new ModelBundle();
    }

    public Point getDisplayPoints() {
        Display display = ((AppCompatActivity)context).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    public void setData(ModelRadioCategory item) {
        switch (bundle.getSize()) {
            case 0: {
                bundle.setItem1(item);
                break;
            }
            case 1: {
                bundle.setItem2(item);
                break;
            }
            case 2: {
                bundle.setItem3(item);
                break;
            }
            case 3: {
                bundle = new ModelBundle();
                bundle.setItem1(item);
                isNewBundleCreated = true;
                break;
            }
        }

        if (isNewBundleCreated) {
            bundleList.add(bundle);
            isNewBundleCreated = false;
        } else {
            bundleList.set(bundleList.size() - 1, bundle);
        }
    }

    class ViewHolderParentOfFooter extends RecyclerView.ViewHolder {
        private FrameLayout item1;
        private FrameLayout item2;
        private FrameLayout item3;

        public ViewHolderParentOfFooter(View itemView) {
            super(itemView);
        }

        public void setItem1(FrameLayout item1) {
            this.item1 = item1;
        }

        public void setItem2(FrameLayout item2) {
            this.item2 = item2;
        }

        public void setItem3(FrameLayout item3) {
            this.item3 = item3;
        }

        public void setData(final ModelBundle modelBundle) {
            if (modelBundle.getItem1() != null) {
                item1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem1().getTitle());
                    }
                });
            } else {
                item1.setVisibility(View.GONE);
            }

            if (modelBundle.getItem2() != null) {
                item2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem2().getTitle());
                    }
                });
            } else {
                item2.setVisibility(View.GONE);
            }

            if (modelBundle.getItem3() != null) {
                item3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem3().getTitle());
                    }
                });
            } else {
                item3.setVisibility(View.GONE);
            }
        }
    }

    class ViewHolderFooter3 extends ViewHolderParentOfFooter {
        @Bind(R.id.frame_3_1)
        FrameLayout item1;
        @Bind(R.id.frame_3_2)
        FrameLayout item2;
        @Bind(R.id.frame_3_3)
        FrameLayout item3;

        public ViewHolderFooter3(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    class ViewHolderFooterRight extends ViewHolderParentOfFooter {
        @Bind(R.id.frame_right_1)
        FrameLayout item1;
        @Bind(R.id.frame_right_2)
        FrameLayout item2;
        @Bind(R.id.frame_right_3)
        FrameLayout item3;

        public ViewHolderFooterRight(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3 * 2, point.x / 3 * 2));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    class ViewHolderFooterLeft extends ViewHolderParentOfFooter {
        @Bind(R.id.frame_left_1)
        FrameLayout item1;
        @Bind(R.id.frame_left_2)
        FrameLayout item2;
        @Bind(R.id.frame_left_3)
        FrameLayout item3;

        public ViewHolderFooterLeft(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3 * 2, point.x / 3 * 2));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    class ViewHolderParentOfItems extends RecyclerView.ViewHolder {
        private FrameLayout item1;
        private FrameLayout item2;
        private FrameLayout item3;

        public ViewHolderParentOfItems(View itemView) {
            super(itemView);
        }

        public void setItem1(FrameLayout item1) {
            this.item1 = item1;
        }

        public void setItem2(FrameLayout item2) {
            this.item2 = item2;
        }

        public void setItem3(FrameLayout item3) {
            this.item3 = item3;
        }

        public void setData(final ModelBundle modelBundle) {
            if (modelBundle.getItem1() != null) {
                item1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem1().getTitle());
                    }
                });
            } else {
                item1.setVisibility(View.GONE);
            }

            if (modelBundle.getItem2() != null) {
                item2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem2().getTitle());
                    }
                });
            } else {
                item2.setVisibility(View.GONE);
            }

            if (modelBundle.getItem3() != null) {
                item3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Clicked -->", modelBundle.getItem3().getTitle());
                    }
                });
            } else {
                item3.setVisibility(View.GONE);
            }
        }
    }

    class ViewHolder3 extends ViewHolderParentOfItems {
        @Bind(R.id.frame_3_1)
        FrameLayout item1;
        @Bind(R.id.frame_3_2)
        FrameLayout item2;
        @Bind(R.id.frame_3_3)
        FrameLayout item3;

        public ViewHolder3(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    class ViewHolderRight extends ViewHolderParentOfItems {
        @Bind(R.id.frame_right_1)
        FrameLayout item1;
        @Bind(R.id.frame_right_2)
        FrameLayout item2;
        @Bind(R.id.frame_right_3)
        FrameLayout item3;

        public ViewHolderRight(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3 * 2, point.x / 3 * 2));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    class ViewHolderLeft extends ViewHolderParentOfItems {
        @Bind(R.id.frame_left_1)
        FrameLayout item1;
        @Bind(R.id.frame_left_2)
        FrameLayout item2;
        @Bind(R.id.frame_left_3)
        FrameLayout item3;

        public ViewHolderLeft(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            item1.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3 * 2, point.x / 3 * 2));
            item2.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));
            item3.setLayoutParams(new LinearLayout.LayoutParams(point.x / 3, point.x / 3));

            setItem1(item1);
            setItem2(item2);
            setItem3(item3);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case TYPE_3: {
                return new ViewHolder3(inflater.inflate(R.layout.item_homerecycler_3, null));
            }
            case TYPE_LEFT: {
                return new ViewHolderLeft(inflater.inflate(R.layout.item_homerecycler_left, null));
            }
            case TYPE_RIGHT: {
                return new ViewHolderRight(inflater.inflate(R.layout.item_homerecycler_right, null));
            }
            case TYPE_FOOTER_3: {
                return new ViewHolderFooter3(inflater.inflate(R.layout.item_homerecycler_3, null));
            }
            case TYPE_FOOTER_LEFT: {
                return new ViewHolderFooterLeft(inflater.inflate(R.layout.item_homerecycler_left, null));
            }
            case TYPE_FOOTER_RIGHT: {
                return new ViewHolderFooterRight(inflater.inflate(R.layout.item_homerecycler_right, null));
            }
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_3: {
                ((ViewHolder3) holder).setData(bundleList.get(position));
                break;
            }
            case TYPE_LEFT: {
                ((ViewHolderLeft) holder).setData(bundleList.get(position));
                break;
            }
            case TYPE_RIGHT: {
                ((ViewHolderRight) holder).setData(bundleList.get(position));
                break;
            }
            case TYPE_FOOTER_3: {
                ((ViewHolderFooter3) holder).setData(bundleList.get(position));
                break;
            }
            case TYPE_FOOTER_LEFT: {
                ((ViewHolderFooterLeft) holder).setData(bundleList.get(position));
                break;
            }
            case TYPE_FOOTER_RIGHT: {
                ((ViewHolderFooterRight) holder).setData(bundleList.get(position));
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return bundleList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            switch (position % 5) {
                case TYPE_3:
                    return TYPE_FOOTER_3;
                case TYPE_6:
                    return TYPE_FOOTER_3;
                case TYPE_6_2:
                    return TYPE_FOOTER_3;
                case TYPE_LEFT:
                    return TYPE_FOOTER_LEFT;
                case TYPE_RIGHT:
                    return TYPE_FOOTER_RIGHT;
                default:
                    return TYPE_FOOTER_3;
            }
        } else {
            switch (position % 5) {
                case TYPE_3:
                    return TYPE_3;
                case TYPE_6:
                    return TYPE_3;
                case TYPE_6_2:
                    return TYPE_3;
                case TYPE_LEFT:
                    return TYPE_LEFT;
                case TYPE_RIGHT:
                    return TYPE_RIGHT;
                default:
                    return TYPE_3;
            }
        }
    }
}