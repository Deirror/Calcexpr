package main.calculator.model.database;

import main.calculator.model.exception.HasSuchArgumentException;
import main.calculator.model.function.Function;

import java.io.*;
import java.util.*;

public final class FunctionDatabase {
    private static final String connection;
    private static FunctionDatabase instance;
    private static HashMap<String, Function> functions;
    private static HashSet<Function> functionsSet;

    static {
        instance = null;
        connection = System.getProperty("user.home") + "/.calcexpr/functions.dat";

        File file = new File(connection);

        //Can silently fail
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
    }

    public HashMap<String, Function> getFunctions() {
        return functions;
    }

    private FunctionDatabase()
            throws IOException {
        functions = new HashMap<>();
        functionsSet = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(connection))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String key = validKey();
                functions.put(key, Function.of(line));
                functionsSet.add(functions.get(key));
            }
        }
    }

    private static String validKey() {
        String key;
        do {
            key = generateRandomKey();
        } while(functions.containsKey(key));
        return key;
    }

    private static String generateRandomKey() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder key = new StringBuilder();
        Random random = new Random();
        final int LENGTH = 5;
        for (int i = 0; i < LENGTH; i++) {
            key.append(chars.charAt(random.nextInt(chars.length())));
        }
        return key.toString();
    }

    public static FunctionDatabase getInstance()
            throws IOException {
        if (instance == null) {
            instance = new FunctionDatabase();
        }
        return instance;
    }

    public void add(Function function) {
        if(functionsSet.contains(function)) {
            throw new HasSuchArgumentException("Function already exists");
        } else {
            functions.put(validKey(), function);
            functionsSet.add(function);
        }
    }

    public void delete(String key) {
        if(functions.containsKey(key)) {
            functionsSet.remove(functions.get(key));
            functions.remove(key);
        } else {
            throw new NoSuchElementException("Function does not exist");
        }
    }

    public Function get(String key) {
        if(functions.containsKey(key)) {
            return functions.get(key);
        } else {
            throw new NoSuchElementException("Function does not exist");
        }
    }

    public void save()
            throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(connection))) {
            for (Function function : functionsSet) {
                writer.write(function.toString());
                writer.newLine();
            }
        }
    }
}
