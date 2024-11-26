//package me.parsa.menulobby.Handlers;
//
//import org.yaml.snakeyaml.Yaml;
//
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MessageHandler {
//
//    private Map<String, Object> messages;
//
//    public void loadMessages() {
//        Yaml yaml = new Yaml();
//
//        try (InputStream input = getClass().getResourceAsStream("/messages.yml")) {
//            if (input != null) {
//                messages = (Map<String, Object>) yaml.load(input); // Load messages.yml into a Map
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getMessage(String key, Map<String, String> variables) {
//        // Get the message template from the YAML file
//        String message = (String) ((Map<String, Object>) messages.get("messages")).get(key);
//
//        // Replace placeholders with values
//        if (message != null && variables != null) {
//            for (Map.Entry<String, String> entry : variables.entrySet()) {
//                String placeholder = "${" + entry.getKey() + "}";
//                message = message.replace(placeholder, entry.getValue());
//            }
//        }
//        return message;
//    }
//
////    public static void main(String[] args) {
////        Map<String, String> variables = new HashMap<>();
////        variables.put("player", "Parsa");
////
////        // Example usage
////        MessageHandler handler = new MessageHandler();
////        handler.loadMessages();
////        String welcomeMessage = handler.getMessage("welcome", variables);
////        System.out.println(welcomeMessage);
////    }
//}
