1. What is the difference between parallism vs concurrency?

| S.NO |Concurrency|                                           Parallelism                                           |
|:----:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------:|
|  1.  |                               Concurrency is the task of running and managing the multiple computations at the same time.                               |          While parallelism is the task of running multiple computations simultaneously.         | 
|  2.  | Concurrency is achieved through the interleaving operation of processes on the central processing unit(CPU) or in other words by the context switching. |             While it is achieved by through multiple central processing units(CPUs).            |  
|  3.  |                                                Concurrency can be done by using a single processing unit.                                               | While this can’t be done by using a single processing unit. it needs multiple processing units. | 
|  4.  |                                               Concurrency increases the amount of work finished at a time.                                              |             While it improves the throughput and computational speed of the system.             | 
|  5.  |                                                  Concurrency deals with a lot of things simultaneously.                                                 |                          While it does a lot of things simultaneously.                          | 
|  6.  |                                               Concurrency is the non-deterministic control flow approach.                                               |                         While it is deterministic control flow approach.                        | 
|  7.  |                                                          In concurrency debugging is very hard.                                                         |                While in this debugging is also hard but simple than concurrency.                | 

2. List vs Set
3. Create an immutable class
  Immutable class in java means that once an object is created, we cannot change its content. In Java, all the wrapper classes (like Integer, Boolean, Byte,     
  Short) and String class is immutable. We can create our own immutable class as well. Prior to going ahead do go through characteristics of immutability in order 
  to have a good understanding while implementing the same. Following are the requirements: 
  - The class must be declared as final so that child classes can’t be created.
  - Data members in the class must be declared private so that direct access is not allowed.
  - Data members in the class must be declared as final so that we can’t change the value of it after object creation.
  - A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
  - Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
  
  Note: There should be no setters or in simpler terms, there should be no option to change the value of the instance variable.

4. Validation in Spring Boot
5. Questions on Stream API
   - Create List<Integer> add some values in it and filter all even numbers and return to list again using java 8 stream.
   - Convert List<Integer> to List<String> using  java 8 streams.
   - Convert List<Employee> to Map<Integer,String> where key will be employee id and value will be employee name using java 8 stream.'
   - Convert List<Employee> to Map<Double,List<Employee>> where key will be employee salary and value will be employee list accordingly using java 8 stream.
   - Convert List<Employee> to Map<Double,String> where key will be employee salary and value will be employee names comma seperated	 accordingly using java 8 stream.
   
7. Functional interface
8. SOLID principles
9. Difference between hibernate and JDBC
10. Annotations used in java.
11. Given a string s, find the length of the longest substring without duplicate characters.
  Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
