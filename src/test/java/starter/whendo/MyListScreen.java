package starter.whendo;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class MyListScreen {


    public static Target addTaskButton = Target.the("add button")
            .located(By.id("com.vrproductiveapps.whendo:id/fab"));

    public static Target getTaskByTitle(String titulo){
        return Target.the("task with title "+titulo)
                .located(By.xpath("//android.widget.TextView[@text='"+titulo+"' and not(contains(@resource-id,'text2'))]"));
    }

}
