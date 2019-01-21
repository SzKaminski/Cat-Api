import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //public-appis
        Gson gson = new Gson();
        for (int i = 1; i <11 ; i++) {



            URL url = new URL("https://aws.random.cat/meow");


            String text = getTextFromURL(url);
            Cat cat = gson.fromJson(text, Cat.class);
            BufferedImage image = ImageIO.read(cat.getFile());
            File file = new File("C:\\Users\\User\\Desktop\\Nowy folder\\KOTY\\kot_" + i +".jpg");
            ImageIO.write(image, "jpg", file);
            System.out.println(file.length()/1024 + " KB");
            System.out.println(image.getData());

        }
    }

    private static String getTextFromURL(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        try (InputStream inputStream = connection.getInputStream()){
            Scanner sc = new Scanner(inputStream);
            return sc.nextLine();
        }
        
    }

}


