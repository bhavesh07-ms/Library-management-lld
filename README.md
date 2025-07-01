# Library-management-lld

## 📘 UML Overview

![image](https://github.com/user-attachments/assets/c69a3e2a-d5a1-4dfc-bcf9-86d42a6ea60d)

# 📚 Library Management System (LLD)

A **Low-Level Design (LLD)** project implementing a scalable and extensible Library Management System using **Java**, **OOP principles**, and standard **design patterns** like **Strategy**, **Composition**, and **Separation of Concerns**.  
This project closely follows real-world software development practices with modular services, interface-driven design, and extensible class structure.

---

## ✅ Problem Statement

Design and implement a **Library Management System** that enables:

- 📖 Book management (Add, Remove, Search)
- 👤 Patron management (Add, Update, Track Borrow History)
- 🔁 Borrow and return flow with overdue tracking
- 🔎 Flexible search functionality (title, author, ISBN)

> The goal is to simulate real-world responsibilities of a library system through clean, testable, and maintainable Java code.

---

## 🏗️ Project Structure


Library-management-lld/
├── model/ # Core domain models (Book, Patron, Librarian, etc.)
├── repository/ # In-memory data stores (e.g., Inventory)
├── service/ # Business logic: lending, inventory, patron services
│ └── strategy/ # Strategy pattern implementation for search
├── app/ # Entry point for running the system
└── README.md # You are here


---



- **Composition & Aggregation**
  - `Library` owns `List<Patrons>` and `List<Librarians>` (Composition).
  - `InventoryService`, `BookService`, and `LendingService` use `Inventory` (Aggregation).

- **Interfaces**
  - `User`: Implemented by `Librarian` and `Patron`
  - `BookSearchStrategy`: Enables pluggable search strategies (title/author search)

- **BorrowInfo** tracks:
  - Which book a patron borrowed
  - Borrow date and return period
  - Overdue status

---

## 🧠 Design Principles Followed

| Principle | Application |
|----------|-------------|
| **Single Responsibility Principle (SRP)** | Each service class handles one domain: lending, patron, inventory |
| **Open/Closed Principle** | Search strategy supports new filters without modifying core logic |
| **Composition over Inheritance** | Library aggregates inventory and user collections |
| **Dependency Injection** | Services receive repositories via constructor |
| **Encapsulation** | Book and Patron maintain internal state and expose clean APIs |

---

## 🧩 Key Functionalities

- **Book Operations**
  - Add/Remove/Search (title, author, ISBN)
  - Track all book statuses (available, borrowed)

- **Patron Operations**
  - Borrow and return books
  - Get overdue books
  - View borrowing history

- **Inventory**
  - Maintains master book list
  - Optimized with both `List` and `Map` for lookup

- **Strategy Pattern**
  - Easily extendable search logic via strategy interface

- **Overdue Tracking**
  - Auto-check and list overdue books using `isReturnPeriodOver()`

---

## 🔍 Sample Class Relationships

```java
// Search strategy usage
SearchService searchService = new SearchService(inventory);
searchService.setStrategy(new SearchByTitle());
searchService.search("Clean Code");

// Borrowing logic
lendingService.borrowBook(patron, "1234", 7);

// Overdue check
bookService.isAnyBookOverdue();


