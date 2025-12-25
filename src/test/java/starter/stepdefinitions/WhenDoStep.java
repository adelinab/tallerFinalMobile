package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;
import starter.whendo.MyListScreen;
import starter.whendo.TaskDetailScreen;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;


import java.util.Map;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class WhenDoStep {
    @Given("{actor} is using whenDo")
    public void adminIsUsingWhenDo(Actor actor) {
    }


    @When("{actor} creates a new task")
    public void heCreatesANewTask(Actor actor, Map<String,String> data) {
        actor.attemptsTo(Click.on(MyListScreen.addTaskButton));
        actor.attemptsTo(SendKeys.of(data.get("title")).into(TaskDetailScreen.titleTextBox));
        actor.attemptsTo(SendKeys.of(data.get("note")).into(TaskDetailScreen.notesTextBox));
        actor.attemptsTo(Click.on(TaskDetailScreen.saveButton));
    }


    @Then("{actor} should see the task {string}")
    public void heShouldSeeTheTask(Actor actor,String expected) {
        actor.should(
                seeThat("verify the created task",
                        Text.of(MyListScreen.getTaskByTitle(expected)),
                        equalTo(expected))
        );
    }

    @When("{actor} crea una nueva tarea")
    public void heCreaUnaNuevaTarea(Actor actor, Map<String,String> data) {
        actor.attemptsTo(Click.on(MyListScreen.addTaskButton));
        actor.attemptsTo(SendKeys.of(data.get("titulo")).into(TaskDetailScreen.titleTextBox));
        actor.attemptsTo(SendKeys.of(data.get("nota")).into(TaskDetailScreen.notesTextBox));
        actor.attemptsTo(Click.on(TaskDetailScreen.saveButton));
    }

    @Then("{actor} deberia ver la tarea {string}")
    public void heDeberiaVerLaTarea(Actor actor,String expected) {
        actor.should(
                seeThat("verificar la tarea creada",
                        Text.of(MyListScreen.getTaskByTitle(expected)),
                        equalTo(expected))
        );
    }

    @When("{actor} edita la tarea {string}")
    public void heEditaLaTarea(Actor actor,String tarea,Map<String,String> data) {
        actor.attemptsTo(Click.on(MyListScreen.getTaskByTitle(tarea)));
        actor.attemptsTo(Clear.field(TaskDetailScreen.titleTextBox),SendKeys.of(data.get("nuevo_titulo")).into(TaskDetailScreen.titleTextBox));
        actor.attemptsTo(Clear.field(TaskDetailScreen.notesTextBox),SendKeys.of(data.get("nueva_nota")).into(TaskDetailScreen.notesTextBox));
        actor.attemptsTo(Click.on(TaskDetailScreen.saveButton));
    }

    @When("{actor} elimina la tarea {string}")
    public void heEliminaLaTarea(Actor actor,String tarea) {
        actor.attemptsTo(Click.on(MyListScreen.getTaskByTitle(tarea)));
        actor.attemptsTo(Click.on(TaskDetailScreen.deleteButton));
        actor.attemptsTo(Click.on(TaskDetailScreen.confirmDeleteButton));
    }

    @Then("{actor} no deberia encontrar la tarea {string}")
    public void heNoDeberiaEncontrarLaTarea(Actor actor,String expected) {
        actor.should(
                seeThat("verificar la tarea eliminada",
                        actorActual ->
                                MyListScreen.getTaskByTitle(expected)
                                        .resolveAllFor(actorActual)
                                        .size(),
                        equalTo(0))
        );
    }
}
