package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview.Model.Restaurant;
import com.example.recyclerview.WebService.Asynchtask;
import com.example.recyclerview.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.jsonbin.io/b/5f0113737f16b71d48ab5221",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET","secret-key","$2b$10$61DxtbBFiYpbKz07QOLkNODix6EGGwl1I//2/fcxkov5uX.ByBbO.");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Restaurant> lstRestaurants = new ArrayList<Restaurant> ();
        try {
            JSONArray JSONlistaRestaurants= new JSONArray(result);
            lstRestaurants = Restaurant.JsonObjectsBuild(JSONlistaRestaurants);

            //agregar datos al recyclerView
            recyclerView = (RecyclerView) findViewById(R.id.rcRestaurants);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

            AdapterRestaurant adapter= new AdapterRestaurant(lstRestaurants);
            recyclerView.setAdapter(adapter);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}