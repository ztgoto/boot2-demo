package io.github.ztgoto.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import difflib.DiffUtils;
import difflib.Patch;
import io.github.ztgoto.demo.utils.DiffMatchPatch.Diff;

@RunWith(BlockJUnit4ClassRunner.class)
public class DiffMatchPatchTest {
	String file1 = "diff1.yml";
	String file2 = "diff2.yml";

	@Test
	public void testDiff1() throws IOException {
		
		InputStream input1 = null;
		
		InputStream input2 = null;
		
		try {
			input1 = this.getClass().getClassLoader().getResourceAsStream(file1);
			
			input2 = this.getClass().getClassLoader().getResourceAsStream(file2);
			
			List<String> t1 = IOUtils.readLines(input1,"UTF-8");
			List<String> t2 = IOUtils.readLines(input2,"UTF-8");
			
			
			
			long begin = System.currentTimeMillis();
			
			Patch<String> patch = DiffUtils.diff(t1, t2);
			
			
			List<String> result =  DiffUtils.generateUnifiedDiff("Speedtest1.txt", "Speedtest2.txt", t1, patch, 5);
			
			
			long end = System.currentTimeMillis();
			
			System.out.println("time:"+(end-begin)+"ms");
			
			for (String str : result) {
				System.out.println(str);
			}
		} finally {
			if (input2 != null) {
				input2.close();
			}
			if (input1 != null) {
				input1.close();
			}
		}
		
	}
	
	@Test
	public void testDiff2() throws IOException {
		
		InputStream input1 = null;
		
		InputStream input2 = null;
		
		try {
			input1 = this.getClass().getClassLoader().getResourceAsStream(file1);
			
			input2 = this.getClass().getClassLoader().getResourceAsStream(file2);
			
			String t1 = IOUtils.toString(input1,"UTF-8");
			String t2 = IOUtils.toString(input2,"UTF-8");
			
			DiffMatchPatch match = new DiffMatchPatch();
			
			long begin = System.currentTimeMillis();
			
			LinkedList<Diff> diffs = match.diff_main(t1, t2);
			
//			match.diff_cleanupEfficiency(diffs);
			
			String result = match.diff_prettyHtml(diffs);
			
//			LinkedList<DiffMatchPatch.Patch> patchs = match.patch_make(diffs);
//			
//			String result = match.patch_toText(patchs);
			
			long end = System.currentTimeMillis();
			
			System.out.println("time:"+(end-begin)+"ms");
			
			System.out.println(result);
			
		} finally {
			if (input2 != null) {
				input2.close();
			}
			if (input1 != null) {
				input1.close();
			}
		}
		
	}
}
