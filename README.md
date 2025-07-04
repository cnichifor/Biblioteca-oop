# Biblioteca OOP

A simple C++ console application demonstrating object‑oriented design for managing a small library of books, clients, and loan operations.

---

## Project Overview

This project illustrates core OOP principles in C++ by modeling:

* **Book** — encapsulates title, author, ISBN, and availability status.
* **Client** — represents a library user with name and unique ID.
* **Library** — manages collections of books and clients, and handles borrowing/returning operations.

It provides a text‑based menu that lets the user add books/clients, search and list entries, and process loans.

---

## Project Structure

```
├── include/                # Header files
│   ├── Book.h              # Book class declaration
│   ├── Client.h            # Client class declaration
│   └── Library.h           # Library class declaration and operations
├── src/                    # Source files
│   ├── Book.cpp            # Book class definitions
│   ├── Client.cpp          # Client class definitions
│   └── Library.cpp         # Library operations (add, search, loan)
├── main.cpp                # Entry point with interactive menu
├── data/                   # (Optional) CSV files for persistence
│   ├── books.csv           # Saved book records
│   └── clients.csv         # Saved client records
├── tests/                  # Unit tests (if included)
│   └── LibraryTest.cpp     # Tests for core functionality
├── Makefile                # Build automation
└── README.md               # This file
```

---

## Features

* **Book Management**:

  * Add new books with title, author, and ISBN.
  * Search books by title or author.
  * List all books with availability status.

* **Client Management**:

  * Register clients with name and unique ID.
  * Search clients by name or ID.
  * List all registered clients.

* **Loan Processing**:

  * Borrow a book: marks it unavailable and records loan under the client.
  * Return a book: updates status and clears the loan record.
  * Prevent double‑borrowing of the same book.

* **Interactive Menu**:

  * Text‑based UI to navigate operations.
  * Input validation for menu choices and IDs.

* **Data Persistence (Optional)**:

  * Load and save books/clients to CSV files in `data/` folder.

---

## Requirements

* C++17 or newer
* Standard library only (no external dependencies)
* Make (optional) or manual compilation via `g++`

---

## Build Instructions

### Using Makefile

```bash
# Compile the project
git clone https://github.com/cnichifor/Biblioteca-oop.git
cd Biblioteca-oop
make
```

This produces the executable `biblioteca` in the project root.

### Manual Compilation

```bash
g++ -std=c++17 -Iinclude src/*.cpp main.cpp -o biblioteca
```

---

## Usage

Launch the application:

```bash
./biblioteca
```

Follow the on‑screen menu, e.g.:

```
1. Add Book
2. List Books
3. Search Book
4. Add Client
5. List Clients
6. Search Client
7. Borrow Book
8. Return Book
9. Exit
Select an option:
```

Enter the requested details when prompted.

---

## Example Session

```text
Select an option: 1
Enter title: The Hobbit
Enter author: J.R.R. Tolkien
Enter ISBN: 978-0547928227
Book added successfully.

Select an option: 4
Enter client name: Alice
Enter client ID: 1001
Client registered.

Select an option: 7
Enter client ID: 1001
Enter ISBN to borrow: 978-0547928227
Loan processed: The Hobbit is now borrowed by Alice.
```

---

## Testing

If unit tests are provided in `tests/`, compile and run:

```bash
# Example using g++ and Google Test
g++ -std=c++17 -Iinclude -I/path/to/gtest/include tests/LibraryTest.cpp src/*.cpp -L/path/to/gtest/lib -lgtest -o test_runner
./test_runner
```

---

## Potential Improvements

* **Exception Safety**: Replace error‑code returns with C++ exceptions for invalid operations.
* **GUI Front‑end**: Create a Qt or web interface to replace the console menu.
* **Database Integration**: Persist records in SQLite or another lightweight database.
* **Reporting**: Add due‑date and overdue tracking with fine calculation.
* **Modern C++**: Use smart pointers, `std::optional`, and range‑based algorithms.

---

## License

This project is licensed under the MIT License. See `LICENSE` for details.


