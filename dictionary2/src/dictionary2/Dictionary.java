/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Dictionary {
    static ArrayList<Word> listWord = new ArrayList<>();
    private Scanner sc= new Scanner(System.in);
    public Dictionary(){
        
    }
    public boolean Delete_Word(){
        System.out.println("Nhap vao tu can xoa:");
        String word = sc.nextLine();
        for(int i = 0; i < listWord.size(); i++){
            if(word.equals(listWord.get(i).getWord_target())){
                listWord.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean Add_Word(){
        System.out.println("Nhap tu tieng anh:");
        String word = sc.nextLine();
        System.out.println("Nhap nghia tieng viet:");
        String explain = sc.nextLine();
        for(Word s:listWord){
            if(s.getWord_target().equals(word)){
                return false;
            }
        }
        return true;
    }
    /*public boolean Repair_Word(){
        if (Delete_Word()){
            return Add_Word();
        }
        else {
            return false;
        }
    }*/
    public boolean Repair_Word(){
        System.out.println("Nhap tu muon sua nghia:");
        String word = sc.nextLine();
        System.out.println("Nhap nghia sua:");
        String explain = sc.nextLine();
        for(Word s: listWord){
            if(word.equals(s.getWord_target()))
                listWord.remove(s);
            else  listWord.add(new Word(word, explain));
            return true;
            
        }
        return false;
    }
    
    public String Find_Word(){
        System.out.println("Nhap tu can tim:");
        String word = sc.nextLine();
        for(int i = 0; i < listWord.size(); i++){
            if(word.equals(listWord.get(i).getWord_target())){
                return listWord.get(i).getWord_explain();
            }
        }
        return "";
    }
    public void AddFromFile() {
        System.out.println("Nhap tu tieng anh:");
        String word = sc.nextLine();
        System.out.println("Nhap nghia tieng viet:");
        String explain = sc.nextLine();
        if(!Find_Word().equals("")) System.out.println("this word existed in dictionary");
        else listWord.add(new Word(word,explain));  
        try{
            FileWriter f= new FileWriter("Dictionaries.txt");
            try( BufferedWriter fw= new BufferedWriter(f)){
                for (int i = 0; i<listWord.size(); i++) {
                    fw.write(listWord.get(i).getWord_target()+" "+ listWord.get(i).getWord_explain()+"\r\n");
                 }
             }
             
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
  
    
    //add tu tu file vao list
    public void addToList(){
        try{
            FileReader fr = new FileReader("Dictionaries.txt");
            BufferedReader bReader = new BufferedReader(fr); 
                String line;
                while((line = bReader.readLine()) != null){
                    String[] lineWord;//= new String[2];
                    lineWord = line.split(" ",2);//cat 
                    listWord.add(new Word(lineWord[0],lineWord[1]));
                }
            }
        catch(IOException e){
            e.printStackTrace();
        }           
    }
     
     
    public void Print_List(){
        System.out.printf("%-10s|%-20s|%s","Stt","target","explain");
        for(int i=0;i<listWord.size();i++){
            System.out.printf("\n%-10d|%-20s|%s",i+1,listWord.get(i).getWord_target(),listWord.get(i).getWord_explain());
        }
    }
}
