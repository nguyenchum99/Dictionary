
package dictionary2;
import java.io.IOException;
/**
 *
 * @author NGUYEN
 */
public class Dictionary2 {

    public static void main(String[] args) throws IOException{
        
        /*Dictionary d= new Dictionary();
        d.insertFromFile();
        Word word = new Word("abcxyz", "trai tim");
        d.AddFromFile(word);
        d.Print_List();
        
        System.out.println("\n"+new Dictionary().Delete_Word("heart"));
        System.out.println("\n"+new Dictionary().Find_Word("heart"));
        //new Dictionary().Print_List();*/
        Dictionary dic = new Dictionary();
        dic.addToList();
        dic.AddFromFile();
        dic.Print_List();
        System.out.println("\n");
        dic.Delete_Word();
        dic.Print_List();
        //dic.Repair_Word();
        //dic.Print_List();
    }
    
}
