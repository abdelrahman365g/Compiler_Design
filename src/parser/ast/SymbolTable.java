package ast;

import java.util.*;

public class SymbolTable {
    
    public static class Symbol {
        String name;
        String type;
        String scopeName;
        
        public Symbol(String name, String type, String scopeName) {
            this.name = name;
            this.type = type;
            this.scopeName = scopeName;
        }
        
        @Override
        public String toString() {
            return String.format("| %-15s | %-10s | %-15s |", name, type, scopeName);
        }
    }

    private Stack<Map<String, Symbol>> scopes = new Stack<>();
    private List<Symbol> allSymbols = new ArrayList<>();
    
    private String currentScopeName = "Global";

    public SymbolTable() {
        scopes.push(new HashMap<>());
    }

    public void enterScope(String scopeName) {
        currentScopeName = scopeName;
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
            currentScopeName = "Previous Scope"; 
        }
    }

    public void insert(String name, String type) {
        Map<String, Symbol> currentScope = scopes.peek();
        if (currentScope.containsKey(name)) {
            System.err.println("Semantic Error: Variable '" + name + "' is already declared in scope " + currentScopeName);
        } else {
            Symbol s = new Symbol(name, type, currentScopeName);
            currentScope.put(name, s);
            allSymbols.add(s);
        }
    }

    public boolean lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    public void printTable() {
        System.out.println("-------------------------------------------------------");
        System.out.println(String.format("| %-15s | %-10s | %-15s |", "Name", "Type", "Scope"));
        System.out.println("-------------------------------------------------------");
        for (Symbol s : allSymbols) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
}