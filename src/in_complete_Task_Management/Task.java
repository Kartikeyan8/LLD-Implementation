package in_complete_Task_Management;

import java.util.ArrayList;
import java.util.List;

public class Task {
    String id;
    User createdBy;
    User assignedTo;
    String title;
    String description;
    TaskStatus status;
    Priority priority;
    List<ActivityLog> activityLogs = new ArrayList<>();
    public void setId(String id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Task(String id, User createdBy, User assignedTo, String title, String description, TaskStatus status, Priority priority, List<ActivityLog> activityLogs) {
        this.id = id;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;

    }
    public synchronized void assignUser(User user) {
        this.assignedTo = user;
        activityLogs.add(new ActivityLog("Assigned to " + user.getName(),user.getName()));
    }
    public synchronized void changeStatus(TaskStatus status) {
        this.status = status;
        activityLogs.add(new ActivityLog("Status changed to " + status, assignedTo.getName()));
    }
    public synchronized void addActivityLog(ActivityLog log) {
        activityLogs.add(log);
    }
    public String getId() {
        return id;
    }
    public synchronized void updatePriority(Priority priority) {
        this.priority = priority;
        activityLogs.add(new ActivityLog("Priority changed to " + priority, this.priority.name()));
    }

}
