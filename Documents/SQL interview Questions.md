# SQL interview questions

## Q. What are procedures and functions in SQL?
In SQL, both stored procedures and functions are reusable blocks of code used to perform specific tasks, but they differ in their purpose and behavior. Procedures are primarily used for data manipulation and can be called to execute a set of SQL statements, potentially changing the database. Functions, on the other hand, are designed for calculations and always return a single value, making them suitable for operations like data transformation or retrieving computed values.  
Key Differences:  

* Purpose:  
  * Procedures: Primarily for data manipulation (e.g., inserting, updating, deleting data).
  * Functions: Primarily for calculations and returning a single value.

* Return Value:  
	* Procedures: Can return multiple values, a single value, or no value at all. They can modify the database data.  
	* Functions: Always return a single value.

* Usage:
	* Procedures: Can be called directly or indirectly through other procedures or SQL statements.  
	* Functions: Can be used within SQL statements, including `SELECT`, `INSERT`, `UPDATE`, and `DELETE`.  

* Data Modification:
	* Procedures: Can modify data in the database (e.g., using DML statements like `INSERT`, `UPDATE`, `DELETE`).
	* Functions: Generally, they cannot modify data in the database.  

* Example:
	* Procedure: A procedure might be used to update product inventory levels when a sale occurs.  
	* Function: A function might be used to calculate the total cost of items in a shopping cart.

---
## Q. What are views and temporary tables in SQL?
In database management, both views and temporary tables offer ways to present and work with data without storing it physically in the main database tables, but they differ in their persistence and usage. Views are virtual representations of data, reflecting the latest underlying data changes, while temporary tables store a copy of data within a specific session and are deleted when that session ends. 

* **Views**:
  * _Virtual Representations_: Views are not actual data storage; they are like virtual tables based on SQL queries.
  * _Dynamic Updates_: When a view is accessed, the data is retrieved from the underlying tables, ensuring it reflects the latest changes.
  * _Abstraction_: Views can hide complex table structures or data transformations, providing a simplified interface for users or applications.
  * _Security_: Views can be used to restrict access to specific columns or rows, improving security.
  * _Reusability_: Views can be used multiple times in different queries or stored procedures, saving time and effort.
  * _Persistence_: Views persist until they are explicitly dropped or the database is altered.

* **Temporary Tables**:
  * _Data Storage_: Temporary tables physically store data, similar to regular tables, but within a temporary storage area (often the tempdb database).
  * _Session-Based_: Temporary tables are created and exist only for the duration of the database session in which they were created.
  * _Data Copy_: A temporary table holds a copy of the data, and it is not synchronized with the underlying tables.
  * _Multi-Step Operations_: Temporary tables are often used to store intermediate results in multi-step queries or procedures, improving efficiency and reducing the need to repeatedly execute complex queries.
  * _Performance_: Temporary tables can improve performance by avoiding repeated execution of complex queries or by allowing the use of indexes on the temporary data.
  * _Explicit Management_: Temporary tables can be created, altered, and dropped explicitly, providing greater control.

**Key Differences:** 

| Feature | View | Temporary Table  |
| --- | --- | --- |
| Data Storage | Virtual (not physically stored) | Physically stored (in tempdb)  |
| Persistence | Persists across sessions | Limited to the current session  |
| Data Synchronization | Reflects latest data in underlying tables | Does not synchronize with underlying tables  |
| Use Cases | Abstraction, reusability, security | Intermediate data storage, performance  |

---
## Q. How do you optimize SQL queries?
To optimize SQL queries, focus on efficient indexing, minimizing data retrieval, and optimizing join operations. Avoid `SELECT *` and use `UNION ALL` instead of `UNION` for better performance. Also, consider database-specific features like partitioning and stored procedures.

