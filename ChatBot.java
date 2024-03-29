import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.Set;

/**
 * This class implements Chatty and extends Robot
 * It is a simple model of a ChatBot class
 * 
 * @author Michael Bamikunle
 * @version v 1.0 07/12/2023
 */
public class ChatBot extends Robot implements Chatty {

    // AI level of the chatbot
    private int level;

    // A list of friends of the chatbot
    private final List<ChatBot> friends;

    // A list of chats made by the chatbot
    private final List<String> chatRecords;
    
    //A Random Int Generator of the ChatBot class
    private Random rand;

    /**
     * Create a chatbot
     *
     * @param name  A given name
     * @param level A a given level
     */
    public ChatBot(String name, int level) {

        // Constructs the chat bot
        super(name);
        if (level >= LEVEL_MIN && level <= LEVEL_MAX) {
            this.level = level;
        }
        else if (level < LEVEL_MIN) {
            this.level = LEVEL_MIN;
        }
        else if (level > LEVEL_MAX) {
            this.level = LEVEL_MAX;
        }
        friends = new ArrayList<>();
        chatRecords = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Add a friend of the chatbot to the friends list
     * The added bot must not be null and must not already
     * be in the friend list
     * @param bot A given chatbot
     */
    public void addFriend(ChatBot bot) {

        /* Add only new bots that are not in the friends list already 
         * Also does not allow null bots to be added
        */
        if (!friends.contains(bot) && bot != null) {
                friends.add(bot);
        }
    }
    
    /**
     * This method tries to tell us if the ChatBot is associated with an
     * AI
     * This is determined based on the level of the ChatBot
     * @return true or false
     */
    
    @Override
    public boolean hasAI() {
        if (level > LEVEL_MIN) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Generates and returns a random Question which depends on the Chatbot having
     * an AI or the ChatBot's level
     * @return String question randomly generated
     */
    
    @Override
    public String question() {
        List <String> questionsArray = new ArrayList<>();
        questionsArray.addAll(QA.keySet());
        if (!hasAI()) {
            addChatRecord('Q', "Good");
            return "Good";
        } 
        
        else if (hasAI() && level > LEVEL_MIN && level < LEVEL_MAX) {
            
            String randomQuestion1 = questionsArray.get(rand.nextInt(questionsArray.size()));
            addChatRecord('Q', randomQuestion1);
            return randomQuestion1;
        }
        else if (hasAI() && level == LEVEL_MAX && chatRecords.isEmpty()){
            String randomQuestion2 = questionsArray.get(rand.nextInt(questionsArray.size()));
            addChatRecord('Q', randomQuestion2);
            return randomQuestion2;
        }
            
        else if (hasAI() && level == LEVEL_MAX && !chatRecords.isEmpty()) {
            String randomQuestion3 = questionsArray.get(rand.nextInt(questionsArray.size()));
            
            ArrayList<String> onlyQuestions = new ArrayList<>();
            for (String strings: chatRecords) {
                if(strings.substring(0,1).equals("Q")) {
                    onlyQuestions.add(strings);    
                }
            }
            
            var lastQuestion = onlyQuestions.get(onlyQuestions.size() -1);
            if (!lastQuestion.contains(randomQuestion3)) {
                    addChatRecord('Q', randomQuestion3);
                    return randomQuestion3;
            }
            else {
                return question();
            }
        }
        else {
            return question();    
        }
    
    }
    
    
    
    /**
     * Generates and returns an answer which is dependent 
     * on if the ChatBot is associated with an AI or the question
     * being asked
     * @return String answer 
     * @params String the question 
     */
    
    @Override
    public String answer(String question) {
        if (!hasAI()) {
            String noAIAnswer = "Excellent";
            addChatRecord('A', noAIAnswer);
            return noAIAnswer;
            
        }
        
        else {
            if (!QA.containsKey(question)) {
                String AIAnswer1 = "Interesting question";
                addChatRecord('A', AIAnswer1);
                return AIAnswer1;
            }
            
            else {
                String AIAnswer2 = QA.get(question);
                addChatRecord('A', AIAnswer2);
                return AIAnswer2;
            }
        }
    } 
    
    /**
     * This method returns an Array containing the Unique number of questions
     * Randomly generated by the ChatBot and also the unique number of answers
     * the ChatBot answered.
     * @return The Array of the number of unique questions and answers
     */
    public int [] getChatStats() {
        int [] statsArray = new int[2];
        
        List<String> allQuestions = new ArrayList<>();
        List<String> allAnswers = new ArrayList<>();
        
        for (String chatrec: chatRecords) {
            if (chatrec.substring(0,1).equals("A")) {
                allAnswers.add(chatrec);    
            }
            else if (chatrec.substring(0,1).equals("Q")) {
                allQuestions.add(chatrec);
            }
        }
        
        Set<String> qSet = new TreeSet<>(allQuestions);
        Set<String> aSet = new TreeSet<>(allAnswers);
        
        statsArray[0] = qSet.size(); 
        statsArray[1] = aSet.size();
        
        return statsArray;
    }


    
    
    
    

    //////////////////////////////////////////////////////////////////////////////////
    /////////    PLEASE DO NOT CHANGE CODE BELOW THIS LINE    ////////////////////////

    /**
     * Get the chatbot's level
     *
     * @return The level of the Chatbot
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get the chatbot's friends
     *
     * @return The list of friends of the Chatbot
     */
    public List<ChatBot> getFriends() {
        return friends;
    }

    /**
     * Get the chatbot's chat records
     *
     * @return The list of chats made by the chatbot
     */
    public List<String> getChatRecords() {
        return chatRecords;
    }

    /**
     * Add a chat by the chatbot in chatRecord
     * 
     * Each chat record is prefixed
     * by "Q:" for a question
     * or "A:" for an answer
     * e.g. if the chatbot asks a question "How are you?",
     * the string "Q:How are you?" will be added in the chatRecords
     *
     * @param type  A type of the chat, either 'Q' or 'A'
     * @param chat  A chat message
     */
    public void addChatRecord(char type, String chat) {
        if (type == 'Q' || type == 'A') {
            chatRecords.add(type + ":" + chat);
        }
        else {
            System.out.println("Wrong type of the chat.");
        }
    }

    /**
     * Check if the given object is the same as the chatbot
     * 
     * @param obj A given object
     * @return true if obj is a ChatBot with the same name and level,
     *         false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatBot)) {
            return false;
        }
        
        ChatBot bot = (ChatBot) obj;
        return super.equals(bot) && level == bot.getLevel();
    }
    
}