12. Technical architecture
13. SQL vs NoSQL
14. Factory Design pattern
15. Alogithm behind Collection.sort().
16. Challenges you faces as an engineer and how did you resolved it?
17. How jvm works?
18. Spring actuator
19. Diff between Abstract class vs interface
20. Understanding of browser caching.
21. Strong knowledge of UX design and principles.
22. Event-driven implementation using Kafka.
23. Html 5/css
24. Angular 17 features
25. Lazy loading in hibernate
26. Reverse you name in Java 
27. Handle exception in Angular
    A: ```Error handling in Angular applications is crucial for providing a smooth user experience and debugging issues. Here's an overview of common strategies:
      1. Try-Catch Blocks
        Used for handling synchronous errors within specific code blocks.
        
        try {
          // Code that might throw an error
          const result = someFunction();
        } catch (error) {
          // Handle the error
          console.error('An error occurred:', error);
        }
  
    2. Angular ErrorHandler
      A global error handling mechanism for catching unhandled exceptions.
      
      import { Injectable, ErrorHandler } from '@angular/core';
      @Injectable()
      export class GlobalErrorHandler implements ErrorHandler {
        handleError(error: any) {
          // Log the error, display a user-friendly message, etc.
          console.error('Global error handler:', error);
        }
      }
      To use it, provide it in your module or component:
      TypeScript
      
      import { NgModule } from '@angular/core';
      import { GlobalErrorHandler } from './global-error-handler';
      import { ErrorHandler } from '@angular/core';
      
      @NgModule({
        providers: [{ provide: ErrorHandler, useClass: GlobalErrorHandler }],
      })
      export class AppModule {}
  
    3. RxJS catchError Operator
      Handles errors in Observables, commonly used with HTTP requests.
      
      import { catchError } from 'rxjs/operators';
      import { of } from 'rxjs';
      
      this.http.get('/api/data').pipe(
        catchError(error => {
          console.error('HTTP error:', error);
          // Return a new observable or throw the error again
          return of([]); // Return an empty array as a fallback
        })
      ).subscribe(data => {
        // Process the data
      });
  
    4. HTTP Interceptors
      Centralized handling of HTTP errors for all requests.
      
      import { Injectable } from '@angular/core';
      import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
      import { Observable, throwError } from 'rxjs';
      import { catchError } from 'rxjs/operators';
      
      @Injectable()
      export class HttpErrorInterceptor implements HttpInterceptor {
        intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
          return next.handle(request)
            .pipe(
              catchError((error: HttpErrorResponse) => {
                console.error('HTTP error:', error);
                // Handle the error (e.g., display a message, retry the request)
                return throwError(() => error);
              })
            );
        }
      }
      Provide the interceptor in your module:
      
      import { NgModule } from '@angular/core';
      import { HTTP_INTERCEPTORS } from '@angular/common/http';
      import { HttpErrorInterceptor } from './http-error-interceptor';
      
      @NgModule({
        providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptor, multi: true }],
      })
      export class AppModule {}
  
    5. Displaying Error Messages
      Provide user-friendly feedback when errors occur.
      Use descriptive error messages that guide users.
      Avoid exposing sensitive information.
      Display errors in a consistent manner (e.g., using a dialog or notification).
    
    6. Logging Errors
      Log errors for debugging and monitoring purposes.
      Use console.error for development.
      Consider using a logging service for production.
      Include relevant information in logs (e.g., timestamp, error message, stack trace). ```

27. Signal in Angular
28. Zone.js
29. Second highest salary from a table
  SELECT salary
  FROM employees
  ORDER BY salary DESC
  LIMIT 1 OFFSET 1;

