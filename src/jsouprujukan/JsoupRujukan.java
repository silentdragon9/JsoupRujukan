/*
Mohammad Ariff Bin Idris
2017430762
Test 1 (ITT786)
 */
package jsouprujukan;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupRujukan {

public static void main(String[] args) {
        print("Fetching....");
Document document;
try {
//Capaian ke atas object melalui HTML
document = Jsoup.connect("https://en.wikipedia.org/wiki/Adobe_ColdFusion").get();
 
//Capaian ke atas object melalui untuk mendapatkan tajuk
String url = "https://en.wikipedia.org/wiki/Adobe_ColdFusion";
Document doc = Jsoup.connect(url).get();
String title = doc.title();
System.out.println("\nTajuk : " +title);    // Paparan tajuk

Elements contents = document.select("#toc"); //Capaian ke atas isi kandungan
print("\nKandungan : " + contents.text());  //Paparan isi kandungan
 
                     
print("\nGambar : ");//Capaian ke atas gambar
Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
                for (Element image : images) {

                    System.out.println("\nsrc : " + image.attr("src"));
                    System.out.println("height : " + image.attr("height"));
                    System.out.println("width : " + image.attr("width"));
                    System.out.println("alt : " + image.attr("alt"));

                }
                        
Elements ref = document.select("#mw-content-text > div > div.reflist.columns.references-column-width");//Get references
//System.out.println(ref.get(0).text()); //Paparan rujukan
print("\nIsi Kandungan : ");
print("References:" + ref.text());                     
                  

} catch (IOException e) {
e.printStackTrace();
}
}

public static void print(String string) {
System.out.println(string);
    }
}