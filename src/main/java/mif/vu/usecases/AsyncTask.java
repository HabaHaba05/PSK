package mif.vu.usecases;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Named
@SessionScoped
public class AsyncTask implements Serializable {

    private CompletableFuture<Integer> asyncTask = null;

    public String generateRandomNumb() {
        asyncTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Random().nextInt(100);
        });

        return  "/index.xhtml?faces-redirect=true";
    }

    public boolean isAsyncTaskRunning() {
        return asyncTask != null && !asyncTask.isDone();
    }

    public String getAsyncTaskStatus() throws ExecutionException, InterruptedException {
        if (asyncTask == null) {
            return null;
        } else if (isAsyncTaskRunning()) {
            return "Task in progress";
        }
        return "Random number: " + asyncTask.get();
    }

}