* **Elaboration:**
 * _Indexing_: Create indexes on columns frequently used in `WHERE`, `JOIN`, `ORDER BY`, and `GROUP BY` clauses. Indexes act like an index in a book, allowing the database to quickly locate specific data.
 * _Data Retrieval_: Avoid fetching unnecessary data by specifying only the required columns in the `SELECT` statement and limiting the amount of data retrieved. This reduces network traffic and improves query speed.
 * _Join Optimization_: Choose appropriate join types (e.g., `INNER JOIN` instead of `OUTER JOIN` when possible) and optimize the order of joins to minimize the number of tables involved in a single query.
 * _Subqueries_: Minimize the use of subqueries as they can impact performance. Consider using `JOIN` or `EXISTS` instead of `IN` for subqueries.
 * _Database-Specific Features_: Utilize database-specific features like partitioning (splitting data into smaller, more manageable chunks) and stored procedures (pre-compiled SQL code that can be executed more efficiently).
 * _Other Techniques_: Use `UNION ALL` instead of `UNION` when you don't need to remove duplicate rows. Optimize `WHERE` clauses by avoiding functions in predicates and using the `LIKE` operator with wildcards at the end of a string.
 * _Monitoring_: Regularly monitor query performance to identify bottlenecks and optimize queries accordingly.

---
## Q. Second Highest Salary in SQL  
### From a single table
```sql
SELECT DISTINCT salary 
FROM employees 
ORDER BY salary DESC 
LIMIT 1 OFFSET 1;
```

This query:
- Removes duplicates with `DISTINCT`
- Orders salaries in descending order
- Skips the highest salary (`OFFSET` 1)
- Limits result to 1 row (`LIMIT` 1)


### With multiple table
```sql
SELECT DISTINCT salary
FROM (
    SELECT salary FROM Employee1
    UNION ALL
    SELECT salary FROM Employee2
) AS combined
ORDER BY salary DESC
LIMIT 1 OFFSET 1;
```
```sql
SELECT MAX(S.Salary)
FROM Employees AS E
JOIN Salaries AS S ON E.EmployeeID = S.EmployeeID
WHERE S.Salary < (SELECT MAX(S2.Salary) FROM Salaries AS S2);
```

---
## Q. Find Employees Who Are Managers  
```sql
SELECT e1.name FROM emp e1 JOIN emp e2 ON e1.emp_id = e2.emp_mgr_id;
```
---
## Q. MySQL vs PostgreSQL: A Detailed Comparison  

| Feature            | **MySQL**  | **PostgreSQL**  |
|--------------------|-----------|----------------|
| **Architecture**  | Relational Database (RDBMS) | Object-Relational Database (ORDBMS) |
| **ACID Compliance** | Fully ACID-compliant (with InnoDB) | Fully ACID-compliant |
| **Performance**  | Faster for **read-heavy** workloads | Better for **write-heavy** and complex queries |
| **SQL Compliance** | Partially SQL-compliant | More SQL-compliant (supports advanced SQL features) |
| **Indexing** | Supports B-Tree, Full-text, and Hash Indexing | Supports B-Tree, Hash, GiST, GIN, BRIN Indexing |
| **JSON Support** | Basic JSON functions | Advanced JSON and JSONB support |
| **Concurrency Control** | Uses **row-level locking** (InnoDB) | Uses **MVCC (Multi-Version Concurrency Control)** |
| **Replication** | Supports Master-Slave & Group Replication | Supports Master-Slave, Logical & Streaming Replication |
| **Partitioning** | Limited support (Range & List) | Advanced Partitioning (Range, List, Hash) |
| **Stored Procedures** | Supports **PL/SQL-like** syntax | Supports **PL/pgSQL**, Python, Java, etc. |
| **Extensions & Customization** | Limited extensibility | Highly extensible (e.g., TimescaleDB, PostGIS) |
| **Security** | Basic authentication & SSL | Advanced security with role-based access, RLS |
| **Use Cases** | Web applications, CMS (e.g., WordPress, Joomla) | Data analytics, OLAP, GIS, complex queries |

