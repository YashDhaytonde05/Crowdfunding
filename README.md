# 🚀 Crowdfunding

A Spring Boot-based crowdfunding platform designed for project creation, funding, and management.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)

---

## 📖 Overview

This repository hosts the source code for a Crowdfunding web application. The platform enables users to create campaigns, make contributions, and manage projects.

**GitHub Repository:**  
[https://github.com/YashDhaytonde05/Crowdfunding.git](https://github.com/YashDhaytonde05/Crowdfunding.git)

---

## ✨ Features

- 🔐 **User registration and authentication**: Users can sign up, log in, and manage their profile.  
- 🏗️ **Campaign creation**: Users can start fundraising campaigns with goals, descriptions, and images.  
- 🔍 **Browse & search campaigns**: Explore all campaigns or search by keyword/category.  
- 💰 **Fund campaigns**: Make donations to campaigns using secure endpoints.  
- 📜 **Transaction history**: View all contributions for transparency and personal history.  
- ⚙️ **Campaign management**: View campaign funding progress and manage campaigns you own.  
- 👮 **Admin controls**: (if included) Admins can remove inappropriate campaigns or manage users.  
- 🌐 **RESTful API**: Comprehensive API endpoints for all major features.

---

## 🛠️ Getting Started

### Prerequisites

- ☕ Java 17 or higher  
- 📦 Maven 3.6+  
- 💻 A modern IDE (IntelliJ IDEA, Eclipse)  
- 🔧 Git  

### Clone the Repository

- git clone https://github.com/YashDhaytonde05/Crowdfunding.git
- cd Crowdfunding


### Build and Run the Application


The application will be available at `http://localhost:8080` (or your configured port).

---

## 📚 API Documentation

API endpoints are documented in a Postman Collection:  
[View the Crowdfunding API Collection on Postman](https://web.postman.co/workspace/My-Workspace~67ddfb79-4a30-4b92-8bd2-e9d49de111a8/collection/36196351-c378b749-9b4d-4f22-b762-220432c8c7a4?action=share&source=copy-link&creator=36196351)

---

## 🛣️ API Endpoints

### 🎯 Campaign APIs
| Endpoint                                                          | Method | Description                          | Notes                      |
|-------------------------------------------------------------------|--------|------------------------------------|----------------------------|
| `POST http://localhost:8182/campaigns`                           | POST   | Create a campaign                  | Body: `{ "title": "...", "description": "...", "goalAmount": 10000 }` |
| `GET http://localhost:8182/campaigns`                            | GET    | View all campaigns                |                            |
| `GET http://localhost:8182/campaigns/{id}`                       | GET    | Get one campaign by ID            |                            |
| `PUT http://localhost:8182/campaigns/{id}`                       | PUT    | Edit a campaign                  | Body: `{ "title": "...", "description": "...", "goalAmount": ... }` |
| `DELETE http://localhost:8182/campaigns/by-name?title={campaignTitle}` | DELETE | Delete campaign(s) by title       | Requires Basic Auth        |
| `GET http://localhost:8182/campaigns/paged?page=0&size=3`        | GET    | List campaigns with pagination   | Query params: page, size   |

### 💸 Pledge APIs
| Endpoint                                                          | Method | Description                          | Notes                      |
|-------------------------------------------------------------------|--------|------------------------------------|----------------------------|
| `POST http://localhost:8182/pledges/campaign/{id}?amount=500`    | POST   | Make a pledge to a campaign        | Requires Basic Auth for backer |

### 📝 Campaign Updates / Progress APIs
| Endpoint                                                          | Method | Description                          | Notes                      |
|-------------------------------------------------------------------|--------|------------------------------------|----------------------------|
| `POST http://localhost:8182/campaigns/{id}/updates`              | POST   | Add campaign update                | Body: `{ "content": "..." }` |
| `GET http://localhost:8182/campaigns/{id}/updates`               | GET    | Get campaign updates              |                            |

### 🔐 Authentication APIs
| Endpoint                                                          | Method | Description                          | Notes                      |
|-------------------------------------------------------------------|--------|------------------------------------|----------------------------|
| `POST http://localhost:8182/auth/register`                       | POST   | Register a creator                 | Body: `{ "username": "yash", "password": "052002", "role": "CREATOR" }` |
| `POST http://localhost:8182/auth/register`                       | POST   | Register a backer                 | Body: `{ "username": "yashd", "password": "052002", "role": "BACKER" }` |

---

**Summary:**  
- 📋 Campaign CRUD operations (create, read, update, delete by title)  
- 💵 Pledging money to campaigns (authenticated backers only)  
- 🔄 Posting and viewing campaign updates/progress by creators  
- 👥 User registration with roles (CREATOR, BACKER)

---
