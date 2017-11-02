package com.oiskeletons.android;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Time;

import timber.log.Timber;

/**
 * Created by rubin.apore on 11/1/17.
 */

public class FileStreamer {
    final String FILE_NAME = "insight-period-dimension.json";
    final String JSON_API_URL = "https://api.myjson.com/bins/tg8cb";

    Context context;

    FileStreamer(Context context) {
        this.context = context;
    }
    public static class Timer {
        public long start;
        public Timer(){
            this.start = System.currentTimeMillis() * (long)0.001;
        }
        public void end(String message) {
            Timber.i(message + " : " + (start - (System.currentTimeMillis() * 0.001)));
            this.start = System.currentTimeMillis();
        }
    }

    public void createFile(String path) {
        try {
            String _path = this.context.getFilesDir().getAbsoluteFile() + path;
            File file = new File(_path);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileOutputStream writer = new FileOutputStream(_path);
                writer.write(("").getBytes());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getJsonObject(Context context) {
        final Timer timer = new Timer();
        timer.end("About to get JsonObject");

        Ion.with(context)
                .load(JSON_API_URL)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        timer.end("It took this amount to get the data back");
                        saveJsonObject(result);
                    }
                });
    }

    public void saveJsonObject(JsonObject jsonObject) {
        createFile(FILE_NAME);

        String _path = this.context.getFilesDir().getAbsoluteFile() + FILE_NAME;

        try (Writer writer = new FileWriter(_path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(jsonObject, writer);
        } catch (Exception exp) {
            Timber.e(exp);
        }
    }

    public JsonObject retrieveJsonObject() {

        String _path = this.context.getFilesDir().getAbsoluteFile() + FILE_NAME;

        try (JsonReader jsonReader = new JsonReader(new FileReader(_path))) {
            Gson gson = new Gson();
            return gson.fromJson(jsonReader, JsonObject.class); //(jsonReader, JsonObject.class);
        } catch (Exception exp) {
            Timber.e(exp);
            return null;
        }
    }
}
