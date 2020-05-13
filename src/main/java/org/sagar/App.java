package org.sagar;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;

public class App {


    //create a method
    public static String getData(String c) throws Exception {
        StringBuffer br = new StringBuffer();

        String url = "https://www.worldometers.info/coronavirus/country/"+c+"/";
        Document doc = Jsoup.connect(url).get();
        //System.out.println(doc.title());  //prints title

        // using id (#maincounter-wrap).
        Elements ele = doc.select("#maincounter-wrap");
        //System.out.println(ele.html()); //this with printall data of id

        //Printing, separating data of id using lamda expression. and foreach loop.
        ele.forEach( (e) ->
                {
                    //System.out.println(item.html() + "\n" + "\n"); //fetching all data with html.

                    //1.fetching text
                    String text = e.select("h1").text();
                    String count = e.select(".maincounter-number > span").text();
                    //System.out.println(text +" : " +count);

                    br.append(text).append(" : ").append(count).append("\n");
                });

                return br.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nDemo of Corono virus Tracker !\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Country name :\n");
        String co = sc.nextLine();
        System.out.println(getData(co));
    }


}

