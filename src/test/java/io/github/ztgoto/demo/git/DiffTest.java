package io.github.ztgoto.demo.git;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import difflib.DiffUtils;
import difflib.Patch;

@RunWith(BlockJUnit4ClassRunner.class)
public class DiffTest {

	@Test
	public void testDiff() throws IOException {
		
		InputStream input1 = null;
		
		InputStream input2 = null;
		
		try {
			input1 = this.getClass().getClassLoader().getResourceAsStream("Speedtest1.txt");
			
			input2 = this.getClass().getClassLoader().getResourceAsStream("Speedtest2.txt");
			
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
}
