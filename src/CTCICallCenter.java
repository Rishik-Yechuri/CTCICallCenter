import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CTCICallCenter {
    public static void main(String[] args) {
        try
        {
            CTCICallCenter obj = new CTCICallCenter();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
    public void run(String[] args){
        //Creates an instance of the CallManager class
        CallManager callManager = new CallManager();
        //Adds Respondents,Managers,and Directors while calling "dispatchCall"
        callManager.addRespondent();
        callManager.addRespondent();
        callManager.dispatchCall();
        callManager.dispatchCall();
        callManager.addDirector();
        callManager.addManager();
        callManager.dispatchCall();
        callManager.addRespondent();
        callManager.dispatchCall();
        callManager.dispatchCall();
    }
}
class Respondent{
    public boolean isBusy;
    public int ID;
    public Respondent(int ID){
        isBusy = false;
        this.ID = ID;
    }
}
class Manager{
    public boolean isBusy;
    public int ID;
    public Manager(int ID){
        isBusy = false;
        this.ID = ID;
    }
}
class Director{
    public boolean isBusy;
    public int ID;
    public Director(int ID){
        isBusy = false;
        this.ID = ID;
    }
}
class CallManager{
    public ArrayList<Object> busyPeople;
    public Queue<Respondent> availableRespondents;
    public Queue<Manager> availableManagers;
    public Queue<Director> availableDirectors;
    int currentID = 0;
    public CallManager(){
        busyPeople = new ArrayList<Object>();
        availableRespondents = new LinkedList<Respondent>();
        availableManagers = new LinkedList<Manager>();
        availableDirectors = new LinkedList<Director>();
    }
    public void addRespondent(){
        availableRespondents.add(new Respondent(currentID));
        currentID++;
    }
    public void addManager(){
        availableManagers.add(new Manager(currentID));
        currentID++;
    }
    public void addDirector(){
        availableDirectors.add(new Director(currentID));
        currentID++;
    }
    public void dispatchCall(){
        if(!availableRespondents.isEmpty()){
            Respondent currentPerson = availableRespondents.poll();
            busyPeople.add(currentPerson);
            System.out.println("Respondent available(ID:" + currentPerson.ID + ")");
        }else if(!availableManagers.isEmpty()){
            Manager currentPerson = availableManagers.poll();
            busyPeople.add(currentPerson);
            System.out.println("Manager available(ID:" + currentPerson.ID + ")");
        }else if(!availableDirectors.isEmpty()){
            Director currentPerson = availableDirectors.poll();
            busyPeople.add(currentPerson);
            System.out.println("Director available(ID:" + currentPerson.ID + ")");
        }
    }
}