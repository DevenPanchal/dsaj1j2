package codeclinic.geolocation;
import org.json.*;
import java.io.*;
import java.net.*;


public class App {

    public static void main( String[] args){
        String location = "";
        JSONObject obj = null;
        String maplink =""; 

        //test case
        location = getData("");
        obj = new JSONObject(location);
        System.out.println("\n\nYou are in or near the city of "
        + obj.getString("city")+ ", "+ obj.getString("country"));

        maplink = "https://www.google.com/maps/?q="
        +obj.getString("loc");

        System.out.println("Your approximate location on the map: \n"
        +maplink);


        location = getData("8.8.8.8");
        //System.out.println(location);
        obj = new JSONObject(location);
        System.out.println("\n\nYou are in or near the city of "
        + obj.getString("city")+ ", "+ obj.getString("country"));
        maplink = "https://www.google.com/maps/?q="
        +obj.getString("loc");
        System.out.println("Your approximate location on the map : \n" + maplink ); 
    }

    public static String getData(String ip) {
        URL url;
        String response = "";
        if (!ip.equals("")) ip = "/" + ip ;
        try {
            // get URL content

            String a="https://ipinfo.io"+ip+"/json";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine; 
            while ((inputLine = br.readLine()) != null) {
                    response = response + inputLine;
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return response;
    }
}
