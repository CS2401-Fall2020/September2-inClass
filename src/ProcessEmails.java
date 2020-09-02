

public class ProcessEmails {

  public static void main(String[] args) {
    
    // Collect email addresses
    String[] emails = GenerateRandomEmails.generateRandomEmails(10);

    // Print addresses to verify
    // using a basic for loop
    /*for(int i=0; i<emails.length; i++) {
      System.out.println(emails[i]);
    }*/
    
    // using an enhanced for loop
    /*int i=0;
    for(String singleEmail: emails) {
      System.out.println(singleEmail + " - " + getDomainFromEmail(singleEmail) + " - " + countDomainInSubArray(emails,getDomainFromEmail(singleEmail), 0, i));
      i++;
    }*/
    String[] uniq = uniqueDomains(emails);
    for(String domain: uniq) {
      System.out.println("Domain: " + domain);
    }
    
  }
  
  
  // Given a list of email addresses, 
  // return a new array of only the unique domains 
  // (the number of unique domains is unknown to start, you will need to count them)
  public static String[] uniqueDomains(String[] emails) {
    Boolean[] firstAppear = new Boolean[emails.length];
    for(int i=0; i<emails.length; i++) {
      firstAppear[i] = (countDomainInSubArray(emails,getDomainFromEmail(emails[i]), 0, i) == 1);
      //System.out.println(emails[i] + " - " + firstAppear[i]);
    }
    int numUniq = 0;
    for(int i=0; i<emails.length; i++) {
      if(firstAppear[i]) {
        numUniq++;
      }
    }
    System.out.println("Number of Unique: " + numUniq);
    String[] uniqDomains = new String[numUniq];
    
    int uniqCounter = 0; 
    for(int i=0; i<emails.length; i++) {
      if(firstAppear[i]) {
        uniqDomains[uniqCounter++] = getDomainFromEmail(emails[i]);
      }
    }
    /*
    int i = 0;
    for(int j=0; j<numUniq; j++) {
      while(!firstAppear[i]) {
        i++;
      }
      uniqDomains[j] = getDomainFromEmail(emails[i++]);
    }*/
    
    return uniqDomains;
  }
  
  // For a given range, and a search domain, 
  // find the number of email addresses in the range (inclusive) with that domain
  public static int countDomainInSubArray(String[] emails, String domain, int start, int end) {
    int count = 0; 
    for(int i=start; i<=end; i++) {
      if(getDomainFromEmail(emails[i]).equals(domain)) {
        count++;
      }
    }
    return count;
  }

  // Find the domain in a string (i.e. the substring after '@')
  public static String getDomainFromEmail(String email) {
    // .charAt()
    // .length()
    // .substring()
    
    int indexOfAt = 0;
    // Afk0H@miners.utep.edu
    //      ^
    
    // find it
    while(email.charAt(indexOfAt) != '@') {
      indexOfAt++;
    }
    
    assert(email.charAt(indexOfAt) == '@');
    return email.substring(indexOfAt + 1);
  }

}