### **Which One to Choose?**
- **Choose MySQL if:** You need a simple, fast, and lightweight database for web apps.  
- **Choose PostgreSQL if:** You need complex queries, high scalability, and advanced features like JSON, GIS, and full ACID compliance.

---

## Q. Duplicate records from a table.
| EmployeeID | FirstName | LastName | Email                   | Department | Salary  | HireDate   |
|------------|-----------|----------|-------------------------|------------|---------|------------|
| 1          | John      | Doe      | john.doe@example.com    | Sales      | 50000.00| 2023-01-15 |
| 2          | Jane      | Smith    | jane.smith@example.com  | Marketing  | 60000.00| 2022-05-20 |
| 3          | Peter     | Jones    | peter.jones@example.com | IT         | 75000.00| 2024-03-01 |
| 4          | John      | Doe      | john.doe@example.com    | Sales      | 50000.00| 2023-01-15 |
| 5          | Alice     | Brown    | alice.brown@example.com | HR         | 55000.00| 2023-11-10 |
| 6          | Jane      | Smith    | jane.smith@example.com  | Marketing  | 60000.00| 2022-05-20 |
| 7          | Peter     | Jones    | p.jones@sample.com      | IT         | 78000.00| 2024-04-01 |
| 8          | David     | Wilson   | david.wilson@example.com| Finance    | 65000.00| 2023-07-01 |

```
SELECT * 
FROM your_table 
WHERE your_column IN (
    SELECT your_column 
    FROM your_table 
    GROUP BY your_column 
    HAVING COUNT(*) > 1
);
```
**OR**
```
SELECT FirstName, LastName, Email, Department, Salary, HireDate, COUNT(*) AS DuplicateCount
FROM Employee
GROUP BY FirstName, LastName, Email, Department, Salary, HireDate
HAVING COUNT(*) > 1;
```

---
## Q.  SQL vs NoSQL  
| SQL | NoSQL |
|-----|-------|
| Structured | Unstructured |
| Fixed Schema | Dynamic Schema |
| ACID | BASE |

---
## Q. `WHERE` vs `HAVING` in sql
In SQL, `WHERE` and `HAVING` clauses are used for filtering data, but they operate at different levels. `WHERE` filters rows based on conditions applied to individual columns before any grouping or aggregation. `HAVING` filters groups of rows based on conditions involving aggregate functions like `COUNT`, `SUM`, or `AVG`, and it's always used with `GROUP BY`. 

Here's a more detailed breakdown: 
### `WHERE` Clause: 

- Purpose: Filters rows in a table based on conditions. 
- Scope: Applies to individual rows, not groups. 
- Timing: Used before `GROUP BY` clause. 
- Aggregate Functions: Cannot be used directly with aggregate functions. 
- Example: `SELECT * FROM employees WHERE salary > 50000`;  

### `HAVING` Clause:

- Purpose: Filters groups of rows after they've been grouped by `GROUP BY`. 
- Scope: Applies to the results of aggregate functions. 
- Timing: Used after `GROUP BY` clause. 
- Aggregate Functions: Required to be used with aggregate functions like `COUNT`, `SUM`, `AVG`. 
- Example: `SELECT department, COUNT(*) FROM employees GROUP BY department HAVING COUNT(*) > 5`; 

### Key Differences: 

| Feature | WHERE | HAVING  |
| --- | --- | --- |
| Scope | Individual rows | Groups of rows  |
| Timing | Before `GROUP BY` | After `GROUP BY`  |
| Aggregate Functions | Not allowed | Allowed (with `GROUP BY`)  |
| Purpose | Filtering individual rows | Filtering grouped data  |

In essence, `WHERE` filters the data before grouping, while `HAVING` filters the data after grouping, based on the results of aggregate functions.

---
## Q. What is Partitioning in databases?
Partitioning in databases is a design technique used to divide a large database into smaller, more manageable pieces, called partitions. Each partition can be treated as an independent unit, which can improve performance, manageability, and availability. Partitioning is particularly useful for large datasets and can help optimize query performance and maintenance tasks.

