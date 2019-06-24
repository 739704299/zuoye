package cn.edu.swufe.zuoye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class select_city extends AppCompatActivity implements View.OnClickListener {

    private ImageView backBtn;
    private ListView cityListlv;

    private List<City> mCityList;
    private MyApplication mApplication;
    private ArrayList<String> mArrayList;

    private String updateCityCode = "-1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        backBtn=findViewById(R.id.title_selectCity_back);
        backBtn.setOnClickListener(this);

        mApplication = (MyApplication) getApplication();
        mCityList =mApplication.getCityList();
        mArrayList=new ArrayList<String>();
        for (int i=0;i<mCityList.size();i++){
            String cityName =mCityList.get(i).getCity();
            mArrayList.add(cityName);
        }
        cityListlv =findViewById(R.id.seleccity_lv);
        ArrayAdapter<String>adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mArrayList);
        cityListlv.setAdapter(adapter);

        String[] ListData ={"1","2","3"};
        cityListlv =findViewById(R.id.seleccity_lv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListData);
        cityListlv.setAdapter(adapter);


        AdapterView.OnItemClickListener itemClickListener =new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int updateCityCode = Integer.parseInt(mCityList.get(position).getNumber());
                Log.d("update city code",Integer.toString(updateCityCode));
            }
        };
        cityListlv.setOnClickListener((View.OnClickListener) itemClickListener);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_selectCity_back:
           finish();
                Intent intent =new Intent(this,MainActivity.class);
                intent.putExtra("CityCode",updateCityCode);
                startActivity(intent);
           break;
           default:
               break;

        }

    }
}
