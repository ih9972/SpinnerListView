package com.example.spinnerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    ListView listv;
    Spinner spinner;
    TextView capital_view, population_view, language_view, anthem_view;
    String[] constants = {"Asia","Europe","North America","South America","Africa","Australia"};
    ArrayAdapter<String> adp,listadp;
    String[][] countries = {
            {"China", "Japan", "India", "Russia", "South Korea", "Indonesia", "Saudi Arabia"},
            {"France", "Germany", "United Kingdom", "Italy", "Greece", "Spain", "Switzerland"},
            {"United States", "Canada", "Mexico", "Cuba", "Barbados", "Bermuda", "Costa Rica"},
            {"Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador", "Falkland Islands"},
            {"Nigeria", "Egypt", "South Africa", "Algeria", "Ethiopia", "Angola", "Morocco",},
            {"Australia", "Fiji", "Kiribati", "Micronesia", "New Zealand", "Samoa", "Tonga"}
    };
    String[] arr;
    String[][] info = {
            {"Beijing/1,425 million/Chinese/March of the Volunteers","Tokyo/125.7 million/Japanese/Kimigayo","New Delhi/1.408 billion/Hindi/Jana Gana Mana","Moscow/143.4 million/Russian/State Anthem of the Russian Federation","Seoul/51.74 million/Korean/Aegukga","Jakarta/273.8 million/Indonesian/Indonesia Raya","Riyadh/35.95 million/Arabic/Āsh al-Malīk"},
            {"Paris/67.75 million/French/La Marseillaise","Berlin/83.2 million/German/Deutschlandlied","London/67.33 million/English/God Save The King","Rome/59.11 million/Italian/Il Canto degli Italiani","Athens/10.64 million/Greek/Hymn to Liberty","Madrid/47.42 million/Spanish/Marcha Real","Bern/8.703 million/German/Swiss Psalm"},
            {"Washington/331.9 million/English/The Star-Spangled Banner","Ottawa/38.25 million/English/O Canada","Mexico city/126.7 million/Spanish/Himno Nacional Mexicano","Havana/11.26 million/Spanish/La Bayamesa","Bridgetown/281,200/English/In Plenty and In Time of Need","Hamilton/63,867/English/Hail to Bermuda","San José/5.154 million/Spanish/Himno Nacional de Costa Rica"},
            {"Buenos Aires/45.81 million/Spanish/Himno Nacional Argentino","La Paz/12.08 million/Spanish/Bolivianos, el Hado Propicio","Brasília/214.3 million/Portuguese/Hino Nacional Brasileiro","Santiago,19.49 million/Spanish/Puro, Chile, es tu cielo azulado","Bogota/51.52 million/Spanish/Himno Nacional de la República de Colombia","Quito/17.8 million/Spanish/Salve, Oh Patria","Stanley/2,840/English/Song of the Falklands"},
            {"Abuja/213.4 million/English/Arise, O Compatriots","Cairo/109.3 million/Arabic/Bilady, Bilady, Bilady","Pretoria/59.39 million/Zulu/National anthem of South Africa","Algiers,44.18 million/Arabic/Kassaman","Addis Ababa/120.3 million/Amharic/March Forward, Dear Mother Ethiopia","Luanda/34.5 million/Portuguese/Angola Avante","Rabat/37.08 million/Arabic/Cherifian Anthem"},
            {"Canberra/25.69 million/English/Advance Australia Fair","Suva/924,610/Fijian/Meda Dau Doka","Tarawa/128,874/Gilbertese/Kunan Kiribati","Palikir/113,131/Micronesian/Patriots of Micronesia","Wellington/5.123 million/Māori/God Defend New Zealand","Apia/218,764/Samoan/The Banner of Freedom","Nuku'alofa/106,017/Tongan/Ko e fasi ʻo e tuʻi ʻo e ʻOtu Tonga"}
    };
    int constant;
    String temp_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listv = (ListView) findViewById(R.id.listView);
        spinner = (Spinner) findViewById(R.id.sp);
        capital_view = (TextView) findViewById(R.id.capital_view);
        population_view = (TextView) findViewById(R.id.population_view);
        language_view = (TextView) findViewById(R.id.language_view);
        anthem_view = (TextView) findViewById(R.id.anthem_view);
        adp = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,constants);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(this);
        listv.setOnItemClickListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        listadp = new ArrayAdapter<String>(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,countries[position]);
        listv.setAdapter(listadp);
        constant = position;
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        temp_string  = info[constant][position];
        arr = temp_string.split("/", 5);
        capital_view.setText("The capital city is: "+arr[0]);
        population_view.setText("The population is: "+arr[1]);
        language_view.setText("The most common language is: "+arr[2]);
        anthem_view.setText("The anthem name is: "+arr[3]);
    }
}