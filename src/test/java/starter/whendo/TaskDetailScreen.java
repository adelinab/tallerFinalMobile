package starter.whendo;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class TaskDetailScreen {
    public static Target titleTextBox = Target.the("title textbox")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public static Target notesTextBox = Target.the("note textbox")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public static Target saveButton = Target.the("save button")
            .located(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public static Target deleteButton = Target.the("delete button")
            .located(By.id("com.vrproductiveapps.whendo:id/deleteItem"));

    public static Target confirmDeleteButton = Target.the("confirmDelete button")
            .located(By.id("android:id/button1"));

}
