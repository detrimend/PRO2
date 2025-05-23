package model;

import java.util.ArrayList;

public class ExerciseList
{
  private ArrayList<Exercise> exercises;

  public ExerciseList()
  {
    this.exercises = new ArrayList<>();
  }

  public int size()
  {
    return exercises.size();
  }

  public Exercise getExercise(int index)
  {
    return exercises.get(index);
  }

  public Exercise getExercise(String number)
  {
    for (int i = 0; i < exercises.size(); i++)
    {
      if (exercises.get(i).getNumber().equals(number))
      {
        return exercises.get(i);
      }
    }
    return null;
  }

  public Exercise removeExercise(String number)
  {
    for (int i = 0; i < exercises.size(); i++)
    {
      if (exercises.get(i).getNumber().equals(number))
      {
        Exercise exercise = exercises.get(i);
        exercises.remove(i);
        return exercise;
      }
    }
    return null;
  }

  public ArrayList<Exercise> getAllExercises()
  {
    ArrayList<Exercise> localList = new ArrayList<>();
    for (int i = 0; i < exercises.size(); i++)
    {
      localList.add(exercises.get(i));
    }
    return localList;
  }

  public ArrayList<Exercise> getExercises(boolean completed)
  {
    ArrayList<Exercise> localList = new ArrayList<>();
    for (int i = 0; i < exercises.size(); i++)
    {
      if (!exercises.get(i).isCompleted() == completed)
      {
        localList.add(exercises.get(i));
      }
    }
    return localList;
  }

  public Exercise getNextUncompletedExercise()
  {
    for (int i = 0; i < exercises.size(); i++)
    {
      if (!exercises.get(i).isCompleted())
      {
        return exercises.get(i);
      }
    }
    return null;
  }

  public void addExercise(Exercise exercise)
  {
    for (int i = 0; i < exercises.size(); i++)
    {
      if (exercise.getSessionNumber() < exercises.get(i).getSessionNumber())
      {
        exercises.add(i, exercise);
        return;
      }
      else if (exercise.getSessionNumber() == exercises.get(i)
          .getSessionNumber())
      {
        if (exercise.getExerciseNumber() < exercises.get(i).getExerciseNumber())
        {
          exercises.add(i, exercise);
          return;
        }
        else if (exercise.getExerciseNumber() == exercises.get(i).getExerciseNumber())
        {
          throw new IllegalStateException("Number already exist");
        };
      }
    }
    exercises.add(exercise);
  }

  @Override public String toString()
  {
    return "ExerciseList{" + "exercises=" + exercises + '}';
  }
}
