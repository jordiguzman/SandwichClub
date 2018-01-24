package appkite.jordiguzman.com.sandwichclub.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import appkite.jordiguzman.com.sandwichclub.R;

/**
 * Created by Jordi Guzmán on 24/01/2018.
 */

public class AdapterListMainActivity extends BaseAdapter {

    private Context context;
    public static String[] sandwiches= {"Ham and cheese sandwich", "Bosna", "Chivito", "Club sandwich", "Gua bao"
            , "Medianoche", "Pljeskavica", "Roujiamo", "Shawarma", "Vada Pav"};
    private static ArrayList<String> strings= new ArrayList<>(Arrays.asList(sandwiches));

    public AdapterListMainActivity(Context context, ArrayList<String> items){
        this.context= context;
        strings= items;
    }

    @Override
    public int getCount() {
        return strings.size();

    }

    @Override
    public Object getItem(int i) {
        return strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView==null){
            LayoutInflater inflater= (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_items_list_main, null);

            TextView tv_items= convertView.findViewById(R.id.item_list);
            String text= strings.get(position);
            tv_items.setText(text);


        }
        return convertView;
    }
}
