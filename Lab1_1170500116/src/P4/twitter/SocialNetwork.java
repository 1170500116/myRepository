/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
    	Map<String, Set<String>> map = new HashMap<>();
        for(int i=0;i<tweets.size();i++) {
        	Set<String> s = new HashSet<>();
        	for(int j=0;j<tweets.size();j++) {
        		if(j==i) {
        			continue;
        		}

        		
        		if(tweets.get(i).getText().toLowerCase().contains("@"+tweets.get(j).getAuthor().toLowerCase())) {
        			if(tweets.get(i).getText().length()>tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1) {
        				
        				String pattern = "(^[a-zA-Z])";
        				if(pattern.compareTo(""+tweets.get(i).getText().toLowerCase().charAt(tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1))<-82||pattern.compareTo(""+tweets.get(i).getText().toLowerCase().charAt(tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1))>-25) {

        					if((""+tweets.get(i).getText().toLowerCase().charAt(tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1)).equals(".")) {
        						
        						
        						if(tweets.get(i).getText().toLowerCase().length()>tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1+1) {

        							if(pattern.compareTo(""+tweets.get(i).getText().toLowerCase().charAt(tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1+1))<-82&&pattern.compareTo(""+tweets.get(i).getText().toLowerCase().charAt(tweets.get(i).getText().toLowerCase().indexOf("@"+tweets.get(j).getAuthor().toLowerCase())+tweets.get(j).getAuthor().length()+1+1))>-25) {
        								
        								s.add(tweets.get(j).getAuthor().toLowerCase());
        							}
        						}else {
        							s.add(tweets.get(j).getAuthor().toLowerCase());
        						}
        					}else {
        						s.add(tweets.get(j).getAuthor().toLowerCase());
        					}
        					
        				}
        			}else {
        				s.add(tweets.get(j).getAuthor().toLowerCase());
        				
        			}
        		}
        	}
        	if(s.size()!=0) {
        		map.put(tweets.get(i).getAuthor().toLowerCase(), s);
        	}
        	
        }
    	return map;
    }

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
    	List<String> s = new ArrayList<>();
    	Map<String,Integer> map  = new HashMap<>();
    	Set<String> mapSet = followsGraph.keySet(); 
    	Iterator<String> itor = mapSet.iterator();
    	while(itor.hasNext()){
    		String key = itor.next();
    		Iterator<String> i = followsGraph.get(key).iterator();
    		while(i.hasNext()) {
    			String name = i.next();
    			if(map.get(name)==null) {
    				map.put(name, 1);
    			}else {
    				Integer a = map.get(name) +1;
    				map.put(name, a);
    			}
    		}
    	}
    	
    	Iterator<String> itor3 = mapSet.iterator();
    	while(itor3.hasNext()){
    		String key = itor3.next();
    		map.putIfAbsent(key, 0);
    	}
    	
    	while(map.size()>0) {
    	Set<String> mapSet2 = map.keySet(); 
    	Iterator<String> itor2 = mapSet2.iterator();
    	String maxname  = "";
    	String key= "";
    	Integer max = -1;
    	while(itor2.hasNext()){
    		key = itor2.next();
    		if(map.get(key)>max) {
    			max = map.get(key);
    			maxname = key;			
    		}
    	}
    	s.add(maxname.toLowerCase());
    	map.remove(maxname);
    	}
    	
    	return s;
    	
    }

}
