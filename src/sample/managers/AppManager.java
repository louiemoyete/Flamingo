package sample.managers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Models.AppData;
import sample.utils.FXMLTool;

import java.util.Observable;

public class AppManager extends Observable {

    private static final int[] START_STAGE_DIMENSIONS = {600, 400};

    private static final int[] WORK_STAGE_DIMENSIONS = {800, 600};

    private static final String TITLE = "Flamingo";

    private static final String SEARCH_SCENE_URL = "../FXML/searchScene.fxml";

    private static final String TRIP_ITINERARY_SCENE_URL = "../FXML/tripItineraryScene.fxml";

    private static final String TRIP_OPTIONS_SCENE_URL = "../FXML/tripOptionsScene.fxml";

    private static final String TRIP_SETUP_SCENE_URL = "../FXML/tripSetupScene.fxml";

    private AppData appData = new AppData();

    private Stage startStage, workStage, currentStage;

    private Scene searchScene, tripItineraryScene, tripOptionsScene, tripSetupScene;

    public AppData getAppData() { return appData; }

    public Scene getTripItineraryScene() { return tripItineraryScene; }

    public Scene getTripOptionsScene() { return tripOptionsScene; }

    public Scene getTripSetupScene() { return tripSetupScene; }

    public Stage getCurrentStage() { return currentStage; }

    private static AppManager instance = new AppManager();

    public static AppManager getInstance(){
        return instance;
    }

    public void setupStages(Stage primaryStage){
        try {
            workStage = new Stage();
            startStage = primaryStage;

            startStage.setResizable(false); workStage.setResizable(false);

            startStage.setTitle(TITLE); workStage.setTitle(TITLE);

            searchScene = FXMLTool.createScene(getClass().getResource(SEARCH_SCENE_URL), START_STAGE_DIMENSIONS);
            tripItineraryScene = FXMLTool.createScene(getClass().getResource(TRIP_ITINERARY_SCENE_URL), WORK_STAGE_DIMENSIONS);
            tripOptionsScene = FXMLTool.createScene(getClass().getResource(TRIP_OPTIONS_SCENE_URL), WORK_STAGE_DIMENSIONS);
            tripSetupScene = FXMLTool.createScene(getClass().getResource(TRIP_SETUP_SCENE_URL), WORK_STAGE_DIMENSIONS);

            startStage.setScene(searchScene);
            workStage.setScene(tripOptionsScene);

            showStartStage();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void changeWorkStageScene(Scene scene){
        workStage.setScene(scene);

        setChanged();
        notifyObservers(scene);
    }

    public void showWorkStage(){
        workStage.show();
        startStage.hide();
        currentStage = workStage;

        setChanged();
        notifyObservers(tripOptionsScene);
    }

    public void showStartStage(){
        startStage.show();
        workStage.hide();
        currentStage = startStage;
    }
}
