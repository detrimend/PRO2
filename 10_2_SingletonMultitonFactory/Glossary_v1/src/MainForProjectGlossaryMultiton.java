import multiton.GlossaryItem;
import multiton.Project;

public class MainForProjectGlossaryMultiton
{
  public static void main(String[] args)
  {
    String project1language = "English";
    Project project1 = new Project("Project 1", project1language);
    project1.addGlossaryItem("Client",
        "The client part of a client/server " + "application.");
    project1.addGlossaryItem("User",
        "End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account", "A location on the server application "
        + "storing username, password and phone number.");
    System.out.println(
        "Project 1: Client: " + project1.getDefinition("Client"));
    System.out.println("Project language: " + project1language);
    System.out.println(project1);

    // Danish:
    String project2language = "Danish";
    Project project2 = new Project("Project 2", project2language);
    try
    {
      project2.addGlossaryItem("Client",
          "Det program der som en del af en Client/Server applikation bliver "
              + "installeret på computere til læger og sygeplejesker.");
    }
    catch (IllegalStateException e) // Using the same phrase as in Project 1
    {
      System.out.println("Error: " + e.getMessage());
    }
    project2.addGlossaryItem("Bruger",
        "Bruger af systemet - her en læge " + "eller sygeplejeske.");
    project2.addGlossaryItem("Konto", "Et sted på en server med oplysninger "
        + "om brugernavn, kodeord og telefonnummer.");
    System.out.println(
        "Project 2: Client: " + project2.getDefinition("Client"));
    System.out.println("Project language: " + project2language);
    System.out.println(project2);

    // A new project with the project glossary as in project 1
    String project3language = "Angry English";
    Project project3 = new Project("Project 3", project3language);
    GlossaryItem[] glossaryItems = project1.getGlossary().getAll();
    for (GlossaryItem item : glossaryItems)
    {
      project3.addGlossaryItem(item.getPhrase().toUpperCase(),
          item.getDefinition().toUpperCase());
    }
    System.out.println("Project language: " + project3language);
    System.out.println(project3);
  }
}