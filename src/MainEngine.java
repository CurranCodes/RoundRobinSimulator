import java.util.*;

public class MainEngine {
    public static void Initializer(){

    }

    public static void scheduler(Process[] processes, int quantum){
        LinkedList<Process> schedule = new LinkedList<Process>();//que to represent processes in ready queue
        LinkedList<Process> toArrive = new LinkedList<>();//queue to allow for dynamic arrival
        int time = 0; //"global" counter for quantum time

        ArrayList<Process> unsorted = new ArrayList<Process>();

        for (int i = processes.length - 1; i >= 0; i++){
            unsorted.add(processes[i]);
        }

        while (unsorted.isEmpty() == false){
            Process queueNext = unsorted.get(0);
            for (int i = 1; i < unsorted.size(); i++){
                Process currentProcess = unsorted.get(i); //selects the first object arbitrarily for comparison

                //if process arrives sooner, then we should queue that process instead
                if (queueNext.getArrivalTime() > currentProcess.getArrivalTime())
                {
                    queueNext = currentProcess;
                }
                //if process arrives at the same time and the id is smaller, then we should queue that process instead
                else if ((queueNext.getArrivalTime() == currentProcess.getArrivalTime()) && (queueNext.getId() > currentProcess.getId()))
                {
                    queueNext = currentProcess;
                }
            }
            unsorted.remove(queueNext);//remove selected process from unsorted list
            toArrive.addLast(queueNext);//add selected process to queue
        }

        while(toArrive.isEmpty() != false || schedule.isEmpty() != false){
            while (toArrive.get(0).getArrivalTime() >= time){
                schedule.addLast(toArrive.removeFirst());
            }
            System.out.println("Current Time: "+ time);

            //ready queue is current
            System.out.print("Ready Queue<<" );

            for (int i = 0; i < schedule.size() -1 ; i++){
                System.out.print(schedule.get(i).getId() + ", ");
            }

            System.out.println(schedule.getLast().getId() + " >>\n");

            int loopNum = schedule.size();

            // Current Time: 0
            // Executing Process With ID: 1

            // Current Time: 4
            // Process 1 is not done yet, enqueueing...
            // Process 1 finished

            for (int i = 0; i < loopNum; i++){
                Process current = schedule.removeFirst();

                System.out.println("Current Time: "+ time);
                System.out.println("Next Process is as follows\n" + current + "\n");

                current.setExecutionTime(current.getExecutionTime() - quantum);//runs for set amount of time
                if (current.getExecutionTime() > 0){
                    schedule.addLast(current);
                    time += quantum;

                    System.out.println("Current Time: "+ time);
                    System.out.println(current);
                    System.out.println("Process " + current.getId() + " is not done yet, enqueueing...\n");
                } else{
                    time += quantum + current.getExecutionTime(); // only runs for remaining time and is not enqueued because it is done!

                    System.out.println("Current Time: "+ time);
                    System.out.println("Process " + current.getId() + " is finished\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("woot woot");
    }
}