package platform.game;

import platform.util.Input;

/**
 * Signal that is on if there exists an instance of a class in the level
 */
public class ExistenceOf extends Actor implements Signal{

 private boolean existence;
 private Class<?> className;
 
 public ExistenceOf(Class<?> className){
  this.className = className;
 }
 
 @Override
 public void preUpdate(Input input) {
  existence = false;
 }
 
 @Override
 public void interact(Actor other){
  if(other.getClass().equals(className)){
   existence=true;
  }
 }

 
 @Override
 public boolean isActive() {
  return existence;
 }
 
 @Override
 public int getPriority() {
  return 1111111111;
 }

}