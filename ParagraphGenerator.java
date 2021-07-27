import java.io.*;
import java.util.*;

public class ParagraphGenerator {
  public void generateParagraph() {
    try {
      Scanner len = new Scanner(System.in);
      Scanner random = new Scanner(System.in);
      int t = 0;
      boolean maxLen = false;
      ArrayList<String> noun = new ArrayList<String>();
      ArrayList<String> verb = new ArrayList<String>();
      ArrayList<String> adj = new ArrayList<String>();
      ArrayList<String> art = new ArrayList<String>();
      ArrayList<String> prep = new ArrayList<String>();
      FileReader fr1 = new FileReader("Noun.txt");
      FileReader fr2 = new FileReader("Verb.txt");
      FileReader fr3 = new FileReader("Adjective.txt");
      FileReader fr4 = new FileReader("Preposition.txt");
      FileReader fr5 = new FileReader("Article.txt");
      BufferedReader br1 = new BufferedReader(fr1);
      BufferedReader br2 = new BufferedReader(fr2);
      BufferedReader br3 = new BufferedReader(fr3);
      BufferedReader br4 = new BufferedReader(fr4);
      BufferedReader br5 = new BufferedReader(fr5);
      String line;
      while ((line = br1.readLine()) != null) {
        noun.add(line);
      }
      fr1.close();
      while ((line = br2.readLine()) != null) {
        verb.add(line);
      }
      fr2.close();
      while ((line = br3.readLine()) != null) {
        adj.add(line);
      }
      fr3.close();
      while ((line = br4.readLine()) != null) {
        prep.add(line);
      }
      fr4.close();
      while ((line = br5.readLine()) != null) {
        art.add(line);
      }
      fr5.close();
      System.out.println("Do you wish to set the number of lines in the paragraph (enter \"yes\" or \"no\")");
      //Receives input from user if user desires to personally set the number of lines in the paragraph to be generated
      if (random.nextLine().equals("yes")) {
        //Continues to receive input from user until a valid input is entered
        while (maxLen == false) {
          System.out.println("Enter the number of lines you desire in the paragraph(max limit: 17)");
          t = len.nextInt();
          maxLen = true;
          //Checks if input entered is valid or not 
          if (t > 17 || t < 1) {
            maxLen = false;
            System.out.println("Enter valid input");
          }
        }
      } else
        t = 5 + (int) (Math.random() * 15);
      len.close();
      random.close();
      String para = "";
      int n;
      //Selects random nouns, verbs, adjectives, articles, and prepositions 
      for (int i = 0; i < t; i++) {
        n = (int) (Math.random() * art.size());
        para = para + art.get(n) + " ";
        n = (int) (Math.random() * adj.size());
        para = para + adj.get(n) + " ";
        n = (int) (Math.random() * noun.size());
        para = para + noun.get(n) + " ";
        n = (int) (Math.random() * verb.size());
        para = para + verb.get(n) + " ";
        n = (int) (Math.random() * prep.size());
        para = para + prep.get(n) + " ";
        n = (int) (Math.random() * art.size());
        para = para + art.get(n) + " ";
        n = (int) (Math.random() * noun.size());
        para = para + noun.get(n) + ".";
      }
      System.out.println(para);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

class Driver {
  public static void main(String[] args) {
    ParagraphGenerator pg = new ParagraphGenerator();
    pg.generateParagraph();
  }
}