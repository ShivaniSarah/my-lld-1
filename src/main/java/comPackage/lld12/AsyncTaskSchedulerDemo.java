package comPackage.lld12;
import java.util.*;
import java.util.concurrent.*;

 class Task {
        private final String name;
        private final Runnable action;
        private final List<Task> dependencies;

        public Task(String name, Runnable action, List<Task> dependencies) {
            this.name = name;
            this.action = action;
            this.dependencies = dependencies != null ? dependencies : new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public Runnable getAction() {
            return action;
        }

        public List<Task> getDependencies() {
            return dependencies;
        }
    }

class TaskScheduler {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final Map<Task, Integer> inDegree = new HashMap<>();
    private final Map<Task, List<Task>> adjList = new HashMap<>();
    private final Queue<Task> readyQueue = new ConcurrentLinkedQueue<>();

    public void submit(Task task) {
        inDegree.putIfAbsent(task, 0);
        for (Task dependency : task.getDependencies()) {
            adjList.computeIfAbsent(dependency, k -> new ArrayList<>()).add(task);
            inDegree.put(task, inDegree.getOrDefault(task, 0) + 1);
        }
    }

    public void start() {
        for (Task task : inDegree.keySet()) {
            if (inDegree.get(task) == 0) {
                readyQueue.add(task);
            }
        }

        while (!readyQueue.isEmpty()) {
            Task task = readyQueue.poll();
            executor.execute(() -> {
                System.out.println("Executing task: " + task.getName());
                task.getAction().run();
                taskCompleted(task);
            });
        }
    }

    private synchronized void taskCompleted(Task completedTask) {
        if (!adjList.containsKey(completedTask)) return;
        for (Task dependent : adjList.get(completedTask)) {
            inDegree.put(dependent, inDegree.get(dependent) - 1);
            if (inDegree.get(dependent) == 0) {
                readyQueue.add(dependent);
                executor.execute(() -> {
                    System.out.println("Executing task: " + dependent.getName());
                    dependent.getAction().run();
                    taskCompleted(dependent);
                });
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

    public class AsyncTaskSchedulerDemo {
        public static void main(String[] args) {
            TaskScheduler scheduler = new TaskScheduler();

            Task task1 = new Task("Task 1", () -> System.out.println("Task 1 executed"), Collections.emptyList());
            Task task2 = new Task("Task 2", () -> System.out.println("Task 2 executed"), Collections.singletonList(task1));
            Task task3 = new Task("Task 3", () -> System.out.println("Task 3 executed"), Collections.singletonList(task1));
            Task task4 = new Task("Task 4", () -> System.out.println("Task 4 executed"), Arrays.asList(task1));

            scheduler.submit(task1);
            scheduler.submit(task2);
            scheduler.submit(task3);
            scheduler.submit(task4);

            scheduler.start();
//            scheduler.shutdown();
        }
    }

