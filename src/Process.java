import java.util.Date;

public class Process {
    private int id, arrivalTime, executionTime, priority;

    public Process(){
        id = (int) (new Date().getTime()%100000); //gives us a unique ID based off of the time
        arrivalTime = 0;
        executionTime = 0;
        priority =0;
    }

    public Process(int id, int arrivalTime, int executionTime, int priority){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        String s = "ID: ";
        s += id;
        s += ", ArrivalTime: " + arrivalTime;
        s += ", ExecutionTime: " + executionTime;
        s += ", Priority: " + priority;
        return s;
    }
}
