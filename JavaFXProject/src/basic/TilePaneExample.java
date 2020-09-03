package basic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane fp = new TilePane();
		fp.setPrefTileHeight(100);
		fp.setPrefTileWidth(100);
		
		ImageView iv1 = new ImageView();
		iv1.setImage(new Image("/basic/images/fruit1.jpg"));
		ImageView iv2 = new ImageView();
		iv2.setImage(new Image("/basic/images/fruit2.jpg"));
		ImageView iv3 = new ImageView();
		iv3.setImage(new Image("/basic/images/fruit3.jpg"));
		ImageView iv4 = new ImageView();
		iv4.setImage(new Image("/basic/images/fruit4.jpg"));
		ImageView iv5 = new ImageView();
		iv5.setImage(new Image("/basic/images/fruit5.jpg"));
		
		fp.getChildren().add(iv1);
		fp.getChildren().add(iv2);
		fp.getChildren().add(iv3);
		fp.getChildren().add(iv4);
		fp.getChildren().add(iv5);
		
/*		ImageView[] ary = new Image();
 * 		for(int i=1;i<6; i++){
 * 
 * 
 * 
 * }
*/		
		Scene scene = new Scene(fp);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AppMain");
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