30. Write a code to Shift an array by 3 to the right ([1,2,3,4,5] -> [4,5,1,2,3])
    import java.util.Arrays;
    
    public class ArrayShift {
        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5, 6, 7};
            int shiftBy = 3;
    
            System.out.println("Original array: " + Arrays.toString(array));
            shiftArrayRight(array, shiftBy);
            System.out.println("Array after shifting by " + shiftBy + " positions: " + Arrays.toString(array));
        }
    
        public static void shiftArrayRight(int[] array, int positions) {
            int length = array.length;
            positions = positions % length; // Handle cases where positions > length
            reverseArray(array, 0, length - 1);
            reverseArray(array, 0, positions - 1);
            reverseArray(array, positions, length - 1);
        }
    
        private static void reverseArray(int[] array, int start, int end) {
            while (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
    }
31. Stream API in Java
  Stream API is used to process collections of objects. A stream in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result.
    Intermediate operations:
      flatMap(List::stream): Flattens the nested lists into a single stream of strings.
      filter(s -> s.startsWith("S")): Filters the strings to only include those that start with “S”.
      map(String::toUpperCase): Converts each string in the stream to uppercase.
      distinct(): Removes any duplicate strings.
      sorted(): Sorts the resulting strings alphabetically.
      peek(...): Adds each processed element to the intermediateResults set for intermediate inspection.
      collect(Collectors.toList()): Collects the final processed strings into a list called result.

  Terminal operations:
    forEach: Prints each name in the list.
    collect: Filters names starting with ‘S’ and collects them into a new list.
    reduce: Concatenates all names into a single string.
    count: Counts the total number of names.
    findFirst: Finds and prints the first name in the list.
    allMatch: Checks if all names start with ‘S’.
    anyMatch: Checks if any name starts with ‘S’.

  For more: https://www.geeksforgeeks.org/stream-in-java/
  
  32. Find the first repeating character from a string.
      import java.util.HashSet;
      import java.util.Optional;
      import java.util.Set;
      
      public class Main {
          public static final String myString=  "iamaveryverylongstringbutaneasyone";
      
          public static void main(String[] args) {
              // Step 2: Find the first repeated character using Java 8 streams
              Optional<Character> firstRepeated = findFirstRepeatedCharacter(myString);
      
              // Step 3: Display the result
              if (firstRepeated.isPresent()) {
                  System.out.println("The first repeated character is '" + firstRepeated.get() + "'");
              } else {
                  System.out.println("No repeated characters found.");
              }
          }
      
          // Method to find the first repeated character in a string
          public static Optional<Character> findFirstRepeatedCharacter(String input) {
              Set<Character> seenCharacters = new HashSet<>();
      
              return input.chars()  // Convert the string to an IntStream of character codes
                      .mapToObj(c -> (char) c)  // Convert character codes to characters
                      .filter(c -> !seenCharacters.add(c))  // Filter characters that are already in the set
                      .findFirst();  // Return the first repeated character if found
          }
      }

  33. Find the name of employee who are managers
  table: emp
       (emp_id,name,salary,dep,emp_mgr_id) 
    		(1,A,1200,HR,3)
    		(2,B,2000,HR,3)
    		(3,C,2200,HR,6)
    		(4,D,200,IT,23)
    		(5,E,200,IT,13)
    		(6,F,3200,HR,17)
      
    Solution: select e1.name from emp e1 join emp m1 where e1.emp_mgr_id = m2.emp_id;
    
  35. Status code:
    200: OK status,
    201: Ok suceess,
    403: Forbidden,
    500: Internal server errors,
    502: Bad gateway
  36. 
  37. 


  Here are some great websites to **practice output-based JavaScript questions**:

### **1. [JSitor](https://jsitor.com/)**
   - **Best for:** Running JavaScript code online and testing outputs.
   - **Features:** Supports ES6, TypeScript, and frameworks like React.

### **2. [JSBench.me](https://jsbench.me/)**
   - **Best for:** Comparing JavaScript performance and analyzing different approaches.
   - **Features:** Run code snippets and see execution time.

### **3. [W3Schools JavaScript Quiz](https://www.w3schools.com/js/js_quiz.asp)**
   - **Best for:** Beginner-friendly output-based questions.
   - **Features:** Instant feedback, step-by-step learning.

### **4. [GeeksforGeeks JavaScript Quiz](https://www.geeksforgeeks.org/javascript-quiz-set-1/)**
   - **Best for:** Practicing tricky JavaScript questions.
   - **Features:** Covers concepts like closures, hoisting, and scopes.

### **5. [Codewars](https://www.codewars.com/)**
   - **Best for:** Competitive JavaScript coding challenges.
   - **Features:** Solve real-world problems, ranked by difficulty.

### **6. [Edabit](https://edabit.com/challenges)**
   - **Best for:** Practicing short coding challenges with immediate feedback.
   - **Features:** Output-based and logic-based problems.

### **7. [LeetCode JavaScript Challenges](https://leetcode.com/tag/javascript/)**
   - **Best for:** Practicing JavaScript coding interview questions.
   - **Features:** Interactive editor, discussion forums.

### **8. [HackerRank JavaScript Challenges](https://www.hackerrank.com/domains/tutorials/10-days-of-javascript)**
   - **Best for:** Hands-on JavaScript problem-solving.
   - **Features:** Beginner to advanced problems with live execution.

Would you like recommendations for specific types of questions (hoisting, closures, async, etc.)? 🚀

React project 
Core Java prepare
Spring boot
