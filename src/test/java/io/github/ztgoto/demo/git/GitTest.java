package io.github.ztgoto.demo.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class GitTest {

	File f = new File("C:\\Users\\rax\\Desktop\\jgit");

	Git git;
	Repository repository;

	@Test
	public void testGitInit() throws IllegalStateException, GitAPIException {

		Git.init().setDirectory(f).call();
	}

	@Before
	public void before() throws IllegalStateException, GitAPIException, IOException {
		git = Git.open(f);
		repository = git.getRepository();
	}

	@Test
	public void testDiff() throws GitAPIException {

	}


}
