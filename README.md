# **WebFlux SSE with Quartz Example**

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green)
![License](https://img.shields.io/badge/License-MIT-brightgreen)

A practical example showcasing how to integrate **Spring WebFlux Server-Sent Events (SSE)** with **Quartz Scheduler** for real-time progress tracking in Java.

---

## **Table of Contents**

1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Installation](#installation)
5. [Endpoints](#endpoints)
6. [How It Works](#how-it-works)
7. [Screenshots](#screenshots)
8. [Future Enhancements](#future-enhancements)
9. [License](#license)
10. [Contributing](#contributing)
11. [Author](#author)

---

## **Overview**

This project demonstrates:  
- Using **Server-Sent Events (SSE)** for streaming real-time updates to the client.  
- Scheduling and managing tasks dynamically with **Quartz Scheduler**.  
- Combining the power of **Spring WebFlux** and **Reactive Streams** to build an efficient, non-blocking application.

Common use cases include progress tracking for long-running jobs such as:  
- File uploads.  
- Data processing.  
- Report generation.

---

## **Features**

- **Dynamic Quartz Jobs:** Start, manage, and monitor jobs at runtime.  
- **Real-Time Updates:** Stream progress updates to clients using WebFlux SSE.  
- **Reactive Programming:** Fully asynchronous and non-blocking with Spring WebFlux.  
- **RESTful Endpoints:** Simple APIs for job creation and progress tracking.

---

## **Technology Stack**

- **Java:** 17+  
- **Spring Boot:** 3.1+  
- **Spring WebFlux:** Reactive web framework for asynchronous programming.  
- **Quartz Scheduler:** Advanced job scheduling library for Java.  

---

## **Installation**

### **Prerequisites**

1. **Java 17+** installed.  
2. **Maven** for dependency management.  
3. **Postman** or any API testing tool for testing endpoints.

### **Run the Application**

1. Clone the repository:  
   ```bash
   git clone https://github.com/its-me-gayan/WebfluxSSEQuartzExample.git
   cd WebfluxSSEQuartzExample
