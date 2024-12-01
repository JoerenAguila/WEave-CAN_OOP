

<div align="center">
  <img src="/image/WEaveCAN_Logo.png" alt="WEaveCAN Logo" width="800">   
  <br><br>
    <a href="https://github.com/JoerenAguila">Joeren Aguila IT - 2104</a>
  </p>
</div>

---

## **Table of Contents**

I. [Project Overview](#i-project-overview)  
II. [OOP Principles in WEave CAN](#ii-oop-principles-in-weave-can)  
III. [Integration with SDG 8: Decent Work and Economic Growth](#iii-integration-with-sdg-8-decent-work-and-economic-growth)  
IV. [Instructions for Running the GUI Program](#iv-instructions-for-running-the-gui-program)  
V. [Acknowledgements](#acknowledgements)

---

## **I. Project Overview**

**WEave CAN** is a Java-based inventory and order management system designed for Filipino artisans, particularly weavers. The system streamlines stock and order management while promoting cultural preservation and sustainable economic growth. By digitizing artisan operations, it helps honor indigenous materials and patterns, ensuring that Filipino weaving traditions are maintained and expanded.

### Key Features:
- **Inventory Management** - manage stock levels, materials, patterns, and product pricing efficiently.  
- **Order Processing** - simplifies the process of creating customer orders, automatically updating stock, and tracking order statuses.  
- **Order Tracking** - view and track customer orders, including quantities and statuses with detailed insights.  
- **Admin Panel** - manage product restocking and pricing adjustments in a user-friendly admin panel.  
- **Reporting** - generate reports on inventory and sales performance to aid decision-making.  

---

## **II. OOP Principles in WEave CAN**

### **1. Encapsulation**
- **Product Class**:
  - Fields such as `price`, `stock`, `material`, `pattern`, and `sold` are private, protecting them from direct access or modification.
  - Controlled access is provided through **getter and setter methods**, ensuring data security and integrity.
- **Order Class**:
  - Encapsulates customer order details such as `status`, `contactNumber`, and `amount`, restricting direct access.
  - Methods like `setStatus()` ensure controlled updates while preserving the consistency of order data.

---

### **2. Inheritance**
- Specific product types (`Shawl`, `Bag`, `Pants`, etc.) inherit common properties and methods from the base `Product` class.
- This approach promotes code reuse by defining shared features like `price`, `stock`, and `material` in the parent class.
- Subclasses implement the `displayDetails` method to customize how each product type is displayed.

---

### **3. Polymorphism**
- Polymorphism is achieved through method overriding:
  - Each subclass of `Product` overrides the `displayDetails` method to provide type-specific details (e.g., category name, stock, pattern).
  - This allows the system to treat all products uniformly as `Product` objects while dynamically invoking their unique behaviors.
- During runtime, the correct `displayDetails` implementation is automatically resolved based on the product type.

---

### **4. Abstraction**
- The `Product` class is declared as **abstract** to serve as a template for    various product types like `Shawl`, `Bag`, `Skirt`, etc.
- It ensures that all essential product features (e.g., price, stock, material, pattern) and behaviors (e.g., `displayDetails`) are standardized and available across all product types while hiding unnecessary details from the user.

---

## **III. Integration with SDG 8: Decent Work and Economic Growth**
**WEave CAN** aligns with multiple Sustainable Development Goals, particularly **SDG 8: Decent Work and Economic Growth** and **SDG 5: Gender Equality**. These goals support the empowerment of Filipino artisans, with a focus on women weavers, to achieve sustainable economic opportunities and equality.

---

### **1. SDG 8: Decent Work and Economic Growth**

<div align="center">
  <img src="https://www.un.org/sites/un2.un.org/files/field/image/e_gif_08.gif" width="200">
</div>

**WEave CAN** contributes to **SDG 8** by fostering sustainable business practices and supporting economic growth in artisan communities:

- **Efficiency and Growth** - streamlines inventory and order management, enabling artisans to scale their businesses efficiently.
- **Economic Empowerment** - provides access to digital tools that help weavers achieve income stability and financial independence.
- **Cultural Heritage** - highlights traditional weaving techniques and materials (e.g., abaca, cotton) to preserve Filipino craftsmanship.
- **Community Impact** - strengthens local economies and benefits indigenous and tribal groups reliant on weaving as a primary source of livelihood.

---

### **2. SDG 5: Gender Equality**

<div align="center">
  <img src="https://www.un.org/sites/un2.un.org/files/field/image/e_gif_05.gif" alt="SDG 5 GIF" width="200">
</div>

**WEave CAN** actively supports **SDG 5** by promoting gender equality and empowering women, who constitute a significant portion of Filipino weavers:

- **Women’s Empowerment** - focuses on providing digital tools and resources to women artisans, enabling them to manage their businesses more effectively and access larger markets.
- **Economic Inclusion** - addresses barriers that limit women’s participation in the workforce by offering solutions tailored to their roles in traditional crafts.
- **Skill Development** - encourages the preservation and growth of weaving skills, often passed down through generations of women, ensuring their cultural and economic relevance.
- **Leadership Opportunities** - recognizes women artisans as leaders in preserving cultural heritage and driving economic change within their communities.

By integrating these SDGs into its design and goals, **WEave CAN** serves as a platform for inclusive growth, gender equality, and cultural preservation, contributing to a better future for Filipino weaving communities.


---


## **IV. Instructions for Running the GUI Program**

### **Prerequisites**  
Ensure you have the following installed:  
- **Java Development Kit (JDK 8 or higher)**  
- A **Java-compatible IDE** (e.g., IntelliJ IDEA, Eclipse) or terminal for compiling and running Java programs.  

### **Steps to Run the Program**  

1. **Set Up the Environment**  
   - Install Java and a Java-compatible IDE on your system.

2. **Prepare the Files**  
   - **Backend Logic**: Save the backend code as `weave_can.java`.  
   - **GUI Logic**: Save the GUI code as `weave_gui.java`.  

3. **Compile the Program**  
   - **Using an IDE**:  
     Open the project in your IDE, ensure all `.java` files (including `weave_can.java` and `weave_gui.java`) are in the same project, and compile the project.  
   - **Command Line**:  
     In the terminal, navigate to the directory where the `.java` files are saved and execute:  
     ```bash
     javac weave_can.java weave_gui.java
     ```  

4. **Run the Program**  
   - **Using an IDE**:  
     Locate and run the `weave_gui` class from your IDE.  
   - **Command Line**:  
     In the terminal, run the program with:  
     ```bash
     java weave_gui
     ```  

By following these steps, you will launch the **WEave CAN** application, which combines the backend inventory and order management system with a user-friendly graphical interface built using **Java Swing**. Thus, merging traditional Filipino weaving practices with modern technological tools, **WEave CAN** offers a platform for artisans to enhance their businesses while promoting cultural heritage and economic sustainability.

---

## **Acknowledgements**

I would like to express my sincere gratitude to the following individuals:

### **Instructor**
- **Sir Jayson Abratique**  
  For your unwavering support, expert guidance, and insightful feedback throughout the development of this project. Your advice has been crucial in shaping the success of this system and in ensuring its overall quality.

### **Filipino Weavers**
- A special dedication goes to the **Filipino weavers**, whose talent and cultural heritage inspired the creation of this system. My goal is to celebrate and preserve Filipino weaving traditions while providing artisans with the tools they need for sustainable growth in today’s economy. This project is a tribute to your skill and creativity, and I hope it helps in enhancing the future of Filipino weaving communities.

<div align="center">
  <img src="/image/WEavers.png" alt="Weavers" width="800">
</div>

<br><br>
  <h3 align="center"><strong>Thank you for your priceless contribution to the cultural legacy of the Philippines!</strong></h3>
  <h2 align="center">"YOU CAN, I CAN, WEAVE CAN!"</h2>
</div>

---
