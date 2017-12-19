package com.vlogellaa.espresso.ufl.util;


import android.content.Context;
import android.content.res.AssetManager;

import com.vlogellaa.espresso.ufl.models.Dates;
import com.vlogellaa.espresso.ufl.models.Game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSONParser {
    private Context mContext;

    public JSONParser(Context mContext) {
        this.mContext = mContext;
    }

    private String AssetJSONFile() {
        String json;
        AssetManager manager = mContext.getAssets();
        try {
            InputStream is = manager.open("AllLeagues.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private Game getGame(JSONObject jsonObject) {
        try {
            return new Game(
                    jsonObject.getString("time"),
                    jsonObject.getString("team_one"),
                    jsonObject.getString("team_two"),
                    jsonObject.getString("filter_type")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void filterGame(ArrayList<Object> list, JSONObject jsonObject, int filter) {
        Game game = getGame(jsonObject);

        if (filter == 0) {
            list.add(game);
        } else if (filter == 1) {
            if ("Series A".matches(game.getLeague())) {
                list.add(game);
            }
        } else if (filter == 2) {
            if ("Premier League".matches(game.getLeague())) {
                list.add(game);
            }

        } else if (filter == 3) {
            if ("Ligui 1".matches(game.getLeague())) {
                list.add(game);
            }

        } else if (filter == 4) {
            if ("Saudi League".matches(game.getLeague())) {
                list.add(game);
            }
        } else if (filter == 5) {
            if ("La Liga".matches(game.getLeague())) {
                list.add(game);
            }
        }

    }

    public ArrayList<Object> getList(int filter) {

        ArrayList<Object> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(AssetJSONFile());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String type = jsonObject.getString("type");

                if ("date".matches(type)) {
                    list.add(new Dates(jsonObject.getString("value")));
                } else if ("game".matches(type)) {
                    filterGame(list, jsonObject, filter);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
