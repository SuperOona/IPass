package status;

import inlog.Gebruiker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Status {
    private static Status deStatus;
    private String jaNee;
    private String status;
    private Gebruiker gebruiker;
    private LocalDate date;
    private static final ArrayList<JSONArray> alleStatus = new ArrayList<JSONArray>();


    public Status(String jaNee, String reden) {
        this.jaNee = jaNee;
        this.status = reden;
        this.date = LocalDate.now();
    }

    public static void setDeStatus(Status deStatus){
        Status.deStatus = deStatus;
    }

    public static ArrayList<JSONArray> getAlleStatus(){
        return alleStatus;
    }

    public void voegStatusToe(JSONArray stat){
        alleStatus.add(stat);
    }

    public static ArrayList<Object> read_products() throws IOException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Object> newlist= new ArrayList<>();

        try (FileReader reader = new FileReader("src/main/java/inlog/oudStatus.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray statusList = (JSONArray) obj;
            String jaNee = (String)statusList.get(Integer.parseInt("jaNee"));
            String reden = (String)statusList.get(Integer.parseInt("reden"));
            System.out.println(jaNee + "\n" + reden);
            statusList.forEach( pr -> parseProductObject( (JSONObject) pr ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newlist;
    }
    private static void parseProductObject(JSONObject product)
    {
        JSONObject employeeObject = (JSONObject) product.get("naam");
        String jaNee = (String) employeeObject.get("jaNee");
        String reden = (String) employeeObject.get("reden");
    }


}


