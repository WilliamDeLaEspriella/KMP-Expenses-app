package org.example.project.data

import org.example.project.model.Expense
import org.example.project.model.ExpenseCategory

object ExpenseManager {
    private var currentId = 1L

    var fakeExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.GROCERIES,
            description = "Wekly1"
        ),
        Expense(
            id = currentId++,
            amount = 1233.0,
            category = ExpenseCategory.SNACK,
            description = "Wekly2"
        ),
        Expense(
            id = currentId++,
            amount = 123.0,
            category = ExpenseCategory.PARTY,
            description = "Wekly3"
        ),
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.HOUSE,
            description = "Wekly4"
        ),
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.COFFEE,
            description = "Weklyd5"
        )
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { fakeExpense ->
            fakeExpense.id == expense.id
        }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                id = expense.id,
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory>{
        return listOf(
            ExpenseCategory.COFFEE,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACK,
            ExpenseCategory.GROCERIES,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSE
        )
    }
}

