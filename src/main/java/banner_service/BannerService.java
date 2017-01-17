package banner_service;

import banner_service.Service.Service;
import banner_service.controller.BannerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

import static spark.Spark.*;


/**
 * Created by svindler on 10.01.2017.
 */

/**
 * <h1>Banner Service</h1>
 * <h2>By Kicsikacsák</h2>
 * This class is responsible for running the server for the service
 *
 * @author doramedgyasszay
 * @version beta
 * @see BannerService
 * @see BannerController
 */

public class BannerService {

    private BannerController controller;
    private static final Logger logger = LoggerFactory.getLogger(BannerService.class);

    /**
     * This method is responsible for setting the port, the endpoints, and for Exception handling
     *
     * @param args
      */

    public static void main(String[] args) {
        logger.debug("Starting " + BannerService.class.getName() + "...");

        setup(args);
        System.out.println(args[0]);

        BannerService application = new BannerService();

        application.controller = new BannerController(Service.getInstance());

        // --- MAPPINGS ---
        post("/banner", application.controller::getBanner);

        // --- EXCEPTION HANDLING ---
        exception(URISyntaxException.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("URI building error, maybe wrong format? : %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });
    }

    /**
     * Setting up port
     * @param args - app args
     */
    private static void setup(String[] args){
        if(args == null || args.length == 0){
            logger.error("Port must be given as the first argument.");
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e){
            logger.error("Invalid port given '{}', it should be number.", args[0]);
            System.exit(-1);
        }
    }
}