### Key Concepts of Database Partitioning

1. **Definition**: Partitioning is the process of splitting a database table into smaller, more manageable pieces while still treating it as a single logical entity.

2. **Types of Partitioning**:
   - **Horizontal Partitioning**: Divides a table into rows. Each partition contains a subset of the rows based on a specified criterion (e.g., date ranges, geographic regions).
   - **Vertical Partitioning**: Divides a table into columns. Each partition contains a subset of the columns, which can be useful for optimizing queries that only need a few columns.
   - **Range Partitioning**: Rows are distributed based on a specified range of values (e.g., dates).
   - **List Partitioning**: Rows are distributed based on a list of values (e.g., specific categories).
   - **Hash Partitioning**: Rows are distributed based on a hash function applied to a specified column, ensuring an even distribution of data.
   - **Composite Partitioning**: Combines multiple partitioning strategies, such as range and hash partitioning.

3. **Benefits of Partitioning**:
   - **Improved Performance**: Queries can be faster because they can scan only the relevant partitions instead of the entire table.
   - **Easier Maintenance**: Maintenance tasks (e.g., backups, index rebuilding) can be performed on individual partitions without affecting the entire table.
   - **Enhanced Manageability**: Large tables can be managed more easily by breaking them into smaller, more manageable pieces.
   - **Increased Availability**: If one partition becomes unavailable, the others can still be accessed, improving overall system availability.

4. **Considerations**:
   - **Complexity**: Partitioning can add complexity to the database design and management.
   - **Overhead**: There may be some overhead associated with managing partitions, especially if the partitioning strategy is not well thought out.
   - **Query Optimization**: Not all queries will benefit from partitioning; it’s essential to analyze query patterns to determine if partitioning is appropriate.

### Example of Partitioning

Here’s a simple example of how you might implement range partitioning in SQL:

```sql
CREATE TABLE sales (
    id INT,
    sale_date DATE,
    amount DECIMAL(10, 2)
)
PARTITION BY RANGE (YEAR(sale_date)) (
    PARTITION p2020 VALUES LESS THAN (2021),
    PARTITION p2021 VALUES LESS THAN (2022),
    PARTITION p2022 VALUES LESS THAN (2023)
);
```

In this example, the `sales` table is partitioned by year, with each partition containing sales data for a specific year. Queries that filter by `sale_date` can be optimized to access only the relevant partition.

### Conclusion

Partitioning is a powerful technique in database design that can significantly enhance performance, manageability, and availability. By carefully choosing a partitioning strategy that aligns with your data access patterns and business requirements, you can optimize your database for better performance and easier maintenance.

---
## Q. Main difference between left join vs left outer join
There's no practical difference between a `LEFT JOIN` and a `LEFT OUTER JOIN` in most database systems. They perform the same function, returning all rows from the left table and only the matching rows from the right table. If there are no matches in the right table, the corresponding columns in the result set will have `NULL` values. 

In essence, they are interchangeable and can be used synonymously. 
Here's a more detailed breakdown:

- `LEFT JOIN`: Returns all rows from the left table and the matching rows from the right table. If a row in the left table doesn't have a match in the right table, `NULL` values will be returned for the columns from the right table. 
- `LEFT OUTER JOIN`: This is the same as `LEFT JOIN`. The "OUTER" keyword is optional and doesn't change the functionality or performance. 

#### Why the confusion? 
The "OUTER" keyword was initially added to the SQL standard for clarity, but it's become redundant in most database systems. Many systems treat LEFT JOIN and LEFT OUTER JOIN identically, and the "OUTER" keyword is optional in their syntax.

---
## Q. Write an SQL query to fetch three max GPA from a table using co-related subquery.
```sql
SELECT gpa FROM Student
WHERE gpa IN (SELECT DISTINCT gpa FROM Student ORDER BY gpa DESC LIMIT 3)
ORDER BY gpa DESC
LIMIT 3;
```
Explanation: 

