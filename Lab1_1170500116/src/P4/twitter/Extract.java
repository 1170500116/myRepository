/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
    	Instant start = Instant.parse("1970-01-01T00:00:00Z");
    	Instant end = Instant.parse("1970-01-01T00:00:00Z");

    
    	for(int i=0;i<tweets.size();i++) {
    		if(start.getEpochSecond()== 0) {
    			start = tweets.get(i).getTimestamp();
    		}else {
    			if( tweets.get(i).getTimestamp().getEpochSecond()<start.getEpochSecond()) {
    				start = tweets.get(i).getTimestamp();
    			}
    		}
    		if(end.getEpochSecond()== 0) {
    			end = tweets.get(i).getTimestamp();
    		}else {
    			if( tweets.get(i).getTimestamp().getEpochSecond()>start.getEpochSecond()) {
    				end = tweets.get(i).getTimestamp();
    			}
    		}
    	}
    	return new Timespan( start, end);
    	
    	
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
    	Set<String> s = new HashSet<>();
        for(int i=0;i<tweets.size();i++) {
        	
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
        }
        return s;
    }

}
