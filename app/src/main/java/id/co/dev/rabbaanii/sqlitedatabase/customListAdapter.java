package id.co.dev.rabbaanii.sqlitedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moeslim on 16/10/17.
 */

public class customListAdapter extends BaseAdapter{

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<modalMahasiswa> itemListMahasiswa;

    public customListAdapter(Activity activity, List<modalMahasiswa> itemListMahasiswa){
        this.activity = activity;
        this.itemListMahasiswa = itemListMahasiswa;
    }

    @Override
    public int getCount() {
        return itemListMahasiswa.size();
    }

    @Override
    public Object getItem(int location) {
        return itemListMahasiswa.get(location);
    }

    @Override
    public long getItemId(int posisi) {
        return posisi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.custom_list, null);

        TextView namaSiswa = (TextView)convertView.findViewById(R.id.txtTitles);
        TextView namaKelas = (TextView)convertView.findViewById(R.id.txtSubtitles);
        ImageView resImage = (ImageView)convertView.findViewById(R.id.imgPictures);

        modalMahasiswa ambilData = itemListMahasiswa.get(position);

        namaSiswa.setText("" + ambilData.getNama());
        namaKelas.setText("" + ambilData.getKelas());
        return convertView;
    }
}
