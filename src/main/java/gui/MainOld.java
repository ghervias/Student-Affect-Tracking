package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tasks.DefaultTask;
import tasks.Session;
import tasks.Task;

import java.util.ArrayList;

/**
 * An example application which demonstrates use of a
 * CodeMirror based JavaScript CodeEditor wrapped in
 * a JavaFX WebView.
 */
public class MainOld extends Application {
    static Task task;
    static ArrayList<Task> listOfTasks;
    static Session session;
    // some sample code to be edited.
    static final private String editingCode =
            "import javafx.application.Application;\n" +
                    "import javafx.scene.Scene;\n" +
                    "import javafx.scene.web.WebView;\n" +
                    "import javafx.stage.Stage;\n" +
                    "\n" +
                    "/** Sample code editing application wrapping an editor in a WebView. */\n" +
                    "public class CodeEditorExample extends Application {\n" +
                    "  public static void main(String[] args) { launch(args); }\n" +
                    "  @Override public void start(Stage stage) throws Exception {\n" +
                    "    WebView webView = new WebView();\n" +
                    "    webView.getEngine().load(\"http://codemirror.net/mode/groovy/index.html\");\n" +
                    "    final Scene scene = new Scene(webView);\n" +
                    "    webView.prefWidthProperty().bind(scene.widthProperty());\n" +
                    "    webView.prefHeightProperty().bind(scene.heightProperty());\n" +
                    "    stage.setScene(scene);\n" +
                    "    stage.show();\n" +
                    "  }\n" +
                    "}";

    public static void main(String[] args) {
        task = new DefaultTask("1 + 1", "2");
        listOfTasks = new ArrayList<>();
        listOfTasks.add(task);
        session = new Session(10, listOfTasks, "OLD");
        launch(args);
    }
    @Override public void start(Stage stage) throws Exception {
        // create the editing controls.
        Label title = new Label("Editing: CodeEditor.java");
        title.setStyle("-fx-font-size: 20;");
        final Label labeledCode = new Label(editingCode);
        final CodeEditor editor = new CodeEditor(editingCode);
        final Button revertEdits = new Button("Revert edits");
        revertEdits.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                editor.revertEdits();
            }
        });
        final Button copyCode = new Button(
                "Take a snapshot from the editor and set a revert point"
        );
        copyCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                labeledCode.setText(editor.getCodeAndSnapshot());
                System.out.println(editor.getCodeAndSnapshot());
            }
        });

        // layout the scene.

        ///// adding new javafx elements for session (TESTING)
        final Label taskAnswer = new Label("hm...");
        final Button showSessionTest = new Button( "QUESTION!");
        showSessionTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                taskAnswer.setText(session.nextTask().getAnswer());
            }
        });
        /////


        HBox childHbox = new HBox(30);
        childHbox.getChildren().addAll(copyCode, revertEdits);
        VBox layout = new VBox(30);

        layout.getChildren().addAll(title, editor, childHbox, labeledCode, showSessionTest, taskAnswer);


        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 30;");

        // display the scene.
        final Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}