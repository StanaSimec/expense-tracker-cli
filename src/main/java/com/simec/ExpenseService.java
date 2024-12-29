package com.simec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simec.action.ActionNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenseService {

    private static final File file = new File("expense.json");
    private final ObjectMapper mapper;

    public ExpenseService() {
        this.mapper = new ObjectMapper();
    }

    public boolean create(String description, int amount) {
        List<Expense> expenseList = findAll();
        Expense expense = new Expense(expenseList.size() + 1, description, amount);
        expenseList.add(expense);
        return saveExpenses(expenseList);
    }

    public List<Expense> findAll() {
        try {
            Expense[] expenses = mapper.readValue(file, Expense[].class);
            return new ArrayList<>(Arrays.asList(expenses));
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public boolean deleteById(int id) {
        List<Expense> expenses = findAll();
        Expense expense = expenses.stream().filter(e -> e.getId() == id)
                .findAny()
                .orElseThrow(() -> new ActionNotFoundException("Expense not found"));
        expenses.remove(expense);
        return saveExpenses(expenses);
    }

    private boolean saveExpenses(List<Expense> expenses) {
        try {
            mapper.writeValue(file, expenses);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