#### 1. `SELECT gpa FROM Student`: 
This selects the GPA column from the Student table.

#### 2. `WHERE gpa IN (SELECT DISTINCT gpa FROM Student ORDER BY gpa DESC LIMIT 3)`: 
This part filters the GPA values.
  #### - `SELECT DISTINCT gpa FROM Student ORDER BY gpa DESC LIMIT 3`: 
  This subquery selects the top 3 distinct GPA values in descending order.
  #### - `WHERE gpa IN (...)`: 
  This condition ensures that only the GPA values that are within the top 3 distinct GPA values are selected. 

#### 3. `ORDER BY gpa DESC`: 
This orders the results in descending order, ensuring that the highest GPA values are at the top.

#### 4. `LIMIT 3`: 
This limits the results to the top 3 GPA values, effectively retrieving the three highest GPA values.

---
## Q. How to design db schema for your new API?
To design a database schema for a new API, you need to first understand the API's purpose and the data it will manage, then define the entities, attributes, relationships, and constraints within your database model. You should also consider normalization, indexing, and scalability to ensure a well-structured and efficient database.
Here's a more detailed breakdown of the process: 
1. Understand the API's Purpose and Data: 

• Business Requirements: Analyze what the API needs to achieve and the data it will handle. This includes understanding the types of data, their relationships, and how the API will interact with this data. 
• Data Modeling: Determine the entities (tables) and their attributes (columns) based on the data requirements. 
• API Endpoints: Identify the API endpoints (e.g., GET, POST, PUT, DELETE) and their data input/output formats.

2. Define the Database Schema:

• Entities and Relationships: Identify the key entities (tables) in your database and how they relate to each other. For example, an e-commerce app might have tables for Customers, Orders, Products, and OrderDetails, connected by foreign keys.
• Data Types: Choose appropriate data types for each column (e.g., VARCHAR, INT, DATE, BOOLEAN).  
• Constraints: Implement constraints like PRIMARY KEY, FOREIGN KEY, NOT NULL, UNIQUE, and CHECK to ensure data integrity and enforce business rules. 
• Normalization: Apply normalization techniques to reduce data redundancy and improve data consistency (e.g., First Normal Form (1NF), Second Normal Form (2NF), Third Normal Form (3NF)).  

3. Implement Data Relationships: 

• Primary Keys: Define primary keys for each table to uniquely identify records. 
• Foreign Keys: Use foreign keys to establish relationships between tables, ensuring data consistency. 
• Indexes: Create indexes on frequently used columns to improve query performance.  

4. Test and Refine: 

• Test API Endpoints: Ensure your API endpoints interact with the database correctly, including data insertion, retrieval, update, and deletion.  
• Performance Testing: Evaluate database performance under load to ensure it can handle the expected API traffic.
• Refine Schema: Adjust the schema based on testing results and changing requirements.  

Example: E-commerce API Schema:
Imagine an e-commerce API that needs to handle customer information, order details, and product data. A possible database schema could include:  

• Customers: (customer_id, first_name, last_name, email, address) 
• Orders: (order_id, customer_id, order_date, total_amount) 
• Products: (product_id, product_name, description, price) 
• OrderDetails: (order_detail_id, order_id, product_id, quantity) 

These tables would be linked through foreign keys, for example, orders.customer_id would be a foreign key referencing customers.customer_id. 
Tools for Schema Design: 

• Database Design Tools: Tools like DbSchema, SQL Developer, or TablePlus can assist in visualizing and creating the database schema.  
• ER Diagrams: Entity-Relationship Diagrams (ERDs) can help visualize the relationships between entities. 

By following these steps and utilizing the appropriate tools, you can design a robust and efficient database schema for your new API, ensuring data integrity and optimized performance.



## TODO
2. Which database to be used and when and why?