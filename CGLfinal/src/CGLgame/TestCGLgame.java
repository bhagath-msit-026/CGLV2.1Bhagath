package CGLgame;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class TestCGLgame {

	@Test
	public void testCreateBoard() throws FileNotFoundException {
		Boolean n[][]= {{false,false,false,false,false,false,false,false,false,false},
				{false,false,false,true,true,false,false,false,false,false},
				{false,false,false,false,true,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false},
				{false,false,false,true,true,false,false,false,false,false},
				{false,false,true,true,false,false,false,false,false,false},
				{false,false,false,false,false,true,false,false,false,false},
				{false,false,false,false,true,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false}};
		CGLgame cg=new CGLgame("./input001.txt");
		Assertions.assertEquals(Arrays.deepToString(n),(Arrays.deepToString(cg.ReadInput())));
				
		}
	@Test
	public void testPrintBoard() throws FileNotFoundException{
		String str="..........\n"
				+ "...**.....\n"
				+ "....*.....\n"
				+ "..........\n"
				+ "..........\n"
				+ "...**.....\n"
				+ "..**......\n"
				+ ".....*....\n"
				+ "....*.....\n"
				+ "..........\n";
		CGLgame cg=new CGLgame("./input001.txt");
		Assertions.assertEquals(str,cg.printInput());
	}
	@Test
	public void NextGeneration() throws FileNotFoundException{
		String str="..........\n"
				+ "...**.....\n"
				+ "...**.....\n"
				+ "..........\n"
				+ "..........\n"
				+ "..***.....\n"
				+ "..**......\n"
				+ "...**.....\n"
				+ "..........\n"
				+ "..........\n";
		CGLgame cg=new CGLgame("./input001.txt");
		
	}

}

