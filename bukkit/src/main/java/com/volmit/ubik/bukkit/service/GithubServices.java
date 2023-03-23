package com.volmit.ubik.bukkit.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;


public class GithubServices {
    public boolean cloneRepository(String remoteUrl, String localPath) {
        try {
            Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setDirectory(new File(localPath))
                    .call();
            return true;
        } catch (GitAPIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean commitChanges(String localPath, String commitMessage) {
        try (Repository repository = openRepository(localPath)) {
            try (Git git = new Git(repository)) {
                git.add().addFilepattern(".").call();
                git.commit().setMessage(commitMessage).call();
                return true;
            }
        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pushChanges(String localPath, String username, String password) {
        CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(username, password);

        try (Repository repository = openRepository(localPath)) {
            try (Git git = new Git(repository)) {
                git.push().setCredentialsProvider(credentialsProvider)
                        .call();
                return true;
            }
        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Repository openRepository(String localPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder.setGitDir(new File(localPath + "/.git"))
                .readEnvironment()
                .findGitDir()
                .build();
    }
}
