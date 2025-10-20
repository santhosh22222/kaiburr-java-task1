package com.kaiburr.assessment.taskrunner.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaiburr.assessment.taskrunner.model.Task;
import com.kaiburr.assessment.taskrunner.model.TaskExecution;
import com.kaiburr.assessment.taskrunner.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> findAll() { return repo.findAll(); }

    public Optional<Task> findById(String id) { return repo.findById(id); }

    public Task save(Task t) { return repo.save(t); }

    public void delete(String id) { repo.deleteById(id); }

    public List<Task> findByName(String name) { return repo.findByNameContainingIgnoreCase(name); }

    public TaskExecution runCommandAndRecord(Task task) throws Exception {
        String cmd = task.getCommand();
        if (!CommandValidator.isSafe(cmd)) {
            throw new IllegalArgumentException("Unsafe command detected!");
        }

        TaskExecution ex = new TaskExecution();
        ex.setStartTime(Instant.now());

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        StringBuilder out = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                out.append(line).append(System.lineSeparator());
            }
        }

        int exit = p.waitFor();
        ex.setEndTime(Instant.now());
        ex.setOutput("ExitCode=" + exit + "\n" + out.toString());

        task.getTaskExecutions().add(ex);
        repo.save(task);
        return ex;
    }
}
