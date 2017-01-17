package banner_service.Service;

import org.json.JSONObject;

/**
 * Created by svindler on 10.01.2017.
 */

/**
This class contains the business logic of the API
*
* @author doramedgyasszay
* @version beta
*/
public class Service {

    private static Service instance;
    private static String basic_banner_HTML = "<div class=\"container\">" +
            "<div class=\"col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3\">" +
            "<a href=\"https://codecool.hu/\"><img src=\"http://www.auplod.com/u/opladu8f6e7.gif\" border=\"1\">" +
            "</a></div></div>";

    private static String customer_HTML = "<div class=\"container\">" +
            "<div class=\"col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3\">" +
            "<a href=\"https://codecool.hu/\"><img src=\"http://www.auplod.com/u/aoludp8f70b.gif\" border=\"1\">" +
            "</a></div></div>";

    private Service() {
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    /**
     * Method for getting the Advertisement banner
     * @return a JSON object, containing status and Advertisement as keys
     */
    public JSONObject getBanner(){
        JSONObject obj = new JSONObject();
        obj.put("status","done");
        obj.put("Advertisement", basic_banner_HTML);
        return obj;
    }

    /**
     * Parameterized method for getting the Products banner
     * NOT IMPLEMENTED
     * @param user, a string from the request
     * @return a JSON object, containing status and Advertisement as keys
     */
    public JSONObject getBanner(String user) {
        JSONObject obj = new JSONObject();
        obj.put("Advertisement", customer_HTML);
        obj.put("status", "done");
        return obj;
    }

    /**
     * Parameterized method for getting the Products banner, based on cart data
     * NOT IMPLEMENTED
     * @param user, a string from the request
      * @param cart, a string from the request
     * @return a JSON object, containing status and Advertisement as keys
     */
    public JSONObject getBanner(String user, String cart) {
        JSONObject obj = new JSONObject();
        obj.put("Advertisement", customer_HTML);
        obj.put("status", "done");
        return obj;
    }
}
