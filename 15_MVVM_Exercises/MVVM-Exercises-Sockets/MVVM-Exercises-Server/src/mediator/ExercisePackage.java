package mediator;

import model.Exercise;

public class ExercisePackage
{
  private String type;
  private String number;
  private String error;
  private Exercise exercise;

  public ExercisePackage(String type, Exercise exercise, String number)
  {
    this.type = type;
    this.number = number;
    this.exercise = exercise;
  }

  public ExercisePackage(String type, String error)
  {
    this.type = type;
    this.error = error;
  }

  public Exercise getExercise()
  {
    return exercise;
  }

  public String getNumber()
  {
    return number;
  }

  public String getType()
  {
    return type;
  }

  public String getError()
  {
    return error;
  }

  public boolean equals(Object object)
  {
    if (!(object instanceof ExercisePackage))
    {
      return false;
    }
    ExercisePackage other = (ExercisePackage) object;
    return type.equals(other.getType()) && number.equals(other.getNumber())
        && error.equals(other.getError()) && exercise.equals(
        other.getExercise());
  }

  public String toString()
  {
    return "Type: " + type + ", Number: " + number + ", Error: " + error
        + ", Exercise: " + exercise;
  }
}
