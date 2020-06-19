package com.example.appnewst3h.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.appnewst3h.R;
import com.example.appnewst3h.adapter.NewsAdapter;
import com.example.appnewst3h.item.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FragmentContent extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<Item>items;
    private String link;

    public void setLink(String link) {
        this.link = link;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        recyclerView = view.findViewById(R.id.rcl_list);
        adapter = new NewsAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        if (link.equals("https://www.24h.com.vn")){
            crawlData();
        }else {
            singlePage();
        }


        //
        return view;
    }
    private void crawlData(){
        items = new ArrayList<>();
        new AsyncTask<String, Void, Void>(){
            ///doInBackground
            @Override
            protected Void doInBackground(String... values) {
                try {
                    Document document = Jsoup.connect(values[0]).get();
                    Elements elements = document.select("div.bxDoC");
                    for (Element element :elements){
                        System.out.println("check");
                        String title = element.select("a").first().text();
                        String img = element.select("img").attr("data-original");
                        String content = element.select("span.nwsSpSpc").text();
                        String linkDetail = element.select("a").attr("href");
                        Log.d("Content","title: "+title);
                        Log.d("Content","img: "+img);
                        Log.d("Content","content: "+content);
                        Log.d("Content","linkDetail: "+linkDetail);
                        items.add(
                                new Item(
                                        img,title,linkDetail,content
                                )
                        );
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        }.execute(link);

    }
    private void singlePage(){
        items = new ArrayList<>();
        new AsyncTask<String, Void, Void>(){
            ///doInBackground
            @Override
            protected Void doInBackground(String... values) {

                try {
                    Document document = Jsoup.connect(values[0]).get();
                    Elements elements = document.select("article.bxDoiSbIt");
                    for (Element element :elements){
                        System.out.println("check");
                        String title = element.select("a").attr("title");
                        String img = element.select("img").attr("data-original");
                        String content = element.select("span.nwsSp").text();
                        String linkDetail = element.select("a").attr("href");
                        Log.d("Content","title: "+title);
                        Log.d("Content","img: "+img);
                        Log.d("Content","content: "+content);
                        Log.d("Content","linkDetail: "+linkDetail);
                        items.add(
                                new Item(
                                        img,title,linkDetail,content
                                )
                        );
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        }.execute(link);

    }
}
