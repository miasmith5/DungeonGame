package dungeon;
import java.util.List;
import java.util.ArrayList;
public class Memento {
	private String state;

	   public Memento(String state){
	      this.state = state;
	   }

	   public String getState(){
	      return state;
	   }
}//end save(memento) class
class Originator {
	   private String state;

	   public void setState(String state){
	      this.state = state;
	   }

	   public String getState(){
	      return state;
	   }

	   public Memento saveStateToMemento(){
	      return new Memento(state);
	   }

	   public void getStateFromMemento(Memento memento){
	      state = memento.getState();
	   }
}//end originator class
class CareTaker {
	   private List<Memento> mementoList = new ArrayList<Memento>();

	   public void add(Memento state){
	      mementoList.add(state);
	   }

	   public Memento get(int index){
	      return mementoList.get(index);
	   }
	}
class display{
 		 public static void main(String[] args) {
	   
	      Originator originator = new Originator();
	      CareTaker careTaker = new CareTaker();
	      
	      originator.setState("Saved Game");
	      careTaker.add(originator.saveStateToMemento());
	      
	      originator.setState("State #3");
	      careTaker.add(originator.saveStateToMemento());
	      
	      originator.setState("State #4");
	      System.out.println("Current State: " + originator.getState());		
	      
	      originator.getStateFromMemento(careTaker.get(0));
	      System.out.println("First saved State: " + originator.getState());
	      originator.getStateFromMemento(careTaker.get(1));
	      System.out.println("Second saved State: " + originator.getState());
	}
}// end main demo