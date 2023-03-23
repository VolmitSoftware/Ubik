package com.volmit.ubik.bukkit.service;

import com.volmit.ubik.bukkit.BukkitUbik;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;

public class GitHubService {
    public static boolean cloneRepository(String remoteUrl, String localPath) {
        try {
            Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setDirectory(new File(localPath))
                    .call();
            BukkitUbik.info("Cloned repository from " + remoteUrl + " to " + localPath);
            return true;
        } catch (GitAPIException e) {
            e.printStackTrace();
            BukkitUbik.error("Failed to clone repository from " + remoteUrl + " to " + localPath);
            return false;
        }
    }

    public static boolean commitChanges(String localPath, String commitMessage) {
        try (Repository repository = openRepository(localPath)) {
            try (Git git = new Git(repository)) {
                git.add().addFilepattern(".").call();
                git.commit().setMessage(commitMessage).call();
                BukkitUbik.info("Committed changes to repository at " + localPath);
                return true;
            }
        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
            BukkitUbik.error("Failed to commit changes to repository at " + localPath);
            return false;
        }
    }

    public static boolean pushChanges(String localPath, String username, String password) {
        CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(username, password);

        try (Repository repository = openRepository(localPath)) {
            try (Git git = new Git(repository)) {
                git.push().setCredentialsProvider(credentialsProvider)
                        .call();
                BukkitUbik.info("Pushed changes to repository at " + localPath);
                return true;
            }
        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
            BukkitUbik.error("Failed to push changes to repository at " + localPath);
            return false;
        }
    }

    private static Repository openRepository(String localPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder.setGitDir(new File(localPath + "/.git"))
                .readEnvironment()
                .findGitDir()
                .build();
    }
}
