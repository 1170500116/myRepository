/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import P1.graph.Graph;

/**
 * A graph-based poetry generator.
 * 
 * <p>GraphPoet is initialized with a corpus of text, which it uses to derive a
 * word affinity graph.
 * Vertices in the graph are words. Words are defined as non-empty
 * case-insensitive strings of non-space non-newline characters. They are
 * delimited in the corpus by spaces, newlines, or the ends of the file.
 * Edges in the graph count adjacencies: the number of times "w1" is followed by
 * "w2" in the corpus is the weight of the edge from w1 to w2.
 * 
 * <p>For example, given this corpus:
 * <pre>    Hello, HELLO, hello, goodbye!    </pre>
 * <p>the graph would contain two edges:
 * <ul><li> ("hello,") -> ("hello,")   with weight 2
 *     <li> ("hello,") -> ("goodbye!") with weight 1 </ul>
 * <p>where the vertices represent case-insensitive {@code "hello,"} and
 * {@code "goodbye!"}.
 * 
 * <p>Given an input string, GraphPoet generates a poem by attempting to
 * insert a bridge word between every adjacent pair of words in the input.
 * The bridge word between input words "w1" and "w2" will be some "b" such that
 * w1 -> b -> w2 is a two-edge-long path with maximum-weight weight among all
 * the two-edge-long paths from w1 to w2 in the affinity graph.
 * If there are no such paths, no bridge word is inserted.
 * In the output poem, input words retain their original case, while bridge
 * words are lower case. The whitespace between every word in the poem is a
 * single space.
 * 
 * <p>For example, given this corpus:
 * <pre>    This is a test of the Mugar Omni Theater sound system.    </pre>
 * <p>on this input:
 * <pre>    Test the system.    </pre>
 * <p>the output poem would be:
 * <pre>    Test of the system.    </pre>
 * 
 * <p>PS2 instructions: this is a required ADT class, and you MUST NOT weaken
 * the required specifications. However, you MAY strengthen the specifications
 * and you MAY add additional methods.
 * You MUST use Graph in your rep, but otherwise the implementation of this
 * class is up to you.
 */
public class GraphPoet {
    
    private final Graph<String> graph = Graph.empty();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    /**
     * Create a new poet with the graph from corpus (as described above).
     * 
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
    	
	    BufferedInputStream bis =null;
	    FileInputStream fis = null;
		fis = new FileInputStream(corpus);
		bis = new BufferedInputStream(fis);
		StringBuffer sb = new StringBuffer();
		
		while(bis.available()>0) {
			sb.append((char)bis.read());
		}
		String s = sb.toString();
		String dest = "";
		if (s!=null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(s);
			dest = m.replaceAll(" ");
		}
		String [] spString = dest.split("\\s+");
		for(String ss : spString){		
		    graph.add(ss.toLowerCase());		    
		}
		for(int i=0;i<spString.length-1;i++) {
			if(graph.targets(spString[i]).containsKey(spString[i+1])) {
				int w = graph.targets(spString[i]).get(spString[i+1]);
				graph.set(spString[i], spString[i+1], w+1);
			}else {
				graph.set(spString[i], spString[i+1], 1);
			}
		}	
	    //System.out.println(graph.toString());
    }
    
    // TODO checkRep
    
    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
    	String dest = "";
    	if (input!=null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(input);
			dest = m.replaceAll(" ");
		}
    	
		String [] spString = dest.split("\\s+");		
		StringBuffer ans = new StringBuffer();
		for(int i=0;i<spString.length-1;i++) {
			Map<String, Integer> map = graph.targets(spString[i].toLowerCase());
			Map<String, Integer> map1 = graph.sources(spString[i+1].toLowerCase());
			int weight = 0;
			String insert ="";			
			if(map!=null&&map1!=null) {
				for (String key : map.keySet()) { 
					for (String key1 : map1.keySet()) { 
						
						if(key.equals(key1)){
							int myweight = map.get(key)+map1.get(key1);
							if(myweight>weight) {
								insert = key;
								weight = myweight;
							}
						}
					}
				} 
			}			
			ans.append(spString[i]);
			if(weight!=0) {
				ans.append(" "+insert+" ");
			}else {
				ans.append(" ");
			}
			
		}
		ans.append(spString[spString.length-1]);
		return ans.toString();
    }
    
    // TODO toString()
    
}
