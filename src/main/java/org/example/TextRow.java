package org.example;

import org.example.flyweight.CharFlyweight;

import java.util.ArrayList;
import java.util.List;

public class TextRow {
    private ArrayList<CharFlyweight> data=new ArrayList<>();

    public void addCharacter(CharFlyweight ch,int column){
        data.add(ch);
        int current=data.size()-1;
        while(current>0 && current>column){
            CharFlyweight temp=data.get(current-1);
            data.set(current-1,data.get(current));
            data.set(current,temp);
            current--;
        }
    }

    public CharFlyweight getFlyweight(int column){
        if(column<0 || column>= data.size()) return null;
        return data.get(column);
    }

    public List<CharFlyweight> readLine(){
        return data;
    }

    public boolean deleteCharacter(int col){
        if(col<0 || col>= data.size()) return false;
        data.remove(col);
        return true;
    }

}
